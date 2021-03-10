/*
 * Copyright (c) ${YEAR} J`Han, private. All rights reserved.
 */
package me.jhan.seckill.sample.controller;

import me.jhan.seckill.sample.service.SeckillService;
import me.jhan.seckill.sample.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author J`Han
 * @since 2021/3/9-9:46 上午
 */
@RestController
@RequestMapping("/seckill")
public class SeckillController {
    @Autowired
    private SeckillService seckillService;
    @GetMapping("/{productId}/{userId}")
    public ResponseVo seckillProduct(@PathVariable("productId")Long productId,
                                     @PathVariable("userId")Long userId){
        Assert.notNull(productId, () -> "商品参数不能为空");
        Assert.notNull(userId, () -> "用户参数不能为空");
        return seckillService.seckillProduct(productId, userId);
    }
}