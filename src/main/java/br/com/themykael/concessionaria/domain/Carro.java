package br.com.themykael.concessionaria.domain;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Carro {
	
	private Long id;
	
	@NotBlank
	@Size(min = 2, max = 50)
	private String marca;
	
	@NotBlank
	@Size(min = 2, max = 50)
	private String modelo;
	
	@NotNull()
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataLancamento;
	
	private TipoCambio cambio;
	
	public Carro() {}
	
	public Carro(Long id, String marca, String modelo, LocalDate dataLancamento, TipoCambio cambio) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.dataLancamento = dataLancamento;
		this.cambio = cambio;
	}

	public Carro(Long id, String marca, String modelo, LocalDate dataLancamento) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.dataLancamento = dataLancamento;
	}

	public Carro(Long id, String marca, String modelo) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	
	public TipoCambio getCambio() {
		return cambio;
	}

	public void setCambio(TipoCambio cambio) {
		this.cambio = cambio;
	}

	@Override
	public String toString() {
		return "Marca do carro: " + this.marca + ". Modelo: " + this.modelo + 
				". Identificação: " + this.id + ". Data de lançamento: " + this.dataLancamento +
				". Câmbio: " + this.cambio;
	}

}
