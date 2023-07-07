package com.springBootLearning.bean;

import org.springframework.stereotype.Component;

/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2023/7/7 15:51
 */
@Component
public class Cat {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
