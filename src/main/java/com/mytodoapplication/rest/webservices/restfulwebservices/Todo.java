package com.mytodoapplication.rest.webservices.restfulwebservices;

import java.util.Date;

public class Todo {

	private long id;
	private String username;
	private String description;
	private Date targateDate;

	private boolean isComplted;
	protected Todo()
	{
		 
	}

	public Todo(long id, String username, String description, boolean isComplted, Date targateDate) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.isComplted = isComplted;
		this.targateDate = targateDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getIsComplted() {
		return isComplted;
	}

	public void setIsComplted(boolean isComplted) {
		this.isComplted = isComplted;
	}

	public Date getTargatesDate() {
		return targateDate;
	}

	public void setTargatesDate(Date targateDate) {
		this.targateDate = targateDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	

}
