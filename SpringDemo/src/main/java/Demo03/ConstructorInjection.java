package Demo03;

import com.sun.tools.classfile.Dependency;

import java.security.PublicKey;

/**
 * 构造函数依赖注入
 * 当在组件的构造函数中提供依赖时就会发生构造函数依赖注入。首先，组件声明一个或者一组构造函数，并将其依赖项作为参数，然后在组件实例化时由IOC
 * 容器将依赖项传递给组件
 * 一个显而易见的结果是，如果没有依赖项，就不能创建对象；因此，必须有依赖项。
 */
public class ConstructorInjection {
    private Dependency dependency;
    public ConstructorInjection(Dependency dependency){
        this.dependency=dependency;
    }
    public String toString(){
        return dependency.toString();
    }
}
