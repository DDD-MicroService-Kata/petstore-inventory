package com.ThoughtWorks.DDD.Inventory.fixture;

import com.ThoughtWorks.DDD.Inventory.domain.shop.Shop;
import com.ThoughtWorks.DDD.Inventory.domain.shop.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopFixture {
    private final ShopRepository repository;

    @Autowired
    public ShopFixture(ShopRepository repository) {

        this.repository = repository;
    }

    public Shop createShop(String shopName) {
        return this.repository.save(new Shop(shopName));
    }
}
