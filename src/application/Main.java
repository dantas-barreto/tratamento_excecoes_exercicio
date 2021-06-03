package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner teclado = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = teclado.nextInt();
			System.out.print("Holder: ");
			teclado.nextLine();
			String holder = teclado.nextLine();
			System.out.print("Initial balance: ");
			double balance = teclado.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = teclado.nextDouble();
			
			Account account = new Account(number, holder, balance, withdrawLimit);
			
			System.out.print("Enter amount for withdraw: ");
			account.withdraw(teclado.nextDouble());
			
			System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		
		
		teclado.close();
	}

}
