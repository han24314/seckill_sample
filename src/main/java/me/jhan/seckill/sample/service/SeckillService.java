/*
 * Copyright (c) ${YEAR} J`Han, private. All rights reserved.
 */
package me.jhan.seckill.sample.service;

import me.jhan.seckill.sample.vo.ResponseVo;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

/**
 * @author J`Han
 * @date Created at 2021/3/9
 **/
public interface SeckillService {
    /**
     * 用户发起秒杀操作功作
     * @param productId 商品Id
     * @param userId 用户Id
     * @return 略
     */
    ResponseVo seckillProduct(@PathVariable("productId")Long productId,
                              @PathVariable("userId")Long userId);

    /**
     * 预加载秒杀商品/设定秒杀/开启秒杀
     * @param productId 商品Id
     * @param start 开始时间
     * @param end 结束时间
     */
    void preLoadseckillProduct(Long productId, Date start, Date end);
}
