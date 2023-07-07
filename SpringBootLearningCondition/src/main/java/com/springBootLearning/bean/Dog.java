package com.springBootLearning.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2023/7/7 15:46
 */
@Component
@Data
public class Dog {
    private  Long id;
    private String name;
}
