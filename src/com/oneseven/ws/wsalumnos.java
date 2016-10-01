package com.oneseven.ws;

import com.oneseven.data.StudentDL;
import com.oneseven.entiteslayer.Student;

public class wsalumnos {
	/*public Student searchStudent(int id) throws Exception {
		Student s = new Student();
		try {
			s = StudentBL.Instancia().searchStudent(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public Student loginStudent(String user, String pass) throws Exception {
		Student s = new Student();
		try {
			s = StudentBL.Instancia().loginStudent(user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}*/
	public Student searchStudent(int id) throws Exception {
		Student s = new Student();
		try {
			s = StudentDL.Instancia().searchStudent(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
}
