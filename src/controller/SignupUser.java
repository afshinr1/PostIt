package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

@WebServlet("/SignupUser")
public class SignupUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Model model;

	public SignupUser() {
		super();
		model = new Model();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uName = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("mail");
		String pwdConfirm = request.getParameter("pwd-confirm");
		System.out.println(uName + " " + email + " " + " " + pwd + " " + pwdConfirm);

		boolean exist = model.checkUserExist(uName);
		if (exist == true) {
			request.setAttribute("userfail", uName);
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}

		else if (pwdConfirm.contentEquals(pwd) == false) {
			request.setAttribute("pwdfail", pwd);
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		} else if (uName.isEmpty() || pwd.isEmpty() || email.isEmpty() || pwdConfirm.isEmpty()) {
			request.setAttribute("emptyfail", "Empty");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}

		else {
			model.addUser(uName, pwd, email);
			HttpSession session = request.getSession();
			session.setAttribute("username", uName);
			request.setAttribute("succ", uName);
			RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
			rd.forward(request, response);
		}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uName = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("mail");
		String pwdConfirm = request.getParameter("pwd-confirm");
		System.out.println(uName + " " + email + " " + " " + pwd + " " + pwdConfirm);

		boolean exist = model.checkUserExist(uName);
		if (exist == true) {
			request.setAttribute("userfail", uName);
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}

		else if (pwdConfirm.contentEquals(pwd) == false) {
			request.setAttribute("pwdfail", pwd);
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		} else if (uName.isEmpty() || pwd.isEmpty() || email.isEmpty() || pwdConfirm.isEmpty()) {
			request.setAttribute("emptyfail", "Empty");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}

		else {
			model.addUser(uName, pwd, email);
			HttpSession session = request.getSession();
			session.setAttribute("username", uName);
			request.setAttribute("succ", uName);
			RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
			rd.forward(request, response);
		}

	}

}
