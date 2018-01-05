/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-25 下午3:45:55
 * TODO //
 */
package com.topspace.core.framework.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topspace.core.framework.bo.BaseBO;
import com.topspace.core.framework.utils.Page;
import com.topspace.core.framework.utils.PageParam;
import com.topspace.core.framework.utils.QueryParam;


@Repository("BaseDAO")
public class BaseDAOImp<T extends Serializable> implements IBaseDAO<T> {


	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	public static final String SQLNAME_SEPARATOR = ".";

	public static final String SQL_INSERT = "insert";
	public static final String SQL_UPDATE = "update";
	public static final String SQL_FINDBYID = "findById";
	public static final String SQL_FINDONE = "findOne";
	public static final String SQL_DELETEBYID = "deleteById";
	public static final String SQL_DELETEBYIDS = "deleteByIds";
	public static final String SQL_FINDBYPAGE = "findByPage";
	public static final String SQL_FINDBYLIST = "findByList";
	public static final String SQL_GETCOUNT = "getCount";
	

	private static final String SORT_NAME = "SORT";

	private static final String DIR_NAME = "DIR";

	private static final String QueryCount = "QueryCount";

	private static final String QueryPage = "QueryPage";
	
	private static final String QueryTail = "_slave";
	
	private static final Map<String, Object> defaultValue = new HashMap<String, Object>();
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private SqlSession sqlSessionSlave;

	protected Map<String, Object> transPageParam(PageParam param) {
		if (param == null) {
			return defaultValue;
		}
		Map<String, Object> p = param.getParam().getParam();
		if (!p.containsKey(SORT_NAME)) {
			p.put(SORT_NAME, param.getOrderField());
		}
		if (!p.containsKey(DIR_NAME)) {
			p.put(DIR_NAME, param.getOrderType());
		}

		return p;
	}

	protected String getSqlName(Class<?> clz, String sqlName) {
		return clz.getName() + SQLNAME_SEPARATOR + sqlName;
	}

	public Integer insert(BaseBO ob) {
		this.daolog(ob.getClass(), getSqlName(ob.getClass(), SQL_INSERT),
				ob.toString());
		return sqlSession.insert(getSqlName(ob.getClass(), SQL_INSERT), ob);
	}

	public Integer update(BaseBO ob) {
		this.daolog(ob.getClass(), getSqlName(ob.getClass(), SQL_UPDATE),
				ob.toString());
		return sqlSession.update(getSqlName(ob.getClass(), SQL_UPDATE), ob);
	}

	@SuppressWarnings("unchecked")
	public T findById(Class<?> clz, String id) {
		return (T) sqlSession.selectOne(getSqlName(clz, SQL_FINDBYID), id);
	}

	public T findOne(Class<?> clz, QueryParam param) {
		return sqlSession.selectOne(getSqlName(clz, SQL_FINDONE),
				param == null ? defaultValue : param.getParam());

	}

	public Integer deleteById(Class<?> clz, String id) {
		this.daolog(clz, getSqlName(clz, SQL_DELETEBYID), id);
		return sqlSession.delete(getSqlName(clz, SQL_DELETEBYID), id);
	}

	public Integer deleteByIds(Class<?> clz, List<String> ids) {
		this.daolog(clz, getSqlName(clz, SQL_DELETEBYIDS), ids.toString());
		return sqlSession.delete(getSqlName(clz, SQL_DELETEBYIDS), ids);
	}

	public Integer getCount(Class<?> clz, QueryParam param) {
		return (Integer) sqlSession.selectOne(getSqlName(clz, SQL_GETCOUNT),
				param.getParam());
	}

	public Integer getCountBySqlId(Class<?> clz, String sqlId, QueryParam param) {
		return (Integer) sqlSession.selectOne(getSqlName(clz, sqlId),
				param == null ? defaultValue : param.getParam());

	}

