package com.swuorange.common;

import java.util.List;

import org.springframework.stereotype.Component;
/**
 * 
 * @Description 传到前端的，用于展示给用户
 * @author wujiwei
 * @version 1.0
 * @since 1.0
 * @date 2019年3月7日
 */
@Component
public class PageResult<T> {
	/**
	 * 当前页数
	 */
	private Integer nowPage;
	/**
	 * 总页数
	 */
	private Integer totalPage;
	private List<T> list;
	/**
	 * 总数据条数
	 */
	private Integer totalData;
	
	
	public PageResult() {
		super();
	}

	public PageResult(Integer nowPage, Integer totalPage, List<T> list, Integer totalData) {
		super();
		this.nowPage = nowPage;
		this.totalPage = totalPage;
		this.list = list;
		this.totalData = totalData;
	}

	public Integer getTotalData() {
		return totalData;
	}

	public void setTotalData(Integer totalData) {
		this.totalData = totalData;
	}
	
	public Integer getNowPage() {
		return nowPage;
	}

	public void setNowPage(Integer nowPage) {
		this.nowPage = nowPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "PageResult [nowPage=" + nowPage + ", totalPage=" + totalPage + ", list=" + list + ", totalData="
				+ totalData + "]";
	}


	
}
