package com.cart.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class Sku {

	private Long skuId;
	private Long Id;
	private Integer price;
	public Integer getStock() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
