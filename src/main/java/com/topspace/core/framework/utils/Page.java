/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-25 下午2:04:17
 * TODO //
 */
package com.topspace.core.framework.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"rawtypes"})
public class Page implements Serializable{


    private static final long serialVersionUID = -8702537503551891547L;

    public static final Page EMPTY_PAGE;

    static{
        // 默认为空时返回空结果集、pageNo=1;totalPage=1;
        EMPTY_PAGE = new Page(new ArrayList(), 1, 0, 0);
    }

    private List list = new ArrayList<Object>(); // 记录集

    private int pageNo; // 页码;1,2,3,4

    private int pageSize; // 每页记录数

    private boolean hasNext = false; // 是否有下一次

    private int totalCount; // 记录总数

    private int totalPage;

    private PageParam pageParam;

    /**
     * 
     * @param ls
     *            查询结果List
     * @param start
     *            查询记录开始位置
     * @param count
     *            当前结果页最大条数
     * @param total
     *            满足条件记录数
     * @param flag
     *            是否有下一页
     * @param positionOfPage
     */
    public Page(List ls, int pageNo, int pageSize, int totalCount) {
        // 构造方法 (如有必要,请手工调整该方法)
        list = ls;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    } // 构造方法结束

    public int getTotalPage() {
        if(totalCount == 0){
            return 1;
        }
        if(totalCount % pageSize == 0){
            return totalCount / pageSize;
        }else{
            return (totalCount / pageSize) + 1;
        }
    }

    public int getFirstPage() {
        return 1;
    }

    public List<?> getList() {
        return list;
    }

    public boolean hasNextPage() {
        return this.pageNo < getTotalPage();

    }

    public int getSize() {
        return list.size();
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public final PageParam getPageParam() {
        return pageParam;
    }

    public final void setPageParam(PageParam pageParam) {
        this.pageParam = pageParam;
    }

}


