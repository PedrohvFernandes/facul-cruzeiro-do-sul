package com.cruzeiro.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cruzeiro.entity.Student;

public class StudentSelectById {
	public static void main(String args[])  {
		SessionFactory factory = new Configuration().configure("Hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.print("\n\nSeleciona o registro pelo ID: " + studentId);
			Student myStudent = session.get(Student.class, studentId);
			System.out.print("Dados: " + myStudent);
			
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}
}
