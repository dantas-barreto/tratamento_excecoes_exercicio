package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BusinessException;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner teclado = new Scanner(System.in);
		
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
		double amount = teclado.nextDouble();
		
		try {
			account.withdraw(amount);
			System.out.printf("New balance: %.2f%n", account.getBalance());
		}
		catch (BusinessException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		
		teclado.close();
	}

}
