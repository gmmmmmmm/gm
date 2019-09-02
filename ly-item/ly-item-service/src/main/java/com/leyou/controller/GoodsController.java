package com.leyou.controller;


import com.leyou.common.pojo.PageResult;
import com.leyou.item.bo.SpuBo;
import com.leyou.item.pojo.Sku;
import com.leyou.item.pojo.SpuDetail;
import com.leyou.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/spu/page")
    public ResponseEntity<PageResult<SpuBo>> querySpuByPage(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "rows",defaultValue = "10") Integer rows,
            @RequestParam(value = "saleable",required = false) Boolean saleable,

            @RequestParam(value = "key",required = false) String key
    ){

        PageResult<SpuBo> spuBoPageResult= goodsService.querySpuByPage(page,rows,saleable,key);

        if(spuBoPageResult!=null&&null!=spuBoPageResult.getItems()&&spuBoPageResult.getItems().size()>0){
            return  ResponseEntity.ok(spuBoPageResult);

        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("goods")
    public ResponseEntity<Void> saveGoods(@RequestBody SpuBo spuBo){
        goodsService.saveGoods(spuBo);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("spu/detail/{spuId}")
    public ResponseEntity<SpuDetail> querySpuDetailBySpuId(@PathVariable("spuId") Long id){
        SpuDetail spuDetail = goodsService.querySpuDetailBySpuId(id);

        if (spuDetail!=null){
            return ResponseEntity.ok(spuDetail);
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("sku/list")
    public ResponseEntity<List<Sku>> querySkuBySpuId(@RequestParam("id") Long spuId){
        List<Sku> skus = goodsService.querySkuBySpuId(spuId);

        if (skus!= null && skus.size()>0){
            return ResponseEntity.ok(skus);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("goods")
    public ResponseEntity<Void> updateGoods(@RequestBody SpuBo spuBo){
        goodsService.updateGoods(spuBo);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
