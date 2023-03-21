package com.jsmg.sumermarkets.controller;

import com.jsmg.sumermarkets.domain.Product;
import com.jsmg.sumermarkets.domain.Supplier;
import com.jsmg.sumermarkets.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
class Test4ProductController {

    private final String URL = "/api/product";
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductRepository productRepository;

    @Test
    void getAllProduct()throws Exception{
        Product product = new Product();

        Mockito.when(productRepository.findAll()).thenReturn(List.of(product));
        RequestBuilder builder = MockMvcRequestBuilders
                .get(URL + "/")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(builder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        Assertions.assertEquals(200, response.getStatus());
    }

    @Test
    void getAllProductNoContent()throws Exception{

        Mockito.when(productRepository.findAll()).thenReturn(List.of());
        RequestBuilder builder = MockMvcRequestBuilders
                .get(URL + "/")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(builder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        Assertions.assertEquals(204, response.getStatus());
    }

    @Test
    void getProductById() throws  Exception{
        Product product = new Product();

        Mockito.when(productRepository.findById(Mockito.any())).thenReturn(Optional.of(product));
        RequestBuilder builder = MockMvcRequestBuilders
                .get(URL + "/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(builder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        Assertions.assertEquals(200, response.getStatus());
    }

    @Test
    void getProductByIdBadRequest() throws  Exception{

        Mockito.when(productRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        RequestBuilder builder = MockMvcRequestBuilders
                .get(URL + "/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(builder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        Assertions.assertEquals(400, response.getStatus());
    }
}
