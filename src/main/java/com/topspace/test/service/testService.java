/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-25 上午9:16:02
 * TODO //
 */
package com.topspace.test.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topspace.core.framework.service.BaseService;
import com.topspace.test.entity.TestBo;

@SuppressWarnings("rawtypes")
@Service("testService")
@Transactional
public class testService extends BaseService{
	
	public void testInsert() {
	TestBo testa = new TestBo();
	testa.setId(genUUID());
	testa.setName("testName");
	testa.setSex("man");
	testa.setAge("18");
	insert(testa);
}}


