package com.swuorange.dto;

import java.io.Serializable;
import java.lang.Thread.State;

public class DemandSearchDTO implements Serializable {

	private static final long serialVersionUID = -3692316158735455798L;

	private Integer userId;

	private String startTime;

	private String endTime;

	private String title;

	private Integer nowPage;

	private Integer start;

	private Integer pagRow;

	private Integer state;

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getNowPage() {
		return nowPage;
	}

	public void setNowPage(Integer nowPage) {
		this.nowPage = nowPage;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getPagRow() {
		return pagRow;
	}

	public void setPagRow(Integer pagRow) {
		this.pagRow = pagRow;
	}

	@Override
	public String toString() {
		return "DemandSearchDTO [userId=" + userId + ", startTime=" + startTime + ", endTime=" + endTime + ", title="
				+ title + ", nowPage=" + nowPage + ", start=" + start + ", pagRow=" + pagRow + ", state=" + state + "]";
	}
	
}
