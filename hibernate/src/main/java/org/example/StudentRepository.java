package org.example;

import org.hibernate.SessionFactory;

public class StudentRepository extends AbstractRepository<Student, Integer> {
    public StudentRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
