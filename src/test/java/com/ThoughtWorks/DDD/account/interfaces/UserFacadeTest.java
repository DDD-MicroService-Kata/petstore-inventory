package com.ThoughtWorks.DDD.account.interfaces;

import com.ThoughtWorks.DDD.account.APIBaseTest;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserFacadeTest extends APIBaseTest {
    @Test
    public void should_create_bookings_without_authorization() throws Exception {
        this.mockMvc.perform(get("/api/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
}