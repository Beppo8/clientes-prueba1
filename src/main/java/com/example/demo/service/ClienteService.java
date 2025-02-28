package com.example.demo.service;

import com.example.demo.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClienteService {
    private final List<Cliente> clientes = new ArrayList<>();

    // Crear Cliente
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // Obtener Todos
    public List<Cliente> obtenerClientes() {
        return List.copyOf(clientes);
    }

    // Actualizar Cliente por ID
    public Optional<Cliente> actualizarCliente(String id, Cliente clienteActualizado) {
        return clientes.stream()
                .filter(cliente -> cliente.id().equals(id))
                .findFirst()
                .map(clienteExistente -> {
                    Cliente nuevoCliente = new Cliente(
                            clienteExistente.id(),
                            clienteActualizado.nombre(),
                            clienteActualizado.email(),
                            clienteActualizado.edad(),
                            clienteActualizado.tipoCliente()
                    );
                    clientes.add(nuevoCliente);
                    return nuevoCliente;
                });
    }

    // Eliminar Cliente por ID
    public boolean eliminarCliente(String id) {
        return clientes.removeIf(cliente -> cliente.id().equals(id));
    }

    // Aplicar logica con Pattern Matching
    public String aplicarBeneficios(String id) {
        clientes.stream()
                .filter(cliente -> cliente.id().equals(id))
                .findFirst()
                .ifPresent(cliente -> {
                 switch (cliente.tipoCliente()) {
                   case VIP -> System.out.println("Cliente VIP: Descuento aplicado.");
                   case REGULAR -> System.out.println("Cliente REGULAR: No tiene descuento.");
                   }
                });
        return id;
    }
}
