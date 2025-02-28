package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<String> agregarCliente(@RequestBody Cliente cliente) {
        clienteService.agregarCliente(cliente);
        return ResponseEntity.ok("Cliente agregado.");
    }

    @GetMapping
    public List<Cliente> obtenerClientes() {
        return clienteService.obtenerClientes();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCliente(@PathVariable String id, @RequestBody Cliente cliente) {
        Optional<Cliente> actualizado = clienteService.actualizarCliente(id, cliente);
        return actualizado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable String id) {
        boolean eliminado = clienteService.eliminarCliente(id);
        return eliminado ? ResponseEntity.ok("Cliente eliminado.") : ResponseEntity.notFound().build();
    }


    @PostMapping("/{id}/beneficio")
    public ResponseEntity<String> aplicarBeneficio(@PathVariable String id) {
        clienteService.aplicarBeneficios(id);
        return ResponseEntity.ok("Beneficio aplicado segun tipo de cliente.");
    }

}
