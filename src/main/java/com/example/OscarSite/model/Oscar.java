package com.example.OscarSite.model;
 

 public class Oscar{
    private int id;
    private String name;
    private String category;
    private String status;
    private int yearof;

    public Oscar(int id,String name,String category,String status,int yearof){
        this.id=id;
        this.name=name;
        this.category=category;
        this.status=status;
        this.yearof=yearof;
    }

    public int getId(){
        return this.id;
        }
    public void setId(int id1){
        this.id=id1;
        }

    public String getName(){
        return this.name;
    }
    public void setName(String name1){
        this.name=name1;
    }

    public String getCategory(){
        return this.category;
    }
    public void setCategory(String category1){
        this.category=category1;
    }

    public String getStatus(){
        return this.status;
    }
    public void setStatus(String status1){
        this.status=status1;
    }

    public int getYearOf(){
        return this.yearof;
    }
    public void setYearOf(int yearOf1){
        this.yearof=yearOf1;
    }

 }




















