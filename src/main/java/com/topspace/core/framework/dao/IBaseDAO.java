/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-25 下午2:01:38
 * TODO //
 */
package com.topspace.core.framework.dao;

import java.io.Serializable;
import java.util.List;

import com.topspace.core.framework.bo.BaseBO;
import com.topspace.core.framework.utils.Page;
import com.topspace.core.framework.utils.PageParam;
import com.topspace.core.framework.utils.QueryParam;

public interface IBaseDAO <T extends Serializable> {


	/**
	 * 新增
	 * 
	 * @param bo
	 *            需要持久化的业务对象
	 * @return 执行成功的记录个数
	 */
	public Integer insert(BaseBO bo);

	/**
	 * 更新
	 * 
	 * @param bo
	 *            要持久化的对象
	 * @return 执行成功的记录个数
	 */
	public Integer update(BaseBO bo);

	/**
	 * 根据唯一标识加载数据
	 * 
	 * @param clz
	 *            业务对象类型
	 * @param id
	 *            唯一标识
	 * @return 业务对象
	 */
	public T findById(Class<?> clz, String id);

	/**
	 * 根据条件查找一条数据
	 * 
	 * @param clz
	 *            业务对象类型
	 * @param param
	 *            查询参数
	 * @return
	 */
	public T findOne(Class<?> clz, QueryParam param);

	/**
	 * 删除
	 * 
	 * @param clz业务对象类型
	 * @param id
	 *            唯一标识
	 * @return 执行成功的记录个数
	 */
	public Integer deleteById(Class<?> clz, String id);

	/**
	 * 根据标识集合删除数据
	 * 
	 * @param clz
	 *            业务对象类型
	 * @param ids
	 *            唯一标识数组集合
	 * @return 删除成功的记录数
	 */
	public Integer deleteByIds(Class<?> clz, List<String> ids);

	public Page findByPage(Class<?> clz, PageParam pageParam);

	/**
	 * 获取满足查询参数条件的数据总数
	 * 
	 * @param clz
	 *            业务对象类型
	 * @param param
	 *            查询参数
	 * @return 记录数
	 */
	public Integer getCount(Class<?> clz, QueryParam param);

	public Integer getCountBySqlId(Class<?> clz, String sqlId, QueryParam param);

	public List<T> findByList(Class<?> clz, PageParam pageParam);

	public List<T> findByList(Class<?> clz, QueryParam param);

	/**
	 * 修改
	 * 
	 * @param clz
	 *            业务实体class
	 * @param sqlKey
	 *            MyBatis Mapper定义的Id
	 * @param param
	 *            参数，Map(key,value)
	 * @return 成功影响数据条数
	 */
	public Integer updateBySqlKey(Class<?> clz, String sqlKey, QueryParam param);

	public Integer updateBySqlKey(Class<?> clz, String sqlKey, BaseBO param);

	/**
	 * 新增
	 * 
	 * @param clz
	 *            业务实体class
	 * @param sqlKey
	 *            MyBatis Mapper定义的Id
	 * @param param
	 *            参数，Map(key,value)
	 * @return 成功影响数据条数
	 */
	public Integer insertBySqlKey(Class<?> clz, String sqlKey, QueryParam param);

	public Integer insertBySqlKey(Class<?> clz, String sqlKey, BaseBO param);

	/**
	 * 
	 * 删除
	 * 
	 * @param clz
	 *            业务实体class
	 * @param sqlKey
	 *            MyBatis Mapper定义的Id
	 * @param param
	 *            参数，Map(key,value)
	 * @return 成功影响数据条数
	 */
	public Integer deleteBySqlKey(Class<?> clz, String sqlKey, QueryParam param);

	/**
	 * 查询单条记录
	 * 
	 * @param clz
	 *            业务实体class
	 * @param sqlKey
	 *            MyBatis Mapper定义的Id
	 * @param param
	 *            参数，Map(key,value)
	 * @return 查询结果对象
	 */
	public T findOneBySqlKey(Class<?> clz, String sqlKey, QueryParam param);

	public T findOneBySqlKey(Class<?> clz, String sqlKey, BaseBO param);

	public List<T> findListBySqlKey(Class<?> clz, String sqlKey,
			QueryParam param);

	public List<T> findListBySqlKey(Class<?> clz, String sqlKey, BaseBO param);

	/**
	 * 查询
	 * 
	 * @param clz
	 *            业务实体class
	 * @param sqlKey
	 *            MyBatis Mapper定义的Id，需要用户自己确认 BatisMapper中定义了
	 *            sqlKey+"QureyPage", sqlKey+"QueryCount"
	 * @param param
	 *            参数，Map(key,value)
	 * @return 查询结果对象List
	 */

	public Page findPageBySqlKey(Class<?> clz, String sqlKey,
			PageParam pageParam);

	public void batchInsert(List<BaseBO> objs);

	public void batchUpdate(List<BaseBO> objs);

	void batchInsertBySqlId(List<BaseBO> objs, String sqlId);

	void batchUpdateBySqlId(List<BaseBO> objs, String sqlId);

}


