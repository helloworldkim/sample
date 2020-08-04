package school;

import java.util.ArrayList;

public class School {
	//싱글톤 패턴
	private static School instance = new School();
	
	private static String SCHOOL_NAME="Good School"; //학교이름
	private ArrayList<Student> studentList = new ArrayList<Student>();//등록된 학생
	private ArrayList<Subject> subjectList = new ArrayList<Subject>();//등록된 학생
	
	//기본생성자
	private School() {
	}
	//getInstance 메서드 호출때 생성된 instance가 없을경우에만 instance생성함
	public static School getInstance() {
		if(instance == null)
			instance = new School();
		return instance;
	}
	
	public ArrayList<Subject> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(ArrayList<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	public ArrayList<Student> getStudentList(){
		return studentList;
	}
	
	//리스트에 추가하는 메서드
	public void addStudent(Student student) {
		studentList.add(student);
	}
	public void addSubject(Subject subject) {
		subjectList.add(subject);
	}
}
