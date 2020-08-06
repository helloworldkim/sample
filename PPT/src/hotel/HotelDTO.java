package hotel;

import java.util.ArrayList;

import customer.Customer;
import reserve.reserveSystem;
import utils.utils;

public class HotelDTO {
			Hotel hotel;
			reserveSystem sys = new reserveSystem();
			ArrayList<Hotel> hotelList= new ArrayList<Hotel>();
			ArrayList<Customer> customerList = sys.getCustomerList();
		
		public reserveSystem getSys() {
				return sys;
			}

			public void setSys(reserveSystem sys) {
				this.sys = sys;
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
		public void showHotels() {
			for(int i=0; i<hotelList.size(); i++) {
				System.out.print(i+1+"번 ");
				System.out.println(hotelList.get(i));
			}
		}

		public Hotel getHotel() {
			return hotel;
		}

		public void setHotel(Hotel hotel) {
			this.hotel = hotel;
		}

		public ArrayList<Hotel> getHotelList() {
			return hotelList;
		}

		public void setHotelList(ArrayList<Hotel> hotelList) {
			this.hotelList = hotelList;
		}

		public ArrayList<Customer> getCustomerList() {
			return customerList;
		}

		public void setCustomerList(ArrayList<Customer> customerList) {
			this.customerList = customerList;
		}
		
		
}
