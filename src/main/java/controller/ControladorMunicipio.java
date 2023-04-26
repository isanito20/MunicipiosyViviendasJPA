package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Municipio;


public class ControladorMunicipio {

	/**
	 * 
	 * @param municipio
	 * @return
	 */
	public static List<Municipio> filtrarMunicipio(String municipio) {
		List<Municipio> lista = new ArrayList<Municipio>();

		try {
			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo
			// Statement
			Statement s = (Statement) ConnectionManagerJPA.getConexion().createStatement();

			// La ejecución de la consulta se realiza a través del objeto Statement y se
			// recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros
			// obtenidos por la consulta
//			ResultSet rs = s.executeQuery("select * from municipio where nombre='" + municipio + "'");
			ResultSet rs = s.executeQuery("select * from municipio where nombre like '%" + municipio + "%'");

			// Navegación del objeto ResultSet
			while (rs.next()) {
				Municipio i = new Municipio(rs.getInt("id"), rs.getInt("idProvincia"), rs.getInt("codMunicipio"),
						rs.getString("nombre"));
				lista.add(i);
			}
			// Cierre de los elementos
			rs.close();
			s.close();
		} catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
			ex.printStackTrace();
		}

		return lista;
	}

	/**
	 * 
	 */
	public static int modificar(Municipio m) {
		int registrosAfectados = 0;
		try {
			PreparedStatement ps = ConnectionManagerJPA.getConexion()
					.prepareStatement("update municipio set nombre = ?, idProvincia = ?, popularidad = ? where id = ?");
			ps.setString(1, m.getNombre());
			ps.setInt(2, m.getIdProvincia());
			ps.setInt(4, m.getId());
			registrosAfectados = ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return registrosAfectados;
	}

}
