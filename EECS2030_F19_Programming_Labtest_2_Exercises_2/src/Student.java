import java.util.ArrayList;



public class Student {
		private String name;
		private ArrayList<Course> courses;
		public Student(String name) {
			this.name = name;
			courses = new ArrayList<Course>();
		}
		public Course[] getCourses() {
			Course[] result = new Course[courses.size()];
			for(int i = 0; i < courses.size(); i++) {
				result[i] = courses.get(i);
			}
			return result;
		}
		
		public double getTuition() {
			double sum = 0;
			for(int i = 0; i < courses.size();i++) {
				sum += courses.get(i).getFee();
			}
			return sum;
		}
		public void register(Course c) {
			courses.add(c);
		}
		public void drop(Course c) {
			courses.remove(c);
		}
		
}
