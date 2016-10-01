package com.oneseven.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.oneseven.entiteslayer.Student;


public class StudentDL {
	// Singleton
	public static StudentDL _Instancia;

	private StudentDL() {
	};

	public static StudentDL Instancia() {
		if (_Instancia == null) {
			_Instancia = new StudentDL();
		}
		return _Instancia;
	}

	// endSingleton

	public ArrayList<Student> listStudentAll() throws Exception {
		Connection conn = null;
		ArrayList<Student> listStudent = null;
		try {
			listStudent = new ArrayList<>();
			conn = Conexion.Instancia().Conectar();
			CallableStatement cstm = conn.prepareCall("{CALL sp_listaActivos()}");
			ResultSet rs = cstm.executeQuery();
			while (rs.next()) {

				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setNombres(rs.getString("nombres"));
				s.setApellidos(rs.getString("apellidos"));
				s.setEdad(rs.getInt("edad"));
				s.setUsuario(rs.getString("usuario"));

				listStudent.add(s);

				System.out.println("Exito: StudentDL - listStudentAll");
			}
		} catch (Exception e) {
			System.out.println("Error: StudentDL - listStudentAll -> " + e.getMessage());
			throw e;
		} finally {
			conn.close();
		}
		return listStudent;
	}

	public Student searchStudent(int id) throws Exception {
		Connection conn = null;
		Student s = null;
		try {
			conn = Conexion.Instancia().Conectar();
			CallableStatement cstm = conn.prepareCall("SELECT id,nombres,apellidos,edad,usuario FROM alumnos WHERE id = ?");
			cstm.setInt(1, id);
			ResultSet rs = cstm.executeQuery();
			while (rs.next()) {

				s = new Student();
				s.setId(rs.getInt("id"));
				s.setNombres(rs.getString("nombres"));
				s.setApellidos(rs.getString("apellidos"));
				s.setEdad(rs.getInt("edad"));
				s.setUsuario(rs.getString("usuario"));

				System.out.println("Exito: StudentDL - searchStudent");
			}
		} catch (Exception e) {
			System.out.println("Error: StudentDL - searchStudent -> " + e.getMessage());
			throw e;
		} finally {
			conn.close();
		}
		return s;
	}

	public Student loginStudent(String user, String pass) throws Exception {
		Connection conn = null;
		Student s = null;
		try {
			conn = Conexion.Instancia().Conectar();
			CallableStatement cstm = conn.prepareCall("{CALL sp_loginAlumnos(?,?)}");
			cstm.setString(1, user);
			cstm.setString(2, pass);
			ResultSet rs = cstm.executeQuery();
			while (rs.next()) {

				s = new Student();
				s.setId(rs.getInt("id"));
				s.setNombres(rs.getString("nombres"));
				s.setApellidos(rs.getString("apellidos"));
				s.setEdad(rs.getInt("edad"));
				s.setUsuario(rs.getString("usuario"));

				System.out.println("Exito: StudentDL - loginStudent");
			}
		} catch (Exception e) {
			System.out.println("Error: StudentDL - loginStudent -> " + e.getMessage());
			throw e;
		} finally {
			conn.close();
		}
		return s;
	}
}
