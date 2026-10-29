package com.craft;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Student {
    private int id;
    private String name;
    private int age;
    private String city;
    private String country;
    private Address address;
    private List<Subject> subjects = new ArrayList<>();
    private Subject[] subjectsArray = new Subject[0];
    private Set<Subject> subjectsSet;

    public Student() { System.out.println("Student empty constructor called"); }
    public Student(int id, String name, int age) {
        this.id=id; this.name=name; this.age=age;
        System.out.println("Student parameterized constructor called");
    }
    public Student(int id, String name, int age, Address address) {
        this(id,name,age); this.address=address;
    }
    public int getId(){return id;} public void setId(int id){this.id=id;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public int getAge(){return age;} public void setAge(int age){this.age=age;}
    public String getCity(){return city;} public void setCity(String city){this.city=city;}
    public String getCountry(){return country;} public void setCountry(String country){this.country=country;}
    public Address getAddress(){return address;} public void setAddress(Address address){this.address=address;}
    public List<Subject> getSubjects(){return subjects;} public void setSubjects(List<Subject> subjects){this.subjects=subjects;}
    public Subject[] getSubjectsArray(){return subjectsArray;} public void setSubjectsArray(Subject[] subjectsArray){this.subjectsArray=subjectsArray;}
    public Set<Subject> getSubjectsSet(){return subjectsSet;} public void setSubjectsSet(Set<Subject> subjectsSet){this.subjectsSet=subjectsSet;}

    public void getDetails(){
        System.out.println("Student Details: "+this);
        if(subjects != null) for(int i=0;i<subjects.size();i++) System.out.println("Subject "+(i+1)+": "+subjects.get(i).getSubjectName());
    }
    @Override public String toString(){
        return "Student{id="+id+", name='"+name+"', age="+age+", city='"+city+"', country='"+country+"', address="+address+", subjects="+subjects+", subjectsArray="+java.util.Arrays.toString(subjectsArray)+", subjectsSet="+subjectsSet+"}";
    }
}
