package com.exemplo.springboot.apirest.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empregados")

public class Empregado {
	private long id;
	private String primeiroNome;
	private String ultimoNome;
	private String email;

public Empregado(){
	
}

public Empregado(String primeiroNome, String ultimoNome, String email) {
	this.primeiroNome = primeiroNome;
	this.ultimoNome = ultimoNome;
	this.email = email;
}

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public long getId() {
	return id;
	}

public void setId(long id) {
	this.id=id;
}

@Column(name="primeiro_nome", nullable=false)
public String getPrimeiroNome() {
	return primeiroNome;
}

public void setPrimeiroNome(String primeiroNome) {
	this.primeiroNome = primeiroNome;
}

@Column(name="ultimo_nome", nullable = false)
public String getUltimoNome(){
	return ultimoNome;
}

public void setUltimoNome(String ultimoNome) {
	this.ultimoNome = ultimoNome;
}

@Column(name="email", nullable = false)
public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email=email;
}

@Override
public String toString() {
	return "Empregado[id=" + id + ", primeiroNome=" + primeiroNome +", ultimoNome=" + ultimoNome + ",email=" +email+"]";
}

}

