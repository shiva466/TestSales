package com.ait.sales;

public class SalesPerson {
	
	// Instance fields
	// INSERT CODE HERE
	
	public String name;
	private int yearsOfService;
	private int numLocksSold;
	private int numStocksSold;
	private int numBarrelsSold;
	private final static int LOCK_PRICE = 45;
	private final static int STOCK_PRICE = 30;
	private final static int BARREL_PRICE = 25;
	
	// Constructor
	

	public SalesPerson(String name, int yearsOfService, int numLocks, 
			int numStocks, int numBarrels) 
	{
		this.name = name;
		this.yearsOfService = yearsOfService;
		this.numLocksSold = numLocks;
		this.numBarrelsSold = numBarrels;
		this.numStocksSold = numStocks;

	}
	// Methods
	public double divide(int a , int b)
	{
		return a/b;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getYearsOfService() {
		return yearsOfService;
	}

	public void setYearsOfService(int yearsOfService) {
		this.yearsOfService = yearsOfService;
	}

	public int getTotalSales() {
		return ((numLocksSold * LOCK_PRICE) + (numStocksSold * STOCK_PRICE) + (numBarrelsSold * BARREL_PRICE));
	}

	public double getCommissionOnSales() {
		int sales = this.getTotalSales();
		double commission;
		if (sales < 1000) {
			commission = sales * 0.10;
		} else {
			commission = 100 + (sales - 1000) * 0.15;
		}
		return commission;
	}

	public boolean shouldBeDismissed() {
		boolean shouldBeDismissed = false;
		if ((numLocksSold < 1) || (numStocksSold < 1) || (numBarrelsSold < 1)) {
			shouldBeDismissed = true;
		}
		return shouldBeDismissed;
	}

	public boolean shouldGetBonus() {
		boolean shouldGetBonus = false;
		if ((yearsOfService < 5) && (numLocksSold > 50)) {
			shouldGetBonus = true;
		}
		return shouldGetBonus;
	}
	
}
