package com.bayram.app.model.dto;

public class ReservationUpdateRequest {

    private Long id;
    
    private Boolean checkedIn;
    
    private Integer numberOfBags;

	public ReservationUpdateRequest() {
		this.checkedIn=false;
	}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(Boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public Integer getNumberOfBags() {
        return numberOfBags;
    }

    public void setNumberOfBags(Integer numberOfBags) {
        this.numberOfBags = numberOfBags;
    }
}
