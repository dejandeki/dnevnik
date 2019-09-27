/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dnevnikjartest.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Grupa2
 */

@Entity
@Table(name = "ocena")
public class Ocena {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ocena")
	private int id_ocena;

	@Column(name = "ocena")
	private Integer ocena;

	@Column(name = "datum")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date datum = new Date();

	@Column(name = "zaklj_ocena")
	private Integer zaklj_ocena;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_ucenik")
	private Ucenik ucenik;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_predmet")
	private Predmet predmet;

	public Ucenik getUcenik() {
		return ucenik;
	}

	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Ocena() {
	}

	public Ocena(Integer ocena, Date datum, Integer zaklj_ocena) {

		this.ocena = ocena;
		this.datum = datum;

		this.zaklj_ocena = zaklj_ocena;
	}

	public int getId_ocena() {
		return id_ocena;
	}

	public void setId_ocena(int id_ocena) {
		this.id_ocena = id_ocena;
	}

	public Integer getOcena() {
		return ocena;
	}

	public void setOcena(Integer ocena) {
		this.ocena = ocena;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Integer getZaklj_ocena() {
		return zaklj_ocena;
	}

	public void setZaklj_ocena(Integer zaklj_ocena) {
		this.zaklj_ocena = zaklj_ocena;
	}

	@Override
	public String toString() {
		return "Ocene{" + "id_ocena=" + id_ocena + ", ocena=" + ocena + ", datum=" + datum + ",  zaklj_ocena="
				+ zaklj_ocena + '}';
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		result = prime * result + id_ocena;
		result = prime * result + ((ocena == null) ? 0 : ocena.hashCode());
		result = prime * result + ((predmet == null) ? 0 : predmet.hashCode());
		result = prime * result + ((ucenik == null) ? 0 : ucenik.hashCode());
		result = prime * result + ((zaklj_ocena == null) ? 0 : zaklj_ocena.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ocena other = (Ocena) obj;
		if (datum == null) {
			if (other.datum != null)
				return false;
		} else if (!datum.equals(other.datum))
			return false;
		if (id_ocena != other.id_ocena)
			return false;
		if (ocena == null) {
			if (other.ocena != null)
				return false;
		} else if (!ocena.equals(other.ocena))
			return false;
		if (predmet == null) {
			if (other.predmet != null)
				return false;
		} else if (!predmet.equals(other.predmet))
			return false;
		if (ucenik == null) {
			if (other.ucenik != null)
				return false;
		} else if (!ucenik.equals(other.ucenik))
			return false;
		if (zaklj_ocena == null) {
			if (other.zaklj_ocena != null)
				return false;
		} else if (!zaklj_ocena.equals(other.zaklj_ocena))
			return false;
		return true;
	}

}
