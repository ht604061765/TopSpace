/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-25 下午1:58:54
 * TODO //
 */
package com.topspace.core.framework.service;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import com.topspace.core.framework.bo.BaseBO;
import com.topspace.core.framework.dao.IBaseDAO;
import com.topspace.core.framework.utils.Page;
import com.topspace.core.framework.utils.PageParam;
import com.topspace.core.framework.utils.QueryParam;
import com.topspace.core.utils.PKCreator;

import javax.annotation.Resource;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class BaseService<T extends Serializable>{


	protected Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "BaseDAO")
	private IBaseDAO baseDao;

	public Integer insert(BaseBO bo) {
		return this.baseDao.insert(bo);
	}

	public Integer update(BaseBO bo) {
		return this.baseDao.update(bo);
	}

	public Integer deleteById(Class clz, String id) {
		return this.baseDao.deleteById(clz, id);
	}

	public Integer deleteByIds(Class clz, List ids) {
		return this.baseDao.deleteByIds(clz, ids);
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Serializable findById(Class clz, String id) {
		return this.baseDao.findById(clz, id);
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Serializable findOne(Class clz, QueryParam param) {
		return this.baseDao.findOne(clz, param);
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Page findByPage(Class clz,  PageParam pageParam) {
		return baseDao.findByPage(clz, pageParam);
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<T> findByList(Class clz, PageParam param) {
		return this.baseDao.findByList(clz, param);
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<T> findByList(Class clz, QueryParam param) {
		return this.baseDao.findByList(clz, param);
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Integer getCount(Class clz, QueryParam param) {
		return this.baseDao.getCount(clz, param);
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Integer getCountBySqlId(Class clz, String sqlId, QueryParam param) {
		return this.baseDao.getCountBySqlId(clz, sqlId, param);
	}

	public void batchInsert(List objs) {
		this.baseDao.batchInsert(objs);
	}

	public void batchUpdate(List objs) {
		this.baseDao.batchUpdate(objs);
	}

	protected String genUUID() {
		return PKCreator.getPrimaryKey();
	}

	protected void batchInsertBySqlId(List objs, String sqlId) {
		baseDao.batchInsertBySqlId(objs, sqlId);
	}

	protected void batchUpdateBySqlId(List objs, String sqlId) {
		baseDao.batchUpdateBySqlId(objs, sqlId);
	}

	protected Integer insertBySqlKey(Class clz, String sqlKey, QueryParam param) {
		return this.baseDao.insertBySqlKey(clz, sqlKey, param);
	}

	protected Integer updateBySqlKey(Class clz, String sqlKey, QueryParam param) {
		return this.baseDao.updateBySqlKey(clz, sqlKey, param);
	}
	
	protected Integer updateBySqlKey(Class clz, String sqlKey, BaseBO param) {
		return this.baseDao.updateBySqlKey(clz, sqlKey, param);
	}

	public Integer deleteBySqlKey(Class clz, String sqlKey, QueryParam param) {
		return this.baseDao.deleteBySqlKey(clz, sqlKey, param);
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	protected T findOneBySqlKey(Class clz, String sqlKey, QueryParam param) {
		return (T) this.baseDao.findOneBySqlKey(clz, sqlKey, param);
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	protected List<T> findListBySqlKey(Class clz, String sqlKey,
			QueryParam param) {
		return this.baseDao.findListBySqlKey(clz, sqlKey, param);
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	protected Page findPageBySqlKey(Class clz, String sqlKey,
			PageParam pageParam) {
		return baseDao.findPageBySqlKey(clz, sqlKey, pageParam);
	}

}


