package com.example.hello.controller.dto;
//유저정보
public class UserRequest {
    private String name;
    private String email;
    private int age;


    //getset 메서드
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\''+
                '}';
    }
}
