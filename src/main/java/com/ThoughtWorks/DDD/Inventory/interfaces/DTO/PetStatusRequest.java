package com.ThoughtWorks.DDD.Inventory.interfaces.DTO;

import com.ThoughtWorks.DDD.Inventory.domain.pet.PetStatus;

public class PetStatusRequest {
    private PetStatus petStatus;

    public PetStatusRequest() {
    }

    public PetStatusRequest(PetStatus petStatus) {
        this.petStatus = petStatus;
    }

    public PetStatus getPetStatus() {
        return petStatus;
    }
}
