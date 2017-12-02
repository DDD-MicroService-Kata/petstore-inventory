package com.ThoughtWorks.DDD.Inventory.interfaces.facade;

import com.ThoughtWorks.DDD.Inventory.domain.shop.Shop;
import com.ThoughtWorks.DDD.Inventory.domain.shop.ShopRepository;
import com.ThoughtWorks.DDD.Inventory.interfaces.DTO.ShopResponse;
import com.ThoughtWorks.DDD.Inventory.interfaces.assembler.ShopAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/shops")
public class ShopFacade {

    private final ShopRepository shopRepository;
    private final ShopAssembler shopAssembler;

    @Autowired
    public ShopFacade(ShopRepository shopRepository, ShopAssembler shopAssembler) {
        this.shopRepository = shopRepository;
        this.shopAssembler = shopAssembler;
    }

    @GetMapping
    public final List<ShopResponse> GetShops() {
        List<Shop> shops = shopRepository.findAll();
        return shopAssembler.toDTO(shops);
    }

}
