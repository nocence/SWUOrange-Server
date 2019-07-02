package com.swuorange.dto;

/*
 * 
* @Description: 该类的描述 用于用户进行审批的时候记录信息
*
* @version: v1.0.0
* @author: Randy
* @date: 2019年3月15日 下午5:07:39
 */

public class Remarks {

	// 操作的id
	private Integer operateId;
	// 操作的备注
	private String remark;
	//审核状态
	private Integer state;

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getOperateId() {
		return operateId;
	}

	public void setOperateId(Integer operateId) {
		this.operateId = operateId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Remarks [operateId=" + operateId + ", remark=" + remark + ", state=" + state + "]";
	}

	
}
