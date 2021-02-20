package usecase;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.TreeMap;

public class Ticket {

	private int counter=100;
	private String pnr;
	private LocalDate TravelDate;
	private Train train;
	private TreeMap <Passenger,Double>Passengers=new TreeMap();


	public Ticket(LocalDate travelDate, Train train) {
		super();
		TravelDate = travelDate;
		this.train = train;
	}


	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public String getPnr() {
		return pnr;
	}


	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public LocalDate getTravelDate() {
		return TravelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		TravelDate = travelDate;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public String generatePNR()
	{
		String source=String.valueOf(train.getSource().charAt(0));
		String destination=String.valueOf(train.getDestination().charAt(0));

		String date=TravelDate.format(DateTimeFormatter.ofPattern("YYYYMMdd"));
		pnr=source+destination+""+date+""+"_"+counter;
		this.counter++;

		if(TravelDate.isAfter(LocalDate.now()))
			return pnr;
		else
			return "Invalid date";
	}

	double calPassengerFare(Passenger Passenger)
	{
		if(Passenger.getAge()<=12)
			return(0.5)*(train.getTicketprice());
		else if(Passenger.getAge()>=60)
			return(0.6)*(train.getTicketprice());
		else if(Passenger.getAge()=='F')
			return (0.25)*(train.getTicketprice());
		else
			return train.getTicketprice();
	}
	public void addPassenger(String name,int age,char gender)throws NullPointerException
	{
		Double fare=calPassengerFare(new Passenger(name,age,gender));
		System.out.println(fare);
		Passengers.put(new Passenger(name,age,gender), fare);
	}

	double calculateTotalTicketPrice()
	{
		Double totalPrice=0.0;
		{
			for(Double values:Passengers.values())
			{
				totalPrice=totalPrice+values;
			}
			System.out.println(totalPrice);
			return totalPrice;
		}
	}

	StringBuilder generateTicket()
	{
		StringBuilder sb=new StringBuilder();

		sb.append("PNR   :"+generatePNR()).append("\n").append("TrainNo :"+train.getTrainNo());
		return sb;
	}
	public void writeTicket() throws IOException
	{
		FileWriter f=new FileWriter(generatePNR()+".txt");
		BufferedWriter bw=new BufferedWriter(f);
		bw.flush();
		bw.close();

	}

}