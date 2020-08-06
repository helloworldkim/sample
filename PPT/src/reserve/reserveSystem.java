package reserve;

import java.util.ArrayList;

import customer.Customer;
import hotel.Hotel;

public class reserveSystem {
	int reservedNumber; //예약번호
	Customer customer; //고객정보
	Hotel hotel; //호텔정보
	ArrayList<Customer> customerList;
	
	//인스턴스 생성시 호텔4개 생성해서 가지고있고 고객리스트도 가지고있음
	public reserveSystem() {
		//hotelList = sys.createHotel();
		//hotelList = new ArrayList<Hotel>();
		customerList = new ArrayList<Customer>();
	}
	
	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}
	//예약 메서드 랜덤으로 만든 예약번호를 고객에게 반환함
	public int getReserveHotel(Customer customer,Hotel hotel) {
		if(hotel.getRoomCount()>0) {
			customer.setReservationNumber(hotel.hotelReservationNumber());
			hotel.setRoomCount(hotel.getRoomCount()-1);//룸 갯수를 하나 줄어들게함
			hotel.addCustomer(customer);//해당고객 선택한 호텔에 추가함
			return customer.getReservationNumber();
		}else {
			System.out.println("예약에 실패하셨습니다 해당호텔에 남은 객실이 없습니다");
			return -1;
		}
	}
	public Customer checkCustomer(String customerName, int customerAge, String customerAddress ) {
		for(int i=0; i<customerList.size(); i++) {
			if(customerList.get(i).getCustomerName().equals(customerName) && customerList.get(i).getCustomerAge()==customerAge && customerList.get(i).getCustomerAddress().equals(customerAddress)) {
				System.out.println("등록된 고객 확인되었습니다");
				return customerList.get(i);
			}
		}
		System.out.println("비등록된 고객입니다");
		return null;
}
	
	
	public int getReservedNumber() {
		return reservedNumber;
	}
	public void setReservedNumber(int reservedNumber) {
		this.reservedNumber = reservedNumber;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}	
	
}
