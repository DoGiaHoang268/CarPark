package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import fa.training.DBConnection.DBConnection;
import fa.training.entity.Trip;

public class TripDao {
	public void addNewTrip(String destination, String departureTime, String driver, String carType,
			String maximumOnlineTicketNumber, String depatureDate) {
		PreparedStatement ps = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement("INSERT INTO [dbo].[trip]\r\n" + "			           ([destination],\r\n"
					+ "			           [departureTime],\r\n" + "			           [driver],\r\n"
					+ "			           [carType],\r\n" + "			          [maximumOnlineTicketNumber]\r\n"
					+ "			          ,[departureDate]) \r\n" + "			    VALUES(?,?,?,?,?,?)");
			ps.setString(1, destination);
			ps.setString(2, departureTime);
			ps.setString(3, driver);
			ps.setString(4, carType);
			ps.setString(5, maximumOnlineTicketNumber);
			ps.setString(6, depatureDate);
			ps.executeUpdate();
			System.out.println("insert thanh cong");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, null);
		}

	}

	public int countPageSearchAll(String txtSearch) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement("select count(*) from  trip where tripId like ?  or  destination like ?\r\n"
					+ "							   or  departureTime like ?  or driver like ?  or carType like ? or maximumOnlineTicketNumber like ?  ");
			ps.setString(1, "%" + txtSearch + "%");
			ps.setString(2, "%" + txtSearch + "%");
			ps.setString(3, "%" + txtSearch + "%");
			ps.setString(4, "%" + txtSearch + "%");
			ps.setString(5, "%" + txtSearch + "%");
			ps.setString(6, "%" + txtSearch + "%");
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

	// search all
	public List<Trip> search(String txtSearch, int index, int pageSize) {
		ArrayList<Trip> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"with a as(select ROW_NUMBER () over (order by [tripId] asc) as b,* from [dbo].[trip] "
							+ "  where destination like ? " + "    or  departureTime like ?" + "    or  driver like ?"
							+ "    or  carType like ?" + "    or  maximumOnlineTicketNumber like ?)"
							+ "  select * from a where b between ?*5-4 and ?*5 ");
			ps.setString(1, "%" + txtSearch + "%");
			ps.setString(2, "%" + txtSearch + "%");
			ps.setString(3, "%" + txtSearch + "%");
			ps.setString(4, "%" + txtSearch + "%");
			ps.setString(5, "%" + txtSearch + "%");
			ps.setInt(6, index);
			ps.setInt(7, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				Trip trip = new Trip(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getString(8), rs.getString(9));
				list.add(trip);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}

	public List<Trip> searchByTripId(String txtSearch, int index, int pageSize) {
		ArrayList<Trip> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement("with a as(select ROW_NUMBER () over (order by tripId asc) as b,* from trip\r\n"
					+ "where tripId like ? )    select * from a where b between ?*5-4 and ?*5");
			ps.setString(1, "%" + txtSearch + "%");
			ps.setInt(2, index);
			ps.setInt(3, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				Trip trip = new Trip(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getString(8), rs.getString(9));
				list.add(trip);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}

	
	public List<Trip> searchByDepartureDate(String txtSearch, int index, int pageSize) {
		ArrayList<Trip> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement("with a as(select ROW_NUMBER () over (order by [tripId] asc) as b,* from [dbo].[trip] "
					+ "  where destination like ? " + "    or  departureTime like ?" + "    or  driver like ?"
					+ "    or  carType like ?" + "    or  maximumOnlineTicketNumber like ? or  DEPARTUREDATE like ?)"
					+ "  select * from a where b between ?*5-4 and ?*5 ");
			ps.setString(1, "%" + txtSearch + "%");
			ps.setString(2, "%" + txtSearch + "%");
			ps.setString(3, "%" + txtSearch + "%");
			ps.setString(4, "%" + txtSearch + "%");
			ps.setString(5, "%" + txtSearch + "%");
			ps.setString(6, "%" + txtSearch + "%");
			ps.setInt(7, index);
			ps.setInt(8, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				Trip trip = new Trip(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getString(8), rs.getString(9));
				list.add(trip);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}

	public List<Trip> searchByCarType(String txtSearch, int index, int pageSize) {
		ArrayList<Trip> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement("with a as(select ROW_NUMBER () over (order by tripId asc) as b,* from trip\r\n"
					+ "where carType like ? )    select * from a where b between ?*5-4 and ?*5");
			ps.setString(1, "%" + txtSearch + "%");
			ps.setInt(2, index);
			ps.setInt(3, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				Trip trip = new Trip(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getString(8), rs.getString(9));
				list.add(trip);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}

	public List<Trip> searchByDriver(String txtSearch, int index, int pageSize) {
		ArrayList<Trip> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement("with a as(select ROW_NUMBER () over (order by tripId asc) as b,* from trip\r\n"
					+ "where driver like ? )    select * from a where b between ?*5-4 and ?*5");
			ps.setString(1, "%" + txtSearch + "%");
			ps.setInt(2, index);
			ps.setInt(3, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				Trip trip = new Trip(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getString(8), rs.getString(9));
				list.add(trip);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}

	public List<Trip> searchByBookedTicketNumber(String txtSearch, int index, int pageSize) {
		ArrayList<Trip> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement("with a as(select ROW_NUMBER () over (order by tripId asc) as b,* from trip\r\n"
					+ "where bookedTicketNumber like ? )    select * from a where b between ?*5-4 and ?*5");
			ps.setString(1, "%" + txtSearch + "%");
			ps.setInt(2, index);
			ps.setInt(3, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				Trip trip = new Trip(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getString(8), rs.getString(9));
				list.add(trip);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}

	/// end

	public int getTotalTrip() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement("select COUNT(*) from trip");
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

	public ArrayList<Trip> getAllTrip() {
		ArrayList<Trip> listT = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement("select * from trip");
			rs = ps.executeQuery();
			while (rs.next()) {
				Trip trip = new Trip(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8));
				listT.add(trip);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return listT;

	}

	public List<Trip> pagingTrip(int index) {
		ArrayList<Trip> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement("select * from trip order by tripId offset ? rows fetch next 5 rows only");
			ps.setInt(1, ((index - 1) * 5));
			rs = ps.executeQuery();
			while (rs.next()) {
				Trip trip = new Trip(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8));
				list.add(trip);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}

	public Trip getTripbyTripId(int tripId) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement(" select * from trip where tripId = ?");
			ps.setInt(1, tripId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Trip trip = new Trip(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8));
				return trip;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return null;
	}

	public Trip getTripByTripId(String tripId) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement(" select * from trip where tripId = ?");
			ps.setString(1, tripId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Trip trip = new Trip(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8));
				return trip;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return null;
	}

	public Trip getTripByDay(String depatureDate) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement("select * from trip\r\n" + "where departureDate =?");
			ps.setString(1, depatureDate);
			rs = ps.executeQuery();
			while (rs.next()) {
				Trip trip = new Trip(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8));
				return trip;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return null;
	}

	public void updateTripByTripId(String destination, String departureTime, String driver, String carType,
			String maximumOnlineTicketNumber, String depatureDate, String tripId) {
		PreparedStatement ps = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					" update [trip] set  destination=?,  departureTime =?,  driver=?,  carType =?,\r\n"
							+ "			 maximumOnlineTicketNumber=?,  departureDate=? where  tripId = ?");
			ps.setString(1, destination);
			ps.setString(2, departureTime);
			ps.setString(3, driver);
			ps.setString(4, carType);
			ps.setString(5, maximumOnlineTicketNumber);
			ps.setString(6, depatureDate);
			ps.setString(7, tripId);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, null);
		}

	}

	public Trip getTripByDestination(String destination) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteTripByTripId(String tripId) {
		PreparedStatement ps = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement("delete from trip where tripId = ?");
			ps.setString(1, tripId);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, null);
		}

	}

}
