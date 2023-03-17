package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fa.training.DBConnection.DBConnection;
import fa.training.entity.Car;

public class CarDao {
	public void addNewCar(String licenseplate, String carColor, String carType, String company, int parkingLot) {
		PreparedStatement ps = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement("INSERT INTO [dbo].[car]\r\n" + "           ([licensePlate]\r\n"
					+ "           ,[carColor]\r\n" + "           ,[carType]\r\n" + "           ,[company]\r\n"
					+ "           ,[parkId])\r\n" + "     VALUES\r\n" + "           (?\r\n" + "           ,?\r\n"
					+ "           ,?\r\n" + "           ,?\r\n" + "           ,?)");
			ps.setString(1, licenseplate);
			ps.setString(2, carColor);
			ps.setString(3, carType);
			ps.setString(4, company);
			ps.setInt(5, parkingLot);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, null);
		}

	}

	public ArrayList<Car> getAllCar() {
		ArrayList<Car> listC = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement("select * from car");
			rs = ps.executeQuery();
			while (rs.next()) {
				Car car = new Car(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				listC.add(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return listC;

	}

	public ArrayList<Car> pagingCar(int index) {
		ArrayList<Car> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement("select * from car order by licenseplate offset ? rows fetch next 5 rows only");
			ps.setInt(1, ((index - 1) * 5));
			rs = ps.executeQuery();
			while (rs.next()) {
				Car car = new Car(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				list.add(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}

	public int getTotalCar() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement("select COUNT(*) from car");
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

	public Car getCarbyLicense(String license) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement(" select * from car where licensePlate = ?");
			ps.setString(1, license);
			rs = ps.executeQuery();
			while (rs.next()) {
				Car car = new Car(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				return car;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return null;
	}

	public void deleteCarbyLicense(String license) {
		PreparedStatement ps = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement("delete from car where licensePlate = ?");
			ps.setString(1, license);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, null);
		}
	}

	public void UpdateCar(String carColor, String carType, String company, int parkingLot, String licenseplate) {
		PreparedStatement ps = null;
		try {
			Connection con = DBConnection.SQLCONNECTION.getConnection();
			ps = con.prepareStatement(
					"update car set carColor = ?, carType = ?, company = ?, parkId = ? where licensePlate = ?");
			ps.setString(1, carColor);
			ps.setString(2, carType);
			ps.setString(3, company);
			ps.setInt(4, parkingLot);
			ps.setString(5, licenseplate);
			ps.executeUpdate();
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
			ps = con.prepareStatement("select count(*) from  car where licensePlate like ?  or  carColor like ?\r\n"
					+ "							   or  carType like ?  or company like ?  or parkId like ?");
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
	public int countPageSearchByLicense(String txtSearch) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"select count(*) from  car where licensePlate like ?");
			ps.setString(1, "%" + txtSearch + "%");		
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
	public int countPageSearchByColor(String txtSearch) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"select count(*) from  car where CARCOLOR like ?");
			ps.setString(1, "%" + txtSearch + "%");		
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
	public int countPageSearchByCarType(String txtSearch) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"select count(*) from  car where CARTYPE like ?");
			ps.setString(1, "%" + txtSearch + "%");		
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
	public int countPageSearchByCompany(String txtSearch) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"select count(*) from  car where COMPANY like ?");
			ps.setString(1, "%" + txtSearch + "%");		
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
	public int countPageSearchByParkId(String txtSearch) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"select count(*) from  car where PARKID like ?");
			ps.setString(1, "%" + txtSearch + "%");		
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

	public List<Car> search(String txtSearch, int index, int pageSize) {
		ArrayList<Car> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"with a as(select ROW_NUMBER () over (order by licensePlate asc) as b,* from car\r\n"
							+ "							  where licensePlate like ? or carColor like ? or carType like ? or company like ? or parkId like ?  )    select * from a where b between ?*5-4 and ?*5");
			ps.setString(1, "%" + txtSearch + "%");
			ps.setString(2, "%" + txtSearch + "%");
			ps.setString(3, "%" + txtSearch + "%");
			ps.setString(4, "%" + txtSearch + "%");
			ps.setString(5, "%" + txtSearch + "%");
			ps.setInt(6, index);
			ps.setInt(7, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				Car car = new Car(
						rs.getString(2),
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getInt(6));
				list.add(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}

	public static void main(String[] args) {
		CarDao dao = new CarDao();
	
	System.out.println(dao.searchByCarColor("pink", 1, 1));
	}

	public List<Car> searchByLicensePlate(String txtSearch, int index, int pageSize) {
		ArrayList<Car> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"with a as(select ROW_NUMBER () over (order by licensePlate asc) as b,* from car \r\n" + 
					"where licensePlate like ? )   select * from a where b between ?*5-4 and ?*5");
			ps.setString(1, "%" + txtSearch + "%");
			ps.setInt(2, index);
			ps.setInt(3, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				Car car = new Car(
						rs.getString(2),
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getInt(6));
				list.add(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}

	public List<Car> searchByCarColor(String txtSearch, int index, int pageSize) {
		ArrayList<Car> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"with a as(select ROW_NUMBER () over (order by licensePlate asc) as b,* from car\r\n" + 
					"where carColor like ? )    select * from a where b between ?*5-4 and ?*5");
			ps.setString(1, "%" + txtSearch + "%");
			ps.setInt(2, index);
			ps.setInt(3, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				Car car = new Car(
						rs.getString(2),
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getInt(6));
				list.add(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}
	public List<Car> searchByCarType(String txtSearch, int index, int pageSize) {
		ArrayList<Car> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"with a as(select ROW_NUMBER () over (order by licensePlate asc) as b,* from car\r\n" + 
					"where carType like ? )    select * from a where b between ?*5-4 and ?*5");
			ps.setString(1, "%" + txtSearch + "%");
			ps.setInt(2, index);
			ps.setInt(3, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				Car car = new Car(
						rs.getString(2),
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getInt(6));
				list.add(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}

	public List<Car> searchByCompany(String txtSearch, int index, int pageSize) {
		ArrayList<Car> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"with a as(select ROW_NUMBER () over (order by licensePlate asc) as b,* from car\r\n" + 
					"where company like ? )    select * from a where b between ?*5-4 and ?*5");
			ps.setString(1, "%" + txtSearch + "%");
			ps.setInt(2, index);
			ps.setInt(3, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				Car car = new Car(
						rs.getString(2),
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getInt(6));
				list.add(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}

	public List<Car> searchByParkId(String txtSearch, int index, int pageSize) {
		ArrayList<Car> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"with a as(select ROW_NUMBER () over (order by licensePlate asc) as b,* from car\r\n" + 
					"where parkId like ? )    select * from a where b between ?*5-4 and ?*5");
			ps.setString(1, "%" + txtSearch + "%");
			ps.setInt(2, index);
			ps.setInt(3, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				Car car = new Car(
						rs.getString(2),
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getInt(6));
				list.add(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}

}
