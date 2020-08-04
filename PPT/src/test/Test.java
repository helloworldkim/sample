package test;

import java.util.ArrayList;
import java.util.Scanner;

import customer.Customer;
import hotel.Hotel;
import reserve.reserveSystem;



public class Test {
	
	
	
	public static void main(String[] args) {
		Hotel hotel = new Hotel();
		//ArrayList<Hotel> hotelList=new ArrayList<Hotel>();
		hotel.setHotelList(hotel.createHotel());//호텔4개생성 후 list에 추가
		ArrayList<Hotel>hList = hotel.getHotelList();
		Customer customer = new Customer();
		
		Scanner sc = new Scanner(System.in);
		
		boolean loop= true;
		while(loop) {
				System.out.println("원하시는 메뉴를 선택해주세요");
				System.out.println("1.회원가입 2.호텔예약 3.예약확인4.나가기");
				int answer = sc.nextInt();
			if(answer==1) {//처음에는 무조건 회원등록을 해야만 사용가능  db를 이용하는게 아니라서
				System.out.print("고객성함을 입력해주세요");
				customer.setCustomerName(sc.next());
				System.out.print("나이를 입력해주세요");
				customer.setCustomerAge(sc.nextInt());
				System.out.print("주소를 입력해주세요");
				customer.setCustomerAddress(sc.next());
				System.out.println("등록되었습니다");
			}else if(answer==2) {
				System.out.println("호텔이름를 선택해주세요");
				hotel.showHotels();
				String choosedHotel="";
				choosedHotel = sc.next();
				for(int i=0; i<hList.size();i++) {
				//가져온 호텔이름과 고객이 선택한 호텔이름이 같을경우
				if(hList.get(i).getHotelName().equals(choosedHotel)) {
					reserveSystem sys = new reserveSystem();
					hotel = hList.get(i); //현재호텔
					int reservedNumber =sys.getReserveHotel(customer, hotel);
					//예약번호 생성해줌
					System.out.println(hList.get(i).getHotelName()+"에 정상적으로 예약되셨습니다");
					System.out.printf("고객님의 예약번호는 %d 입니다", reservedNumber);
				}
			}
		}else if(answer==3){
			System.out.println("예약하신 호텔이름을 입력해주세요");
			String choosedHotel="";
			choosedHotel = sc.next();
			System.out.println("예약번호를 입력해주세요");
			int reservedNumber = sc.nextInt();
			
			hotel.getCustomer(choosedHotel, reservedNumber, hList);
		}else {
			System.out.println("이용해주셔서 감사합니다");
			loop=false;
		}
	} //반복문 종료
	
	

	}
}
