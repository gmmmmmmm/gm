package com.leyou.item.bo;


import com.leyou.item.pojo.Sku;
import com.leyou.item.pojo.Spu;
import com.leyou.item.pojo.SpuDetail;
import lombok.Data;

import java.util.List;

@Data
public class SpuBo extends Spu {
    public String cname;

    public String bname;

    public List<Sku> skus;

    public SpuDetail spuDetail;

}
