package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {
		double installmentAmount = contract.getTotalValue() / months;
		for (int i = 1; i <= months; i++) {
			double installmentUpdated = installmentAmount + onlinePaymentService.interest(installmentAmount, i);
			double totalInstallment = installmentUpdated + onlinePaymentService.paymentFee(installmentUpdated);
			Date date = addMonths(contract.getDateContract(), i);
			contract.addInstallment(new Installment(date, totalInstallment));
		}
	}

	private Date addMonths(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

}
