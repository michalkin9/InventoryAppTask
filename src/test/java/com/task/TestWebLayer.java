package com.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.aspectj.lang.annotation.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder.webAppContextSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static sun.plugin2.util.PojoUtil.toJson;


@WebMvcTest
public class TestWebLayer {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private InventoryS service;


    @Test
        //check if by get request we get an empty response because the DB is still empty .
    void getAllEmployeesAPI() throws Exception {
        RequestBuilder r = MockMvcRequestBuilders.get("/api/inventories"); //creating a request
        MvcResult result = mvc.perform(r).andReturn();
        assertEquals("[]", result.getResponse().getContentAsString()); //checking the result

        MockHttpServletResponse response = result.getResponse();
        assertEquals(200, response.getStatus());
    }


    @Test
    void addInventoryTest() throws Exception {

        String json = "{\"amount\":10,\"code\":01,\"name\":\"book\",\"number\":1}";

        RequestBuilder r = MockMvcRequestBuilders.post("/api/inventories/add").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(json); //creating a request
        MvcResult result = mvc.perform(r).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(200, response.getStatus());

    }
}
