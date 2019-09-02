package com.leyou.controller;


import com.leyou.item.pojo.Category;
import com.leyou.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("list")

    public ResponseEntity<List<Category>> queryByParentId(@RequestParam("pid")  Long id) {

        List<Category> categories = categoryService.queryByParentId(id);
        if (categories != null && categories.size() > 0) {

            return ResponseEntity.ok(categories);
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
