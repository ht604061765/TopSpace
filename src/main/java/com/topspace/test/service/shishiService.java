
package com.topspace.test.service;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topspace.core.framework.service.BaseService;
import com.topspace.core.framework.utils.QueryParam;
import com.topspace.customer.login.entity.UserBo;
import com.topspace.customer.login.entity.UserInfoBo;

@SuppressWarnings("rawtypes")
@Service("shishiService")
@Transactional
public class ShishiService extends BaseService{
	
	@SuppressWarnings("unchecked")
	public List<UserBo> selectUser() {
		QueryParam param = QueryParam.build();
		return findListBySqlKey(UserBo.class,"selectUser",param);
}
}