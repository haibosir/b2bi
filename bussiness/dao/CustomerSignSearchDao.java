package com.lxsk.bussiness.dao;

import com.lxsk.bussiness.domain.CustomerSignSearchDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 客户签约查询; InnoDB free: 10240 kB
 * @author hhb
 * @email 925657651@qq.com
 * @date 2021-03-11 14:57:05
 */
@Mapper
public interface CustomerSignSearchDao {

	CustomerSignSearchDO get(Integer id);
	
	List<CustomerSignSearchDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CustomerSignSearchDO customerSignSearch);
	
	int update(CustomerSignSearchDO customerSignSearch);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
