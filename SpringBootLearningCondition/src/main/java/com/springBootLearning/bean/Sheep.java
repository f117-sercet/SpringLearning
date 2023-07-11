package com.springBootLearning.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2023/7/11 17:53
 */
@Data
@ConfigurationProperties(prefix = "sheep")
public class Sheep {
    private  Long id;
    private String name;
}
