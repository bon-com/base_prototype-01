package com.example.prototype.biz.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.prototype.web.dto.Item;

/**
 * 商品サービス
 */
@Service
public class ItemService {

	/** 商品一覧 */
	private final Map<String, Item> itemMap = new LinkedHashMap<>();
	
	/** 本来はDBから */
	@PostConstruct
	public void init() {
		itemMap.put("A001", new Item("A001", "大葉", 100));
		itemMap.put("A002", new Item("A002", "小松菜", 120));
		itemMap.put("A003", new Item("A003", "キャベツ", 200));
	}

	/** 商品一覧取得（本来はサービスでやるところ） */
	public List<Item> findAll() {
		return new ArrayList<>(itemMap.values());
	}

	/** 商品検索（本来はサービスでやるところ） */
	public Item findById(String id) {
		return itemMap.get(id);
	}
}
