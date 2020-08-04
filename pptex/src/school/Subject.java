package school;

import java.util.ArrayList;

import utils.Define;

public class Subject {
	private String subjectName; //과목이름
	private int subjectId; //과목 고유번호
	private int gradeType; //학점 평가정책
	
	private ArrayList<Student> studentList = new ArrayList<Student>(); //학생 리스트
	
	//register메서드 사용시 학생리스트에 학생을 추가함(수강신청)
	public void register(Student student) {
		studentList.add(student);
	}

	public Subject(String subjectName, int subjectId) {
		this.subjectName = subjectName;
		this.subjectId = subjectId;
		this.gradeType = Define.AB_TYPE; //기본방식은 ab방식! 일반과목 산출정책
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getGradeType() {
		return gradeType;
	}

	public void setGradeType(int gradeType) {
		this.gradeType = gradeType;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	
	

}
