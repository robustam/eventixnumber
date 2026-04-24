package com.eventos.eventixnumber.service;

import com.eventos.eventixnumber.exception.EventoNotFoundException;
import com.eventos.eventixnumber.model.EventosModel;
import com.eventos.eventixnumber.repository.EventosRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EventosServiceImpl implements EventosService {
    private final EventosRepository repo;

    public EventosServiceImpl(EventosRepository repo) {
        this.repo = repo;
    }

    public EventosModel guardar(EventosModel registro) {
        if (this.repo.buscarPorNombre(registro.getNombre()) != null) {
            throw new IllegalArgumentException("Ya existe un evento con el nombre: " + registro.getNombre());
        } else {
            return this.repo.guardar(registro);
        }
    }

    public List<EventosModel> listarTodos() {
        return this.repo.listarTodos();
    }

    public EventosModel buscarPorId(Integer id) {
        EventosModel evento = this.repo.buscarPorId(id);
        if (evento == null) {
            throw new EventoNotFoundException("Evento no encontrado con ID: " + id);
        } else {
            return evento;
        }
    }

    public List<EventosModel> buscarPorTipo(String tipo) {
        return this.repo.buscarPorTipo(tipo);
    }

    public EventosModel actualizar(Integer id, EventosModel act) {
        if (this.repo.buscarPorId(id) == null) {
            throw new EventoNotFoundException("No se puede actualizar: El ID " + id + " no existe.");
        } else {
            return this.repo.actualizar(id, act);
        }
    }

    public void eliminar(Integer id) {
        if (!this.repo.eliminar(id)) {
            throw new EventoNotFoundException("No se pudo eliminar: El ID " + id + " no existe.");
        }
    }
}
