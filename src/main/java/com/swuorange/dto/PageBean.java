package com.swuorange.dto;

import java.util.List;

/*
 * 
* @Description: 该类的描述 该类用于分页   使用时先查询总条数赋值给totalRow   
* 				会自动根据每页的条数改变总页数
*
* @version: v1.0.0
* @author: Randy
* @date: 2019年3月9日 下午1:39:28
 */

public class PageBean<T> {

	// 当前页
	private Integer nowPage;
	
	// 总页数
	private Integer totalPage;

	// 每页条数 默认设置十条
	private Integer pageRow=10;

	// 总条数
	private Integer totalRow;

	// 存放返回的list
	private List<T> list;

	public PageBean() {
	}

	public PageBean(Integer pageRow) {
		super();
		this.pageRow = pageRow;
	}

	public Integer getNowPage() {
		return nowPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getPageRow() {
		return pageRow;
	}

	public void setPageRow(Integer pageRow) {
		this.pageRow = pageRow;
	}

	public Integer getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(Integer totalRow) {
		// 传入总得条数设置总页数
		this.totalRow = totalRow;
		setTotalPage(totalRow % pageRow == 0 ? totalRow / pageRow : (totalRow / pageRow) + 1);
	}

	public List<T> getList() {
		return list;
	}

	public void setNowPage(Integer nowPage) {
		this.nowPage = nowPage;
	}

	public void setList(List<T> list) {
		this.list = list;
	}


}
