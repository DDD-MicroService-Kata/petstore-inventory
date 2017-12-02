package com.ThoughtWorks.DDD.Inventory.infrastructure.persistence;

import com.ThoughtWorks.DDD.Inventory.domain.shop.Shop;
import com.ThoughtWorks.DDD.Inventory.domain.shop.ShopRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepositoryImpl extends ShopRepository, JpaRepository<Shop, String> {

}
