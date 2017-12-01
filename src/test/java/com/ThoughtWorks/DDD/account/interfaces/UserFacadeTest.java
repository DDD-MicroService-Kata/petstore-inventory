package com.ThoughtWorks.DDD.account.interfaces;

import com.ThoughtWorks.DDD.account.APIBaseTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserFacadeTest extends APIBaseTest {
    @Test
    public void should_create_bookings_without_authorization() throws Exception {
        this.mockMvc.perform(get("/api/users")
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
        this.mockMvc.perform(get(location).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id':1, 'firstName':'Anne', 'lastName':'Queen'}"));
    }
}