package com.lxsk.bussiness.service;

import com.lxsk.bussiness.domain.DiscountRateDetailDO;

import java.util.List;
import java.util.Map;

/**
 * 平安利率查询详情; InnoDB free: 10240 kB
 * 
 * @author hhb
 * @email 925657651@qq.com
 * @date 2021-03-09 12:37:26
 */
public interface DiscountRateDetailService {
	
	DiscountRateDetailDO get(Integer id);
	
	List<DiscountRateDetailDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DiscountRateDetailDO discountRateDetail);
	
	int update(DiscountRateDetailDO discountRateDetail);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
