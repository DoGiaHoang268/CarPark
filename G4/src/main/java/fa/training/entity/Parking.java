package fa.training.entity;

public class Parking {
	private int parkId;
	private String parkName;
	private String place;
	private int parkArea;
	private int price;
	private String Status;

	public int getParkId() {
		return parkId;
	}

	public void setParkId(int parkId) {
		this.parkId = parkId;
	}

	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getParkArea() {
		return parkArea;
	}

	public void setParkArea(int parkArea) {
		this.parkArea = parkArea;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	

	public Parking(int parkId, String parkName, String place, int parkArea, int price, String status) {
		super();
		this.parkId = parkId;
		this.parkName = parkName;
		this.place = place;
		this.parkArea = parkArea;
		this.price = price;
		Status = status;
	}

	public Parking() {
		super();
	}

}
