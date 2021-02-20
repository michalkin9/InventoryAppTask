package com.task;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;

import org.springframework.mock.web.MockHttpServletResponse;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.jupiter.api.Assertions.assertEquals;



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


//    @Test
//    void addInventoryTest() throws Exception {
//
//        String json = "{\"amount\":10,\"code\":01,\"name\":\"book\",\"number\":1}";
//
//        RequestBuilder r = MockMvcRequestBuilders.post("/api/inventories/add").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(json); //creating a request
//        MvcResult result = mvc.perform(r).andReturn();
//
//        MockHttpServletResponse response = result.getResponse();
//        assertEquals(200, response.getStatus());
//
//    }
    
}
