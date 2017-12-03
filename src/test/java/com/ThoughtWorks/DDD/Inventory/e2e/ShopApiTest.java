package com.ThoughtWorks.DDD.Inventory.e2e;


import com.ThoughtWorks.DDD.Inventory.fixture.ShopFixture;
import com.ThoughtWorks.DDD.Inventory.interfaces.DTO.ShopResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ShopApiTest extends APIBaseTest {

    @Autowired
    private ShopFixture shopFixture;

    private String shopName = "NST center";

    @Before
    public void init(){
        shopFixture.createShop(shopName);
    }

    @Test
    public void should_get_the_preset_shop_list() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/api/shops")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        List<ShopResponse> shops = this.objectMapper.readValue(
                mvcResult.getResponse().getContentAsByteArray(),
                new TypeReference<List<ShopResponse>>(){});
        assertEquals(1, shops.size());

        ShopResponse shop = shops.get(0);
        assertEquals(shopName, shop.getName());


    }
}

