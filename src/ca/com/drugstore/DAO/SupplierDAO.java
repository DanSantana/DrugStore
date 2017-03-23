package ca.com.drugstore.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ca.com.drugstore.domain.Supplier;
import ca.com.drugstore.factory.ConnectionFactory;

public class SupplierDAO {
	public void save(Supplier sup) throws SQLException {
		// Definir o sql
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO supplier ");// sempr edeixar um espaco em
												// branco
		sql.append("(description)");
		sql.append("VALUES (?) ");

		Connection con = ConnectionFactory.openConnectio();
		PreparedStatement cmd = con.prepareStatement(sql.toString());
		// mapeamento de objeto relacional
		cmd.setString(1, sup.getDescription());// 1= quantidade de "?"// valores
		cmd.executeUpdate();
	}

	public void delete(Supplier sup) throws SQLException {
		// 1 - definir SQL string
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM supplier ");
		sql.append("WHERE idsuplier = ? ");

		Connection con = ConnectionFactory.openConnectio();
		PreparedStatement cmd = con.prepareStatement(sql.toString());
		cmd.setLong(1, sup.getIdsupplier());
		cmd.executeUpdate();
	}

	public void editDescription(Supplier sup) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE supplier ");
		sql.append("SET description = ? ");
		sql.append("WHERE idsuplier = ? ");

		Connection con = ConnectionFactory.openConnectio();
		PreparedStatement cmd = con.prepareStatement(sql.toString());
		cmd.setString(1, sup.getDescription());
		cmd.setLong(2, sup.getIdsupplier());

		cmd.executeUpdate();
	}

	public Supplier find(Supplier sup) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idsuplier, description ");
		sql.append("FROM supplier ");
		sql.append("WHERE idsuplier = ? ");

		Connection con = ConnectionFactory.openConnectio();

		PreparedStatement cmd = con.prepareStatement(sql.toString());
		cmd.setLong(1, sup.getIdsupplier());
		ResultSet resultado = cmd.executeQuery();

		Supplier retorno = null;

		if (resultado.next()) {
			retorno = new Supplier();
			retorno.setIdsupplier(resultado.getLong("idsuplier"));
			retorno.setDescription(resultado.getString("description"));
		}
		return retorno;
	}

	public ArrayList<Supplier> listing() throws SQLException {
		// 1- construir sql builder string de query
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idsuplier, description ");
		sql.append("FROM supplier ");
		sql.append("ORDER BY description ASC ");
		// 2- abrir conection
		Connection con = ConnectionFactory.openConnectio();
		// 3 - preparar comando de query e converter para string
		PreparedStatement cmd = con.prepareStatement(sql.toString());
		// 4- executar o comando dentro de um result set
		ResultSet result = cmd.executeQuery();

		ArrayList<Supplier> listing = new ArrayList<Supplier>();
		while (result.next()) {
			Supplier s = new Supplier();
			s.setIdsupplier(result.getLong("idsuplier"));
			s.setDescription(result.getString("description"));
			listing.add(s);
		}
		return listing;
	}

	public ArrayList<Supplier> listByDescription(Supplier s) throws SQLException {
		// 1- construir sql builder string de query
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idsuplier, description ");
		sql.append("FROM supplier ");
		sql.append("WHERE description LIKE ? ");
		sql.append("ORDER BY description ASC ");

		// 2- abrir conection
		Connection con = ConnectionFactory.openConnectio();
		// 3 - preparar comando de query e converter para string
		PreparedStatement cmd = con.prepareStatement(sql.toString());
		// 4 - configurar o ?
		cmd.setString(1, "%" + s.getDescription() + "%");
		// 5- executar o comando dentro de um result set
		ResultSet result = cmd.executeQuery();
		ArrayList<Supplier> listing = new ArrayList<Supplier>();
		while (result.next()) {
			Supplier item = new Supplier();
			item.setIdsupplier(result.getLong("idsuplier"));
			item.setDescription(result.getString("description"));
			listing.add(item);
		}
		return listing;
	}

	public static void main(String[] args) {

		Supplier s1 = new Supplier();
		s1.setDescription("2");
		SupplierDAO sDAO = new SupplierDAO();

		try {
			ArrayList<Supplier> list = sDAO.listByDescription(s1);
			for (Supplier item : list) {
				System.out.println(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * SupplierDAO sDAO = new SupplierDAO();
	 * 
	 * try { ArrayList<Supplier> listyeah = sDAO.listing(); for (Supplier s1 :
	 * listyeah) { System.out.println(s1); } } catch (SQLException e) {
	 * System.out.println(" Error: "); e.printStackTrace(); } } /* public static
	 * void main(String[] args) {
	 * 
	 * Supplier s1 = new Supplier(); s1.setIdsuplier(2L);
	 * 
	 * Supplier s2 = new Supplier(); s2.setIdsuplier(5L);
	 * 
	 * SupplierDAO sdao = new SupplierDAO(); try { Supplier supA =
	 * sdao.find(s1); Supplier SupB = sdao.find(s2);
	 * 
	 * System.out.println(" Result 1: " + supA);
	 * System.out.println(" Result 2: " + SupB);
	 * 
	 * } catch (SQLException e) {
	 * System.out.println(" there is Error during the search: ");
	 * e.printStackTrace(); }
	 * 
	 * 
	 * Supplier s2 = new Supplier(); s2.setIdsuplier(2L);// codigo exsitente
	 * s2.setDescription("Descricao 2 _R01");// nova descricao
	 * 
	 * SupplierDAO sdao = new SupplierDAO(); try { sdao.editDescription(s2);
	 * System.out.println("Supplier succcessfully spdated! ");
	 * 
	 * } catch (SQLException e) {
	 * System.out.println("Was not possible update the customer, ERROR: ");
	 * e.getClass(); e.getStackTrace(); }
	 */

	/*
	 * Supplier s1 = new Supplier(); s1.setIdsuplier(1L); Supplier s2 = new
	 * Supplier(); s2.setIdsuplier(4L);
	 * 
	 * SupplierDAO sdao = new SupplierDAO();
	 * 
	 * try { sdao.delete(s2); System.out.println("Supplier deleted! ");
	 * 
	 * } catch (SQLException e) {
	 * System.out.println("Was not possible delete the Suplier Error: ");
	 * e.getStackTrace(); e.getClass(); }
	 */
	/*
	 * Supplier s1 = new Supplier(); Supplier s2 = new Supplier();
	 * 
	 * s1.setDescription("Description 1"); s2.setDescription("Description 2");
	 * 
	 * SupplierDAO sdao = new SupplierDAO();
	 * 
	 * try { sdao.save(s1); sdao.save(s2);
	 * System.out.println(" Supplier saved successfully!"); } catch
	 * (SQLException e) {
	 * 
	 * System.out.println(" ERROR saving Supplier is unable!");
	 * e.printStackTrace(); }
	 */
}
