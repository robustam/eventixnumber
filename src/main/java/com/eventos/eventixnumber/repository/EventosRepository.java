package com.eventos.eventixnumber.repository;

import com.eventos.eventixnumber.model.EventosModel;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EventosRepository {
    private List<EventosModel> registros = new ArrayList<>();
    private Integer contadorId = 0;

    public EventosModel guardar(EventosModel registro) {
        this.contadorId++;
        registro.setId(this.contadorId);
        this.registros.add(registro);
        return registro;
    }

    public List<EventosModel> listarTodos() {
        return this.registros;
    }

    public EventosModel buscarPorId(Integer id) {
        return this.registros.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public EventosModel buscarPorNombre(String nombre) {
        return this.registros.stream()
                .filter(r -> r.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    public List<EventosModel> buscarPorTipo(String tipo) {
        return this.registros.stream()
                .filter(r -> r.getTipoevento().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

    public EventosModel actualizar(Integer id, EventosModel act) {
        for (int i = 0; i < this.registros.size(); i++) {
            if (this.registros.get(i).getId().equals(id)) {
                act.setId(id);
                this.registros.set(i, act);
                return act;
            }
        }
        return null;
    }

    public boolean eliminar(Integer id) {
        return this.registros.removeIf(r -> r.getId().equals(id));
    }
}