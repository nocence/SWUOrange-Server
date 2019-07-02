package com.swuorange.dto;


public class SupplySearchDTO {

	private Integer userId;
	private String startTime;
	private String endTime;
	private String title;
	private Integer nowPage;
	private Integer start;
	private Integer pageRow;
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

	public Integer getPageRow() {
		return pageRow;
	}

	public void setPageRow(Integer pageRow) {
		this.pageRow = pageRow;
	}

	@Override
	public String toString() {
		return "SupplySearchDTO [userId=" + userId + ", startTime=" + startTime + ", endTime=" + endTime + ", title="
				+ title + ", nowPage=" + nowPage + ", start=" + start + ", pageRow=" + pageRow + ", state=" + state
				+ "]";
	}
	
}
