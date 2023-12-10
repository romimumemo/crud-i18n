package com.teskerja.teskerja.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    @JsonProperty("nama_keren")
    private String name;
    @JsonIgnore
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter dan setter untuk atribut name dan age

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
