package report;

import java.util.ArrayList;

import grade.BasicEvaluation;
import grade.GradeEvaluation;
import grade.MajorEvaluation;
import grade.PassFailEvaluation;
import school.School;
import school.Score;
import school.Student;
import school.Subject;
import utils.Define;

public class GenerateGradeReport {
	School school = School.getInstance();
	public static final String TITLE = " 수강생 학점 \t\t\n";
	public static final String HEADER = "이름 | 학번 | 필수과목 | 점수  \n";
	public static final String LINE = "----------------------------\n";
	
	private StringBuffer buffer = new StringBuffer();
	
	public String getReport() {
		//과목리스트를 가져옴
		ArrayList<Subject> subjectList = school.getSubjectList();
		
		for(Subject subject : subjectList) {
			makeHeader(subject);
			makeBody(subject);
			makeFooter();
		}
		return buffer.toString(); //string 형으로 변환
	}
	
	public void makeHeader(Subject subject) {
		//처음에 라인추가
		buffer.append(GenerateGradeReport.LINE);
		buffer.append("\t"+subject.getSubjectName());//과목이름 추가
		buffer.append(GenerateGradeReport.TITLE); //수강생 학점
		buffer.append(GenerateGradeReport.HEADER); //기타 사항들
		buffer.append(GenerateGradeReport.LINE); //라인
	}
	public void makeBody(Subject subject) {
		ArrayList<Student> studentList = subject.getStudentList();
		
		for(int i=0; i<studentList.size(); i++) {
			Student student = studentList.get(i); //학생을 한명씩 받아와서
			buffer.append(student.getStudentName());//학생이름 추가
			buffer.append("|");
			buffer.append(student.getStudentId()); //학번추가
			buffer.append("|");
			buffer.append(student.getMajorSubject().getSubjectName()+"\t");
			buffer.append("|");
			
			getScoreGrade(student, subject.getSubjectId()); //학생별 수강 과목 학점 계산 메서드
			
			buffer.append("\n");
			buffer.append(LINE);
		}
	}

	public void getScoreGrade(Student student, int subjectId) {
		ArrayList<Score> scoreList = student.getScoreList();
		int majorId= student.getMajorSubject().getSubjectId();
		
		//학점 산출방식에따른 메서드 2개 생성해서 배열로 저장(학점평가 클래스) //pass fail클래스 추가됨
		GradeEvaluation[] gradeEvaluation = {new BasicEvaluation(),
				new MajorEvaluation(), new PassFailEvaluation()};
		
		for(int i=0; i<scoreList.size();i++) {
			Score score = scoreList.get(i);
			if(score.getSubject().getSubjectId() == subjectId) {
				String grade;
			if(score.getSubject().getGradeType() == Define.PF_TYPE) {
				grade= gradeEvaluation[Define.PF_TYPE].getGrade(score.getPoint());
			}else {
				if(score.getSubject().getSubjectId()==majorId) {
					//메이저 과목 
					grade = gradeEvaluation[Define.SAB_TYPE].getGrade(score.getPoint());
				}else {//일반과목
					grade = gradeEvaluation[Define.AB_TYPE].getGrade(score.getPoint());
				}
			}
			
			buffer.append(score.getPoint());
			buffer.append(":");
			buffer.append(grade);
			buffer.append("|");
			}
		}
	}
	
	public void makeFooter() {
		buffer.append("\n");
		buffer.append(LINE);
	}
}
