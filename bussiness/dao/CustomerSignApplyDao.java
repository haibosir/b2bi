package com.lxsk.bussiness.dao;

import java.util.List;
import java.util.Map;

import com.lxsk.bussiness.domain.CustomerSignApplyDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 平安 客户签约申请; InnoDB free: 10240 kB
 * @author hhb
 * @email 925657651@qq.com
 * @date 2021-03-09 12:37:26
 */
@Mapper
public interface CustomerSignApplyDao {

	CustomerSignApplyDO get(Integer id);
	
	List<CustomerSignApplyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CustomerSignApplyDO customerSignApply);
	
	int update(CustomerSignApplyDO customerSignApply);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
