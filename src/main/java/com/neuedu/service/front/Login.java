package com.neuedu.service.front;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import com.neuedu.entity.Account;
import com.neuedu.service.LoginService;
import com.neuedu.service.impl.LoginServiceImpl;
import com.neuedu.utils.MD5Utils;


/**
 * Servlet implementation class Login
 */
@WebServlet("/front_/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginService ls = new LoginServiceImpl();
		
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		Account acc = ls.LogonLogic(username, MD5Utils.GetMD5Code(password));
		//Ò³ÃæÌø×ª
		if(acc!=null) {
			String methed = request.getParameter("methed");
			
			PrintWriter pw = response.getWriter();
			
			Gson gson = new Gson();
			String result = gson.toJson(acc);
			System.out.println(result);
			pw.println(methed+"("+result+")");
			
			
		
		}else {
			request.getRequestDispatcher("view/fail.jsp").forward(request, response);
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
