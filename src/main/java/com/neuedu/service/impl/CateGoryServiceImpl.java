package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.dao.CategoryDao;
import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;
import com.neuedu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CateGoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDao cgd;

	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub
		return cgd.addCategory(category);
	}


	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return cgd.findAll();
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		return cgd.updateCategory(category);
	}

	@Override
	public boolean deleteCategory(int id) {
		// TODO Auto-generated method stub
		return cgd.deleteCategory(id);
	}

	@Override
	public Category findCategoryById(int id) {
		// TODO Auto-generated method stub
		return cgd.findCategoryById(id);
	}

	@Override
	public PageModel<Category> findCategoryByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return cgd.findCategoryByPage(pageNo, pageSize);
	}



}
