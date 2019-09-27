package com.example.dnevnikjartest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ucenik")
public class Ucenik {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ucenik")
	private int id_ucenik;
	
	@Column(name = "ime", length = 50)
	private String ime;
	
	@Column(name = "prezime", length = 50)
	private String prezime;
	
	@JoinColumn(name = "id_roditelj")
    @OneToOne(optional = false,fetch = FetchType.LAZY)
	private Korisnik korisnik;

	@ManyToOne(fetch = FetchType.LAZY, optional= false)
	@JoinColumn(name="id_odeljenje")
	private Odeljenje odeljenje;
        
       
	
	public Ucenik() {
	}

	public Ucenik(String ime, String prezime) {
		this.ime = ime;
		this.prezime = prezime;
	
		
	}

	public int getId_ucenik() {
		return id_ucenik;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	

	public void setId_ucenik(int id_ucenik) {
		this.id_ucenik = id_ucenik;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	

	
	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Odeljenje getOdeljenje() {
		return odeljenje;
	}

	public void setOdeljenje(Odeljenje odeljenje) {
		this.odeljenje = odeljenje;
	}

	@Override
	public String toString() {
		return "Ucenici [id_ucenik=" + id_ucenik + ", ime=" + ime + ", prezime=" + prezime + ", korisnik=" + korisnik
				+ ", odeljenje=" + odeljenje + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_ucenik;
		result = prime * result + ((ime == null) ? 0 : ime.hashCode());
		result = prime * result + ((korisnik == null) ? 0 : korisnik.hashCode());
		result = prime * result + ((odeljenje == null) ? 0 : odeljenje.hashCode());
		result = prime * result + ((prezime == null) ? 0 : prezime.hashCode());
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
		Ucenik other = (Ucenik) obj;
		if (id_ucenik != other.id_ucenik)
			return false;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (!ime.equals(other.ime))
			return false;
		if (korisnik == null) {
			if (other.korisnik != null)
				return false;
		} else if (!korisnik.equals(other.korisnik))
			return false;
		if (odeljenje == null) {
			if (other.odeljenje != null)
				return false;
		} else if (!odeljenje.equals(other.odeljenje))
			return false;
		if (prezime == null) {
			if (other.prezime != null)
				return false;
		} else if (!prezime.equals(other.prezime))
			return false;
		return true;
	}
	
	
	
}


