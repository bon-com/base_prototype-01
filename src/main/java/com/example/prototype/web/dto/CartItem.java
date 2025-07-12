package com.example.prototype.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 商品と数量を保持するクラス
 */
@Data
@AllArgsConstructor
public class CartItem {
	/** 商品 */
	private Item item;
	/** 数量 */
	private int quantity;
	
	/** 合計金額を返却 */
    public int getTotal() {
        return item.getPrice() * quantity;
    }
}
