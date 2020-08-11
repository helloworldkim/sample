package model.customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import hotel.Hotel;
import hotel.HotelDTO;

public class HotelCSVInOut {
	private static HotelCSVInOut instance = new HotelCSVInOut();
	HotelDTO hDTO;

	private HotelCSVInOut() {
		
	}
	
	
	public static HotelCSVInOut getInstance() {
		return instance;
	}


	public static void setInstance(HotelCSVInOut instance) {
		HotelCSVInOut.instance = instance;
	}


	public void ReadHotelCSV() {
		BufferedReader in = null;		
		String Filename = "HotelCSV.csv"; //읽어올 파일이름
		try {
			ArrayList<Hotel>hlist = new ArrayList<Hotel>();
			in = new BufferedReader(new FileReader(Filename));
			String line = in.readLine();//1줄 읽어옴
			String[] data = null;			
			while (line != null) {
				data = line.split(",");
				Hotel hotel = new Hotel(data[0],data[1],Integer.parseInt(data[3]));
				hlist.add(hotel);
				line = in.readLine();
			}
			//모든 호텔 출력부분
			for(Hotel h: hlist) {
				System.out.println(h);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	public ArrayList<Hotel> UseHotelCSV() {
		BufferedReader in = null;		
		String Filename = "HotelCSV.csv"; //읽어올 파일이름
		try {
			ArrayList<Hotel>hList = new ArrayList<Hotel>();
			in = new BufferedReader(new FileReader(Filename));
			String line = in.readLine();//1줄 읽어옴
			String[] data = null;			
			while (line != null) {
				data = line.split(",");
				Hotel hotel = new Hotel(data[0],data[1],Integer.parseInt(data[2]));
				hList.add(hotel);
				line = in.readLine();
			}
			return hList;
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void WriteHotelCSV() {
		Scanner sc = new Scanner(System.in);
		String FilePath = "./";
		String title="HotelCSV.csv";
		
		BufferedWriter fw;
		
		try {
			 fw = new BufferedWriter(new FileWriter(FilePath+"/"+title,true));
			 	Hotel hotel = new Hotel();
				System.out.print("호텔이름을 입력해주세요");
				hotel.setHotelName(sc.next());
				System.out.print("지역을 입력해주세요");
				hotel.setHotelLocation(sc.next());
				System.out.print("객실의 총 갯수를 입력해주세요");
				hotel.setRoomCount(sc.nextInt());
				System.out.println("등록되었습니다");
				ArrayList<Hotel> hList = UseHotelCSV();
				hList.add(hotel);
				String hotelName = hotel.getHotelName();
				String hotelLocaiton= hotel.getHotelLocation();
				String hotelRoomTotal = Integer.toString(hotel.getRoomCount());
				//String cage = String.valueOf(age);
				
				fw.append(hotelName).append(",");
				fw.append(hotelLocaiton).append(",");
				fw.append(hotelRoomTotal);
				fw.append("\n");
				
				fw.flush();
				
				fw.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
