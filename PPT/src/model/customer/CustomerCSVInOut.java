package model.customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import customer.Customer;
import reserve.reserveSystem;

public class CustomerCSVInOut {
	reserveSystem sys = reserveSystem.getInstance();
	Scanner sc = new Scanner(System.in);
	public void WriteCustmerCSV() {
		String FilePath = "./";
		String title="exCSV.csv";

		BufferedWriter fw;
		
		try {
			fw = new BufferedWriter(new FileWriter(FilePath+"/"+title,true));
			Customer customer = new Customer();
			System.out.print("등록하실 아이디를입력해주세요");
			customer.setCustomerId(sc.next());
			System.out.print("비밀번호를 입력해주세요");
			customer.setCustomerPassword((sc.next()));
			System.out.print("고객성함을 입력해주세요");
			customer.setCustomerName(sc.next());
			System.out.print("나이를 입력해주세요");
			customer.setCustomerAge(sc.nextInt());
			System.out.print("주소를 입력해주세요");
			customer.setCustomerAddress(sc.next());
			System.out.println("등록되었습니다");
			ArrayList<Customer>cList = sys.getCustomerList();
			cList.add(customer); //첫 등록고객은 바로 사용가능하게 sys의 customerList에 추가함
			//CSV파일 작성부분
			String Id = customer.getCustomerId();
			String Pw = customer.getCustomerPassword();
			String name = customer.getCustomerName();
			String age = Integer.toString(customer.getCustomerAge());
			//String cage = String.valueOf(age);
			String address = customer.getCustomerAddress();
			fw.append(Id).append(",");
			fw.append(Pw).append(",");
			fw.append(name).append(",");
			fw.append(age).append(",");
			fw.append(address);
			//줄바꿈메서드
			fw.append(System.lineSeparator());
			//append("\n"); 해당방법으로는 줄바꿈 안됨
			
			fw.flush();
			fw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	public void ReadCustomerCSV() {
		BufferedReader in = null;		
		String Filename = "exCSV.csv"; //읽어올 파일이름
		try {
			ArrayList<Customer>clist = new ArrayList<Customer>();
			in = new BufferedReader(new FileReader(Filename));
			String line = in.readLine();//1줄 읽어옴
			String[] data = null;			
			while (line != null) {
				data = line.split(",");
				Customer customer = new Customer(data[0],data[1],data[2],Integer.parseInt(data[3]),data[4]);
				clist.add(customer);
				line = in.readLine();
			}
			//모든 회원 출력부분
			for(Customer c:clist) {
				System.out.println(c);
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
	public ArrayList<Customer> UseCustomerCSV() {
		BufferedReader in = null;		
		String Filename = "exCSV.csv"; //읽어올 파일이름
		try {
			ArrayList<Customer>clist = new ArrayList<Customer>();
			in = new BufferedReader(new FileReader(Filename));
			String line = in.readLine();//1줄 읽어옴
			String[] data = null;			
			while (line != null) {
				data = line.split(",");
				Customer customer = new Customer(data[0],data[1],data[2],Integer.parseInt(data[3]),data[4]);
				clist.add(customer);
				line = in.readLine();
			}
			return clist;
			//모든 회원 출력부분
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
	

}
