package fa.training.entity;

public class Ticket extends Trip {
private int ticketId;
private String bookingTime;
private String customerName;
private String licensePlate;
private int tripId;


public Ticket() {
	// TODO Auto-generated constructor stub
}

public Ticket(int ticketId, String bookingTime, String customerName, String licensePlate, int tripId) {
	super();
	this.ticketId = ticketId;
	this.bookingTime = bookingTime;
	this.customerName = customerName;
	this.licensePlate = licensePlate;
	this.tripId = tripId;
}

public int getTicketId() {
	return ticketId;
}

public void setTicketId(int ticketId) {
	this.ticketId = ticketId;
}

public String getBookingTime() {
	return bookingTime;
}

public void setBookingTime(String bookingTime) {
	this.bookingTime = bookingTime;
}

public String getCustomerName() {
	return customerName;
}

public void setCustomerName(String customerName) {
	this.customerName = customerName;
}

public String getLicensePlate() {
	return licensePlate;
}

public void setLicensePlate(String licensePlate) {
	this.licensePlate = licensePlate;
}

public int getTripId() {
	return tripId;
}

public void setTripId(int tripId) {
	this.tripId = tripId;
}

public Ticket(String bookingTime, String customerName, String licensePlate, int tripId) {
	super();
	this.bookingTime = bookingTime;
	this.customerName = customerName;
	this.licensePlate = licensePlate;
	this.tripId = tripId;
}

public Ticket(int ticketId, String bookingTime, String customerName, String licensePlate,int tripId,String destination) {
	super();
	// TODO Auto-generated constructor stub
	this.ticketId = ticketId;
	this.bookingTime = bookingTime;
	this.customerName = customerName;
	this.licensePlate = licensePlate;
	this.tripId = tripId;
	
}

public Ticket(String destination, int ticketId, String bookingTime, String customerName, String licensePlate,
		int tripId) {
	super(destination);
	this.ticketId = ticketId;
	this.bookingTime = bookingTime;
	this.customerName = customerName;
	this.licensePlate = licensePlate;
	this.tripId = tripId;
}

@Override
public String toString() {
	return "Ticket [ticketId=" + ticketId + ", bookingTime=" + bookingTime + ", customerName=" + customerName
			+ ", licensePlate=" + licensePlate + ", tripId=" + tripId + "]";
}

}
