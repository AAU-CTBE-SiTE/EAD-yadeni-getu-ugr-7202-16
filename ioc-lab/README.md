# Day 1 – Spring Core: IoC and Bean Management Lab

Package: `com.craft` | Maven | Java 17 | Spring Framework `spring-context` 6.2.7.

## Run
1. Open this folder in IntelliJ IDEA (the folder containing `pom.xml`).
2. Wait for Maven sync; ensure internet access is available so Maven can download `spring-context`.
3. Open `src/main/java/com/craft/App.java` and run `main()`.

## Activities covered from the supplied 28-page lab PDF
- Create a Maven Java project and configure Spring Core dependency.
- Create `Student`, `Address`, and `Subject` classes and an XML file in `src/main/resources/beansConfig.xml`.
- Load `ApplicationContext` with `ClassPathXmlApplicationContext` and retrieve beans using `getBean`.
- Setter injection of literal values: ID, name, age, city, country.
- Read/print bean properties.
- Constructor injection using named arguments, ordered arguments, and index (0-based).
- Object dependency injection using `ref="address"` via setter and constructor.
- Collection injection using `<list>`, `<array>`, and `<set>`.
- Singleton scope: same object returned; changes visible through both references.
- Prototype scope: new object per lookup; separate object state.

## Expected checks
- Student details show injected fields and address.
- List subjects: `Maths 101`, `Java EE`.
- Singleton prints `Same instance? true`.
- Prototype prints `Same instance? false`.

The PDF presents array/set as alternative collection examples, so this project demonstrates list, array, and set together for easy verification. The early standalone `new Student()` example is the concept motivating IoC; the final activities use Spring-managed beans.
