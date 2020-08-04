package test;

import report.GenerateGradeReport;
import school.School;
import school.Score;
import school.Student;
import school.Subject;
import utils.Define;

public class Test {
	School school = School.getInstance();
	Subject korean;
	Subject math;
	
	GenerateGradeReport gradeReport = new GenerateGradeReport();
	
	public static void main(String[] args) {
		Test test = new Test();
		test.createSubject();
		test.createStudent();
		
		String report = test.gradeReport.getReport();//성적결과 생성
		System.out.println(report);
	}

	public void createSubject() {
		korean = new Subject("국어", Define.KOREAN);
		math = new Subject("수학", Define.MATH);
		
		school.addSubject(korean);
		school.addSubject(math);
	}
	public void createStudent() {
		Student s1 = new Student(181213, "안성원", korean);
		Student s2 = new Student(181518, "오태훈", math);
		Student s3 = new Student(171230, "이동호", korean);
		Student s4 = new Student(171255, "조성욱", korean);
		Student s5 = new Student(171590, "최태평", math);
		
		school.addStudent(s1);
		school.addStudent(s2);
		school.addStudent(s3);
		school.addStudent(s4);
		school.addStudent(s5);
		
		korean.register(s1);
		korean.register(s2);
		korean.register(s3);
		korean.register(s4);
		korean.register(s5);
		
		math.register(s1);
		math.register(s2);
		math.register(s3);
		math.register(s4);
		math.register(s5);
		
		addScoreStudent(s1,korean,95);
		addScoreStudent(s1,math,56);
		
		addScoreStudent(s2,korean,95);
		addScoreStudent(s2,math,95);
		
		addScoreStudent(s3,korean,100);
		addScoreStudent(s3,math,88);
		
		addScoreStudent(s4,korean,89);
		addScoreStudent(s4,math,95);
		
		addScoreStudent(s5,korean,85);
		addScoreStudent(s5,math,56);
		
	}

	public void addScoreStudent(Student student, Subject subject, int point) {
		Score score = new Score(student.getStudentId(), subject, point);
		student.addSubjectScore(score);
		
	}

}
