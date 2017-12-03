package com.ThoughtWorks.DDD.Inventory.e2e;

import com.ThoughtWorks.DDD.Inventory.domain.pet.PetStatus;
import com.ThoughtWorks.DDD.Inventory.domain.shop.Shop;
import com.ThoughtWorks.DDD.Inventory.fixture.ShopFixture;
import com.ThoughtWorks.DDD.Inventory.interfaces.DTO.PetCreateRequest;
import com.ThoughtWorks.DDD.Inventory.interfaces.DTO.ShopPetResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static java.lang.String.format;
import static org.apache.commons.lang.StringUtils.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PetApiTest extends APIBaseTest {

    @Autowired
    private ShopFixture shopFixture;
    private Shop shop;

    @Before
    public void init() {
        shop = shopFixture.createShop("NST center");
    }

    @Test
    public void should_get_the_new_pet_in_the_shop_list_just_created() throws Exception {
        String petName = "pet1";
        PetCreateRequest request = new PetCreateRequest(petName, shop.getId());
        this.mockMvc.perform(post("/api/pets").
                contentType(APPLICATION_JSON_UTF8).
                content(this.objectMapper.writeValueAsString(request))).
                andExpect(status().isCreated());

        MvcResult queryResult = this.mockMvc.perform(get(format("/api/pets/shops/%s", shop.getId()))).
                andExpect(status().isOk()).
                andReturn();

        List<ShopPetResponse> shopPets = this.objectMapper.readValue(
                queryResult.getResponse().getContentAsByteArray(),
                new TypeReference<List<ShopPetResponse>>(){});
        Assert.assertEquals(1, shopPets.size());
        ShopPetResponse shopPet = shopPets.get(0);
        Assert.assertEquals(shop.getId(), shopPet.getShopId());
        Assert.assertEquals(petName, shopPet.getPetName());
        Assert.assertEquals(PetStatus.ForSale, shopPet.getPetStatus());
        Assert.assertTrue(isNotEmpty(shopPet.getPetId()));
    }
}

