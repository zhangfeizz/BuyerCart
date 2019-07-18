package com.cart.buyer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cart.pojo.BuyerItem;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class BuyerCart implements Serializable {
	/**
	 * 购物车
	 */
	private static final long serialVersionUID = 1L;
	
	//商品结果集
	List<BuyerItem> items = new ArrayList<>();
	
	//添加购物项到购物车
	public void addItem(BuyerItem item) {
		//判断是否包含同款
		if (items.contains(item)) {
			//叠加数量
			for (BuyerItem buyerItem : items) {
				if (buyerItem.equals(item)) {
					buyerItem.setAmount(item.getAmount() + buyerItem.getAmount());
				}
			}
		} else {
			item.add(item);
		}
	}
	
	public List<BuyerItem> getItems(){
		return items;
	}
	
	public void setItems(List<BuyerItem> items) {
		this.items = items;
	}
	

	/**
	 * @return 商品数量
	 */
	public Integer getProductAmount() {
		Integer result = 0;
		//计算
		for (BuyerItem buyerItem : items) {
			result += buyerItem.getAmount();
		}
		return result;
	}
	
	/**
	 * @return  商品金额
	 */
	public Float getProductPrice() {
		Float result = 0f;
		//计算
		for (BuyerItem buyerItem : items) {
			result += buyerItem.getAmount() * buyerItem.getSku().getPrice();
		}
		return result;
	}
	
	/**
	 * @return 运费
	 * 这里使用了@JsonIgonre注解是因为下面需要将BuyerCart 转换成Json格式, 
	 * 而这几个字段只有get 方法, 所以不能转换, 需要使用忽略Json.
	 */
	@JsonIgnore
	public Float getFee() {
		Float result = 0f;
		if (getProductPrice() < 79) {
			result = 5f;
		}
		return result;
	}

	/**
	 * @return 总价
	 */
	@JsonIgnore
	public Float getTotalPrice() {
		return getProductPrice() + getFee();
	}
	
	
	
}




































