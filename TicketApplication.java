package usecase;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TicketApplication {

	public static LocalDate dateInput(String userInput)
	{
		DateTimeFormatter dateFormat=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date=LocalDate.parse(userInput, dateFormat);
		return date;
	}

	public static void main(String[] args) throws IOException, NullPointerException{
		Scanner sc=new Scanner(System.in);

		System.out.println("===========WELCOME ============");

		TrainDAO traindao=new TrainDAO();
		System.out.println("Enter Train No");
		Train train=traindao.findTrain(sc.nextInt());

		System.out.println("Enter Travel Date");
		String userInput=sc.next();

		LocalDate travelDate=dateInput(userInput);
		Ticket ticket=new Ticket(travelDate, train);

		System.out.println("Enter No of Passengers");
		int numberOfPassengers=sc.nextInt();
		for(int i=1;i<=numberOfPassengers;i++)
		{
			System.out.println("Enter Name of Passengers");
			String name=sc.next();
			sc.nextLine();

			System.out.println("Enter Age");
			int age=sc.nextInt();
			sc.nextLine();


			System.out.println("Enter  Gender(M/F/T)");
			String gender=sc.next();
			char g=gender.charAt(0);

			ticket.addPassenger(name, age, g);

		}

		System.out.println("Ticked Booked with PNR"+ticket.generatePNR());
		ticket.writeTicket();
		ticket.calculateTotalTicketPrice();













	}

}