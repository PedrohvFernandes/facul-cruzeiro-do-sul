package com.cruzeiro.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cruzeiro.entity.Student;

public class StudentInsert {
	public static void main(String[] args) {
// create session factory
		SessionFactory factory = new Configuration().configure("Hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
// create session
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Criando objeto Students...");
			Student tempStudent = new Student("Alexander", "Gobbato", "alexander@cruzei");
			session.beginTransaction();
			System.out.println("Inserindo os dados no banco...");
			session.save(tempStudent);
			session.getTransaction().commit();
			System.out.println("Finalizado");
		} finally {
			factory.close();
		}
	}
}