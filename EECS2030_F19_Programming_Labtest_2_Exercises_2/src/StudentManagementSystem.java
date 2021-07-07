import java.util.ArrayList;

public class StudentManagementSystem {
	private ArrayList<Student> students;
	public StudentManagementSystem() {
		students = new ArrayList<>();
	}
	public Student[] getStudents() {
		Student[] result = new Student[students.size()];
		for(int i = 0; i < students.size(); i++) {
			result[i] = students.get(i);
		}
		return result;
	}
	
	
	public void addStudent(Student s) {
		students.add(s);
	}
	public void registerAll(Course c) {
		for(Student s :students) {
			s.register(c);
		}
	}
	
}
