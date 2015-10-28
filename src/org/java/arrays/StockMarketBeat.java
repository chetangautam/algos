package org.java.arrays;

public class StockMarketBeat {

	public static void main(String[] args) {

		int[] stockPrice = {10, 10, 9, 11, 8, 10, 11, 9, 8, 7, 10, 12, 10, 9};
		int[] buySellIndex = new int[2];

		findBuySellIndex(stockPrice, buySellIndex);
	}

	private static void findBuySellIndex(int[] stockPrice, int[] buySellIndex) {
		int buyingPrice = stockPrice[0];
		int totalProfit = 0;
		for (int i=1; i<stockPrice.length; ++i) {
			buyingPrice = Math.min(stockPrice[i-1], buyingPrice);
			int difference = stockPrice[i] - buyingPrice;
			totalProfit = Math.max(difference, totalProfit);
		}
		System.out.println("Buying price: " + buyingPrice);
		System.out.println("Selling price: " + (totalProfit+buyingPrice));
		System.out.println("Total profit: " + totalProfit);
	}

}
