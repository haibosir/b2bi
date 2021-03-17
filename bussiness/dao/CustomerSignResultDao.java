package com.lxsk.bussiness.dao;

import com.lxsk.bussiness.domain.CustomerSignResultDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 平安客户签约-结果; InnoDB free: 10240 kB
 * @author hhb
 * @email 925657651@qq.com
 * @date 2021-03-11 14:57:05
 */
@Mapper
public interface CustomerSignResultDao {

	CustomerSignResultDO get(Integer id);
	
	List<CustomerSignResultDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CustomerSignResultDO customerSignResult);
	
	int update(CustomerSignResultDO customerSignResult);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
