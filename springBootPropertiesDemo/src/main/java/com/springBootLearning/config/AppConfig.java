package com.springBootLearning.config;

import com.alibaba.druid.FastsqlException;
import com.springBootLearning.bean.User;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2023/7/7 16:02
 */
//@Configuration // 这是一个配置类，替代以前的配置文件
//  @SpringBootConfiguration 等价于 Configuration
@Import(FastsqlException.class) // 导入任意第三方组件，给容器中放指定类型的组件，组件的名字默认是全类名
@SpringBootConfiguration
public class AppConfig {

    /**
     * 组件默认是单实例的，
     * @return
     */
    @Scope("prototype")  // 多实例，每次创建组件都不会相等
    @Bean("userWang") // 替代以前的 bean标签，组件在容器的名字是方法名,可以直接修改注解的值
    public User user(){
        var user = new User();
        user.setId(1L);
        user.setName("张三");
        return user;

    }
  /*  @Bean
     public FastsqlException fastsqlException(){

        return  new  FastsqlException();
     }*/
}
