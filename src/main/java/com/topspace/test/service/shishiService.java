
package com.topspace.test.service;


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
public class shishiService extends BaseService{
public UserBo selectUser() {
	QueryParam param = QueryParam.build();
	UserBo ub = (UserBo) findListBySqlKey(UserBo.class,"selectUser",null);
	return ub;
}
}