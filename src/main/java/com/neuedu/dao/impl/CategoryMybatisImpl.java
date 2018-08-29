package com.neuedu.dao.impl;

import com.neuedu.dao.CategoryDao;
import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class CategoryMybatisImpl implements CategoryDao{
  @Autowired
   private  SqlSession session;


    @Override
    public List<Category> findAll() {
        return null;
    }


    /*
    * 添加一个类别
    * */
    @Override
    public boolean addCategory(Category category) {

        /*
        * namespace+id
        * */
        int result = session.insert("com.neuedu.entity.Category.addCategory",category);
        return isFou(session, result);

    }



    @Override
    public boolean updateCategory(Category category) {


        /*
         * namespace+id
         * */
        int result = session.update("com.neuedu.entity.Category.updateCateGory",category);
        return isFou(session, result);
    }

    @Override
    public boolean deleteCategory(int id) {

        /*
         * namespace+id
         * */
        int result = session.delete("com.neuedu.entity.Category.deleteCategory",id);
        return isFou(session, result);
    }

    /*封装一个结果方法*/
    private boolean isFou(SqlSession session, int result) {
        if(result==1){

            System.out.println("success");
            return true;
        }else{

            return false;
        }
    }

    @Override
    public Category findCategoryById(int id) {


        /*
         * namespace+id
         * */
        Category category = session.selectOne("com.neuedu.entity.Category.findCategoryById",id);
        return category;
    }

    @Override
    public PageModel<Category> findCategoryByPage(int pageNo, int pageSize) {


        /*
         * 1.namespace+id
         * 先查询总的记录数，然后计算总共有几页
         *
         * */

        int totalCount = session.selectOne("com.neuedu.entity.Category.findTotalCount");
        int totalPage = (totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);

        //查询页面数据
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("offset",(pageNo-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Category> categorys = session.selectList("com.neuedu.entity.Category.findCategoryByPage",map);


        PageModel<Category> pagemodel = new PageModel<Category>();
        pagemodel.setData(categorys);
        pagemodel.setCurrentPage(pageNo);
        pagemodel.setTotalpage(totalPage);

        return pagemodel;
    }
}
