package com.tan.java8.stream;

import lombok.Data;

@Data
public class User {
    /** 学号 */
    private long id;

    private String name;

    private int age;

    /** 年级 */
    private int grade;

    /** 专业 */
    private String major;

    /** 学校 */
    private String school;

    // 省略getter和setter
    public User(long id,String name,int age,int grade,String major,String school) {
        this.id=id;
        this.name=name;
        this.age=age;
        this.grade=grade;
        this.major=major;
        this.school=school;
    }

}
