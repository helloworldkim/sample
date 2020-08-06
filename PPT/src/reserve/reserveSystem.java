package reserve;

import java.util.ArrayList;

import customer.Customer;
import hotel.Hotel;
import utils.utils;

public class reserveSystem {
	int reservedNumber; //예약번호
	Customer customer; //고객정보
	Hotel hotel; //호텔정보
	ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
	
	public reserveSystem() {
		// TODO Auto-generated constructor stub
	}
	
	ArrayList<Customer> customerList = new ArrayList<Customer>(); //고객명단
	
	/*public void showCustomers() {
		for(int i=0; i<customerList.size(); i++) {
			System.out.println(customerList.get(i));
		}
	}*/
	
	//시스템에 고객을 등록하는 메서드
	public void addCustomer(Customer customer) {
		customerList.add(customer);
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
	public void getMyHotels(String customerName, int customerAge, String customerAddress ) {
		for(int i=0; i<customerList.size(); i++) {
			String myhotels="";
			if(customerList.get(i).getCustomerName().equals(customerName) && customerList.get(i).getCustomerAge()==customerAge && customerList.get(i).getCustomerAddress().equals(customerAddress)) {
				System.out.println("고객등록 확인되었습니다");
				//호텔모두를 순회하면서 등록된 고객이 있는지 확인
				for(int j=0; j<hotelList.size(); j++) {
					ArrayList<Customer> clist=hotelList.get(i).getCustomerList();//호텔의 고객명단
					for(int k=0; k<clist.size();k++) {
						if(clist.get(i).getCustomerName().equals(customerName)&&clist.get(i).getCustomerAge()==customerAge&&clist.get(i).getCustomerAddress().equals(customerAddress)) {
							myhotels += hotelList.get(i).getHotelName();
						}
					}
					System.out.println(myhotels);
					return;
				}
				System.out.println("등록되신 호텔이 없습니다");
				return;
			}
		}
		System.out.println("비등록고객입니다");
		return;
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
	
public ArrayList<Hotel> createHotel() {
		
		Hotel sinra = new Hotel("신라호텔", "서울", 3);
		Hotel westin = new Hotel("웨스틴조선","부산",3);
		Hotel grand = new Hotel("그랜드호텔","부산",3);
		Hotel toyo = new Hotel("토요코인","부산",3);
	
		sinra.setHotelGrade(utils.FRIVESTAR);
		westin.setHotelGrade(utils.FRIVESTAR);
		grand.setHotelGrade(utils.FRIVESTAR);
		
		hotelList.add(sinra);
		hotelList.add(westin);
		hotelList.add(grand);
		hotelList.add(toyo);
		
		return hotelList;
		
	}
	public void showHotels() {
		ArrayList<Hotel>hotels =getHotelList();
		for(int i=0; i<hotels.size(); i++) {
			System.out.print(i+1+"번 ");
			System.out.println(hotels.get(i));
		}
		/*
		for(Hotel h : hotels) {
			System.out.println(h);
		}*/
		
	}
	public ArrayList<Hotel> getHotelList() {
		return hotelList;
	}

	public void setHotelList(ArrayList<Hotel> hotelList) {
		this.hotelList = hotelList;
	}

}
