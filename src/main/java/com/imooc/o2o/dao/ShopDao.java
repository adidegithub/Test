package com.imooc.o2o.dao;

import com.imooc.o2o.entity.Shop;

public interface ShopDao {

	/**
	 * 新增店铺成功返回1，不成功返回-1
	 * 
	 * @param shop
	 * @return
	 */
	int insertShop(Shop shop);

	/**
	 * 更新店铺信息
	 * @param shop
	 * @return
	 */
	int updateShop(Shop shop);
}
