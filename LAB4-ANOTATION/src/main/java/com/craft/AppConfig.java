package com.craft;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Arrays;

@Configuration
public class AppConfig {

    // 1. ADDRESS BEAN
    @Bean(name = "address")
    public Address address() {

        Address address = new Address();

        address.setCity("Addis Ababa");
        address.setCountry("Ethiopia");

        return address;
    }

    // 2. SUBJECT BEAN: MATH
    @Bean(name = "math")
    public Subject math() {

        Subject subject = new Subject();

        subject.setSubjectName("Maths 101");

        return subject;
    }

    // 3. SUBJECT BEAN: JAVA
    @Bean(name = "javaSubject")
    public Subject javaSubject() {

        Subject subject = new Subject();

        subject.setSubjectName("Java EE");

        return subject;
    }

    // 4. SETTER INJECTION
    // OBJECT INJECTION
    // COLLECTION INJECTION

    @Bean(name = "student")
    public Student student(
            Address address,
            @Qualifier("math") Subject math,
            @Qualifier("javaSubject") Subject javaSubject) {

        Student student = new Student();

        student.setId(101);
        student.setName("John Doe");
        student.setAge(20);

        // Object dependency injection
        student.setAddress(address);

        // Collection dependency injection
        student.setSubjects(
                Arrays.asList(math, javaSubject)
        );

        return student;
    }

    // 5. SETTER INJECTION OF LITERAL VALUES

    @Bean(name = "setterStudent")
    public Student setterStudent() {

        Student student = new Student();

        student.setId(102);
        student.setName("Jane Doe");
        student.setAge(21);

        return student;
    }

    // 6. CONSTRUCTOR INJECTION

    @Bean(name = "constructorStudent")
    public Student constructorStudent(Address address) {

        return new Student(
                103,
                "Abebe Kebede",
                22,
                address
        );
    }

    // 7. SINGLETON SCOPE

    @Bean(name = "singletonStudent")
    @Scope("singleton")
    public Student singletonStudent() {

        return new Student();
    }

    // 8. PROTOTYPE SCOPE

    @Bean(name = "prototypeStudent")
    @Scope("prototype")
    public Student prototypeStudent() {

        return new Student();
    }
}