	public List<T> findByList(Class<?> clz, QueryParam param) {
		long s = System.currentTimeMillis();
		List<T> lst = sqlSession.selectList(getSqlName(clz, SQL_FINDBYLIST),
				param == null ? defaultValue : param.getParam());
		LOG.debug("BaseDAOImp findByList 。。。。。" + clz.getName() + "===耗费时间="
				+ (System.currentTimeMillis() - s));
		return lst;
	}

	public List<T> findByList(Class<?> clz, PageParam param) {
		long s = System.currentTimeMillis();
		List<T> lst = sqlSession.selectList(getSqlName(clz, SQL_FINDBYLIST),
				transPageParam(param));
		LOG.debug("BaseDAOImp findByList 。。。。。" + clz.getName() + "===耗费时间="
				+ (System.currentTimeMillis() - s));
		return lst;
	}

	// 扩展给基类调用
	public Integer insertBySqlKey(Class<?> clz, String sqlKey, QueryParam param) {
		this.daolog(clz, getSqlName(clz, sqlKey), param.getParam().toString());
		return sqlSession.insert(getSqlName(clz, sqlKey), param.getParam());
	}

	public Integer insertBySqlKey(Class<?> clz, String sqlKey, BaseBO param) {
		this.daolog(clz, getSqlName(clz, sqlKey), param.toString());
		return sqlSession.insert(getSqlName(clz, sqlKey), param);
	}

	public Integer updateBySqlKey(Class<?> clz, String sqlKey, QueryParam param) {
		this.daolog(clz, getSqlName(clz, sqlKey), param.getParam().toString());
		return sqlSession.update(getSqlName(clz, sqlKey), param.getParam());
	}

	public Integer updateBySqlKey(Class<?> clz, String sqlKey, BaseBO param) {
		this.daolog(clz, getSqlName(clz, sqlKey), param.toString());
		return sqlSession.update(getSqlName(clz, sqlKey), param);
	}

	public Integer deleteBySqlKey(Class<?> clz, String sqlKey, BaseBO param) {
		this.daolog(clz, getSqlName(clz, sqlKey), param.toString());
		return sqlSession.delete(getSqlName(clz, sqlKey), param);
	}

//	@Override
	public Integer deleteBySqlKey(Class<?> clz, String sqlKey, QueryParam param) {
		this.daolog(clz, getSqlName(clz, sqlKey), param.getParam().toString());
		return sqlSession.delete(getSqlName(clz, sqlKey),
				param == null ? defaultValue : param.getParam());
	}

	public T findOneBySqlKey(Class<?> clz, String sqlKey, QueryParam param) {
		long s = System.currentTimeMillis();
		T t = sqlSession.selectOne(getSqlName(clz, sqlKey),
				param == null ? defaultValue : param.getParam());
		LOG.debug("BaseDAOImp findListBySqlKey 。。。。。" + clz.getName()
				+ "===耗费时间=" + (System.currentTimeMillis() - s));
		return t;
	}

	public T findOneBySqlKey(Class<?> clz, String sqlKey, BaseBO param) {
		long s = System.currentTimeMillis();
		T t = sqlSession.selectOne(getSqlName(clz, sqlKey), param);
		LOG.debug("BaseDAOImp findListBySqlKey 。。。。。" + clz.getName()
				+ "===耗费时间=" + (System.currentTimeMillis() - s));
		return t;
	}

//	@Override
	public List<T> findListBySqlKey(Class<?> clz, String sqlKey, BaseBO param) {

		long s = System.currentTimeMillis();
		List<T> rst;
		if (sqlKey.endsWith(QueryTail)) { //如果是以‘_slave’结尾，就调用第二个数据源
			try {
				rst = sqlSessionSlave.selectList(getSqlName(clz, sqlKey), param);
			} catch (Exception e) {  //如果第二个数据源获取失败，就从第一个数据源获取
				rst = sqlSession.selectList(getSqlName(clz, sqlKey), param);
			}
		} else {   //否则调用第一个数据源
			rst = sqlSession.selectList(getSqlName(clz, sqlKey), param);
		}
		LOG.debug("BaseDAOImp findListBySqlKey 。。。。。" + clz.getName()
				+ "===耗费时间=" + (System.currentTimeMillis() - s));
		return rst;
	}

