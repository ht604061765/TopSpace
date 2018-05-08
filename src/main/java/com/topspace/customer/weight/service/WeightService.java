package com.topspace.customer.weight.service;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topspace.core.framework.service.BaseService;
import com.topspace.core.framework.utils.QueryParam;
import com.topspace.customer.login.entity.UserBo;
import com.topspace.customer.weight.entity.WeightBo;


@SuppressWarnings("rawtypes")
@Service("")
@Transactional
public class WeightService extends BaseService{
	public void weightinsert(WeightBo ub) {
		insert(ub);
	}

}