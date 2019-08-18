package com.lanqiao.domain;

import java.util.List;

/*商品表JavaBean*/
public class Commodity {
	/* 商品id */
	private Integer gid;
	/* 商品名 */
	private String gname;
	/* 商品价格 */
	private Double price;
	/* 库存 */
	private Integer stock;

	private List<String> images;

	public Commodity() {
		super();
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Commodity [gid=" + gid + ", gname=" + gname + ", price=" + price + ", stock=" + stock + ", images="
				+ images + "]";
	}

}
