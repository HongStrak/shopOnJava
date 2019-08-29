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
	// 月销售量
	private Integer mouthlySales;
	// 销售总量
	private Integer totalSales;
	// 总评价数
	private Integer evaluationNum;

	public Commodity() {
		super();
	}

	public Commodity(Integer gid, Integer stock) {
		super();
		this.gid = gid;
		this.stock = stock;
	}

	public Integer getMouthlySales() {
		return mouthlySales;
	}

	public void setMouthlySales(Integer mouthlySales) {
		this.mouthlySales = mouthlySales;
	}

	public Integer getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(Integer totalSales) {
		this.totalSales = totalSales;
	}

	public Integer getEvaluationNum() {
		return evaluationNum;
	}

	public void setEvaluationNum(Integer evaluationNum) {
		this.evaluationNum = evaluationNum;
	}

	private List<String> images;

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
