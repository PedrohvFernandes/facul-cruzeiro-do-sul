package com.cruzeiro;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudantServlet
 */
@WebServlet("/StudantServlet")
public class StudantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		Recuperando os dados
		List<Student> students = StudentDataUtil.getStudents();
		
//		Para settar em um atributo e pra usar na viewport no caso a viewport no HTML jsp
//		O nome do atributo e o objeto request que vai ser passado
		request.setAttribute("student_list", students);

//		Pra mandar para uma view usamos o objeto requestDispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("view_students.jsp");
//		Pega o request e o response do objeto instanciado
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
