package com.softtek.academia.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.softtek.academia.entity.State;
import com.softtek.academia.service.StateService;

@Controller
public class StateController {
	//instanciar nuestro obj de Stateservice 
	private StateService stateService;
	
	//contructor de esta misma clase vacio para sobrecargarlo
	public StateController() {
		
	}
	
	@Autowired
	public StateController(StateService stateService) {
		this.stateService= stateService;
	}
	
	//el eandponit para consegir todos mis estados (get)
	@GetMapping("/allStates")
	public ModelAndView displayAllStates() {
		//intanciamos nuestro obj modelandview
		ModelAndView mv= new ModelAndView();
		//crear una lista que obtenar todos mis estados 
		List<State> listaEstados= stateService.getAllStates();
		mv.addObject("stateList",listaEstados);
		mv.setViewName("State/allStates");
		return mv;
	}
	
	//Endpoint para agregar estados. 
	@GetMapping("/addState")
	public ModelAndView displayAddNewForm() {
		ModelAndView mv = new ModelAndView("State/addState");
		mv.addObject("headerMessage", "Add State details");
		mv.addObject("State",new State());
		return mv;
	}
	
	@PostMapping("/addState")
	public ModelAndView saveNewState(@ModelAttribute State State,BindingResult result) {
		ModelAndView mv= new ModelAndView("redirect:/home");
		if(result.hasErrors()) {
			return new ModelAndView("error");
		}
		boolean isAdd= stateService.addState(State);
		if(isAdd)
			mv.addObject("messege","New State successfully added");
		else {
			return new ModelAndView("error");
		}
		
		return mv;
			
	}
	
	//endpoint para editar mis estados 
	@GetMapping("/editState/{id}")
	public ModelAndView displayNewEditForm(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("State/editState");
		State estado= stateService.getState(id);
		mv.addObject("headerMessage", "Edit State details");
		mv.addObject("state",estado);
		return mv;
		
	}
	
	@PostMapping("/editState/{id}")
	public ModelAndView saveEditState(@ModelAttribute State state, BindingResult result) {
		ModelAndView mv = new ModelAndView("redirect:/home");
		if(result.hasErrors()) {
			System.out.println(result.toString());
			return new ModelAndView("error");
		}
		boolean isEdit = stateService.addState(state);
		if(!isEdit) {
			return new ModelAndView("error");
		}
		return mv;
		
	}
	@GetMapping("/deleteState/{id}")
	public ModelAndView deleteStateById(@PathVariable Long id) {
		boolean isDeleted = stateService.deleteState(id);
		ModelAndView mv = new ModelAndView("redirect:/home");
		return mv;
	}
}
