import java.util.*;

public class MAIN {
	public static void main(){
		char ch;
		Car car = new RacingCar();
		RacingCar carz = new RacingCar();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("1>>Enter Car\n2>>Enter Racing Car\n3>>See Car\n4>>See Racing Car");
			ch = sc.nextLine().charAt(0);
			switch(ch){
			case '1':
				System.out.println("Enter Car Capacity : ");car.setCapacity(sc.nextInt());sc.nextLine();
				System.out.println("Enter Fuel Type : ");car.setFuel(sc.nextLine());
				System.out.println("Enter Price : ");car.setPrice(sc.nextDouble());sc.nextLine();
				break;
			case '2':
				System.out.println("Enter Car Capacity : ");carz.setCapacity(sc.nextInt());sc.nextLine();
				System.out.println("Enter Fuel Type : ");carz.setFuel(sc.nextLine());
				System.out.println("Enter Price : ");carz.setPrice(sc.nextDouble());sc.nextLine();
				System.out.println("Enter Top Speed : ");carz.setTopSpeed(sc.nextDouble());sc.nextLine();
				System.out.println("Is Streamlined : ");carz.setStreamlined(sc.nextBoolean());sc.nextLine();
				break;
			case '3':
				System.out.println("Car Capacity : "+car.getCapacity());
				System.out.println("Fuel Type : "+car.getFuel());
				System.out.println("Price : "+car.getPrice());
				break;
			case '4':
				System.out.println("Car Capacity : "+carz.getCapacity());
				System.out.println("Fuel Type : "+carz.getFuel());
				System.out.println("Price : "+carz.getPrice());
				System.out.println("Top Speed : "+carz.getTopSpeed());
				System.out.println("Streamlined : "+carz.isStreamlined());
				break;
			default:continue;
			}
		}
	}
}
