package com.ThoughtWorks.DDD.Inventory.domain.pet;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Pet {
    @Id
    private String id;
    private String name;
    private String shopId;
    private PetStatus petStatus;


    public Pet(String name, String shopId) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.shopId = shopId;
        this.petStatus = PetStatus.ForSale;
    }

    public Pet() {
    }

    public String getName() {
        return name;
    }

    public String getShopId() {
        return shopId;
    }

    public String getId() {
        return id;
    }

    public PetStatus getPetStatus() {
        return petStatus;
    }
}
