import Demo01.MessageRender;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class test {
    @Test
    public void  HelloWrld(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("test1.xml");
        MessageRender mr = applicationContext.getBean("render", MessageRender.class);
        mr.render();
    }
}

