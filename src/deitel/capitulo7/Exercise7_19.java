package deitel.capitulo7;

import java.util.Scanner;


/* (Airline Reservations System) A small airline has just purchased a computer for its new automated reservations 
system. You’ve been asked to develop the new system. You’re to write an application to assign seats on each flight 
of the airline’s only plane (capacity: 10 seats).
Your application should display the following alternatives: Please type 1 for First Class and Please type 2 for Economy.
If the user types 1, your application should assign a seat in the first class section (seats 1–5). If the user types 2,
your application should assign a seat in the economy section (seats 6–10). Your application should then display a 
boarding pass indicating the person’s seat number and whether it’s in the first-class or economy section of the plane.
Use a one-dimensional array of primitive type boolean to represent the seating chart of the plane. Initialize all the 
elements of the array to false to indicate that all the seats are empty. As each seat is assigned, set the corresponding
element of the array to true to indicate that the seat is no longer available.
Your application should never assign a seat that has already been assigned. When the economysection is full, your 
application should ask the person if it’s acceptable to be placed in the first-class section (and vice versa). 
If yes, make the appropriate seat assignment. If no, display the message "Next flight leaves in 3 hours."*/




public class Exercise7_19 {

	private static int location;
	private static final int SEAT_NUMBER = 10;
	private static boolean[] seat = new boolean[SEAT_NUMBER];
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {


		while(location < seat.length) {
			flightOption();
		}
		System.out.println("Sorry. Next flight leaves in 3 hours.");
	}//main

	private static void flightOption() {
		System.out.print("Please choose the desired class."
				+ "\n1: First Class."
				+ "\n2: Economic Class."
				+ "\nOption: ");
		int input = sc.nextInt();
		seatSearch(input);
	}

	private static void seatSearch(int classe) {
		if (classe == 1)
			firstClass();
		if (classe == 2) 
			economicClass();
	}


	private static void firstClass() {	
		for (int i = 0; i < (seat.length - 5); i++) {
			if ((seat[i] == false)) {
				System.out.println("First class seat: " + (location + 1) + "\n");
				seat[i] = true;
				location++;
				break;
			}else if(location == 5) {
				System.out.println("Sorry. The first class is full.\n\n");
				break;
			}
		}
	}

	private static void economicClass() {	
		for (int j = 5; j < (seat.length); j++) {
			if ((seat[j] == false)) {
				System.out.println("Economy class seat: " + (location + 1) + "\n");
				seat[j] = true;
				location++;
				break;
			}else if(location == 10) {
				System.out.println("Sorry. Economy class is full.\n\n");
				break;
			}
		}
	}

	@SuppressWarnings("unused")
	private static void print() {
		for (int i = 0; i < seat.length; i++) {
			System.out.print(seat[i] + " ");
		}		
	}
}//class
