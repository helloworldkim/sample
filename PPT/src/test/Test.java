package test;

import java.util.ArrayList;
import java.util.Scanner;

import customer.Customer;
import hotel.Hotel;
import reserve.reserveSystem;



public class Test {
	
	
	
	public static void main(String[] args) {
		reserveSystem sys = new reserveSystem();
		sys.setHotelList(sys.createHotel());//호텔4개생성 후 list에 추가
		ArrayList<Hotel>hList = sys.getHotelList();
		
		Scanner sc = new Scanner(System.in);
		
		boolean loop= true;
		while(loop) {
				System.out.println("원하시는 메뉴를 선택해주세요");
				System.out.println("1.회원가입 2.호텔예약 3.예약확인4.내 호텔확인하기5.나가기");
				int answer = sc.nextInt();
			if(answer==1) {//처음에는 무조건 회원등록을 해야만 사용가능  db를 이용하는게 아니라서
				Customer customer = new Customer();
				System.out.print("고객성함을 입력해주세요");
				customer.setCustomerName(sc.next());
				System.out.print("나이를 입력해주세요");
				customer.setCustomerAge(sc.nextInt());
				System.out.print("주소를 입력해주세요");
				customer.setCustomerAddress(sc.next());
				System.out.println("등록되었습니다");
				ArrayList<Customer>clist = sys.getCustomerList();
				clist.add(customer); //고객등록 후 customerList에 추가함
				System.out.println(clist);
			}else if(answer==2) {
				System.out.println("등록된 회원이신지 확인 후 이용가능하십니다");
				System.out.println("예약 진행하시는분의 성함을 입력해주세요");
				String customerName = sc.next();
				System.out.println("나이을 입력해주세요");
				int customerAge = sc.nextInt();
				System.out.println("주소를 입력해주세요");
				String customerAddress = sc.next();
				Customer tempCust=sys.checkCustomer(customerName, customerAge, customerAddress);
				System.out.println("호텔이름를 선택해주세요");
				sys.showHotels();
				String choosedHotel="";
				choosedHotel = sc.next();
				for(int i=0; i<hList.size();i++) {
				//가져온 호텔이름과 고객이 선택한 호텔이름이 같을경우
				if(hList.get(i).getHotelName().equals(choosedHotel)) {
					Hotel hotel = hList.get(i); //현재호텔
					int reservedNumber =sys.getReserveHotel(tempCust, hotel);
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
			for(int i=0; i<hList.size();i++) {
				if(hList.get(i).getHotelName().equals(choosedHotel)) {
					Hotel hotel = hList.get(i);
					System.out.println(hotel.getHotelName());
					hotel.getCustomer(reservedNumber);
				}
		}
			
		}else if(answer==4) {
			System.out.println("등록하신 이름을 입력해주세요");
			String customerName = sc.next();
			System.out.println("등록하신 나이을 입력해주세요");
			int customerAge = sc.nextInt();
			System.out.println("등록하신 주소을 입력해주세요");
			String customerAddress = sc.next();
			sys.getMyHotels(customerName, customerAge, customerAddress);
			
		}else {
			System.out.println("이용해주셔서 감사합니다");
			loop=false;
		}
	} //반복문 종료
	
	

	}
}
