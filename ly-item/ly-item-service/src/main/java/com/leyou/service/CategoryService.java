package com.leyou.service;

import com.leyou.item.pojo.Category;
import com.leyou.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryByParentId(Long id) {
        Category category=new Category();
        category.setParentId(id);

        return categoryMapper.select(category);
        //select * from tb_category where parent_id=0;
    }

    public List<String> queryNamesByIds(List<Long> asList) {
        //74 75 76
        List<String>  namess=  new ArrayList<>();

        //select * from tb_category where id in (74,75,76)
        List<Category> categories= categoryMapper.selectByIdList(asList);

        categories.forEach(t->{
            namess.add(t.getName());

        });
        return namess;
    }
}
