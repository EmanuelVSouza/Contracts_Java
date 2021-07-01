package model.services;

public class PaypalTax implements TaxService {

	public double Calculation(double value, int numb) {
		value += value * 0.01 * numb;
		value += value * 0.02;
		return value;
	}

}
