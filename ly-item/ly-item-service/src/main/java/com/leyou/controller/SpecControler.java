package com.leyou.controller;


import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import com.leyou.service.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spec")
public class SpecControler {

    @Autowired
    private SpecService specService;

    @GetMapping("groups/{id}")
    public ResponseEntity<List<SpecGroup>> querySpecGroups(@PathVariable("id") Long cid){
        List<SpecGroup> specGroups = specService.querySpecGroup(cid);

    if (specGroups!=null&&specGroups.size()>0){

        return ResponseEntity.ok(specGroups);
    }

    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("params")

    public ResponseEntity<List<SpecParam>> querySpecParam(@RequestParam(value = "gid",required = false) Long gid,
                                                          @RequestParam(value = "cid",required = false) Long cid,
                                                          @RequestParam(value = "searching",required = false) Boolean searching,
                                                          @RequestParam(value="generic",required = false) Boolean generic){
        List<SpecParam> specParams = specService.querySpecParam(gid,cid,searching,generic);
        if (specParams!=null &&specParams.size()>0){
            return ResponseEntity.ok(specParams);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


















}
