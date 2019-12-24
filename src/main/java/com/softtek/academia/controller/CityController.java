package com.softtek.academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.softtek.academia.entity.City;
import com.softtek.academia.entity.State;
import com.softtek.academia.service.CityService;
import com.softtek.academia.service.StateService;

import java.util.List;

@Controller
public class CityController {
	
	private CityService CService;
	
	public CityController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public CityController(CityService CService) {
		super();
		this.CService=CService;
	}
	
	@Autowired
    private StateService stateService;
	
	
	@GetMapping("/allCities")
	public ModelAndView getDisplayListCities() {
		ModelAndView mv = new ModelAndView();
		//crear una nueva lista 
		List<City> listadeCiudades= CService.getAllCities();
		mv.addObject("citiesList",listadeCiudades);
		mv.setViewName("City/allCities");
		return mv;
	}
	
	@GetMapping("/addCity")     
	public ModelAndView displayNewStateForm(){ 
		ModelAndView mv = new ModelAndView("City/addCity");  
		mv.addObject("headerMessage","Add City Details"); 
		List<State> states = stateService.getAllStates();   
		mv.addObject("city", new City()); 
		mv.addObject("states", states);  
		return mv;    
		}
	@PostMapping("/addCity")
	public ModelAndView saveNewState(@ModelAttribute City city ,BindingResult result) {
		ModelAndView mv= new ModelAndView("redirect:/home");
		if(result.hasErrors()) {
			return new ModelAndView("error");
		}
		boolean isAdd= CService.addCity(city);
		if(isAdd)
			mv.addObject("messege","New State successfully added");
		else {
			return new ModelAndView("error");
		}
		
		return mv;
			
	}
	
	@GetMapping("/editCity/{id}")
	public ModelAndView displayNewEditForm(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("City/editCity");
		
		List<State> states = stateService.getAllStates();
		City ciudad= CService.getCity(id);
		mv.addObject("headerMessage", "Edit City details");
		mv.addObject("states",states);
		mv.addObject("city",ciudad);
		
		return mv;
		
	}
	
	@PostMapping("/editCity/{id}")
	public ModelAndView saveEditState(@ModelAttribute City city, BindingResult result) {
		ModelAndView mv = new ModelAndView("redirect:/home");
		if(result.hasErrors()) {
			System.out.println(result.toString());
			return new ModelAndView("error");
		}
		boolean isEdit = CService.addCity(city);
		if(!isEdit) {
			return new ModelAndView("error");
		}
		return mv;
		
	}
	
	@GetMapping("/deleteCity/{city_id}")
	public ModelAndView deleteCityById(@PathVariable Long city_id) {
	    boolean isDeleted = CService.deleteCity(city_id);
		ModelAndView mv = new ModelAndView("redirect:/home");
		return mv;
	}
}
