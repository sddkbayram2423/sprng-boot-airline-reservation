package com.bayram.app.controller;

import javax.validation.Valid;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bayram.app.model.dto.ReservationRequest;
import com.bayram.app.service.FlightService;
import com.bayram.app.service.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private ReservationService reservationService;
	
	//-------------------------------------------------------------------------------------------------------------
	
	@PostMapping("/selectFlight/{id}")
	public String selectFlight(Model model,@PathVariable("id") long id) {
		
		model.addAttribute("flight", flightService.findById(id));
		model.addAttribute("reservationRequest", new ReservationRequest());
		
		return "paymentpage";
	}
	
	//----------------------------------------------------------------------------------------------------------
	@PostMapping("/complete-reservation/{id}")
	public String searchFlight(Model model,@PathVariable("id") Long id,
							   @ModelAttribute("reservationRequest") @Valid ReservationRequest reservationRequest,
							   BindingResult bindingResult) {
		
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("flight", flightService.findById(id));
			model.addAttribute("reservationRequest", reservationRequest);
			
			return "paymentpage";
			
		}
	
		model.addAttribute("msg", "Reservation created successfully.You can find your your reservation's pdf format  under D: folder");
		
		reservationRequest.setFlightId(id);
		reservationService.bookFlight(reservationRequest);
		model.addAttribute("flight", flightService.findById(id));
		model.addAttribute("reservationRequest", reservationRequest);
		
		return "reservationConfirmation";
	}
	
	
	
	
	

}
