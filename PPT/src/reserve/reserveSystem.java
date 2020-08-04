package reserve;

import customer.Customer;
import hotel.Hotel;

public class reserveSystem {
	int reservedNumber; //예약번호
	Customer customer; //고객정보
	Hotel hotel; //호텔정보
	
	//예약 메서드 랜덤으로 만든 예약번호를 고객에게 반환함
	public int getReserveHotel(Customer customer,Hotel hotel) {
		if(hotel.getRoomCount()>0) {
			hotel.addCustomer(customer);
			customer.setReservationNumber(hotel.hotelReservationNumber());
			hotel.setRoomCount(hotel.getRoomCount()-1);//룸 갯수를 하나 줄어들게함
			hotel.addCustomer(customer);//해당고객 선택한 호텔에 추가함
			return customer.getReservationNumber();
		}else {
			return -1; //예약실패
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
