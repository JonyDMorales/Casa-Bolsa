package com.phi.proyect.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dias_inhabiles")
public class DiasInhabiles implements Serializable {

	@Id()
	@Column(name = "id_dias_inhabiles")
	private Integer idDiasInhabiles;
	private Date fecha;
	private Integer habil;

	public DiasInhabiles() {
		super();
	}

	public Integer getIdDiasInhabiles() {
		return idDiasInhabiles;
	}

	public void setIdDiasInhabiles(Integer idDiasInhabiles) {
		this.idDiasInhabiles = idDiasInhabiles;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getHabil() {
		return habil;
	}

	public void setHabil(Integer habil) {
		this.habil = habil;
	}

}
