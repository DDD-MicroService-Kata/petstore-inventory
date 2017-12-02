package com.ThoughtWorks.DDD.Inventory.interfaces.assembler;

import com.ThoughtWorks.DDD.Inventory.domain.shop.Shop;
import com.ThoughtWorks.DDD.Inventory.interfaces.DTO.ShopResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShopAssembler {
    public List<ShopResponse> toDTO(List<Shop> shops) {
        return shops.parallelStream().
                map(ShopResponse::new).
                collect(Collectors.toList());
    }
}
