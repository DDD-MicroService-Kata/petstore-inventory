package com.ThoughtWorks.DDD.Inventory.domain.shop;

import com.ThoughtWorks.DDD.Inventory.domain.shop.Shop;

import java.util.List;

public interface ShopRepository {
    public Shop save(Shop shop);
    public List<Shop> findAll();
}
