package com.example.prototype.biz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.prototype.web.dto.Cart;
import com.example.prototype.web.dto.CartItem;
import com.example.prototype.web.dto.Item;

/**
 * カートサービス
 */
@Service
public class CartService {

	/** カートに商品と数量を追加 */
	public void addItem(Cart cart, Item item, int quantity) {
		cart.getItems().compute(item.getId(), (key, val) -> {
			if (val == null) {
				// 商品が存在しない場合、新規追加
				return new CartItem(item, quantity);
			} else {
				// 商品が存在する場合、数量追加
				val.setQuantity(val.getQuantity() + quantity);
				return val;
			}
		});
	}

	/** カート内商品を削除 */
	public void deleteItem(Cart cart, String itemId) {
		cart.getItems().remove(itemId);
	}
	
	/** カート内の合計金額を取得 */
	public int getTotalPrice(Cart cart) {
		return  cart.getItems().values().stream()
				.mapToInt(CartItem::getTotal)
				.sum();
	}
	
	/** カート内の商品一覧を取得 */
	public List<CartItem> getAllItems(Cart cart) {
		return new ArrayList<>(cart.getItems().values());
	}
}
