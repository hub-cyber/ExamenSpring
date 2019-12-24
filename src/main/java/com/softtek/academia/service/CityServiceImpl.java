package com.softtek.academia.service;



import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.stereotype.Service;

import com.softtek.academia.entity.City;
import com.softtek.academia.repository.CityRepository;

@Service
@Transactional
public class CityServiceImpl implements CityService{
	//intanciar un objeto de nuestra clase Cityrepository
	private CityRepository  Crepository;
	
	 public CityServiceImpl() {
		
	}
	//nuestra inversion de control 
	 @Autowired
	 public CityServiceImpl(CityRepository Crepository) {
		 super();
		 this.Crepository = Crepository;
	 }
	
	
	
	
	@Override
	public List<City> getAllCities() {
		List<City> cities = new ArrayList<>();
		Crepository.findAll().forEach(e->cities.add(e));
		return cities;
	}

	@Override
	public City getCity(Long id) {
		City ciudad= Crepository.findById(id).get();
		return ciudad;
	}

	@Override
	public boolean addCity(City entity) {
		try {
			Crepository.save(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCity(Long id) {
		try {
			Crepository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
