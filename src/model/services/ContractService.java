package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private TaxService taxService;

	public ContractService(TaxService taxService) {
		this.taxService = taxService;
	}

	public void processContract(Contract contract, Integer numbOfInstallment) {
		double value = contract.getTotalValue() / numbOfInstallment;
		for (int i = 1; i <= numbOfInstallment; i++) {
			Date date = addMonths(contract.getDateContract(), i);
			contract.addInstallment(new Installment(date, taxService.Calculation(value, i)));

		}
	}

	private Date addMonths(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

}
