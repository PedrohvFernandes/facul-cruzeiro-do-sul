package com.cruzeiro;

import java.util.ArrayList;
import java.util.List;

// Nosso suposto select no banco de dados
public class StudentDataUtil {
//	Construtor vazio
	public StudentDataUtil() {

	}

//	Metodo que retorna uma lista de estudantes
	public static List<Student> getStudents() {
		// criar uma lista vazia
		List<Student> students = new ArrayList<>();

		// adicionar dados a lista
		students.add(new Student("Aluno1", "Sobrenom1", "Email1"));
		students.add(new Student("Aluno2", "Sobrenom2", "Email2"));
		students.add(new Student("Aluno3", "Sobrenom3", "Email3"));

		return students;
	}
}
