package com.ThoughtWorks.DDD.Inventory.interfaces.facade;

import com.ThoughtWorks.DDD.Inventory.domain.pet.Pet;
import com.ThoughtWorks.DDD.Inventory.domain.pet.PetRepository;
import com.ThoughtWorks.DDD.Inventory.interfaces.DTO.PetCreateRequest;
import com.ThoughtWorks.DDD.Inventory.interfaces.DTO.PetStatusRequest;
import com.ThoughtWorks.DDD.Inventory.interfaces.DTO.ShopPetResponse;
import com.ThoughtWorks.DDD.Inventory.interfaces.assembler.PetAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pets/status")
public class PetStatusFacade {
    private final PetRepository petRepository;
    private final PetAssembler petAssembler;

    @Autowired
    public PetStatusFacade(PetRepository petRepository, PetAssembler petAssembler) {
        this.petRepository = petRepository;
        this.petAssembler = petAssembler;
    }

    @PutMapping
    public final ResponseEntity updateStatus(@RequestBody PetStatusRequest petStatusRequest) {
        Pet pet = petRepository.findOne(petStatusRequest.getId());
        pet.locked();
        return new ResponseEntity(HttpStatus.OK);
    }
}
