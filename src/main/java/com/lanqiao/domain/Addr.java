package com.lanqiao.domain;

public class Addr {
		private Integer id;

	    private Integer uid;

	    private String address;

	    private String isDefaultAddr;

	    private String receiver;

	  private String tel;
	    private String sheng;
	    private String shi;
	    private String xian;
	    private String detail;
	    
	    
	    public String getDetail() {
			return detail;
		}

		public void setDetail(String detail) {
			this.detail = detail;
		}

		public String getSheng() {
			return sheng;
		}

		public void setSheng(String sheng) {
			this.sheng = sheng;
		}

		public String getShi() {
			return shi;
		}

		public void setShi(String shi) {
			this.shi = shi;
		}

		public String getXian() {
			return xian;
		}

		public void setXian(String xian) {
			this.xian = xian;
		}

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
