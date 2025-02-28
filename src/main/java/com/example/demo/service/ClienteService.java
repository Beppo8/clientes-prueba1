package com.example.demo.service;

import com.example.demo.model.TipoCliente;
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
    public List<Cliente> getClientes() {
        return List.copyOf(clientes);
    }


}
