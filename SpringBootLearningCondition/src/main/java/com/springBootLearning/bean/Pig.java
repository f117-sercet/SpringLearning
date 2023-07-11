package com.springBootLearning.bean;

import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2023/7/11 17:53
 */
@Data
@Component
@ConfigurationProperties(prefix = "pig")
public class Pig {
    private  Long id;
    private String name;
}
