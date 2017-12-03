package com.ThoughtWorks.DDD.Inventory.interfaces.DTO;

public class PetCreateRequest {
    private String name;
    private String shopId;

    public PetCreateRequest() {
    }

    public PetCreateRequest(String name, String shopId) {
        this.name = name;
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public String getShopId() {
        return shopId;
    }
}
