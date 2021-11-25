package com.ceiba.tipo.controlador;


import com.ceiba.ApplicationMock;
import com.ceiba.tipo.comando.ComandoTipoGlamping;
import com.ceiba.tipo.servicio.testdatabuilder.ComandoTipoGlampingTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorTipoGlamping.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorTipoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear un tipo de glamping")
    void deberiaCrearUnTipoDeGlamping()throws Exception{
        //arrange
        ComandoTipoGlamping tipoGlamping = new ComandoTipoGlampingTestDataBuilder().build();
        //act - assert
        mocMvc.perform(post("/tipoGlamping")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(tipoGlamping)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));

    }

}
