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
	
	
	//예약번호가 있을경우 호텔에 예약한 손님이 맞는지 확인하는 메서드
	public void getCustomer(int reservationNumber) {
		for(int i=0; i<customerList.size();i++) {
			for(int j=0; j<customerList.size();j++) {
					int Num = customerList.get(j).getReservationNumber();
					if(Num == reservationNumber) {
						System.out.printf("정상적으로 예약되어있습니다");
						return;
					}
				}
				
			}
		System.out.println("해당호텔에 일치하는 예약번호가 없습니다");
		System.out.println("호텔또는 예약번호를 확인해주세요");
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

	@Override
	public String toString() {
		return "호텔=" + hotelName + ", 등급=" + hotelGrade + ", 위치=" + hotelLocation
				+ ", 객실남은수=" + roomCount;
	}
	
	
	
}
