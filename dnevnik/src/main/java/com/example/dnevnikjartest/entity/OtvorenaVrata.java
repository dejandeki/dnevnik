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
@Table(name = "otvorena_vrata")
public class OtvorenaVrata {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_otvorena_vrata")
	private int id_otvorena_vrata;
    
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_ucitelj")
	private Korisnik korisnik_ucitelj;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_roditelj")
	private Korisnik korisnik_roditelj;
	
	@Column(name = "odgovor",length = 10)
	private String odgovor;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "datum")
	private Date datum = new Date();

	public OtvorenaVrata() {
	}

	public OtvorenaVrata(String odgovor, Date datum) {
		this.odgovor = odgovor;
		this.datum = datum;
	}

	public int getId_otvorena_vrata() {
		return id_otvorena_vrata;
	}

	public void setId_otvorena_vrata(int id_otvorena_vrata) {
		this.id_otvorena_vrata = id_otvorena_vrata;
	}

	public Korisnik getKorisnik_ucitelj() {
		return korisnik_ucitelj;
	}

	public void setKorisnik_ucitelj(Korisnik korisnik_ucitelj) {
		this.korisnik_ucitelj = korisnik_ucitelj;
	}

	public Korisnik getKorisnik_roditelj() {
		return korisnik_roditelj;
	}

	public void setKorisnik_roditelj(Korisnik korisnik_roditelj) {
		this.korisnik_roditelj = korisnik_roditelj;
	}

	public String getOdgovor() {
		return odgovor;
	}

	public void setOdgovor(String odgovor) {
		this.odgovor = odgovor;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	@Override
	public String toString() {
		return "OtvorenaVrata [id_otvorena_vrata=" + id_otvorena_vrata + ", korisnik_ucitelj=" + korisnik_ucitelj
				+ ", korisnik_roditelj=" + korisnik_roditelj + ", odgovor=" + odgovor + ", datum=" + datum + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		result = prime * result + id_otvorena_vrata;
		result = prime * result + ((korisnik_roditelj == null) ? 0 : korisnik_roditelj.hashCode());
		result = prime * result + ((korisnik_ucitelj == null) ? 0 : korisnik_ucitelj.hashCode());
		result = prime * result + ((odgovor == null) ? 0 : odgovor.hashCode());
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
		OtvorenaVrata other = (OtvorenaVrata) obj;
		if (datum == null) {
			if (other.datum != null)
				return false;
		} else if (!datum.equals(other.datum))
			return false;
		if (id_otvorena_vrata != other.id_otvorena_vrata)
			return false;
		if (korisnik_roditelj == null) {
			if (other.korisnik_roditelj != null)
				return false;
		} else if (!korisnik_roditelj.equals(other.korisnik_roditelj))
			return false;
		if (korisnik_ucitelj == null) {
			if (other.korisnik_ucitelj != null)
				return false;
		} else if (!korisnik_ucitelj.equals(other.korisnik_ucitelj))
			return false;
		if (odgovor == null) {
			if (other.odgovor != null)
				return false;
		} else if (!odgovor.equals(other.odgovor))
			return false;
		return true;
	}

	
	
}
