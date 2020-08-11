package reserve;

import java.util.ArrayList;
import java.util.Scanner;

import customer.Customer;
import hotel.Hotel;
import model.customer.CustomerCSVInOut;

public class reserveSystem {
	int reservedNumber; //예약번호
	Customer customer; //고객정보
	Hotel hotel; //호텔정보
	ArrayList<Customer> customerList;
	CustomerCSVInOut customerCSV = new CustomerCSVInOut();
	private static reserveSystem instance = new reserveSystem(); //스테틱으로 생성함
	
	//싱글톤패턴 외부에서는 생성자 생성못함
	private reserveSystem() {
		customerList = customerCSV.UseCustomerCSV();
	}
	
	

	public static reserveSystem getInstance() {
		return instance;
	}



	public static void setInstance(reserveSystem instance) {
		reserveSystem.instance = instance;
	}


	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}
	//예약 메서드 랜덤으로 만든 예약번호를 고객에게 반환함
	public int getReserveHotel(Customer customer,Hotel hotel) {
		int RoomLeft = hotel.getRoomCount();
		if(RoomLeft>0) {
			customer.setReservationNumber(hotel.hotelReservationNumber());
			hotel.setRoomCount(hotel.getRoomCount()-1);//룸 갯수를 하나 줄어들게함
			hotel.addCustomer(customer);//해당고객 선택한 호텔에 추가함
			return customer.getReservationNumber();
		}else {
			System.out.println("예약에 실패하셨습니다 해당호텔에 남은 객실이 없습니다");
			return -1;
		}
	}
	public Customer checkCustomer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("등록된 회원이신지 확인 후 이용가능하십니다");
		System.out.println("예약 진행하시는분의 아이디을 입력해주세요");
		String customerId = sc.next();
		System.out.println("비밀번호를 입력해주세요");
		String customerPassword = sc.next();
		ArrayList<Customer> cList = customerCSV.UseCustomerCSV();
		for(int i=0; i<cList.size(); i++) {
			if(cList.get(i).getCustomerId().equals(customerId) && cList.get(i).getCustomerPassword().equals(customerPassword)) {
				System.out.println("등록된 고객 확인되었습니다");
				System.out.println("호텔이름를 선택해주세요");
				return cList.get(i);
			}
			
		}
		System.out.println("비등록된 고객입니다");
		return null;
}	
	public void checkRegister(String userId) {
		String tempId= userId;
		ArrayList<Customer> cList = customerCSV.UseCustomerCSV();
		for(int i=0; i<cList.size();i++) {
			if(cList.get(i).getCustomerId().equals(tempId)){//리스트의 아이디값이 동일한것이 있는지 확인
				System.out.println("동일한 아이디가 존재합니다");
			}else {
				System.out.println("생성이 가능합니다");
			}
		}
	
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
