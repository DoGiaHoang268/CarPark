package fa.training.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fa.training.DBConnection.DBConnection;
import fa.training.entity.Parking;

public class ParkingDao {

	public ResultSet getData(String sql) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rs;
	}

	// Parking parkingList = new
	// Parking(rs.getInt(1),rs.getString(3),rs.getString(4),rs.getInt(2),rs.getInt(5),rs.getString(6));
	public int getTotalContent() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement(" select count(*) from  parkinglot");
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return 0;

	}

	public ArrayList<Parking> pagingContent(int index) {
		ArrayList<Parking> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement(
					"select * from parkinglot order by " + "parkId offset ? rows fetch next 5 rows only;");
			ps.setInt(1, ((index - 1) * 5));
			rs = ps.executeQuery();
			while (rs.next()) {
				Parking parkingList = new Parking(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getInt(2),
						rs.getInt(5), rs.getString(6));
				list.add(parkingList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;

	}

	public Parking parkingById(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement("select * from parkinglot where " + "parkId=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Parking parking = new Parking(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getInt(2),
						rs.getInt(5), rs.getString(6));
				return parking;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return null;

	}

	public int execute(String sql) {
		int n = 0;
		try {
			Connection conn;
			try {
				conn = DBConnection.SQLCONNECTION.getConnection();
				PreparedStatement pre = conn.prepareStatement(sql);
				n = pre.executeUpdate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return n;
	}

	public int updateParking(String parkName, String place, int parkArea, int price, int parkId) {
		int n = 0;
		try {
			Connection conn;
			try {
				conn = DBConnection.SQLCONNECTION.getConnection();
				PreparedStatement ps = conn.prepareStatement(
						"update parkinglot set parkName=?,parkPlace=?,parkArea=?,parkPrice=? where parkId=?");
				ps.setString(1, parkName);
				ps.setString(2, place);
				ps.setInt(3, parkArea);
				ps.setInt(4, price);
				ps.setInt(5, parkId);
				n = ps.executeUpdate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return n;
	}

	public int getTotalSearchContent(String textSearch) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement("select count(*) from parkinglot where parkName like ? or parkPlace like ? \r\n"
					+ "or parkArea like ? or parkPrice like ? or parkStatus like ?");
			ps.setString(1, "%" + textSearch + "%");
			ps.setString(2, "%" + textSearch + "%");
			ps.setString(3, "%" + textSearch + "%");
			ps.setString(4, "%" + textSearch + "%");
			ps.setString(5, "%" + textSearch + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return 0;
	}

	public ArrayList<Parking> searchAll(String textSearch, int index) {
		ArrayList<Parking> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement("select * from parkinglot where parkName like ? or parkPlace like ? \r\n"
					+ "or parkArea like ? or parkPrice like ? or parkStatus like ? \r\n"
					+ "order by parkId offset ? rows fetch next 5 rows only;\r\n");
			ps.setString(1, "%" + textSearch + "%");
			ps.setString(2, "%" + textSearch + "%");
			ps.setString(3, "%" + textSearch + "%");
			ps.setString(4, "%" + textSearch + "%");
			ps.setString(5, "%" + textSearch + "%");
			ps.setInt(6, ((index - 1) * 5));
			rs = ps.executeQuery();
			while (rs.next()) {
				Parking parkingList = new Parking(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getInt(2),
						rs.getInt(5), rs.getString(6));
				list.add(parkingList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}
	public ArrayList<Parking> searchByFilter(String textSearch, int index,String filterName) {
		ArrayList<Parking> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement("select * from parkinglot where "+filterName+" like ? "
					+ "order by parkId offset ? rows fetch next 5 rows only;\r\n");
			ps.setString(1, "%" + textSearch + "%");
			ps.setInt(2, ((index - 1) * 5));
			System.out.println("select * from parkinglot where "+filterName+" like "+"%" + textSearch + "%"+" "
					+ "order by parkId offset ? rows fetch next 5 rows only;\r\n");
			rs = ps.executeQuery();
			while (rs.next()) {
				Parking parkingList = new Parking(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getInt(2),
						rs.getInt(5), rs.getString(6));
				list.add(parkingList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}
	public int getTotalSearchContentByFilter(String textSearch,String filterName) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement("select count(*) from parkinglot where ? like ? ");
			ps.setString(1,filterName);
			ps.setString(2, "%" + textSearch + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return 0;
	}
	public int Delete(int parkId) {
		int n = 0;
		try {
			Connection conn;
			try {
				conn = DBConnection.SQLCONNECTION.getConnection();
				PreparedStatement ps = conn.prepareStatement(
						"delete parkinglot where parkId=?");
				ps.setInt(1,parkId);
				n = ps.executeUpdate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return n;
	}
}
