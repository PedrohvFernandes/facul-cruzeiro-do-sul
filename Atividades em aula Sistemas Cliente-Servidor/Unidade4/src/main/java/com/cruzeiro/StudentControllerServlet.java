package com.cruzeiro;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletSecurityElement;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentDbUtil studentDbUtil;

//	Dessa forma eu consigo pegar o datasource definido no context(xml), que é a config da conexao com o banco
//	Passando ele para o StudentDbUtil no init e la no studentDbUtil ele usa essa conexao com o banco, tendo como tipagem o objeto Student
//	fazendo as instruçoes sql dentro dela(StudentDbUtil)
//	e quem controla isso tudo é essa classe controller, centralizando tudo
	@Resource(name = "jdbc/DbStudent")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();

		try {
			studentDbUtil = new StudentDbUtil(dataSource);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		try {
//		Verificar o valor do parametro "command"
			String command = request.getParameter("command");

//		Escolher a opçcao corrta da operaçao
			if (command == null) {
				command = "LIST";
			}

			switch (command) {
			case "LIST":
				listStudents(request, response);
				break;
			case "ADD":
				addStudents(request, response);
				break;
			default:
				listStudents(request, response);

			}
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		Recuperar estudantes do banco de dados
		List<Student> students = studentDbUtil.getStudents();

//		Adicionar os dados do request
		request.setAttribute("STUDENTS_LIST", students);

//		Enviar para a pagina JSP(view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);

	}

	private void addStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		Recuperar as informaçoes enviadas

		String firstName = request.getParameter("firstName");
		String lastHame = request.getParameter("lastName");
		String email = request.getParameter("email");

		// criar um novo objeto de estudante
		Student student = new Student(0, firstName, lastHame, email);

		// gravar na base
		studentDbUtil.addStudent(student);

		// voltar para a lista de estudantes
		listStudents(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
