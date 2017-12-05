package com.ThoughtWorks.DDD.Inventory.e2e;

import com.ThoughtWorks.DDD.Inventory.domain.pet.Pet;
import com.ThoughtWorks.DDD.Inventory.domain.pet.PetStatus;
import com.ThoughtWorks.DDD.Inventory.domain.shop.Shop;
import com.ThoughtWorks.DDD.Inventory.fixture.PetFixture;
import com.ThoughtWorks.DDD.Inventory.fixture.ShopFixture;
import com.ThoughtWorks.DDD.Inventory.interfaces.DTO.PetCreateRequest;
import com.ThoughtWorks.DDD.Inventory.interfaces.DTO.PetStatusRequest;
import com.ThoughtWorks.DDD.Inventory.interfaces.DTO.ShopPetResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static java.lang.String.format;
import static org.apache.commons.lang.StringUtils.isNotEmpty;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PetStatusApiTest extends APIBaseTest {

    @Autowired
    private ShopFixture shopFixture;
    @Autowired
    private PetFixture petFixture;


    private Shop shop;
    private Pet pet;

    @Before
    public void init() {
        shop = shopFixture.createShop("NST center");
        pet = petFixture.createPet(shop, "test");
    }

    @Test
    public void should_update_status() throws Exception {
        String petName = "pet1";
        PetStatusRequest request = new PetStatusRequest(pet.getId(), PetStatus.Locked);
        this.mockMvc.perform(put(format("/api/pets/%s/status", pet.getId())).
                contentType(APPLICATION_JSON_UTF8).
                content(this.objectMapper.writeValueAsString(request))).
                andExpect(status().isOk());

        MvcResult queryResult = this.mockMvc.perform(get(format("/api/pets/shops/%s", shop.getId()))).
                andExpect(status().isOk()).
                andReturn();

        List<ShopPetResponse> shopPets = this.objectMapper.readValue(
                queryResult.getResponse().getContentAsByteArray(),
                new TypeReference<List<ShopPetResponse>>(){});
        Assert.assertEquals(1, shopPets.size());
        ShopPetResponse shopPet = shopPets.get(0);
        Assert.assertEquals(pet.getId(), pet.getId());
        Assert.assertEquals(PetStatus.Locked, shopPet.getPetStatus());
    }
}

