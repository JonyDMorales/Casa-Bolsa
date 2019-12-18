package com.phi.proyect.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="contabilidad")
public class Operacion  implements Serializable  {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer idContabilidad;

    Integer id;

    @Column(name = "fecha_de_compra")
    Date fechaCompra;

    String instrumento;

    public Integer getIdContabilidad() {
        return idContabilidad;
    }

    public void setIdContabilidad(Integer idContabilidad) {
        this.idContabilidad = idContabilidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    @Override
    public String toString() {
        return "Operacion{" +
                "idContabilidad=" + idContabilidad +
                ", id=" + id +
                ", fechaCompra=" + fechaCompra +
                ", instrumento='" + instrumento + '\'' +
                '}';
    }
}
