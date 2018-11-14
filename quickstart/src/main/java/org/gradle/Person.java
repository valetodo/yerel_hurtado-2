package org.gradle;

import org.apache.commons.collections.list.GrowthList;

public class Person {
    private String name;
    private int age;
    private String job;
    private String id;
    private String lasName;

    public Person(String name, int age, String job, String id, String lastName) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.id = id;
        this.lasName = lastName;
        new GrowthList();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLasName() {
        return lasName;
    }

    public void setLasName(String lasName) {
        this.lasName = lasName;
    }
}
