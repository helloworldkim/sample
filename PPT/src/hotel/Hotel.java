package hotel;

import java.util.ArrayList;
import java.util.Random;

import customer.Customer;
import utils.utils;

public class Hotel {
	private String hotelName;
	private String hotelGrade;
	private String hotelLocation;
	private int roomCount;
	
	
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
	//기본생성자
	public Hotel() {
		this.hotelGrade = utils.NOMAL; //기본등급은 일반 등급으로 지정
	}
	//생성자
	public Hotel(String hotelName, String hotelLocation, int roomCount) {
		this.hotelName = hotelName;
		this.hotelGrade = utils.NOMAL; //기본등급은 일반 등급으로 지정
		this.hotelLocation = hotelLocation;
		this.roomCount = roomCount;
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
	
	public int hotelReservationNumber() {
		int reservationNumber =0;
		Random random = new Random();
		reservationNumber=random.nextInt(10000); //1만까지 랜덤번호를 예약번호로 사용
		
		return reservationNumber;
	}
	
	//고객리스트에 고객을 추가하는 메서드
	public void addCustomer(Customer customer) {
		customerList.add(customer);
	}
	
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelGrade() {
		return hotelGrade;
	}
	public void setHotelGrade(String hotelGrade) {
		this.hotelGrade = hotelGrade;
	}
	public String getHotelLocation() {
		return hotelLocation;
	}
	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}
	public int getRoomCount() {
		return roomCount;
	}
	public void setRoomCount(int roomCount) {
		this.roomCount = roomCount;
	}
	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}

	public ArrayList<Hotel> getHotelList() {
		return hotelList;
	}

	public void setHotelList(ArrayList<Hotel> hotelList) {
		this.hotelList = hotelList;
	}
	@Override
	public String toString() {
		return "호텔=" + hotelName + ", 등급=" + hotelGrade + ", 위치=" + hotelLocation
				+ ", 객실남은수=" + roomCount;
	}
	
	
	
}
