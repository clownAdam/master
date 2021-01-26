package com.kmmall.bean;

public class AD {
	private String ad_id;
	private String ad_lv;// 广告等级，级别为1，则是首页大图轮播
	private String ad_pic;
	private String ad_product_id;

	public String getAd_id() {
		return ad_id;
	}

	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}

	public String getAd_lv() {
		return ad_lv;
	}

	public void setAd_lv(String ad_lv) {
		this.ad_lv = ad_lv;
	}

	public String getAd_pic() {
		return ad_pic;
	}

	public void setAd_pic(String ad_pic) {
		this.ad_pic = ad_pic;
	}

	public String getAd_product_id() {
		return ad_product_id;
	}

	public void setAd_product_id(String ad_product_id) {
		this.ad_product_id = ad_product_id;
	}

	@Override
	public String toString() {
		return "AD [ad_id=" + ad_id + ", ad_lv=" + ad_lv + ", ad_pic=" + ad_pic + ", ad_product_id=" + ad_product_id
				+ "]";
	}

}
