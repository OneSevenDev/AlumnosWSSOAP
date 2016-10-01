package com.oneseven.data;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
	public static Conexion _Instancia;

	private Conexion() {
	};

	public static Conexion Instancia() {
		if (_Instancia == null) {
			_Instancia = new Conexion();
		}
		return _Instancia;
	}
	// endSingleton

	public Connection Conectar() throws Exception {
		Connection con = null;
		try {
			String url = "jdbc:mysql://127.0.0.1/escuela";
			String user = "root";
			String clave = "12345678";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, clave);
			System.out.println("Exito conexion BD");
		} catch (Exception e) {
			System.out.println("Error conexion BD " + e.getMessage());
			e.printStackTrace();
		}
		return con;
	}
}
