package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {

	private Integer contractID;
	private Date dateContract;
	private Double totalValue;

	private List<Installment> installment = new ArrayList<>();

	public Contract() {

	}

	public Contract(Integer contractID, Date dateContract, Double totalValue) {
		this.contractID = contractID;
		this.dateContract = dateContract;
		this.totalValue = totalValue;
	}

	public Integer getContractID() {
		return contractID;
	}

	public void setContractID(Integer contractID) {
		this.contractID = contractID;
	}

	public Date getDateContract() {
		return dateContract;
	}

	public void setDateContract(Date dateContract) {
		this.dateContract = dateContract;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public List<Installment> getInstallment() {
		return installment;
	}

	public void addInstallment(Installment installments) {
		installment.add(installments);
	}

}
