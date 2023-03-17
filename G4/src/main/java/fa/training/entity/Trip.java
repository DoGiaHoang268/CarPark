package fa.training.entity;


public class Trip {
private int tripId ;
private String bookedTicketNumber;
private String carType;
private String depatureDate ;
private String departureTime;
private String destination;
private String driver;
private String maximumOnlineTicketNumber;

public Trip() {
	// TODO Auto-generated constructor stub
}

public Trip(int tripId, String bookedTicketNumber, String carType, String depatureDate, String departureTime,
		String destination, String driver, String maximumOnlineTicketNumber) {
	super();
	this.tripId = tripId;
	this.bookedTicketNumber = bookedTicketNumber;
	this.carType = carType;
	this.depatureDate = depatureDate;
	this.departureTime = departureTime;
	this.destination = destination;
	this.driver = driver;
	this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
}


public Trip(String destination) {
	super();
	this.destination = destination;
}

public int getTripId() {
	return tripId;
}
public void setTripId(int tripId) {
	this.tripId = tripId;
}
public String getBookedTicketNumber() {
	return bookedTicketNumber;
}
public void setBookedTicketNumber(String bookedTicketNumber) {
	this.bookedTicketNumber = bookedTicketNumber;
}
public String getCarType() {
	return carType;
}
public void setCarType(String carType) {
	this.carType = carType;
}
public String getDepatureDate() {
	return depatureDate;
}
public void setDepatureDate(String depatureDate) {
	this.depatureDate = depatureDate;
}
public String getDepartureTime() {
	return departureTime;
}
public void setDepartureTime(String departureTime) {
	this.departureTime = departureTime;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
public String getDriver() {
	return driver;
}
public void setDriver(String driver) {
	this.driver = driver;
}
public String getMaximumOnlineTicketNumber() {
	return maximumOnlineTicketNumber;
}
public void setMaximumOnlineTicketNumber(String maximumOnlineTicketNumber) {
	this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
}

@Override
public String toString() {
	return "Trip [tripId=" + tripId + ", bookedTicketNumber=" + bookedTicketNumber + ", carType=" + carType + ", depatureDate="
			+ depatureDate + ", departureTime=" + departureTime + ", destination=" + destination + ", driver=" + driver + ", maximumOnlineTicketNumber=" + maximumOnlineTicketNumber + "]";
}
}
