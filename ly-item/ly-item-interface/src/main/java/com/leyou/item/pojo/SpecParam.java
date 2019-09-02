package com.leyou.item.pojo;

import lombok.Data;

import javax.persistence.*;
@Data
@Table(name = "tb_spec_param")
public class SpecParam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cid;
    private Long groupId;
    private String name;
    @Column(name = "`numeric`")
    private Boolean numeric;//'是否是数字类型参数，true或false',
    private String unit;//'数字类型参数的单位，非数字类型可以为空',
    private Boolean generic;//'是否是sku通用属性，true或false',
    private Boolean searching;//'是否用于搜索过滤，true或false',
    private String segments;//'数值类型参数，如果需要搜索，则添加分段间隔值，如CPU频率间隔：0.5-1.0'


   }