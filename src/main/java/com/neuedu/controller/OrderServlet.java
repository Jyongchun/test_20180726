package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.UserOrder;
import com.neuedu.entity.UserOrderItem;
import com.neuedu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class OrderServlet
 */

@Controller
@WebServlet("/view/OrderServlet")
public class OrderServlet extends HttpServlet {

	@Autowired
	private OrderService os;
    @Autowired
    ProductServlet	pServlet;



	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,this.getServletContext());

	}

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if(operation.equals("1")) {
			createOrder(request,response);
		}else if(operation.equals("2")) {
			findAll(request,response);
		}else if(operation.equals("3")) {
			findOrder(request,response);
		}
			
		
		
	}

	/*
	 * ��jspҳ����ʾ����
	 * */
	
	
	//����
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<UserOrder> orders = os.findAll();
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("ordershow.jsp").forward(request, response);
		
	}

	//������ϸ
	private void findOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long order_no = Long.parseLong(request.getParameter("order_no"));

		UserOrder item = os.findOrder(order_no);
        List<UserOrderItem> items = item.getOrderItemList();
		request.setAttribute("items", items);
		request.getRequestDispatcher("orderitem.jsp").forward(request, response);
		
	}

	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	


	/*
	 * �¶���
	 * */
	public void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(os.createOrder()) {
			System.out.println("�µ��ɹ�");

			pServlet.findAll(request, response);
			//findAll(request,response);
		}else {
			System.out.println("�µ�ʧ��");
		}

	}

	

}
