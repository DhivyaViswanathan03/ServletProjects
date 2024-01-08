package persistence;

import dto.Student;

public interface IStudentDao {
	
public String addStudent(Student s);
	
	public Student searchStudent(int sid);
	
	
	
	public String deleteStudent(int sid);

	public String updateStudent(Student student);
	

}
