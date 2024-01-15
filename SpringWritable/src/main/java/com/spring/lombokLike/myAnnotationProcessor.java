package com.spring.lombokLike;
import com.google.auto.service.AutoService;
import com.sun.tools.javac.api.JavacTrees;
import com.sun.tools.javac.tree.TreeMaker;

import com.google.auto.service.AutoService;
import com.sun.source.tree.Tree;
import com.sun.tools.javac.api.JavacTrees;
import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.tree.TreeTranslator;
import com.sun.tools.javac.util.*;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;


/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2024/1/15 11:35
 */
@SupportedAnnotationTypes({"com.spring.lombokLike.MyGetter", "com.spring.lombokLike.MySetter"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@AutoService(Process.class)
public class myAnnotationProcessor extends AbstractProcessor {

    private JavacTrees javacTrees; // 提供了待处理的抽象语法树
    private TreeMaker treeMaker; // 封装了创建AST节点的一些方法
    private Names names; // 提供了创建标识符的方法

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        Context context = ((JavacProcessingEnvironment) processingEnv).getContext();
        javacTrees = JavacTrees.instance(processingEnv);
        treeMaker = TreeMaker.instance(context);
        names = Names.instance(context);
    }


    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        // 返回使用给定注释类型注释的元素集合
        Set<? extends Element> get = roundEnv.getElementsAnnotatedWith(MyGetter.class);
        get.forEach(element ->{

            //获取当前类的语法抽象树
           JCTree tree =javacTrees.getTree(element);
            //获取抽象语法树的所有节点
            // Visitor抽象内部类，内部定义了访问各种语法节点的方法
            tree.accept( new TreeTranslator(){
                @Override
                public void visitClassDef(JCTree.JCClassDecl jcClassDecl) {

                    // 在抽象树中找出所有的变量
                    //过滤，只处理变量类型
                    jcClassDecl.defs.stream()
                            .filter(it -> it.getKind().equals(Tree.Kind.VARIABLE))
                            // 类型转换
                            .map(it ->(JCTree.JCVariableDecl) it )
                            .forEach(it -> {
                                // 对于变量进行生成方法的操作
                                jcClassDecl.defs = jcClassDecl.defs.prepend(genGetterMethod(it));
                            });
                    super.visitClassDef(jcClassDecl);
                }
            });
        });

        return true;
    }

    private JCTree.JCMethodDecl genGetterMethod(JCTree.JCVariableDecl jcVariableDecl) {

        JCTree.JCReturn returnStatement = treeMaker.Return(
                treeMaker.Select(
                        treeMaker.Ident(names.fromString("this")),
                        jcVariableDecl.getName()
                )
        );
        ListBuffer<JCTree.JCStatement> statements = new ListBuffer<JCTree.JCStatement>().append(returnStatement);

        // public 方法访问级别限制
        JCTree.JCModifiers modifiers = treeMaker.Modifiers(Flags.PUBLIC);
        // 方法名 getXXX ，根据字段名生成首字母大写的get方法
        Name getMethodName = createGetMethodName(jcVariableDecl.getName());
// 返回值类型，get类型的返回值类型与字段类型一致
        JCTree.JCExpression returnMethodType = jcVariableDecl.vartype;
        // 生成方法体
        JCTree.JCBlock body = treeMaker.Block(0, statements.toList());

        // 泛型参数列表
        List<JCTree.JCTypeParameter> methodGenericParamList = List.nil();
        // 参数值列表
        List<JCTree.JCVariableDecl> parameterList = List.nil();
        // 异常抛出列表
        List<JCTree.JCExpression> throwCauseList = List.nil();

        // 生成 方法定义树节点
        return treeMaker.MethodDef(
                // 方法访问级别修饰符
                modifiers,
                // get 方法名
                getMethodName,
                // 返回值类型
                returnMethodType,
                // 泛型参数列表
                methodGenericParamList,
                //参数值列表
                parameterList,
                // 异常抛出列表
                throwCauseList,
                // 方法默认体
                body,
                // 默认值
                null
        );
    }
    private Name createGetMethodName(Name variableName) {
        String fieldName = variableName.toString();
        return names.fromString("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));

    }

    private Name createSetMethodName(Name variableName) {
        String fieldName = variableName.toString();
        return names.fromString("set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));

    }
}
