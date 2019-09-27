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
@Table(name = "poruka")
public class Poruka {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_poruka")
	private int id_poruka;
	
	@Column(name = "sadrzaj_poruke", length = 255)
	private String sadrzaj_poruke;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "datum")
	private Date datum = new Date();
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_ucitelj")
	private Korisnik korisnik_ucitelj;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_roditelj")
	private Korisnik korisnik_roditelj;

	public Poruka() {
	}

	public Poruka(String sadrzaj_poruke, Date datum) {
		this.sadrzaj_poruke = sadrzaj_poruke;
		this.datum = datum;
	}

	public int getId_poruka() {
		return id_poruka;
	}

	public void setId_poruka(int id_poruka) {
		this.id_poruka = id_poruka;
	}

	public String getSadrzaj_poruke() {
		return sadrzaj_poruke;
	}

	public void setSadrzaj_poruke(String sadrzaj_poruke) {
		this.sadrzaj_poruke = sadrzaj_poruke;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
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

	@Override
	public String toString() {
		return "Poruka [id_poruka=" + id_poruka + ", sadrzaj_poruke=" + sadrzaj_poruke + ", datum=" + datum
				+ ", korisnik_ucitelj=" + korisnik_ucitelj + ", korisnik_roditelj=" + korisnik_roditelj + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		result = prime * result + id_poruka;
		result = prime * result + ((korisnik_roditelj == null) ? 0 : korisnik_roditelj.hashCode());
		result = prime * result + ((korisnik_ucitelj == null) ? 0 : korisnik_ucitelj.hashCode());
		result = prime * result + ((sadrzaj_poruke == null) ? 0 : sadrzaj_poruke.hashCode());
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
		Poruka other = (Poruka) obj;
		if (datum == null) {
			if (other.datum != null)
				return false;
		} else if (!datum.equals(other.datum))
			return false;
		if (id_poruka != other.id_poruka)
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
		if (sadrzaj_poruke == null) {
			if (other.sadrzaj_poruke != null)
				return false;
		} else if (!sadrzaj_poruke.equals(other.sadrzaj_poruke))
			return false;
		return true;
	}

	
}
