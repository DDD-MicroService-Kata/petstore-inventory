package com.ThoughtWorks.DDD.Inventory.fixture;

import com.ThoughtWorks.DDD.Inventory.domain.pet.Pet;
import com.ThoughtWorks.DDD.Inventory.domain.pet.PetRepository;
import com.ThoughtWorks.DDD.Inventory.domain.shop.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetFixture {
    private final PetRepository repository;

    @Autowired
    public PetFixture(PetRepository repository){
        this.repository = repository;
    }

    public Pet createPet(Shop shop, String name) {
        return this.repository.save(new Pet(name, shop.getId()));
    }
}
