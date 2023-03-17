package fa.training.entity;

public class Employee {
	private int employeeId;
	private String account;
	private String department;
	private String employeeAddress;
	private String employeeBirthdate;
	private String employeeEmail;
	private String employeeName;
	private String employeePhone;
	private String password;
	private String sex;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}

	public Employee(int employeeId, String account, String department, String employeeAddress, String employeeBirthdate,
			String employeeEmail, String employeeName, String employeePhone, String password, String sex) {
		super();
		this.employeeId = employeeId;
		this.account = account;
		this.department = department;
		this.employeeAddress = employeeAddress;
		this.employeeBirthdate = employeeBirthdate;
		this.employeeEmail = employeeEmail;
		this.employeeName = employeeName;
		this.employeePhone = employeePhone;
		this.password = password;
		this.sex = sex;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeeBirthdate() {
		return employeeBirthdate;
	}

	public void setEmployeeBirthdate(String employeeBirthdate) {
		this.employeeBirthdate = employeeBirthdate;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
