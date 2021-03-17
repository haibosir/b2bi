package com.lxsk.bussiness.service;

import com.lxsk.bussiness.domain.OrderDO;

import java.util.List;
import java.util.Map;

/**
 * 平安订单申请; InnoDB free: 10240 kB
 * 
 * @author hhb
 * @email 925657651@qq.com
 * @date 2021-03-09 12:37:26
 */
public interface OrderService {
	
	OrderDO get(Integer id);
	
	List<OrderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrderDO order);
	
	int update(OrderDO order);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
