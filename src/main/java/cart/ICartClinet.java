/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package cart;

/**
 * ICartClinet
 *
 * @author huangtao
 * @date 2017/9/29
 * desc：
 */
public interface ICartClinet {
    <T extends CartResponse>  T execute(CartRequest<T> cartRequest);
}

    