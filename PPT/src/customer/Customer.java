package customer;

public class Customer {
	
	private String customerId;
	private String customerName;
	private int customerAge;
	private String customerAddress;
	private int reservationNumber;
	
	public Customer() {
		
	}
	
	
	public Customer(String customerId, String customerName, int customerAge, String customerAddress) {
		this.customerId = customerId;
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
		return "성함=" + customerName + ", 나이=" + customerAge + ", 주소="
				+ customerAddress;
	}
	
	
	

}
