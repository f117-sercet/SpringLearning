package com.spring.ISP;

/**
 * Description： 接口隔离
 *
 * @author: 段世超
 * @aate: Created in 2024/1/15 17:30
 */
public class Test {
    public static void main(String[] args) {

        Engine automobile = new Automobile();
        automobile.repaire();
        Drive drive = new Automobile();
        drive.drive();
    }
}
