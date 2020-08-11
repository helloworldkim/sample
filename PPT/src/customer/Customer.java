package customer;

public class Customer {
	
	private String customerId;
	private String customerPassword;
	private String customerName;
	private int customerAge;
	private String customerAddress;
	private int reservationNumber;
	
	public Customer() {
		
	}
	
	
	public String getCustomerPassword() {
		return customerPassword;
	}


	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}


	public Customer(String customerId,String customerPassword, String customerName, int customerAge, String customerAddress) {
		this.customerId = customerId;
		this.customerPassword = customerPassword;
		this.customerName = customerName;
		this.customerAge = customerAge;
		this.customerAddress = customerAddress;
	}


	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getReservationNumber() {
		return reservationNumber;
	}
	public void setReservationNumber(int reservationNumber) {
		this.reservationNumber = reservationNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}


	@Override
	public String toString() {
		return "아이디 :" + customerId + ", 비밀번호 :" + customerPassword + ", 이름"
				+ customerName + ", 나이" + customerAge + ", 주소" + customerAddress;
	}

	
	
	
	

}
