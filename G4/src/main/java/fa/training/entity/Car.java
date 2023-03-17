package fa.training.entity;

public class Car {
	private String licenseplate;
	private String carType;
	private String carColor;
	private String company;
	private int parkingLot;
	public Car() {
		// TODO Auto-generated constructor stub
	}
	public Car(String licenseplate, String carColor, String carType, String company, int parkingLot) {
		super();
		this.licenseplate = licenseplate;
		this.carType = carType;
		this.carColor = carColor;
		this.company = company;
		this.parkingLot = parkingLot;
	}
	public String getLicenseplate() {
		return licenseplate;
	}
	public void setLicenseplate(String licenseplate) {
		this.licenseplate = licenseplate;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getParkingLot() {
		return parkingLot;
	}
	public void setParkingLot(int parkingLot) {
		this.parkingLot = parkingLot;
	}
	@Override
	public String toString() {
		return "Car [licenseplate=" + licenseplate + ", carColor=" + carColor + ", carType=" + carType + ", company="
				+ company + ", parkingLot=" + parkingLot + "]";
	}
}
