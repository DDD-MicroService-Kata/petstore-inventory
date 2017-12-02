package com.ThoughtWorks.DDD.Inventory.interfaces.DTO;

import com.ThoughtWorks.DDD.Inventory.domain.shop.Shop;

public class ShopResponse {

    private String Id;
    private String name;

    public ShopResponse() {
    }

    public ShopResponse(Shop shop) {
        this.name = shop.getName();
        this.Id = shop.getId();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return Id;
    }
}
