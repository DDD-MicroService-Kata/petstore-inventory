package com.ThoughtWorks.DDD.Inventory.e2e;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(profiles = "test")
@Transactional
@AutoConfigureMockMvc
public class APIBaseTest {
    @Autowired
    private WebApplicationContext wac;

    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Before
    public void baseBefore() {
        this.mockMvc =
                MockMvcBuilders.
                        webAppContextSetup(this.wac).
                        build();
    }

    @Test
    public void placeHolder() {
    }
}
