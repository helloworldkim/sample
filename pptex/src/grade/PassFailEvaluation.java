package grade;

public class PassFailEvaluation implements GradeEvaluation {
	//댄스과목 점수 산출방법
	@Override
	public String getGrade(int point) {
		if(point >=70 && point<=100) {
			return "패스";
		}
		else {
			return "재수강";
		}
	}

}
