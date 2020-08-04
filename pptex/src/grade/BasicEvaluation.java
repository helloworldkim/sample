package grade;

public class BasicEvaluation implements GradeEvaluation {
	//일반과목 점수 산출방법
	@Override
	public String getGrade(int point) {
		String grade;
		
		if(point >=90 && point<=100)
			grade="A";
		else if(point >=80)
			grade="B";
		else if(point >=70)
			grade="C";
		else if(point >=55)
			grade="D";
		else
			grade = "F";
		return grade;
	}

}
