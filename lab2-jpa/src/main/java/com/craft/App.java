
package com.craft;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class App {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("studentPU");

    // Get an EntityManager
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // 1. CREATE
    public static void createStudent(Student student) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(student);
            tx.commit();
            System.out.println("Student created: " + student);
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    // 2. READ BY ID
    public static Student getStudentById(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Student.class, id);
        } finally {
            em.close();
        }
    }

    // 3. READ ALL
    public static List<Student> getAllStudents() {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                    "SELECT s FROM Student s ORDER BY s.id",
                    Student.class
            ).getResultList();
        }
    }

    // 4. UPDATE NAME
    public static boolean updateStudentName(String newName, int id) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Student student = em.find(Student.class, id);

            if (student == null) {
                tx.rollback();
                return false;
            }

            student.setName(newName);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    // 5. DELETE BY ENTITY
    public static boolean deleteStudentById(int id) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Student student = em.find(Student.class, id);

            if (student == null) {
                tx.rollback();
                return false;
            }

            em.remove(student);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    // 6. FIND BY EXACT NAME
    public static List<Student> getStudentsByName(String name) {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                    "SELECT s FROM Student s WHERE s.name = :name",
                    Student.class
            ).setParameter("name", name).getResultList();
        }
    }

    // 7. FIND NAME IGNORING CASE
    public static List<Student> getStudentsByNameCaseInsensitive(String name) {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                    "SELECT s FROM Student s WHERE LOWER(s.name) = LOWER(:name)",
                    Student.class
            ).setParameter("name", name).getResultList();
        }
    }

    // 8. FIND BY TECHNOLOGY
    public static List<Student> getStudentsByTech(String tech) {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                    "SELECT s FROM Student s WHERE s.tech = :tech",
                    Student.class
            ).setParameter("tech", tech).getResultList();
        }
    }

    // 9. NAME STARTS WITH
    public static List<Student> getStudentsByNameStartingWith(String prefix) {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                    "SELECT s FROM Student s WHERE s.name LIKE :pattern",
                    Student.class
            ).setParameter("pattern", prefix + "%").getResultList();
        }
    }

    // 10. NAME CONTAINS
    public static List<Student> getStudentsByNameContaining(String text) {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                    "SELECT s FROM Student s WHERE s.name LIKE :pattern",
                    Student.class
            ).setParameter("pattern", "%" + text + "%").getResultList();
        }
    }

    // 11. ID GREATER THAN
    public static List<Student> getStudentsWithIdGreaterThan(int id) {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                    "SELECT s FROM Student s WHERE s.id > :id",
                    Student.class
            ).setParameter("id", id).getResultList();
        }
    }

    // 12. ID BETWEEN TWO VALUES
    public static List<Student> getStudentsWithIdBetween(int start, int end) {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                            "SELECT s FROM Student s WHERE s.id BETWEEN :start AND :end",
                            Student.class
                    ).setParameter("start", start)
                    .setParameter("end", end).getResultList();
        }
    }

    // 13. FIND BY A LIST OF IDS
    public static List<Student> getStudentsByIds(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) return List.of();

        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                    "SELECT s FROM Student s WHERE s.id IN :ids",
                    Student.class
            ).setParameter("ids", ids).getResultList();
        }
    }

    // 14. ORDER BY NAME ASCENDING
    public static List<Student> getStudentsByNameAscending() {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                    "SELECT s FROM Student s ORDER BY s.name ASC",
                    Student.class
            ).getResultList();
        }
    }

    // 15. ORDER BY NAME DESCENDING
    public static List<Student> getStudentsByNameDescending() {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                    "SELECT s FROM Student s ORDER BY s.name DESC",
                    Student.class
            ).getResultList();
        }
    }

    // 16. FIRST N STUDENTS
    public static List<Student> getFirstNStudents(int n) {
        if (n <= 0) return List.of();

        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                    "SELECT s FROM Student s ORDER BY s.id",
                    Student.class
            ).setMaxResults(n).getResultList();
        }
    }

    // 17. PAGINATION
    public static List<Student> getStudentsWithPagination(int offset, int limit) {
        if (offset < 0 || limit <= 0) return List.of();

        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                            "SELECT s FROM Student s ORDER BY s.id",
                            Student.class
                    ).setFirstResult(offset)
                    .setMaxResults(limit).getResultList();
        }
    }

    // 18. COUNT ALL STUDENTS
    public static long countAllStudents() {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                    "SELECT COUNT(s) FROM Student s",
                    Long.class
            ).getSingleResult();
        }
    }

    // 19. COUNT STUDENTS BY TECHNOLOGY
    public static long countStudentsByTech(String tech) {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                    "SELECT COUNT(s) FROM Student s WHERE s.tech = :tech",
                    Long.class
            ).setParameter("tech", tech).getSingleResult();
        }
    }

    // 20. DISTINCT TECHNOLOGIES
    public static List<String> getDistinctTechs() {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                    "SELECT DISTINCT s.tech FROM Student s",
                    String.class
            ).getResultList();
        }
    }

    // 21. GROUP AND COUNT BY TECHNOLOGY
    public static List<Object[]> countStudentsGroupedByTech() {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                    "SELECT s.tech, COUNT(s) FROM Student s GROUP BY s.tech",
                    Object[].class
            ).getResultList();
        }
    }

    // 22. AVERAGE ID
    public static Double getAverageId() {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                    "SELECT AVG(s.id) FROM Student s",
                    Double.class
            ).getSingleResult();
        }
    }

    // 23. MAXIMUM ID
    public static Integer getMaxId() {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                    "SELECT MAX(s.id) FROM Student s",
                    Integer.class
            ).getSingleResult();
        }
    }

    // 24. MINIMUM ID
    public static Integer getMinId() {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                    "SELECT MIN(s.id) FROM Student s",
                    Integer.class
            ).getSingleResult();
        }
    }

    // 25. SUM OF IDS
    public static Long getSumOfIds() {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                    "SELECT SUM(s.id) FROM Student s",
                    Long.class
            ).getSingleResult();
        }
    }

    // 26. STUDENTS WITH THE LONGEST NAME
    public static List<Student> getStudentsWithLongestNames() {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                    "SELECT s FROM Student s WHERE LENGTH(s.name) = " +
                            "(SELECT MAX(LENGTH(s2.name)) FROM Student s2)",
                    Student.class
            ).getResultList();
        }
    }

    // 27. STUDENTS WITH NULL TECHNOLOGY
    public static List<Student> getStudentsWithNullTech() {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                    "SELECT s FROM Student s WHERE s.tech IS NULL",
                    Student.class
            ).getResultList();
        }
    }

    // 28. STUDENTS WITH NON-NULL TECHNOLOGY
    public static List<Student> getStudentsWithNonNullTech() {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                    "SELECT s FROM Student s WHERE s.tech IS NOT NULL",
                    Student.class
            ).getResultList();
        }
    }

    // 29. SEARCH BY TECHNOLOGY AND NAME PATTERN
    public static List<Student> getStudentsByTechAndNamePattern(
            String tech, String pattern) {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                            "SELECT s FROM Student s WHERE s.tech = :tech " +
                                    "AND s.name LIKE :pattern",
                            Student.class
                    ).setParameter("tech", tech)
                    .setParameter("pattern", "%" + pattern + "%")
                    .getResultList();
        }
    }

    // 30. STUDENTS SHARING TECHNOLOGY WITH ANOTHER STUDENT
    public static List<Student> getStudentsSharingTech() {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                    "SELECT s FROM Student s WHERE s.tech IS NOT NULL " +
                            "AND EXISTS (SELECT s2.id FROM Student s2 " +
                            "WHERE s2.tech = s.tech AND s2.id <> s.id)",
                    Student.class
            ).getResultList();
        }
    }

    // BULK UPDATE: update a student's technology using JPQL
    public static int updateStudentTech(int id, String newTech) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            int count = em.createQuery(
                            "UPDATE Student s SET s.tech = :tech WHERE s.id = :id"
                    ).setParameter("tech", newTech)
                    .setParameter("id", id)
                    .executeUpdate();
            tx.commit();
            return count;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    // BULK UPDATE: update technologies matching a pattern
    public static int updateTechByPattern(String oldPattern, String newTech) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            int count = em.createQuery(
                            "UPDATE Student s SET s.tech = :newTech " +
                                    "WHERE s.tech LIKE :pattern"
                    ).setParameter("newTech", newTech)
                    .setParameter("pattern", "%" + oldPattern + "%")
                    .executeUpdate();
            tx.commit();
            return count;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    // BULK DELETE: delete by ID using JPQL
    public static int deleteStudentByJpql(int id) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            int count = em.createQuery(
                    "DELETE FROM Student s WHERE s.id = :id"
            ).setParameter("id", id).executeUpdate();
            tx.commit();
            return count;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    // BULK DELETE: delete all students with a given technology
    public static int deleteStudentsByTech(String tech) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            int count = em.createQuery(
                    "DELETE FROM Student s WHERE s.tech = :tech"
            ).setParameter("tech", tech).executeUpdate();
            tx.commit();
            return count;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("========== 1. CREATE ==========");

            Student student = new Student();
            student.setName("CRUD Test Student");
            student.setTech("Python");

            createStudent(student);

            int studentId = student.getId();
            System.out.println("Generated student ID: " + studentId);


            System.out.println("\n========== 2. READ ==========");

            Student foundStudent = getStudentById(studentId);
            System.out.println("Student found: " + foundStudent);


            System.out.println("\n========== 3. UPDATE ==========");

            boolean updated = updateStudentName(
                    "CRUD Test Updated",
                    studentId
            );

            System.out.println("Update successful: " + updated);
            System.out.println("After update: " + getStudentById(studentId));


            System.out.println("\n========== 4. DELETE ==========");

            boolean deleted = deleteStudentById(studentId);
            System.out.println("Delete successful: " + deleted);

            System.out.println(
                    "Student exists after deletion: "
                            + (getStudentById(studentId) != null)
            );

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            emf.close();
        }
    }

    // TEST THE QUERIES

}
