package com.craft;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        // Start Spring using annotation configuration
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(
                             AppConfig.class)) {

            System.out.println(
                    "\n===================================="
            );

            System.out.println(
                    " SPRING ANNOTATION-BASED LAB 4"
            );

            System.out.println(
                    "===================================="
            );

            // 1. IoC and dependency injection
            System.out.println(
                    "\n=== 1. Setter and Object Injection ==="
            );

            Student student =
                    context.getBean("student", Student.class);

            student.getDetails();

            // 2. Setter injection
            System.out.println(
                    "\n=== 2. Setter Injection ==="
            );

            Student setterStudent =
                    context.getBean(
                            "setterStudent",
                            Student.class
                    );

            System.out.println(setterStudent);

            // 3. Constructor injection
            System.out.println(
                    "\n=== 3. Constructor Injection ==="
            );

            Student constructorStudent =
                    context.getBean(
                            "constructorStudent",
                            Student.class
                    );

            System.out.println(constructorStudent);

            // 4. Singleton scope
            System.out.println(
                    "\n=== 4. Singleton Scope ==="
            );

            Student singleton1 =
                    context.getBean(
                            "singletonStudent",
                            Student.class
                    );

            Student singleton2 =
                    context.getBean(
                            "singletonStudent",
                            Student.class
                    );

            System.out.println(
                    "Same instance? " +
                            (singleton1 == singleton2)
            );

            // 5. Prototype scope
            System.out.println(
                    "\n=== 5. Prototype Scope ==="
            );

            Student prototype1 =
                    context.getBean(
                            "prototypeStudent",
                            Student.class
                    );

            Student prototype2 =
                    context.getBean(
                            "prototypeStudent",
                            Student.class
                    );

            System.out.println(
                    "Same instance? " +
                            (prototype1 == prototype2)
            );

            System.out.println(
                    "\n===================================="
            );

            System.out.println(
                    " LAB 4 COMPLETED SUCCESSFULLY"
            );

            System.out.println(
                    "===================================="
            );
        }
    }
}