package com.softtek.academia.service;

import java.util.List;

import com.softtek.academia.entity.City;

public interface CityService {
	//ESTE PRIMER METODO servira para obtener una lista de todos nuestros estados
	public List<City> getAllCities();
	//Meto para buscar un solo estado
	public City getCity(Long id);
	//Metodo paera crear estados en la lista 
	public boolean addCity(City entity);
	//metodo para eliminar un estado
	public boolean deleteCity(Long id);
	

}
