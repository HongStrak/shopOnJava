package com.lanqiao.domain;


public class Comment {
	private Integer uid;
	private Integer gid;
	private String comment;
	private Integer ctype;
	private Integer praise;
	
	
	
	public Comment() {
		super();
		
	}
	
	public Comment(Integer uid, Integer gid) {
		super();
		this.uid = uid;
		this.gid = gid;
	}

	public Integer getPraise() {
		return praise;
	}
	public void setPraise(Integer praise) {
		this.praise = praise;
	}
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getCtype() {
		return ctype;
	}
	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}
	@Override
	public String toString() {
		return "Comment [uid=" + uid + ", gid=" + gid + ", comment=" + comment + ", ctype=" + ctype + ", praise="
				+ praise + ", user=" + user + "]";
	}
	

}
