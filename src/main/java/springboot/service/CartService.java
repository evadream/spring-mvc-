/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package springboot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.mapper.CartMapper;

import javax.annotation.Resource;

/**
 * CartService
 *
 * @author huangtao
 * @date 2017/10/10
 * desc：
 */
@Service
@Transactional
public class CartService {
    @Resource
    private CartMapper cartMapper;
}

    