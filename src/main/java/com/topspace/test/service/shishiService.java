//
//package com.topspace.test.service;
//
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.topspace.core.framework.bo.BaseBO;
//import com.topspace.core.framework.service.BaseService;
//import com.topspace.core.framework.utils.QueryParam;
//import com.topspace.customer.login.entity.UserBo;
//import com.topspace.customer.login.entity.UserInfoBo;
//
//@SuppressWarnings("rawtypes")
//@Service("shishiService")
//@Transactional
//public class ShishiService extends BaseService{
//	
//	@SuppressWarnings("unchecked")
//	public List<UserBo> selectUserList() {
//		QueryParam param = QueryParam.build();
//		return findListBySqlKey(UserBo.class,"selectUserList",param);
//}
//	@SuppressWarnings("unchecked")
//	public UserBo deleteUser(String id) {
//		QueryParam param = QueryParam.build().add("id", id);
//		UserBo ub = (UserBo) findOneBySqlKey(UserBo.class,"deleteUser",param);
//		return ub;
// }
////	@SuppressWarnings("unchecked")
////	public UserBo mixUser(String id,String userAccount) {
////		QueryParam param = QueryParam.build().add("id", id).add("userAccount", userAccount);
////		UserBo ub = (UserBo) findOneBySqlKey(UserBo.class,"changeUser",param);
////		return ub;
////}
//	@SuppressWarnings("unchecked")
//	public void mixUser(UserBo ub) {
//		update(ub);	
////		 param param = param.build().add("ub", ub);
////		updateBySqlKey(UserBo.class,"changeUser",param);
////		
//}
//}
