package com.example.prototype.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.prototype.biz.service.CartService;
import com.example.prototype.web.dto.CartDto;

@Controller
@RequestMapping("order")
public class OrderController {
	
	/** カート（セッション管理） */
	@Autowired
	private CartDto cart;
	/** カートサービス */
	@Autowired
	private CartService cartService;
	
	/**
	 * 注文内容確認画面の表示
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/")
	public String confirm(Model model) {
		// カート情報
		model.addAttribute("cartitems", cartService.getAllItems(cart));
		// 合計金額
		model.addAttribute("totalPrice", cartService.getTotalPrice(cart));
		
		return "confirm";
	}
	
	@GetMapping(value = "/complete")
	public String complete(HttpSession session) {
		// カート情報をセッションから削除
	    session.removeAttribute("scopedTarget.cart");
		return "complete";
	}
}
