/*
 * Copyright (c) ${YEAR} J`Han, private. All rights reserved.
 */
package me.jhan.seckill.sample.service.impl;

import io.lettuce.core.RedisClient;
import me.jhan.seckill.sample.service.SeckillService;
import me.jhan.seckill.sample.vo.ResponseVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author J`han
 * @since 2021/3/9-10:14 上午
 */
@Service
public class SeckillServiceImpl implements SeckillService {
    @Resource
    private RedisClient redisClient;
    @Override
    public ResponseVo seckillProduct(Long productId, Long userId) {
        return null;
    }

    @Override
    public void preLoadseckillProduct(Long productId, Date start, Date end) {

    }
}