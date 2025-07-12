package com.example.prototype.web.dto;

import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Data;
/**
 * カートクラス
 */
@Data
public class Cart {
	/** 商品毎の情報マップ */
	private Map<String, CartItem> items = new LinkedHashMap<>();
	
	/** カート内の数量を取得 */
	public int getTotal() {
		return items.values().stream()
				.mapToInt(CartItem::getQuantity)
				.sum();
	}
}