package com.lxsk.bussiness.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.lxsk.bussiness.dao.CustomerSignSearchDao;
import com.lxsk.bussiness.domain.CustomerSignSearchDO;
import com.lxsk.bussiness.service.CustomerSignSearchService;



@Service
public class CustomerSignSearchServiceImpl implements CustomerSignSearchService {
	@Autowired
	private CustomerSignSearchDao customerSignSearchDao;
	
	@Override
	public CustomerSignSearchDO get(Integer id){
		return customerSignSearchDao.get(id);
	}
	
	@Override
	public List<CustomerSignSearchDO> list(Map<String, Object> map){
		return customerSignSearchDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return customerSignSearchDao.count(map);
	}
	
	@Override
	public int save(CustomerSignSearchDO customerSignSearch){
		return customerSignSearchDao.save(customerSignSearch);
	}
	
	@Override
	public int update(CustomerSignSearchDO customerSignSearch){
		return customerSignSearchDao.update(customerSignSearch);
	}
	
	@Override
	public int remove(Integer id){
		return customerSignSearchDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return customerSignSearchDao.batchRemove(ids);
	}
	
}
