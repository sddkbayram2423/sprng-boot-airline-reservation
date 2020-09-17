package com.bayram.app.controller;



import java.util.List;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bayram.app.model.Flight;
import com.bayram.app.model.dto.FlightDto;
import com.bayram.app.service.FlightService;

@Controller
@RequestMapping("/flight")
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	
	@ModelAttribute(name = "flightDto")
	public FlightDto flightDto() {
		return new FlightDto();
	}
	
	
	//-------------------------------------------------------------------------------------------------------------------------
	
	@RequestMapping(value = "/searchPage",method = RequestMethod.POST)
	public String searchPage() {
		
		return "searchPage";
	}

	//-------------------------------------------------------------------------------------------------------------------------
	
	@PostMapping("/search")
	private String listFlight( Model model,@Valid @ModelAttribute("flightDto") FlightDto flightDto,  BindingResult result) {
		
		
		if(result.hasErrors()) {
			return "searchPage";
		}
		
		List<Flight> flightsAllList=flightService.getAllFligtList(flightDto);
	
		if(flightsAllList.size()<=0) {
			
			model.addAttribute("message", "No flight found according to your criteria");
			
			return "searchPage";
		}
		
		model.addAttribute("flights", flightsAllList);
		
		return "listFlight";
		
	}
	
	//-------------------------------------------------------------------------------------------------------------------------
	
	@GetMapping("/addNewFlight")
	public String addFlight(Model model) {
		
		model.addAttribute("flight", new Flight());
		
		return "addNewFlight";
	}
	
	//-------------------------------------------------------------------------------------------------------------------------
	
	@PostMapping("/addNewFlight")
	public String saveFlight(Model model,@Valid @ModelAttribute("flight") Flight flight,  BindingResult result) {
		
		if(result.hasErrors()) {
			model.addAttribute("flight", flight);
			
			return "addNewFlight";
		}
		
		System.out.println(flight);
		
		flightService.createFlight(flight);
		
		model.addAttribute("flights", flightService.findAll());
		
		return "listFlightForAdmin";
	}
	
	//-------------------------------------------------------------------------------------------------------------------------
	
	@GetMapping("/edit/{id}")
	public String editFlight(Model model,@PathVariable("id") long id) {
		
		model.addAttribute("flight", flightService.findById(id));
		
		return "update-flight";
	}
	
	
	//-------------------------------------------------------------------------------------------------------------------------
	
	@PostMapping("/update/{id}")
	public String updateFlight(Model model,@Valid @ModelAttribute("flight") Flight flight,@PathVariable("id") long id, BindingResult result) {
		
		if(result.hasErrors()) {
			flight.setId(id);
			model.addAttribute("flight", flight);
			return "update-flight";
		}
		
		System.out.println(flight);
		
		flightService.updateFlight(flight);
		
		model.addAttribute("flights", flightService.findAll());
		
		return "listFlightForAdmin";
	}

	//-------------------------------------------------------------------------------------------------------------------------
	
	@GetMapping("/delete/{id}")
	public String deleteFlight(Model model, @PathVariable("id") long id) {
		
		
		flightService.deleteFlight(id);

		model.addAttribute("flights", flightService.findAll());

		return "listFlightForAdmin";
	}
	//-------------------------------------------------------------------------------------------------------------------------
	@GetMapping("/showAllFlightList")
	public String showAllFlightList(Model model) {
		model.addAttribute("flights", flightService.findAll());
		
		return "listFlightForAdmin";
	}
	
	
	
}
