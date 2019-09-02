package com.leyou.controller;


import com.leyou.common.pojo.PageResult;
import com.leyou.item.pojo.Brand;
import com.leyou.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;
    //page=1&rows=5&sortBy=id&desc=false&key=
    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> pageQuery(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "rows",defaultValue = "10") Integer rows,
            @RequestParam(value = "sortBy",required = false) String sortBy,
            @RequestParam(value = "desc",required = false) Boolean desc,
            @RequestParam(value = "key",required = false) String key
    ){
        PageResult<Brand> brandPageResult=brandService.pageQuery(page,rows,sortBy,desc,key);
        if(brandPageResult!=null&&null!=brandPageResult.getItems()&&brandPageResult.getItems().size()>0){
            return  ResponseEntity.ok(brandPageResult);

        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();


    }

    @PostMapping("")
    public ResponseEntity<Void> addBrand(Brand brand,@RequestParam("cids") List<Long> cids){
        brandService.addBrand(brand,cids);


        System.out.print("fdfdfd");
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping("cid/{id}")

    public ResponseEntity<List<Brand>> queryBrandByCategory(@PathVariable("id") Long cid){

        List<Brand> brands = brandService.queryBrandByCategory(cid);


        if (brands!=null  && brands.size()>0){
            return ResponseEntity.ok(brands);
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();


    }



}
