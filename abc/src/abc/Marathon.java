package abc;

import java.util.HashMap;

public class Marathon {
		public static void main(String[] args) {
			System.out.println(solution(new String[] {"병주","병헌","승언"}, new String[] {"병헌","승언"}));
			System.out.println(solution(new String[] {"병주","병헌","승언","송군"}, new String[] {"병주","병헌","송군"}));
			System.out.println(solution(new String[] {"병주","병헌","승언","송군"}, new String[] {"병주","병헌","승언"}));
		}
		
		public static String solution(String[] participant, String[] completion) {
			String answer ="";
			
			HashMap<String, Integer> hm = new HashMap<>();
			
			for(String name : participant) {
				if(hm.get(name) == null) {
					hm.put(name, 1);
				}else {
					int value = hm.get(name) +1;
					hm.put(name, value);
				}
			}
			
			for(String name : completion) {
				if(hm.get(name) == null) {
					hm.put(name, 1);
				}else {
					int value = hm.get(name) -1;
					hm.put(name, value);
				}
			}
			
			for(String name : hm.keySet()) {
				if(hm.get(name)==1) {
					answer=name;
				}
			}
			return answer;
		}
}
