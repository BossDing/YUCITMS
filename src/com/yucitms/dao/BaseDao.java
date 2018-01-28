package com.yucitms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 数据访问接口
 * @author java_one
 *
 * @param <T>
 */
public interface BaseDao<T> {
	/**
	 * 保存实体
	 * 
	 * @param entity
	 */
	void save(T entity);
	/**
	 * 保存实体List
	 * 
	 * @param entity
	 */
	void saveAll(ArrayList<T> tList);

	/**
	 * 删除实体
	 * 
	 * @param id
	 */
	void delete(Integer id);
	
	/**
	 * 通过一其他ID删除oneOrMore
	 * @param oIdName
	 * @param oIdValue
	 */
	void deleteByOtherID(String oIdName,Integer oIdValue);

	/**
	 * 通过其他ID查询list
	 * @param oIdName
	 * @param oIdValue
	 * @return
	 */
	public List<T> getByOtherID(String oIdName,Integer oIdValue);
	
	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	void update(T entity);

	/**
	 * 按id查询
	 * 
	 * @param id
	 * @return
	 */
	T getById(Integer id);

	/**
	 * 按id查询
	 * 
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Integer[] ids);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<T> findAll();
	/**
	 * 分页信息，传进来的参数为  起始页，一页显示多少
	 * 
	 */
	PageBean getPageBean(int pageNum,int Pagesize,HqlHelper hqlHelper);
	/**
	 * 获取session
	 */
	Session getSession();
}
