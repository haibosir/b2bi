package com.lxsk.bussiness.service.impl;

import com.lxsk.bussiness.dao.CustomerSignApplyDao;
import com.lxsk.bussiness.domain.CustomerSignApplyDO;
import com.lxsk.bussiness.service.CustomerSignApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;




@Service
public class CustomerSignApplyServiceImpl implements CustomerSignApplyService {
	@Autowired
	private CustomerSignApplyDao customerSignApplyDao;
	
	@Override
	public CustomerSignApplyDO get(Integer id){
		return customerSignApplyDao.get(id);
	}
	
	@Override
	public List<CustomerSignApplyDO> list(Map<String, Object> map){
		return customerSignApplyDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return customerSignApplyDao.count(map);
	}
	
	@Override
	public int save(CustomerSignApplyDO customerSignApply){
		return customerSignApplyDao.save(customerSignApply);
	}
	
	@Override
	public int update(CustomerSignApplyDO customerSignApply){
		return customerSignApplyDao.update(customerSignApply);
	}
	
	@Override
	public int remove(Integer id){
		return customerSignApplyDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return customerSignApplyDao.batchRemove(ids);
	}
	
}
