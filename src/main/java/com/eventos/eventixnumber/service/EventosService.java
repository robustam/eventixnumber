package com.eventos.eventixnumber.service;

import com.eventos.eventixnumber.model.EventosModel;
import java.util.List;

public interface EventosService {
    EventosModel guardar(EventosModel registro);

    List<EventosModel> listarTodos();

    EventosModel buscarPorId(Integer id);

    EventosModel actualizar(Integer id, EventosModel act);

    void eliminar(Integer id);

    List<EventosModel> buscarPorTipo(String tipo);
}

