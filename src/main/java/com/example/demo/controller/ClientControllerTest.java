package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.model.TipoCliente;
import com.example.demo.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ClienteControllerTest {
    private MockMvc mockMvc;
    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
        clienteService = Mockito.mock(ClienteService.class);
        ClienteController clienteController = new ClienteController(clienteService);
        mockMvc = MockMvcBuilders.standaloneSetup(clienteController).build();
    }

    @Test
    void testObtenerClientes() throws Exception {
        List<Cliente> clientes = List.of(
                new Cliente("1", "Juan Pérez", "juan@example.com", 30, TipoCliente.REGULAR),
                new Cliente("2", "María López", "maria@example.com", 25, TipoCliente.VIP)
        );

        when(clienteService.obtenerClientes()).thenReturn(clientes);

        mockMvc.perform(get("/clientes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nombre").value("Juan Pérez"))
                .andExpect(jsonPath("$[1].tipoCliente").value("VIP"));
    }
}
