package com.ThoughtWorks.DDD.Inventory.interfaces.assembler;

import com.ThoughtWorks.DDD.Inventory.domain.pet.Pet;
import com.ThoughtWorks.DDD.Inventory.domain.shop.Shop;
import com.ThoughtWorks.DDD.Inventory.interfaces.DTO.ShopPetResponse;
import com.ThoughtWorks.DDD.Inventory.interfaces.DTO.ShopResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PetAssembler {
    public List<ShopPetResponse> toDTO(List<Pet> pets) {
        return pets.parallelStream().
                map(ShopPetResponse::new).
                collect(Collectors.toList());
    }
}
