package fa.training.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fa.training.DBConnection.DBConnection;
import fa.training.entity.Employee;

public class EmployeeDao {
    //get employee by user name
	public Employee getUserByUsername(String username) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement("select * from [dbo].[employee] where account=?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10));
				return employee;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return null;
	}

	// get employee by phone
	public Employee getUserByPhone(String phone) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement("select * from [dbo].[employee] where [employeePhone]=?");
			ps.setString(1, phone);
			rs = ps.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10));
				return employee;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return null;
	}

	// get employee by email
	public Employee getUserByEmail(String email) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement("select * from [dbo].[employee] where [employeeEmail]=?");
			ps.setString(1, email);
			rs = ps.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10));
				return employee;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return null;
	}

     //get check exist user ,password
	public Employee checkAccount(String username, String password) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement("select * from [dbo].[employee] where [account]=? and [password]=?");
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee(rs.getString(1), rs.getString(2));
				return employee;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return null;
	}

    //add new employee
	public void addEmployee(String username, String department, String address, String dob, String email,
			String fullName, String phone, String password, String sex) {
		PreparedStatement ps = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"insert into [dbo].[employee]([account],[department],[employeeAddress],[employeeBirthdate],[employeeEmail],[employeeName],[employeePhone],[password],[sex]) \r\n"
							+ "					values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, username);
			ps.setString(2, department);
			ps.setString(3, address);
			ps.setString(4, dob);
			ps.setString(5, email);
			ps.setString(6, fullName);
			ps.setString(7, phone);
			ps.setString(8, password);
			ps.setString(9, sex);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, null);
		}
	}
    //get total page
	public int getTotalPage() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(" select count(*) from [employee]");
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
    // get element on 1 page  
	public List<Employee> pagingEmployee(int index) {
		ArrayList<Employee> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"select * from [dbo].[employee] order by [employeeid] offset ? rows fetch next 5 rows only;");
			ps.setInt(1, ((index - 1) * 5));
			rs = ps.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10));
				list.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}
    //get employee by id
	public Employee getEmployeeById(String eId) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement("select * from [employee] where employeeId =?");
			ps.setString(1, eId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10));
				return employee;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return null;

	}
    //delete employee by id
	public void deleteEmpoyeeById(String eId) {
		PreparedStatement ps = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement("delete from [employee] where [employeeid] = ?");
			ps.setString(1, eId);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, null);
		}

	}
    // update employee by id
	public void updateEmployeeByEmId(String username, String department, String address, String dob, String email,
			String fullname, String phonenumber, String gender, String id) {
		PreparedStatement ps = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					" update [employee] set   account=?,  department=?,  employeeAddress =?,  employeeBirthdate=?,  employeeEmail =?,\r\n"
							+ "			 employeeName=?,  employeePhone=?,  sex=? where  employeeId = ?");
			ps.setString(1, username);
			ps.setString(2, department);
			ps.setString(3, address);
			ps.setString(4, dob);
			ps.setString(5, email);
			ps.setString(6, fullname);
			ps.setString(7, phonenumber);
			ps.setString(8, gender);
			ps.setString(9, id);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, null);
		}

	}
