package usecase;


public class Train {
	private int trainNo;
	private String trainName;
	private String source;
	private String destination;
	private double ticketprice;


	public Train(int trainNo, String source, String destination, String trainName, double ticketprice) {
		super();
		this.trainNo = trainNo;
		this.source = source;
		this.destination = destination;
		this.ticketprice = ticketprice;
		this.trainName=trainName;
	}



	public int getTrainNo() {
		return trainNo;
	}


	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}


	public String getSource() {
		return source;
	}


	public String getTrainName() {
		return trainName;
	}



	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}



	public void setSource(String source) {
		this.source = source;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public double getTicketprice() {
		return ticketprice;
	}


	public void setTicketprice(double ticketprice) {
		this.ticketprice = ticketprice;
	}
}