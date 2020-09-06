package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Número do Quarto: ");
			int numeroDoQuarto = sc.nextInt();
			System.out.print("Data de CheckIn (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data de CheckOut (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reserva reserva = new Reserva(numeroDoQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);

			System.out.println("--------------------------------------------------------------------------------------------------------");
			System.out.print("Data Atualizada da reserva: ");
			System.out.print("Data de Check-In (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de Check-Out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
	
			reserva.updateDates(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
		}
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}

		sc.close();
	}
}
