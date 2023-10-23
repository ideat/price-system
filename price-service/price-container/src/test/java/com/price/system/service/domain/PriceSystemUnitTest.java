package com.price.system.service.domain;

import com.price.system.price.service.domain.PriceServiceApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = PriceServiceApplication.class)
public class PriceSystemUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testPrice_10_00_day_14() throws Exception {
        this.mockMvc.perform(get("/prices/getprice")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                        .param("brandId","1")
                        .param("productId","35455")
                        .param("requestDate","2020-06-14-10.00.00"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("price").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("price").value(35.50))
                .andReturn();

    }

    @Test
    void testPrice_16_00_day_14() throws Exception{
        this.mockMvc.perform(get("/prices/getprice")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("brandId","1")
                        .param("productId","35455")
                        .param("requestDate","2020-06-14-16.00.00"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("price").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("price").value(25.45))
                .andReturn();
    }

    @Test
    void testPrice_21_00_day_14() throws Exception{
        this.mockMvc.perform(get("/prices/getprice")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("brandId","1")
                        .param("productId","35455")
                        .param("requestDate","2020-06-14-21.00.00"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("price").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("price").value(35.50))
                .andReturn();
    }

    @Test
    void testPrice_10_00_day_15() throws Exception{
        this.mockMvc.perform(get("/prices/getprice")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("brandId","1")
                        .param("productId","35455")
                        .param("requestDate","2020-06-15-10.00.00"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("price").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("price").value(30.50))
                .andReturn();
    }

    @Test
    void testPrice_21_00_day_16() throws Exception{
        this.mockMvc.perform(get("/prices/getprice")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("brandId","1")
                        .param("productId","35455")
                        .param("requestDate","2020-06-16-21.00.00"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("price").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("price").value(38.95))
                .andReturn();
    }
}