	public List<T> findListBySqlKey(Class<?> clz, String sqlKey,
			QueryParam param) {
		long s = System.currentTimeMillis();
		List<T> rst;
		if (sqlKey.endsWith(QueryTail)) { 
			try {
				rst = sqlSessionSlave.selectList(getSqlName(clz, sqlKey),
						param == null ? defaultValue : param.getParam());
			} catch (Exception e) {
				rst = sqlSession.selectList(getSqlName(clz, sqlKey),
						param == null ? defaultValue : param.getParam());
			}
		} else {
			rst = sqlSession.selectList(getSqlName(clz, sqlKey),
					param == null ? defaultValue : param.getParam());
		}
		LOG.debug("BaseDAOImp findListBySqlKey 。。。。。" + clz.getName()
				+ "===耗费时间=" + (System.currentTimeMillis() - s));
		return rst;
	}

	public Page findByPage(Class<?> clz, PageParam pageParam) {
		Page page = findPageBySqlId(clz, SQL_FINDBYPAGE, SQL_GETCOUNT,
				pageParam);
		page.setPageParam(pageParam);
		return page;
	}

	public Page findPageBySqlKey(Class<?> clz, String sqlKey,
			PageParam pageParam) {
		String countSql = sqlKey + QueryCount;
		String querySql = sqlKey + QueryPage;
		Page page = findPageBySqlId(clz, querySql, countSql, pageParam);
		page.setPageParam(pageParam);
		return page;
	}

	private Page findPageBySqlId(Class<?> clz, String querySql,
			String countSql, PageParam pageParam) {
		long s = System.currentTimeMillis();
		// 获取满足条件的记录总数，没有记录时返回空页数据
		int count = getCountBySqlId(clz, countSql, pageParam.getParam());
		LOG.debug("分页查询出的记录数=" + count);
		if (count < 1) {
			return Page.EMPTY_PAGE;
		}

		int pageNo = pageParam.getPageNo();
		int pageSize = pageParam.getPageSize();
		// 分页条件
		int start = (pageNo - 1) * pageSize;
		RowBounds rowBound = new RowBounds(start, pageSize);

		List<T> lst = sqlSession.selectList(getSqlName(clz, querySql),
				transPageParam(pageParam), rowBound);
		LOG.debug("BaseDAOImp findByPage 。。。。。" + clz.getName() + "===耗费时间="
				+ (System.currentTimeMillis() - s));
		Page page = new Page(lst, pageNo, pageSize, count);
		// page.setPageParam(pageParam);
		return page;
	}

	public void batchInsert(List<BaseBO> objs) {
		batchInsertBySqlId(objs, SQL_INSERT);
	}

	public void batchInsertBySqlId(List<BaseBO> objs, String sqlId) {
		SqlSession bsqlse = getBatchSqlSession();
		for (BaseBO bo : objs) {
			bsqlse.insert(getSqlName(bo.getClass(), sqlId), bo);
		}
		bsqlse.flushStatements();
	}

	public void batchUpdate(List<BaseBO> objs) {
		batchUpdateBySqlId(objs, SQL_UPDATE);
	}

	public void batchUpdateBySqlId(List<BaseBO> objs, String sqlId) {
		SqlSession bsqlse = getBatchSqlSession();
		for (BaseBO bo : objs) {
			bsqlse.update(getSqlName(bo.getClass(), sqlId), bo);
		}
		bsqlse.flushStatements();
	}

	private SqlSession getBatchSqlSession() {
		return sqlSession;
	}

	@SuppressWarnings("rawtypes")
	private void daolog(Class clz, String sqlKey, String param) {
//		LOG.info(" 账号 ["
//				+ SystemThreadLocal.getInstanse().getLoginSysAccountId()
//				+ "] 通过IP["+SystemThreadLocal.getInstanse().getReqIP()+"] 调用[" + sqlKey + "] 操作 [" + clz.getSimpleName() + "] 参数 ["
//				+ param + "]");
	}

}


