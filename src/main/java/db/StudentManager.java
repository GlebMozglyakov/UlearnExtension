package db;

import models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentManager {
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();;

    public static void addStudent(Student currentStudent) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(currentStudent);
            transaction.commit();

        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public List<Student> getAllStudents() {
        try (Session session = sessionFactory.openSession()) {
            Query<Student> query = session.createQuery("from Student ", Student.class);
            return query.list();
        }
    }
}
