package com.ThoughtWorks.DDD.account.interfaces;

import com.ThoughtWorks.DDD.account.APIBaseTest;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder.okForJson;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserFacadeTest extends APIBaseTest {
    @Rule
    public WireMockRule accountServiceMock = new WireMockRule(9116);

    @Test
    public void should_create_bookings_without_authorization() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public final void shouldGetTheCustomerAfterJustCreated() throws Exception {
        Map<String, String> newCustomer = new HashMap<>();
        newCustomer.put("firstName", "Anne");
        newCustomer.put("lastName", "Queen");

        MvcResult mvcResult = this.mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(newCustomer)))
                .andExpect(status().isCreated())
                .andReturn();

        String location = mvcResult.getResponse().getHeader("location");
        this.mockMvc.perform(MockMvcRequestBuilders.get(location).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id':1, 'firstName':'Anne', 'lastName':'Queen'}"));
    }

    @Test
    public final void shouldGetTheStringByApiCall() throws Exception {
        stubFor(get(urlEqualTo("9116"))
                .willReturn(okForJson("demo")));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/users").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("demo"));
    }
}