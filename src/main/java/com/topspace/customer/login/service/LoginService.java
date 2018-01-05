/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-28 下午8:36:12
 * TODO //
 */
package com.topspace.customer.login.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topspace.core.framework.service.BaseService;
import com.topspace.customer.login.entity.UserBo;
import com.topspace.customer.login.entity.UserInfoBo;

@SuppressWarnings("rawtypes")
@Service("")
@Transactional
public class LoginService extends BaseService{

	public void insertUser(UserBo ub) {
		//TODO
		insert(ub);
	}
	
	public void insertUserInfo(UserInfoBo uib) {
		//TODO
		insert(uib);
	}
}


