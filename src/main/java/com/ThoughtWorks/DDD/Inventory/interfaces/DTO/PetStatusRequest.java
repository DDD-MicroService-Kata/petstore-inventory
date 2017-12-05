package com.ThoughtWorks.DDD.Inventory.interfaces.DTO;

import com.ThoughtWorks.DDD.Inventory.domain.pet.PetStatus;

public class PetStatusRequest {
    private String id;
    private PetStatus petStatus;

    public PetStatusRequest() {
    }
    public PetStatusRequest(String id, PetStatus petStatus) {
        this.id = id;
        this.petStatus = petStatus;
    }

    public PetStatus getPetStatus() {
        return petStatus;
    }

    public String getId() {
        return id;
    }
}
