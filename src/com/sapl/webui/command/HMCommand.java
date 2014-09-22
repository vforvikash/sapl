package com.sapl.webui.command;

import java.util.Date;

import com.sapl.util.Constants;

public class HMCommand {
	
	private String deleted = Constants.NOT_DELETED;
	private long userPersonId = 0;
	private Date createdAt = null;
	/**
	 * @return Returns the createdAt.
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt The createdAt to set.
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	/**
	 * @return Returns the deleted.
	 */
	public String getDeleted() {
		return deleted;
	}
	/**
	 * @param deleted The deleted to set.
	 */
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	/**
	 * @return Returns the userPersonId.
	 */
	public long getUserPersonId() {
		return userPersonId;
	}
	/**
	 * @param userPersonId The userPersonId to set.
	 */
	public void setUserPersonId(long userPersonId) {
		this.userPersonId = userPersonId;
	}

}
