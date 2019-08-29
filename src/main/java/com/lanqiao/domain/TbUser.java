package com.lanqiao.domain;

import java.util.Date;

public class TbUser {
    private Integer uid;

    private String username;

    private String realname;

    private String sex;

    private String password;

    private String phone;

    private String isSell;
    private String email;
    private String birth;
    private String image;
    
    
    public TbUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	



	public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

	

	public String getIsSell() {
		return isSell;
	}

	public void setIsSell(String isSell) {
		this.isSell = isSell;
	}

	@Override
	public String toString() {
		return "TbUser [uid=" + uid + ", username=" + username + ", realname=" + realname + ", sex=" + sex
				+ ", password=" + password + ", phone=" + phone + ", isSell=" + isSell + ", email=" + email + ", birth="
				+ birth + ", image=" + image + "]";
	}
    

}