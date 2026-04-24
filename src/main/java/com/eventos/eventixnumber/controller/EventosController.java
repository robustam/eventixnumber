package com.eventos.eventixnumber.controller;

import com.eventos.eventixnumber.model.EventosModel;
import com.eventos.eventixnumber.service.EventosService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/eventos"})
public class EventosController {
    private final EventosService svc;

    public EventosController(EventosService svc) {
        this.svc = svc;
    }

    @PostMapping
    public ResponseEntity<EventosModel> crear(@RequestBody @Valid EventosModel r) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.svc.guardar(r));
    }

    @GetMapping
    public ResponseEntity<List<EventosModel>> listar() {
        return ResponseEntity.ok(this.svc.listarTodos());
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<EventosModel> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.svc.buscarPorId(id));
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<EventosModel> editar(@PathVariable Integer id, @RequestBody @Valid EventosModel r) {
        return ResponseEntity.ok(this.svc.actualizar(id, r));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Integer id) {
        svc.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
