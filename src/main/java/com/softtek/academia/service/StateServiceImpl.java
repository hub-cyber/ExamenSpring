package com.softtek.academia.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academia.entity.State;
import com.softtek.academia.repository.StateRepository;


@Service
@Transactional
public class StateServiceImpl implements StateService{
	
	//Instanciar un objeto de tu clase StateRepository
	private StateRepository repository;
	//crear un constructor vacio de nuestra clase StateServiceImpl
	public StateServiceImpl() {
		
	}
	
	@Autowired
	public StateServiceImpl(StateRepository repository) {
		super();
		this.repository= repository;
	}
	

	@Override
	public List<State> getAllStates() {
		//instanciar nuestra lista
		List<State>States= new ArrayList<>();
		//Usar nuestro objeto reposotory
		repository.findAll().forEach(e-> States.add(e));
		
		return States;
	}

	@Override
	public State getState(Long id) {
		
		State st = repository.findById(id).get();
		
		return st;
	}

	@Override
	public boolean addState(State entity) {
		try {
			repository.save(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean deleteState(Long id) {
		try {
			repository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	
	}



}
