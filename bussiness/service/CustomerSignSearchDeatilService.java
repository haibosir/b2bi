package com.lxsk.bussiness.service;

import com.lxsk.bussiness.domain.CustomerSignSearchDeatilDO;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 10240 kB
 * 
 * @author hhb
 * @email 925657651@qq.com
 * @date 2021-03-11 14:57:05
 */
public interface CustomerSignSearchDeatilService {
	
	CustomerSignSearchDeatilDO get(Integer id);
	
	List<CustomerSignSearchDeatilDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CustomerSignSearchDeatilDO customerSignSearchDeatil);
	
	int update(CustomerSignSearchDeatilDO customerSignSearchDeatil);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
