package fa.training.entity;

public class BookingOffice {
	int officeld;
	String officeName;
	String officePhone;
	String officePlace;
	String officePrice;
	String startContractDeadline;
	String endContractDeadline;	
	int tripId;
	String destination;

	public int getOfficeld() {
		return officeld;
	}

	public void setOfficeld(int officeld) {
		this.officeld = officeld;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getOfficePlace() {
		return officePlace;
	}

	public void setOfficePlace(String officePlace) {
		this.officePlace = officePlace;
	}

	public String getOfficePrice() {
		return officePrice;
	}

	public void setOfficePrice(String officePrice) {
		this.officePrice = officePrice;
	}

	public String getEndContractDeadline() {
		return endContractDeadline;
	}

	public void setEndContractDeadline(String endContractDeadline) {
		this.endContractDeadline = endContractDeadline;
	}

	public String getStartContractDeadline() {
		return startContractDeadline;
	}

	public void setStartContractDeadline(String startContractDeadline) {
		this.startContractDeadline = startContractDeadline;
	}

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public BookingOffice(int officeld, String officeName, String officePhone, String officePlace, String officePrice,
			String startContractDeadline, String endContractDeadline, int tripId) {
		super();
		this.officeld = officeld;
		this.officeName = officeName;
		this.officePhone = officePhone;
		this.officePlace = officePlace;
		this.officePrice = officePrice;
		this.startContractDeadline = startContractDeadline;
		this.endContractDeadline = endContractDeadline;
		this.tripId = tripId;
	}

	public BookingOffice(int officeld, String officeName, String officePhone, String officePlace, String officePrice,
			String startContractDeadline, String endContractDeadline, int tripId, String destination) {
		super();
		this.officeld = officeld;
		this.officeName = officeName;
		this.officePhone = officePhone;
		this.officePlace = officePlace;
		this.officePrice = officePrice;
		this.startContractDeadline = startContractDeadline;
		this.endContractDeadline = endContractDeadline;
		this.tripId = tripId;
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "BookingOffice [officeld=" + officeld + ", officeName=" + officeName + ", officePhone=" + officePhone
				+ ", officePlace=" + officePlace + ", officePrice=" + officePrice + ", startContractDeadline="
				+ startContractDeadline + ", endContractDeadline=" + endContractDeadline + ", tripId=" + tripId + "]";
	}

	public BookingOffice() {
		super();
	}

}
