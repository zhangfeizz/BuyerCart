package com.cart.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class BuyerItem {

	//SKu对象
	private Sku sku;

	//是否有货
	private Boolean isHave = true;

	//购买的数量
	private Integer amount = 1;

	public void add(BuyerItem item) {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		//比较地址
		if (this == obj) 
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) 
			return false;
		
		BuyerItem other = (BuyerItem) obj;
		if (sku == null) {
			if (other.sku != null) {
				return false;
			}
		} else if (! sku.getId().equals(other.sku.getId())) {
			return false;
		}
		return true;
	}



}
