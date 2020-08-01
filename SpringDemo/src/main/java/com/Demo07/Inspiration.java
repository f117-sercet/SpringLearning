package com.Demo07;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Spring使用字段注入
 * @author dsc
 */
@Component
public class Inspiration {
    /**
     * 字段注入缺点：
     * 容易在重构时出现难以分离的情况
     * 容易搞错依赖项
     * 字段注入引入了Spring的容器依赖；因此，这个bean不再是一个POJO,并不能独立实例化
     * 字段注入不能用于final字段，这种类型的字段只能使用构造函数进行初始化
     * 由于必须手动注入依赖项，因此在编写测试时，字段注入会带来困难。
     */
    private String lyric="123123";
    public Inspiration(@Value("8888") String lyric){
        this.lyric=lyric;
    }
    public String getLyric(){
        return lyric;
    }
    public void setLyric(String lyric){
        this.lyric=lyric;

    }
}
