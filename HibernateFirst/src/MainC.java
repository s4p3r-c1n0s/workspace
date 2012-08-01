public class MainC {
	public static void main(String[] args) {
		CityDAO cityDAO = new CityDAO();
		
		long cityId1 = cityDAO.saveCity("New York","US");
		long cityId2 = cityDAO.saveCity("Rio de Janeiro","Brazil");
		long cityId3 = cityDAO.saveCity("Tokyo","Japan");
		long cityId4 = cityDAO.saveCity("London","UK");
		
		cityDAO.listCities();
		cityDAO.updateCity(cityId4, "Paris","UK");
		cityDAO.deleteCity(cityId3);
		cityDAO.listCities();
	}
}