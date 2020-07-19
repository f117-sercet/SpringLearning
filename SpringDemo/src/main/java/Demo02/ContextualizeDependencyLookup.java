package Demo02;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import com.sun.tools.classfile.Dependency;

public class ContextualizeDependencyLookup implements ManagedComponent{
    private Dependency dependency;
    @Override
    public void performLookup(Container container) {
        this.dependency= (Dependency) container.getDependency("mydependency");
    }
    public String toString(){
        return dependency.toString();
    }
}
