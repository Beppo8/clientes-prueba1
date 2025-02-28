package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.model.TipoCliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteServiceTest {
    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
        clienteService = new ClienteService();
    }

    @Test
    void testCrearCliente() {
        Cliente cliente = new Cliente("1", "Juan Pérez", "juan@example.com", 30, TipoCliente.REGULAR);
        clienteService.crearCliente(cliente);
        assertEquals(1, clienteService.obtenerClientes().size());
    }

    @Test
    void testObtenerClientes() {
        clienteService.crearCliente(new Cliente("1", "Juan Pérez", "juan@example.com", 30, TipoCliente.REGULAR));
        clienteService.crearCliente(new Cliente("2", "María López", "maria@example.com", 25, TipoCliente.VIP));

        List<Cliente> clientes = clienteService.obtenerClientes();
        assertEquals(2, clientes.size());
    }

    @Test
    void testActualizarCliente() {
        Cliente cliente = new Cliente("1", "Juan Pérez", "juan@example.com", 30, TipoCliente.REGULAR);
        clienteService.crearCliente(cliente);

        Cliente clienteActualizado = new Cliente("1", "Juan Pérez", "nuevoemail@example.com", 30, TipoCliente.VIP);
        clienteService.actualizarCliente("1", clienteActualizado);

        Cliente actualizado = clienteService.obtenerClientes().stream()
                .filter(c -> c.id().equals("1"))
                .findFirst()
                .orElse(null);

        assertNotNull(actualizado);
        assertEquals("nuevoemail@example.com", actualizado.email());
        assertEquals(TipoCliente.VIP, actualizado.tipoCliente());
    }

    @Test
    void testEliminarCliente() {
        clienteService.crearCliente(new Cliente("1", "Juan Pérez", "juan@example.com", 30, TipoCliente.REGULAR));
        clienteService.eliminarCliente("1");

        assertTrue(clienteService.obtenerClientes().isEmpty());
    }

    @Test
    void testAplicarBeneficios() {
        Cliente vip = new Cliente("1", "VIP User", "vip@example.com", 40, TipoCliente.VIP);
        Cliente regular = new Cliente("2", "Regular User", "regular@example.com", 25, TipoCliente.REGULAR);

        clienteService.crearCliente(vip);
        clienteService.crearCliente(regular);

        String mensajeVIP = clienteService.aplicarBeneficios("1");
        String mensajeRegular = clienteService.aplicarBeneficios("2");

        assertEquals("Cliente VIP: Descuento aplicado.", mensajeVIP);
        assertEquals("Cliente REGULAR: No tiene descuento.", mensajeRegular);
    }
}
