
package com.eventos.eventixnumber.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class EventosModel {
    private Integer id;
    private @NotBlank(
            message = "El nombre no puede estar vacio"
    ) String nombre;
    private @NotBlank(
            message = "El tipo de evento no puede estar vacio"
    ) String tipoevento;
    @JsonFormat(
            pattern = "yyyy-MM-dd"
    )
    private @NotNull(
            message = "La fecha no puede estar vacia"
    ) LocalDate fecha;
    private @NotBlank(
            message = "La ubicación no puede estar vacia"
    ) String ubicacion;
    private @NotNull(
            message = "La cantidad de participantes es obligatoria"
    ) @Min(
            value = 1L,
            message = "Mínimo 1 participante"
    ) @Max(
            value = 50L,
            message = "Máximo 50 participantes"
    ) Integer cantidadParticipantes;

    public EventosModel() {
    }

    public EventosModel(Integer id, String nombre, String tipoevento, LocalDate fecha, String ubicacion, Integer cantidadParticipantes) {
        this.id = id;
        this.nombre = nombre;
        this.tipoevento = tipoevento;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.cantidadParticipantes = cantidadParticipantes;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoevento() {
        return this.tipoevento;
    }

    public void setTipoevento(String tipoevento) {
        this.tipoevento = tipoevento;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getCantidadParticipantes() {
        return this.cantidadParticipantes;
    }

    public void setCantidadParticipantes(Integer cantidadParticipantes) {
        this.cantidadParticipantes = cantidadParticipantes;
    }
}
