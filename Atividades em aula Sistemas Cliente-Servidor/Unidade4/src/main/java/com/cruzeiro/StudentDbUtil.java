package com.cruzeiro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

//Ela é responsavel por pegar os elementos, fazer uma req no banco e guardar essa info para a gente usar depois
public class StudentDbUtil {

//	Para trazer o que esta dentro do xml
	private DataSource dataSource;

//	Criar o constructor do StudentDbUtil passando o datasource, pra toda vez que a gente for chama o dbutil, ele ja vai fazer a conexao
//	isso é para fazer a conexao de tudo o que a gente tem no context
	public StudentDbUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

//	metodo que vai retornar uma lista de todos os estudantes que esta na base
	public List<Student> getStudents() throws Exception {
//		Guardando as info recebidas em uma lista
		List<Student> students = new ArrayList<>();

//		Sempre que trabalhamos com conexao a gente tem que mexer com conexao, setença e resultado de retorno
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

//		Tratamento de erro: se der erro passa para frente
		try {
//			Elementos de conexao
			con = dataSource.getConnection();
//			Instruçao que manda para o banco de dados
			String sql = "SELECT id, first_name, last_name, email FROM STUDENT ORDER BY LAST_NAME";
//			Pega essa instruçao junto com a variavel responsavel pela instruçao que é o stmt pega a conexao e
//			cria esse createStatement para executar
			stmt = con.createStatement();
//			Quando executa ele guarda o retorno na variavel rs
			rs = stmt.executeQuery(sql);

//			Esse rs.next é todos os elementos dentro dessa variavel ate que nao tenha nenhuma info
			while (rs.next()) {
//				Recuperamos os dados que o next percorreu
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");

//				guardamos dentro de um objeto
				Student tempStudent = new Student(id, firstName, lastName, email);

//				e depois guardamos dentro de uma lista
				students.add(tempStudent);

			}
			return students;
		} finally {
//			Se algo der errado eu preciso encerrar minha conexao
			close(con, stmt, rs);

		}

	}

	
	public void addStudent(Student student) throws Exception  {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "INSERT INTO STUDENT(FIRST_NAME, LAST_NAME, EMAIL) VALUE(?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, student.getFirstName());
			stmt.setString(2, student.getLastName());
			stmt.setString(3, student.getEmail());
			stmt.execute();
			
		}finally{
			close(con, stmt, null);
		}
	}
	
	
	private void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (con != null) {
				con.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
