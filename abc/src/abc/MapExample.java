package abc;

import java.util.HashMap;

public class MapExample {
	public static void main(String[] args) {
		
		HashMap<String, String> emails = new HashMap<String, String>();
		
		emails.put("나리", "nari@gmail.com");
		emails.put("정애", "jungae@gmail.com");
		emails.put("홍팍", "sehong@gmail.com");
		
		System.out.printf("emails.size()-> %d\n", emails.size());
		
		System.out.println("\n===key set====");
		for(String k : emails.keySet()) {
			System.out.println(k);
		}
		
		System.out.println("\n===values====");
		for(String v : emails.values()) {
			System.out.println(v);
		}
		System.out.println("\n===values====");
		for(String k : emails.keySet()) {
			System.out.println(emails.get(k));
		}
		
	}

}
