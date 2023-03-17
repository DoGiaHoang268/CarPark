package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fa.training.DBConnection.DBConnection;
import fa.training.entity.Ticket;

public class TicketDao {
	public void addNewTicket(String bookingTime, String customerName, String licensePlate, int tripId) {
		PreparedStatement ps = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {

			ps = con.prepareStatement("INSERT INTO [dbo].[ticket]\r\n" + "           ([bookingTime]\r\n"
					+ "           ,[customerName]\r\n" + "           ,[licensePlate]\r\n" + "           ,[tripId])\r\n"
					+ "     VALUES\r\n" + "           (?,?,?,?)");
			ps.setString(1, bookingTime);
			ps.setString(2, customerName);
			ps.setString(3, licensePlate);
			ps.setInt(4, tripId);
			ps.executeUpdate();
			System.out.println("insert thanh cong");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, null);
		}

	}
//	public static void main(String[] args) {
//		TicketDao dao = new TicketDao();
//		dao.addNewTicket("12:12:00.0000000", "adada", "26M1-00007", 1);
//		System.out.println();
//	}

	public ArrayList<Ticket> getAllContent() {
		ArrayList<Ticket> listT = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {

			ps = con.prepareStatement(
					"select ticket.*, trip.destination from ticket\r\n" + "join trip on ticket.tripId = trip.tripId");
			rs = ps.executeQuery();
			while (rs.next()) {
				Ticket ticket = new Ticket(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				listT.add(ticket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return listT;

	}

	public ArrayList<Ticket> pagingContent(int index) {
		ArrayList<Ticket> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {

			ps = con.prepareStatement("select trip.destination, ticket.* from ticket\r\n"
					+ "					join trip on ticket.tripId = trip.tripId\r\n"
					+ "					order by ticketId offset ? rows fetch next 5 rows only");
			ps.setInt(1, ((index - 1) * 5));
			rs = ps.executeQuery();
			while (rs.next()) {
				Ticket ticket = new Ticket(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6));

				list.add(ticket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}

	public int getTotalContent() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement("	select COUNT(*) from ticket");
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

	public int countPageSearchAll(String txtSearch) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement("select count(*) from  ticket where ticketId like ?  or  bookingTime like ?\r\n"
					+ "							   or  customerName like ?  or licensePlate like ?  or tripId like ?"
					+ "like ?");
			ps.setString(1, "%" + txtSearch + "%");
			ps.setString(2, "%" + txtSearch + "%");
			ps.setString(3, "%" + txtSearch + "%");
			ps.setString(4, "%" + txtSearch + "%");
			ps.setString(5, "%" + txtSearch + "%");
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

	public List<Ticket> search(String txtSearch, int index, int pageSize) {
		ArrayList<Ticket> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"with a as(select ROW_NUMBER () over (order by ticketId asc) as b,* from ticket\r\n"
							+ "where ticketId like ?\r\n" + "or bookingTime like ?\r\n" + "or customerName like ?\r\n"
							+ "or licensePlate like ?\r\n" + "or tripId like ? )   \r\n"
							+ "select trip.destination,a.* from a\r\n"
							+ "				join trip on a.tripId = trip.tripId\r\n" + "where b between ?*5-4 and ?*5");
			ps.setString(1, "%" + txtSearch + "%");
			ps.setString(2, "%" + txtSearch + "%");
			ps.setString(3, "%" + txtSearch + "%");
			ps.setString(4, "%" + txtSearch + "%");
			ps.setString(5, "%" + txtSearch + "%");
			ps.setInt(6, index);
			ps.setInt(7, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				Ticket ticket = new Ticket(rs.getString(1), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
				list.add(ticket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}

	public static void main(String[] args) {
		TicketDao dao = new TicketDao();
		dao.search("007", 1, 1);
		System.out.println(dao);
	}

	public List<Ticket> searchByTicketId(String txtSearch, int index, int pageSize) {
		ArrayList<Ticket> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"with a as(select ROW_NUMBER () over (order by ticketId asc) as b,* from ticket\r\n"
					+ "where ticketId like ?) \r\n"
					+ "select trip.destination,a.* from a\r\n"
					+ "				join trip on a.tripId = trip.tripId\r\n"
					+ "where b between ?*5-4 and ?*5");
			ps.setString(1, "%" + txtSearch + "%");
			ps.setInt(2, index);
			ps.setInt(3, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				Ticket ticket = new Ticket(rs.getString(1), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
				list.add(ticket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}

	public List<Ticket> searchByBookingTime(String txtSearch, int index, int pageSize) {
		ArrayList<Ticket> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"with a as(select ROW_NUMBER () over (order by ticketId asc) as b,* from ticket\r\n"
					+ "where bookingTime like ? ) \r\n"
					+ "select trip.destination,a.* from a\r\n"
					+ "				join trip on a.tripId = trip.tripId\r\n"
					+ "where b between ?*5-4 and ?*5");
			ps.setString(1, "%" + txtSearch + "%");
			ps.setInt(2, index);
			ps.setInt(3, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				Ticket ticket = new Ticket(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6));
				list.add(ticket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}

	public List<Ticket> searchByCustomerName(String txtSearch, int index, int pageSize) {
		ArrayList<Ticket> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"with a as(select ROW_NUMBER () over (order by ticketId asc) as b,* from ticket\r\n"
					+ "where customerName like ? )\r\n"
					+ "select trip.destination,a.* from a\r\n"
					+ "				join trip on a.tripId = trip.tripId\r\n"
					+ "where b between ?*5-4 and ?*5");
			ps.setString(1, "%" + txtSearch + "%");
			ps.setInt(2, index);
			ps.setInt(3, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				Ticket ticket = new Ticket(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6));
				list.add(ticket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}

	public List<Ticket> searchByLicensePlate(String txtSearch, int index, int pageSize) {
		ArrayList<Ticket> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement("with a as(select ROW_NUMBER () over (order by ticketId asc) as b,* from ticket\r\n"
					+ "where licensePlate like ? )   \r\n"
					+ "select trip.destination,a.* from a\r\n"
					+ "				join trip on a.tripId = trip.tripId\r\n"
					+ "where b between ?*5-4 and ?*5");
			ps.setString(1, "%" + txtSearch + "%");
			ps.setInt(2, index);
			ps.setInt(3, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				Ticket ticket = new Ticket(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6));
				list.add(ticket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}

	public List<Ticket> searchByTripId(String txtSearch, int index, int pageSize) {
		ArrayList<Ticket> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement("with a as(select ROW_NUMBER () over (order by ticketId asc) as b,* from ticket\r\n"
					+ "where tripId like ? )   \r\n"
					+ "select trip.destination,a.* from a\r\n"
					+ "				join trip on a.tripId = trip.tripId\r\n"
					+ "where b between ?*5-4 and ?*5");
			ps.setString(1, "%" + txtSearch + "%");
			ps.setInt(2, index);
			ps.setInt(3, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				Ticket ticket = new Ticket(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6));
				list.add(ticket);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}

	public void deleteTicketById(String ticketId) {
		PreparedStatement ps = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement("delete from [ticket] where [ticketId] = ?");
			ps.setString(1, ticketId);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, null);
		}

	}

	public ArrayList<Ticket> getAllTicket() {
		ArrayList<Ticket> listT = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement("select * from ticket");
			rs = ps.executeQuery();
			while (rs.next()) {
				Ticket ticket = new Ticket(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5));
				listT.add(ticket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return listT;
	}

}
