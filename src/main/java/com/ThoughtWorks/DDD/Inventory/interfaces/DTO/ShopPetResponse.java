package com.ThoughtWorks.DDD.Inventory.interfaces.DTO;

import com.ThoughtWorks.DDD.Inventory.domain.pet.Pet;
import com.ThoughtWorks.DDD.Inventory.domain.pet.PetStatus;

public class ShopPetResponse {
    private String shopId;
    private String petName;
    private String petId;
    private PetStatus petStatus;

    public String getShopId() {
        return shopId;
    }

    public String getPetName() {
        return petName;
    }

    public String getPetId() {
        return petId;
    }

    public PetStatus getPetStatus() {
        return petStatus;
    }

    public ShopPetResponse() {
    }

    public ShopPetResponse(Pet pet) {
        this.shopId = pet.getShopId();
        this.petName = pet.getName();
        this.petId = pet.getId();
        this.petStatus = pet.getPetStatus();
    }
}
