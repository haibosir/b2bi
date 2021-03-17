package com.lxsk.bussiness.dao;

import java.util.List;
import java.util.Map;

import com.lxsk.bussiness.domain.DiscountRateDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 平安贴现利率查询; InnoDB free: 10240 kB
 * @author hhb
 * @email 925657651@qq.com
 * @date 2021-03-09 12:37:26
 */
@Mapper
public interface DiscountRateDao {

	DiscountRateDO get(Integer id);
	
	List<DiscountRateDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DiscountRateDO discountRate);
	
	int update(DiscountRateDO discountRate);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
