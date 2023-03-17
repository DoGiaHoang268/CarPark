package fa.training.dao;
public class test
{
	public static void main(String[] args) {
		TripDao dao = new TripDao();
		System.out.println(dao.search("ha", 1, 1));
	}
}
