package com.nuuptech.load.controller;

import com.nuuptech.load.model.Articulo;
import com.nuuptech.load.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {
    @Autowired
    private ArticuloRepository articuloRepository;

    @GetMapping("/")
    public List<Articulo> obtenerTodos() {
        return articuloRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Articulo> obtenerPorId(@PathVariable Long id) {
        Optional<Articulo> articulo = articuloRepository.findById(id);
        if (articulo.isPresent()) {
            return ResponseEntity.ok(articulo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Articulo> crear(@RequestBody Articulo articulo) {
        Articulo nuevoArticulo = articuloRepository.save(articulo);
        return ResponseEntity.created(URI.create("/api/articulos/" + nuevoArticulo.getId())).body(nuevoArticulo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Articulo> actualizar(@PathVariable Long id, @RequestBody Articulo articulo) {
        Optional<Articulo> articuloExistente = articuloRepository.findById(id);
        if (articuloExistente.isPresent()) {
            Articulo articuloActualizado = articuloRepository.save(articulo);
            return ResponseEntity.ok(articuloActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Optional<Articulo> articuloExistente = articuloRepository.findById(id);
        if (articuloExistente.isPresent()) {
            articuloRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
