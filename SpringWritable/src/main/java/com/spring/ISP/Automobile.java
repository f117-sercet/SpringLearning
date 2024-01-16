package com.spring.ISP;

/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2024/1/15 17:31
 */
public class Automobile implements Drive,Engine {
    @Override
    public void drive() {
        System.out.println("开车");
    }

    @Override
    public void repaire() {

        System.out.println("修车");
    }
}
