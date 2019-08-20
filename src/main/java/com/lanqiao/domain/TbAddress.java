package com.lanqiao.domain;

public class TbAddress {
    private Integer id;

    private Integer uid;

    private String address;

    private String isDefaultAddr;

    private String receiver;

    private String tel;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getIsDefaultAddr() {
        return isDefaultAddr;
    }

    public void setIsDefaultAddr(String isDefaultAddr) {
        this.isDefaultAddr = isDefaultAddr == null ? null : isDefaultAddr.trim();
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

   
}