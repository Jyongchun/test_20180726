package com.neuedu.service.impl;
import java.util.List;
import com.neuedu.dao.ProductDao;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImplSql implements ProductService {

	@Autowired
	ProductDao productdao;


	public void init(){
		System.out.println("==init==");
	}



	public boolean addProduct(Product product) {
		
		return productdao.addProduct(product);
	}

	@Override
	public List<Product> findAll() {
		
		return  productdao.findAll();
	}

	@Override
	public boolean updateProduct(Product product) {
	
		return productdao.updateProduct(product);
	}

	@Override
	public boolean deleteProduct(int id) {
	
		return productdao.deleteProduct(id);
	}

	@Override
	public Product findProductById(int id) {
		
		return productdao.findProductById(id);
	}

	//∑÷“≥≤È—Ø
	public PageModel<Product> findProductByPage(int pageNo, int pageSize) {
		
		return productdao.findProductByPage(pageNo, pageSize);
	}

	public void destroy(){
		System.out.println("==destroy==");
	}
}
