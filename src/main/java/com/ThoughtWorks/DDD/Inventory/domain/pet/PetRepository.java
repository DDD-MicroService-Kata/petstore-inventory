package com.ThoughtWorks.DDD.Inventory.domain.pet;

import com.ThoughtWorks.DDD.Inventory.domain.pet.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository {
    public Pet save(Pet pet);
    public List<Pet> findByShopId(String shopId);
    public Pet findOne(String id);
    public List<Pet> findAll();
}

