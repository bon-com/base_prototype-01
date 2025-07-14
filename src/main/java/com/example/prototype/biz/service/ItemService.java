package com.example.prototype.biz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prototype.biz.dao.JdbcItemDao;
import com.example.prototype.entity.Item;
import com.example.prototype.web.dto.ItemDto;

/**
 * 商品サービス
 */
@Service
public class ItemService {

    @Autowired
    private JdbcItemDao jdbcItemDao;

    /** 商品一覧取得 */
    public List<ItemDto> findAll() {
        List<ItemDto> items = new ArrayList<>();

        jdbcItemDao.findAll().forEach(i -> {
            var dto = new ItemDto();
            BeanUtils.copyProperties(i, dto);
            items.add(dto);
        });

        return items;
    }

    /** 商品検索 */
    public ItemDto findById(int id) {
        Item res = jdbcItemDao.findById(id);
        var dto = new ItemDto();
        BeanUtils.copyProperties(res, dto);

        return dto;
    }
}
