package com.craft;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beansConfig.xml")) {
            System.out.println("=== 1. IoC bean and literal setter injection ===");
            Student literal = context.getBean("literalStudent", Student.class);
            System.out.println(literal);
            System.out.println("Student Name: " + literal.getName());

            System.out.println("\n=== 2. Setter-based object dependency injection ===");
            System.out.println(context.getBean("objectSetterStudent", Student.class));

            System.out.println("\n=== 3. Constructor injection: named arguments ===");
            System.out.println(context.getBean("constructorNamedStudent", Student.class));
            System.out.println("\n=== 4. Constructor injection: ordered arguments ===");
            System.out.println(context.getBean("constructorOrderedStudent", Student.class));
            System.out.println("\n=== 5. Constructor injection: indexed arguments ===");
            System.out.println(context.getBean("constructorIndexedStudent", Student.class));
            System.out.println("\n=== 6. Constructor injection: object reference ===");
            System.out.println(context.getBean("constructorObjectStudent", Student.class));

            System.out.println("\n=== 7. Collection injection: List, Array, Set ===");
            Student student = context.getBean("student", Student.class);
            student.getDetails();
            System.out.println("Array subjects: " + java.util.Arrays.toString(student.getSubjectsArray()));
            System.out.println("Set subjects: " + student.getSubjectsSet());

            System.out.println("\n=== 8. Singleton scope ===");
            Student singleton1 = context.getBean("singletonStudent", Student.class);
            Student singleton2 = context.getBean("singletonStudent", Student.class);
            System.out.println("Same instance? " + (singleton1 == singleton2));
            singleton1.setName("Singleton shared name");
            System.out.println("Second reference sees: " + singleton2.getName());

            System.out.println("\n=== 9. Prototype scope ===");
            Student prototype1 = context.getBean("prototypeStudent", Student.class);
            Student prototype2 = context.getBean("prototypeStudent", Student.class);
            System.out.println("Same instance? " + (prototype1 == prototype2));
            prototype1.setName("Only prototype 1");
            System.out.println("Prototype 2 name: " + prototype2.getName());
        }
    }
}
