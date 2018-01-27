/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-28 下午8:36:12
 * TODO //
 */
package com.topspace.customer.login.service;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topspace.core.framework.service.BaseService;
import com.topspace.core.framework.utils.QueryParam;
import com.topspace.customer.login.entity.UserBo;
import com.topspace.customer.login.entity.UserInfoBo;

@SuppressWarnings("rawtypes")
@Service("")
@Transactional
public class LoginService extends BaseService{
	
	//查看是否存在这个用户
	public Integer findUser(String userAccount) {
		QueryParam param = QueryParam.build().add("userAccount", userAccount);
		Integer ub =  (Integer) findOneBySqlKey(UserBo.class,"isHaveAccount",param);
		return ub;
	}
	
	public UserBo selectUser(String userAccount) {
		QueryParam param = QueryParam.build().add("userAccount", userAccount);
		UserBo ub = (UserBo) findOneBySqlKey(UserBo.class,"selectUser",param);
		return ub;
	}
	
	public List<UserBo> selectUserList() {
		QueryParam param = QueryParam.build();
		List<UserBo> ub = findListBySqlKey(UserBo.class,"selectUserList",param);
		return ub;
	}
	
	public void insertUser(UserBo ub) {
		insert(ub);
	}
	
	public void insertUserInfo(UserInfoBo uib) {
		insert(uib);
	}
}


