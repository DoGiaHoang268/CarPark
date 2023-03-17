package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fa.training.DBConnection.DBConnection;
import fa.training.entity.BookingOffice;

public class BookingDao {

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

	public int getTotalContent() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement(" select count(*) from  bookingoffice,trip where trip.tripId=bookingoffice.tripId");
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

	public ArrayList<BookingOffice> pagingContent(int index) {
		ArrayList<BookingOffice> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement("select * from bookingoffice,trip where trip.tripId=bookingoffice.tripId order by "
					+ "officeld offset ? rows fetch next 5 rows only;");
			ps.setInt(1, ((index - 1) * 5));
			rs = ps.executeQuery();
			while (rs.next()) {
				BookingOffice booking = new BookingOffice(rs.getInt(1), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(2), rs.getInt(8),rs.getString(14));
				list.add(booking);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}
	public int getTotalSearchContent(String textSearch) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement("select count(*) from bookingoffice\r\n"
					+ "inner join trip on trip.tripId=bookingoffice.tripId \r\n"
					+ "where officeName like ? or destination like ?");
			ps.setString(1, "%"+textSearch+"%");
			ps.setString(2, "%"+textSearch+"%");
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
	public int getTotalSearchContentByName(String textSearch) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement("select count(*) from bookingoffice\r\n"
					+ "inner join trip on trip.tripId=bookingoffice.tripId \r\n"
					+ "where officeName like ?");
			ps.setString(1, "%"+textSearch+"%");
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
	public int getTotalSearchContentByDestination(String textSearch) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement("select count(*) from bookingoffice\r\n"
					+ "inner join trip on trip.tripId=bookingoffice.tripId \r\n"
					+ "where destination like ?");
			ps.setString(1, "%"+textSearch+"%");
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
	public ArrayList<BookingOffice> searchAll(String textSearch,int index) {
		ArrayList<BookingOffice> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement("select * from bookingoffice\r\n"
					+ "inner join trip on trip.tripId=bookingoffice.tripId \r\n"
					+ "where officeName like ? or destination like ?\r\n"
					+ "order by officeld offset ? rows fetch next 5 rows only;");
			ps.setString(1, "%"+textSearch+"%");
			ps.setString(2, "%"+textSearch+"%");
			ps.setInt(3, ((index - 1) * 5));
			rs = ps.executeQuery();
			while (rs.next()) {
				BookingOffice booking = new BookingOffice(rs.getInt(1), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(2), rs.getInt(8),rs.getString(14));
				list.add(booking);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}
	public ArrayList<BookingOffice> searchByDestination(String textSearch,int index) {
		ArrayList<BookingOffice> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement("select * from bookingoffice\r\n"
					+ "inner join trip on trip.tripId=bookingoffice.tripId \r\n"
					+ "where destination like ?\r\n"
					+ "order by officeld offset ? rows fetch next 5 rows only;");
			ps.setString(1, "%"+textSearch+"%");
			ps.setInt(2, ((index - 1) * 5));
			rs = ps.executeQuery();
			while (rs.next()) {
				BookingOffice booking = new BookingOffice(rs.getInt(1), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(2), rs.getInt(8),rs.getString(14));
				list.add(booking);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}
	public ArrayList<BookingOffice> searchByName(String textSearch,int index) {
		ArrayList<BookingOffice> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement("select * from bookingoffice\r\n"
					+ "inner join trip on trip.tripId=bookingoffice.tripId \r\n"
					+ "where officeName like ?\r\n"
					+ "order by officeld offset ? rows fetch next 5 rows only;");
			ps.setString(1, "%"+textSearch+"%");
			ps.setInt(2, ((index - 1) * 5));
			rs = ps.executeQuery();
			while (rs.next()) {
				BookingOffice booking = new BookingOffice(rs.getInt(1), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(2), rs.getInt(8),rs.getString(14));
				list.add(booking);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}
	
	public BookingOffice GetBookingById(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement("select * from bookingoffice "
					+ "inner join trip on trip.tripId=bookingoffice.tripId where officeld=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				BookingOffice booking = new BookingOffice(rs.getInt(1), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(2), rs.getInt(8),rs.getString(14));
				return booking;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return null;

	}
	public ArrayList<String> GetListPlace() {
		ArrayList<String> listPlace= new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement("select distinct destination from trip");
			rs = ps.executeQuery();
			while (rs.next()) {
				listPlace.add(rs.getString(1));
				return listPlace;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return null;

	}
}
