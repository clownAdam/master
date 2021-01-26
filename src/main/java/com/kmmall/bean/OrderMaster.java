package com.kmmall.bean;

public class OrderMaster {
	private Integer product_quantity;
	private String order_id;
	private String product_id;
	private Double product_price;
	private String product_name;
	private String buyer_name;
	private String buyer_phone;
	private String buyer_address;
	private String buyer_openid;
	private Double order_amount;
	private Integer order_status;
	private Integer user_id;
	private String create_time;
	private String update_time;
	public Integer getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(Integer product_quantity) {
		this.product_quantity = product_quantity;
	}
	public String getOrder_id() {
		return order_id;
	}public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	@Override
	public String toString() {
		return "OrderMaster [product_quantity=" + product_quantity + ", order_id=" + order_id + ", product_id="
				+ product_id + ", product_price=" + product_price + ", product_name=" + product_name + ", buyer_name="
				+ buyer_name + ", buyer_phone=" + buyer_phone + ", buyer_address=" + buyer_address + ", buyer_openid="
				+ buyer_openid + ", order_amount=" + order_amount + ", order_status=" + order_status + ", user_id="
				+ user_id + ", create_time=" + create_time + ", update_time=" + update_time + "]";
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public Double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(Double product_price) {
		this.product_price = product_price;
	}
	public String getBuyer_name() {
		return buyer_name;
	}
	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}
	public String getBuyer_phone() {
		return buyer_phone;
	}
	public void setBuyer_phone(String buyer_phone) {
		this.buyer_phone = buyer_phone;
	}
	public String getBuyer_address() {
		return buyer_address;
	}
	public void setBuyer_address(String buyer_address) {
		this.buyer_address = buyer_address;
	}
	public String getBuyer_openid() {
		return buyer_openid;
	}
	public void setBuyer_openid(String buyer_openid) {
		this.buyer_openid = buyer_openid;
	}
	public Double getOrder_amount() {
		return order_amount;
	}
	public void setOrder_amount(Double order_amount) {
		this.order_amount = order_amount;
	}
	public Integer getOrder_status() {
		return order_status;
	}
	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	
}
