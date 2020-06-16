package excecoes_personalizadas;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.Exce;
import model.exceptions.Excecao;

public class Exercicio {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data: ");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial Balance: ");
			Double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withDrawLimit = sc.nextDouble();
			Account account = new Account(number, holder, balance, withDrawLimit);
			
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			Double amount = sc.nextDouble();
			account.withDraw(amount);
			account.exce(balance, amount, withDrawLimit);
			account.exception(balance, withDrawLimit, amount);
			System.out.print("New balance: "+account.toString());

		}
		catch (Excecao e) {
			System.out.println("Withdraw error: "+e.getMessage());
		}
		catch (Exce e) {
			System.out.println("Withdraw error: "+e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		sc.close();
	}
}
