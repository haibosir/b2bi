package com.lxsk.bussiness.service;

import com.lxsk.bussiness.domain.CustomerSignApplyDO;

import java.util.List;
import java.util.Map;

/**
 * 平安 客户签约申请; InnoDB free: 10240 kB
 * 
 * @author hhb
 * @email 925657651@qq.com
 * @date 2021-03-09 12:37:26
 */
public interface CustomerSignApplyService {
	
	CustomerSignApplyDO get(Integer id);
	
	List<CustomerSignApplyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CustomerSignApplyDO customerSignApply);
	
	int update(CustomerSignApplyDO customerSignApply);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
