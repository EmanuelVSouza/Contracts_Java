package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalTax;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter contract data:");
		System.out.print("Number: ");
		int contractID = sc.nextInt();
		System.out.print("Date (dd/mm/yyyy): ");
		Date dateContract = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();

		Contract contracts = new Contract(contractID, dateContract, totalValue);

		System.out.print("Enter numb of installment: ");
		int numbOfInstallment = sc.nextInt();

		ContractService contractServices = new ContractService(new PaypalTax());

		contractServices.processContract(contracts, numbOfInstallment);

		System.out.println("Installments:");
		for (Installment installments : contracts.getInstallment()) {
			System.out.println(installments);
		}

		sc.close();

	}

}
