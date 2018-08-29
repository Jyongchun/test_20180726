package com.neuedu.service.front;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import com.neuedu.entity.Cart;
import com.neuedu.service.CartService;
import com.neuedu.service.impl.CartServiceImpl;


/**
 * Servlet implementation class CartControtrooler
 */
@WebServlet("/front_/CartControtrooler")
public class CartControtrooler extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartControtrooler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT");
		response.setHeader("Access-Control-Max-Age", "3628800");*/
		String operation = request.getParameter("operation");
		if(operation.equals("1")) {
		//	addCart(request,response);
		}else if(operation.equals("2")) {
			findCart(request,response);
		}else if(operation.equals("3")) {
			deleteCart(request,response);
		}else if(operation.equals("4")) {
			updateCart(request,response);
		}else if(operation.equals("5")) {
			getCartById(request,response);
		}
		
	}

	public boolean updateCart(Cart cart) {
		CartService cs = new CartServiceImpl();
		return cs.updateCart(cart);
	}
	private void updateCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		CartService cs = new CartServiceImpl();
		int num = 0;
		int id =0;
		try {
			
			num = Integer.parseInt(request.getParameter("num"));
			id = Integer.parseInt(request.getParameter("id"));
			Cart cart = getCartById(id);
			cart.setNum(num);
			boolean result = updateCart(cart);
			System.out.println(id);
			System.out.println(num);
			System.out.println("=======update=======");
			if(result) {
				System.out.println("修改成功");

				findCart(request, response);

			}else {
				System.out.println("修改失败");
			}
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void findCart(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		System.out.println("========find=========");
		CartService cs = new CartServiceImpl();
		List<Cart> carts = cs.findCart();

		String callback = request.getParameter("callback");

		PrintWriter pw = response.getWriter();
		Gson gson = new Gson();
		String result = gson.toJson(carts);
		System.out.println(result);
		pw.println(callback+"("+result+")");
		
	}

	
	/*删除购物车*/
	public boolean deleteCart(int id) {
		CartService cs = new CartServiceImpl();
		return cs.deleteCart(id);
	}
	private void deleteCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		boolean result = false;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			result = deleteCart(id);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		if(result){
			System.out.println("删除购物车成功");
		}else {
			System.out.println("失败");
		}

		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/*
	 * 通过id寻找购物车
	 * */
	public Cart getCartById(int id) {
		CartService cs = new CartServiceImpl();
		return cs.getCartById(id);

	}
	private void getCartById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			Cart cart = getCartById(id);
			if(cart!=null) {
				
				String methed = request.getParameter("methed");
				PrintWriter pw = response.getWriter();
				Gson gson = new Gson();
				String result = gson.toJson(cart);
				System.out.println(result);
				pw.println(methed+"("+result+")");
				//response.sendRedirect("http://127.0.0.1:8020/shop/updateCart.html");
				
			}else {
				System.out.println("Fail");
			}
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		
	}
}
