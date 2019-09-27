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

@Entity
@Table(name = "obavestenje")
public class Obavestenje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_obavestenje")
	private int id_obavestenje;
	
	@Column(name = "sadrzaj_obavestenja",length = 255)
	private String sadrzaj_obavestenja;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "datum")
	private Date datum = new Date();
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="id_admin")
	private Korisnik korisnik;

	public Obavestenje() {
	}

	public Obavestenje(String sadrzaj_obavestenja, Date datum) {
		this.sadrzaj_obavestenja = sadrzaj_obavestenja;
		this.datum = datum;
		
	}

	public int getId_obavestenje() {
		return id_obavestenje;
	}

	public void setId_obavestenje(int id_obavestenje) {
		this.id_obavestenje = id_obavestenje;
	}

	public String getSadrzaj_obavestenja() {
		return sadrzaj_obavestenja;
	}

	public void setSadrzaj_obavestenja(String sadrzaj_obavestenja) {
		this.sadrzaj_obavestenja = sadrzaj_obavestenja;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	@Override
	public String toString() {
		return "Obavestenje [id_obavestenje=" + id_obavestenje + ", sadrzaj_obavestenja=" + sadrzaj_obavestenja
				+ ", datum=" + datum + ", korisnik=" + korisnik + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		result = prime * result + id_obavestenje;
		result = prime * result + ((korisnik == null) ? 0 : korisnik.hashCode());
		result = prime * result + ((sadrzaj_obavestenja == null) ? 0 : sadrzaj_obavestenja.hashCode());
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
		Obavestenje other = (Obavestenje) obj;
		if (datum == null) {
			if (other.datum != null)
				return false;
		} else if (!datum.equals(other.datum))
			return false;
		if (id_obavestenje != other.id_obavestenje)
			return false;
		if (korisnik == null) {
			if (other.korisnik != null)
				return false;
		} else if (!korisnik.equals(other.korisnik))
			return false;
		if (sadrzaj_obavestenja == null) {
			if (other.sadrzaj_obavestenja != null)
				return false;
		} else if (!sadrzaj_obavestenja.equals(other.sadrzaj_obavestenja))
			return false;
		return true;
	}

	

	
	
}