//Search -----------------------------------------------------------------------------------------------------
	//count page search all
	public int countPageSearchAll(String txtSearch) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"select count(*) from  [employee]" + "where employeeName like ? " + "  or  employeeBirthdate like ?"
							+ "  or  employeeAddress like ?" + "  or employeePhone like ?" + "  or department like ?");
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
	//count page search by name
	public int countPageSearchByName(String txtSearch) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"select count(*) from  [employee]" + "where employeeName like ? ");
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
	//count page search by phone
	public int countPageSearchByPhone(String txtSearch) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"select count(*) from  [employee]" + "where employeePhone like ? ");
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
	//count page search by address
	public int countPageSearchByAddress(String txtSearch) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"select count(*) from  [employee]" + "where employeeAddress like ? ");
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
	//count page search by department
	public int countPageSearchByDepartment(String txtSearch) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"select count(*) from  [employee]" + "where department like ? ");
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
	//count page search by birth date
	public int countPageSearchByDob(String txtSearch) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"select count(*) from  [employee]" + "where employeeBirthdate like ? ");
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
    //search all ------------------------
	public List<Employee> search(String txtSearch, int index, int pageSize) {
		ArrayList<Employee> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"with a as(select ROW_NUMBER () over (order by [employeeId] asc) as b,* from [dbo].[Employee] "
							+ "  where employeeName like ? " + "    or  employeeBirthdate like ?"
							+ "    or  employeeAddress like ?" + "    or  employeePhone like ?"
							+ "    or  department like ?)" + "  select * from a where b between ?*5-4 and ?*5 ");
			ps.setString(1, "%" + txtSearch + "%");
			ps.setString(2, "%" + txtSearch + "%");
			ps.setString(3, "%" + txtSearch + "%");
			ps.setString(4, "%" + txtSearch + "%");
			ps.setString(5, "%" + txtSearch + "%");
			ps.setInt(6, index);
			ps.setInt(7, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee(
						rs.getInt(2), 
						rs.getString(3), 
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9), 
						rs.getString(10),
						rs.getString(11));
				list.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}
    //search by name
	public List<Employee> searchByName(String txtSearch, int index, int pageSize) {
		ArrayList<Employee> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"with a as(select ROW_NUMBER () over (order by [employeeId] asc) as b,* from [dbo].[Employee] "
							+ "  where employeeName like ? )" + "  select * from a where b between ?*5-4 and ?*5 ");
			ps.setString(1, "%" + txtSearch + "%");
			ps.setInt(2, index);
			ps.setInt(3, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee(
						rs.getInt(2),
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5),
						rs.getString(6), 
						rs.getString(7),
						rs.getString(8), 
						rs.getString(9), 
						rs.getString(10),
						rs.getString(11));
				list.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}
	//search by birth date
	public List<Employee> searchByDob(String txtSearch, int index, int pageSize) {
		ArrayList<Employee> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"with a as(select ROW_NUMBER () over (order by [employeeId] asc) as b,* from [dbo].[Employee] "
							+ "  where employeeBirthdate like ? )"
							+ "  select * from a where b between ?*5-4 and ?*5 ");
			ps.setString(1, "%" + txtSearch + "%");
			ps.setInt(2, index);
			ps.setInt(3, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee(
						rs.getInt(2),
						rs.getString(3), 
						rs.getString(4),
						rs.getString(5),
						rs.getString(6), 
						rs.getString(7),
						rs.getString(8), 
						rs.getString(9),
						rs.getString(10),
						rs.getString(11));
				list.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}
    // search by address
	public List<Employee> searchByAddress(String txtSearch, int index, int pageSize) {
		ArrayList<Employee> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"with a as(select ROW_NUMBER () over (order by [employeeId] asc) as b,* from [dbo].[Employee] "
							+ "  where employeeAddress like ? )" 
							+ "  select * from a where b between ?*5-4 and ?*5 ");
			ps.setString(1, "%" + txtSearch + "%");
			ps.setInt(2, index);
			ps.setInt(3, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee(
						rs.getInt(2), 
						rs.getString(3), 
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getString(11));
				list.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}
    //search by phone
	public List<Employee> searchByPhone(String txtSearch, int index, int pageSize) {
		ArrayList<Employee> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"with a as(select ROW_NUMBER () over (order by [employeeId] asc) as b,* from [dbo].[Employee] "
							+ "  where employeePhone like ? )" + "  select * from a where b between ?*5-4 and ?*5 ");
			ps.setString(1, "%" + txtSearch + "%");
			ps.setInt(2, index);
			ps.setInt(3, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee(
						rs.getInt(2),
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5),
						rs.getString(6), 
						rs.getString(7), 
						rs.getString(8), 
						rs.getString(9), 
						rs.getString(10),
						rs.getString(11));
				list.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}
    //search by department
	public List<Employee> searchByDepartment(String txtSearch, int index, int pageSize) {
		ArrayList<Employee> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()) {
			ps = con.prepareStatement(
					"with a as(select ROW_NUMBER () over (order by [employeeId] asc) as b,* from [dbo].[Employee] "
							+ "  where department like ? )" + "  select * from a where b between ?*5-4 and ?*5 ");
			ps.setString(1, "%" + txtSearch + "%");
			ps.setInt(2, index);
			ps.setInt(3, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee(
						rs.getInt(2), 
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6), 
						rs.getString(7), 
						rs.getString(8),
						rs.getString(9), 
						rs.getString(10),
						rs.getString(11));
				list.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, ps, rs);
		}
		return list;
	}
//change password
	public void changePassword(Employee employee) {
		PreparedStatement ps =null;
		try (Connection con = DBConnection.SQLCONNECTION.getConnection()){
			ps=con.prepareStatement("update employee SET password = ? WHERE account = ?");
			ps.setString(1, employee.getPassword());
			ps.setString(2, employee.getAccount());
			ps.executeUpdate();
			
		} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBConnection.closeResource(null, ps, null);
			}
		
	}

	

	
}
