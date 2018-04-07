package com.imooc.o2o.entity;

import java.util.Date;

public class WechatAuth {
	private Long weChatId;
	private String openId;
	private Date createTime;
	private PersonInfo personInfo;

	public Long getWeChatId() {
		return weChatId;
	}

	public void setWeChatId(Long weChatId) {
		this.weChatId = weChatId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

}
