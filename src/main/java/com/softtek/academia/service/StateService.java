package com.softtek.academia.service;

import java.util.List;



import com.softtek.academia.entity.State;

public interface StateService {
	//ESTE PRIMER METODO servira para obtener una lista de todos nuestros estados
	public List<State> getAllStates();
	//Meto para buscar un solo estado
	public State getState(Long id);
	//Metodo paera crear estados en la lista 
	public boolean addState(State entity);
	//metodo para eliminar un estado
	public boolean deleteState(Long id);
	

	
	
}
