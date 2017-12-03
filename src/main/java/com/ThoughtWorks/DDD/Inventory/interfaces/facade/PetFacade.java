package com.ThoughtWorks.DDD.Inventory.interfaces.facade;

import com.ThoughtWorks.DDD.Inventory.domain.pet.Pet;
import com.ThoughtWorks.DDD.Inventory.domain.pet.PetRepository;
import com.ThoughtWorks.DDD.Inventory.interfaces.DTO.PetCreateRequest;
import com.ThoughtWorks.DDD.Inventory.interfaces.DTO.ShopPetResponse;
import com.ThoughtWorks.DDD.Inventory.interfaces.assembler.PetAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetFacade {
    private final PetRepository petRepository;
    private final PetAssembler petAssembler;

    @Autowired
    public PetFacade(PetRepository petRepository, PetAssembler petAssembler) {
        this.petRepository = petRepository;
        this.petAssembler = petAssembler;
    }

    @PostMapping
    public final ResponseEntity createPets(@RequestBody PetCreateRequest createRequest) {
        Pet pet = new Pet(createRequest.getName(),createRequest.getShopId());
        petRepository.save(pet);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/shops/{shopId}")
    public final List<ShopPetResponse> getPetsInShop(@PathVariable("shopId") String shopId) {
        List<Pet> pets = petRepository.findByShopId(shopId);
        return petAssembler.toDTO(pets);
    }
}
