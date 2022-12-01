package com.example.servicepanel;

public class User {
    private String id;
    private String name;
    private String status;
    private String object;

    public User(String id, String name, String status, String object){
        this.id = id;
        this.name = name;
        this.status = status;
        this.object = object;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getStatus(){
        return status;
    }

    public String getObject(){
        return object;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setObject(String object){
        this.object = object;
    }

    public void setStatus(String status){
        this.status = status;
    }


}
