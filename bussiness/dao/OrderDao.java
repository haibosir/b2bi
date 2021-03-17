package com.lxsk.bussiness.dao;


import java.util.List;
import java.util.Map;

import com.lxsk.bussiness.domain.OrderDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 平安订单申请; InnoDB free: 10240 kB
 * @author hhb
 * @email 925657651@qq.com
 * @date 2021-03-09 12:37:26
 */
@Mapper
public interface OrderDao {

	OrderDO get(Integer id);
	
	List<OrderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrderDO order);
	
	int update(OrderDO order);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
