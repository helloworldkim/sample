package menu.view;

import java.util.ArrayList;
import java.util.Scanner;

import customer.Customer;
import hotel.Hotel;
import hotel.HotelDTO;
import model.customer.CustomerCSVInOut;
import model.customer.HotelCSVInOut;
import reserve.reserveSystem;

public class BodyMenu {
	Scanner sc = new Scanner(System.in);
	HotelDTO hDTO = new HotelDTO();
	HotelCSVInOut hotelCSV = HotelCSVInOut.getInstance();
	AdminMenu adminMenu = new AdminMenu();
	LastMenu lastMenu = new LastMenu();
	CustomerCSVInOut customerCSV = new CustomerCSVInOut();
	ArrayList<Hotel>hList = hDTO.getHotelList();
	reserveSystem sys = reserveSystem.getInstance();
	

	public void One() {//회원등록
		customerCSV.WriteCustmerCSV();
	}
	public void Two() { //관리자메뉴
		
		boolean loop = true;
		while(loop) {
			int result = adminMenu.AdminView();
			switch (result) {
			case 1:customerCSV.ReadCustomerCSV();				
				break;
			case 2:hotelCSV.WriteHotelCSV();
			break;
			default:loop=lastMenu.adminLastView();
				break;
			}
		}
		
	}
		//모든 호텔 보기
	public void Three() {
		hDTO.showHotels();
		
	}
	//예약하기
	public void Four() {
			//중복체크 메서드
				Customer tempCustomer=sys.checkCustomer();
				if(tempCustomer==null) return;
				hDTO.showHotels();
				String choosedHotel="";
				choosedHotel = sc.next();
				for(int i=0; i<hList.size();i++) {
				//가져온 호텔이름과 고객이 선택한 호텔이름이 같을경우
				if(hList.get(i).getHotelName().equals(choosedHotel)) {
					Hotel hotel = hList.get(i); //현재호텔
					int reservedNumber =sys.getReserveHotel(tempCustomer, hotel);
					//예약번호 생성해줌
					System.out.println(hList.get(i).getHotelName()+"에 정상적으로 예약되셨습니다");
					System.out.printf("고객님의 예약번호는 %d 입니다", reservedNumber);
					return;
				}
			}
		
}	//호텔이름,예약번호로 호텔조회
	public void Five() {
		System.out.println("예약하신 호텔이름을 입력해주세요");
		String choosedHotel="";
		choosedHotel = sc.next();
		System.out.println("예약번호를 입력해주세요");
		int reservedNumber = 0;
		reservedNumber =sc.nextInt();
		for(int i=0; i<hList.size();i++) {
			if(hList.get(i).getHotelName().equals(choosedHotel)) {
				Hotel hotel = hList.get(i);
				System.out.println(hotel.getHotelName());
				hotel.getCustomer(reservedNumber);
			}
	}
}
	
}
