package com.cruzeiro;

import java.util.LinkedHashMap;

// suposto mapeamento de tabela
public class Employee {
	
	@Min(value=0, message="Id deve ser maior ou igual a 0.")
	@Max(value=10, message="Id deve ser maior ou menor a 10.")
	private int id;
	
//	essas notaçoes sao as validaçoes do javax
	@NotNull(message="Informação Requerida")
	@Size(min=2, message="Digite no mínimo 2 caracteres")
	private String firstName;
	private String lastName;
	private String city;
	private String zipcode;
	private String bussinesseUnit;
	private String[] language;
	private LinkedHashMap<String, String> citiesOptions;

	public Employee() {
		citiesOptions = new LinkedHashMap<>();
		citiesOptions.put("SP", "São Paulo");
		citiesOptions.put("RJ", "Rio de Janeiro");
		citiesOptions.put("MG", "Minas Gerais");

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getBussinesseUnit() {
		return bussinesseUnit;
	}

	public void setBussinesseUnit(String bussinesseUnit) {
		this.bussinesseUnit = bussinesseUnit;
	}

	public String[] getLanguage() {
		return language;
	}

	public void setLanguage(String[] language) {
		this.language = language;
	}

	public LinkedHashMap<String, String> getCitiesOptions() {
		return citiesOptions;
	}

	public void setCitiesOptions(LinkedHashMap<String, String> citiesOptions) {
		this.citiesOptions = citiesOptions;
	}

}
