package org.java;

public class TaxCalculation {

	static private double taxRates[][] = { {0, 0.1}, {1000, 0.2}, {4000, 0.3}, {6000, 0.4}};

	public static void main(String[] args) {
		System.out.println(calculateTax(1500.00));
		System.out.println(calculateTax(4500.00));
		System.out.println(calculateTax(15000.00));
	}

	public static double calculateTax(double income){
		double tax = 0.0,
			currentBand = 0,
			currentTaxAmount = 0.0;
		boolean canContinue = true;
		int taxBrackets = taxRates.length;

        for(int i=0; i<taxBrackets && canContinue; ++i) {
            currentBand = taxRates[i][1];
            if(i+1==taxBrackets) {
                currentTaxAmount = income - taxRates[i][0];
            } else {
                if(income>taxRates[i+1][0]) {
                    currentTaxAmount = taxRates[i+1][0]-taxRates[i][0];
                } else {
                    currentTaxAmount = income - taxRates[i][0];
                    canContinue = false;
                }
            }
            tax += (currentTaxAmount * currentBand);
        }

        return tax;
	}

}

/*
var taxRates = [
                [0, 0.1],
                [1000, 0.2],
                [4000, 0.3],
                [6000, 0.4]];

    1500
    1000*0.1 + 500*0.2

    4500
    1000*0.1 + 3000*0.2 + 500*0.3 = 

    function calculateTax(rates, income) {
        var tax = 0,
            taxBrackets = rates.length,
            currentBand,
            currentTaxAmount,
            canContinue = true;
            for(var i=0; i<taxBrackets && canContinue; ++i) {
                currentBand = rates[i][1];
                if(i+1==taxBrackets) {
                    currentTaxAmount = income - rates[i][0];
                } else {
                    if(income>rates[i+1][0]) {
                        currentTaxAmount = rates[i+1][0]-rates[i][0];
                    } else {
                        currentTaxAmount = income - rates[i][0];
                        canContinue = false;
                    }
                }
                tax += (currentTaxAmount * rates[i][1]);
            }

        return tax;
    }

*/