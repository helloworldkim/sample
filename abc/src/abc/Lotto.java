package abc;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
			public static void main(String[] args) {
				
				LottoMachine machine = new LottoMachine();
				System.out.print("생성번호 :");
				System.out.printf("%s ", machine.generater());
//				System.out.println(machine.generater());
//				int[] numbers = machine.getLottoNumbers();
//				System.out.print(machine.getLottoNumbers());
				
//				System.out.print("생성번호 :");
//				for(int i : numbers)
//					System.out.printf("%d ",i);
			}
			
}
class LottoMachine{
	
	private int[] LottoNumbers;
	Set<Integer> set = new HashSet<>();
	
	public LottoMachine() {
//		int[] LottoNumbers = new int[6];
		generater();
				
	}
	
	public Set<Integer> generater() {
		//6개짜리 배열선언
//		int[] pickedNumbers = new int[6];
		Random rand = new Random();
		while(set.size()!=6) {
			int number = rand.nextInt(45)+1;
			set.add(number);
		}
		set.stream().sorted().collect(Collectors.toList());
		return set;
		
	}
//	public void getLottoNumbers() {
//		for(int set : set) {
//			System.out.println(set);
//		}
//	
//	}
	
	
}