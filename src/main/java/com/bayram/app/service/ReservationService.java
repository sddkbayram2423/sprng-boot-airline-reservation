package com.bayram.app.service;

import com.bayram.app.model.Reservation;
import com.bayram.app.model.dto.ReservationRequest;

public interface ReservationService {
	
	 Reservation bookFlight(ReservationRequest reservationRequest);
	 
	 Reservation findById(long id);

	 

}
