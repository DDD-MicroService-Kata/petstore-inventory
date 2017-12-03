package com.ThoughtWorks.DDD.Inventory.infrastructure.persistence;

import com.ThoughtWorks.DDD.Inventory.domain.pet.Pet;
import com.ThoughtWorks.DDD.Inventory.domain.pet.PetRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public interface PetRepositoryImpl extends PetRepository, JpaRepository<Pet, String> {

}
