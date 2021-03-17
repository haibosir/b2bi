package com.lxsk.bussiness.service;

import com.lxsk.bussiness.domain.CancelOrderDO;

import java.util.List;
import java.util.Map;

/**
 * 平安取消订单; InnoDB free: 10240 kB
 * 
 * @author hhb
 * @email 925657651@qq.com
 * @date 2021-03-09 12:37:26
 */
public interface CancelOrderService {
	
	CancelOrderDO get(Integer id);
	
	List<CancelOrderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CancelOrderDO cancelOrder);
	
	int update(CancelOrderDO cancelOrder);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
