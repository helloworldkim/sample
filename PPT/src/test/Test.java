package test;

import java.util.ArrayList;
import java.util.Scanner;

import customer.Customer;
import hotel.Hotel;
import reserve.reserveSystem;



public class Test {
	
	
	
	public static void main(String[] args) {
		Test test = new Test();
		Hotel hotel = new Hotel();
		ArrayList<Hotel> hotelList=new ArrayList<Hotel>();
		hotelList = hotel.createHotel();//호텔4개생성
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("원하시는 메뉴를 선택해주세요");
		System.out.println("1.회원가입 2.호텔예약 3.나가기");
		int answer = sc.nextInt();
		if(answer==1) {
			Customer customer = new Customer();
			System.out.print("고객성함을 입력해주세요");
			customer.setCustomerName(sc.next());
			System.out.print("나이를 입력해주세요");
			customer.setCustomerAge(sc.nextInt());
			System.out.print("주소를 입력해주세요");
			customer.setCustomerAddress(sc.next());
			System.out.println("등록되었습니다");
			System.out.println("호텔이름를 선택해주세요");
			hotel.showHotels();
			String choosedHotel="";
			choosedHotel = sc.next();
			for(int i=0; i<hotelList.size();i++) {
				//가져온 호텔이름과 고객이 선택한 호텔이름이 같을경우
				if(hotelList.get(i).getHotelName().equals(choosedHotel)) {
					reserveSystem sys = new reserveSystem();
					hotel = hotelList.get(i); //현재호텔
					int reservedNumber =sys.getReserveHotel(customer, hotel);
					//예약번호 생성해줌
					System.out.println(hotelList.get(i).getHotelName()+"님 예약되셨습니다");
					System.out.printf("고객님의 예약번호는 %d 입니다", reservedNumber);
				}
				
			}
			
		}else if(answer==2) {
			System.out.println("");
			System.out.println("호텔 이름을 선택해주세요");
			hotel.showHotels();
		}else {
			System.out.println("이용해주셔서 감사합니다");
		}
		
		
		
	}
	
	


}
