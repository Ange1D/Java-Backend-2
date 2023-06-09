package org.bedu.docs.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// SpringBootTest y SpringExtension habilitan el uso de IoC de Spring
@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@AutoConfigureRestDocs
class ProductControllerTest {

    //Permite simular las peticiones HTTP
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should return all array data")
    void findAll() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(
                        "[{\"code\":\"PR001\",\"name\":\"Gansito\",\"price\":15.0,\"description\":\"Pastelito de chocolate\"},{\"code\":\"PR002\",\"name\":\"Topochico\",\"price\":19.0,\"description\":\"Agua Mineral de Manantial\"},{\"code\":\"PR003\",\"name\":\"Cheetos\",\"price\":10.0,\"description\":\"Fritura de maiz\"}]"
                ))
                .andDo(MockMvcRestDocumentation.document("products/findAll",
                        PayloadDocumentation
                                .responseFields(
                                        PayloadDocumentation
                                                .fieldWithPath("[].code")
                                                .description("El identificador del producto"),
                                        PayloadDocumentation
                                                .fieldWithPath("[].name")
                                                .description("El nombre del producto"),
                                        PayloadDocumentation
                                                .fieldWithPath("[].description")
                                                .description("La descripcion del producto"),
                                        PayloadDocumentation
                                                .fieldWithPath("[].price")
                                                .description("El precio del producto")
                                )));
    }

    @Test
    @DisplayName("Should save a new product")
    public void save() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                "{\"code\":\"PR004\",\"name\":\"Agua\",\"price\":10.0,\"description\":\"Agua de 500ml\"}"
                        ))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcRestDocumentation.document("products/save",
                        PayloadDocumentation
                                .requestFields(
                                        PayloadDocumentation
                                                .fieldWithPath("code")
                                                .description("El identificador del producto"),
                                        PayloadDocumentation
                                                .fieldWithPath("name")
                                                .description("El nombre del producto"),
                                        PayloadDocumentation
                                                .fieldWithPath("description")
                                                .description("La descripcion del producto"),
                                        PayloadDocumentation
                                                .fieldWithPath("price")
                                                .description("El precio del producto")
                                )));

/*
 Valida que el producto fue insertado exitosamente
        mockMvc
                .perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(
                        "[{\"code\":\"PR001\",\"name\":\"Gansito\",\"price\":15.0,\"description\":\"Pastelito de chocolate\"},{\"code\":\"PR002\",\"name\":\"Topochico\",\"price\":19.0,\"description\":\"Agua Mineral de Manantial\"},{\"code\":\"PR003\",\"name\":\"Cheetos\",\"price\":10.0,\"description\":\"Fritura de maiz\"},{\"code\":\"PR004\",\"name\":\"Agua\",\"price\":10.0,\"description\":\"Agua de 500ml\"}]"
                ));
*/

    }
}