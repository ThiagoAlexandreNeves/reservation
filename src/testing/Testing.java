package testing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import testing.exception.DomainException;
import testing.model.Reservation;

public class Testing {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Number: ");
			int number = scan.nextInt();
			System.out.println("checkin: ");
			Date checkIn = sdf.parse(scan.next());
			System.out.println("checkout: ");
			Date checkOut = sdf.parse(scan.next());
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println("checkin: ");
			checkIn = sdf.parse(scan.next());
			System.out.println("checkout: ");
			checkOut = sdf.parse(scan.next());
			
			reservation.update(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}
		catch(ParseException e) {
			System.out.println("erro");
		}
		catch(DomainException e) {
			System.out.println("erro: " + e.getMessage());	
		}
		catch(RuntimeException e) {
			System.out.println("Erro nao estabelecido");
		}
		scan.close();
	}
}
