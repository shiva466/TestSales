package com.ait.sales;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;



public class SalesPersonTest 
{
	private static SalesPerson sales;

	@BeforeAll
	static void setUp()
	{
		sales = new SalesPerson("Shiva",5,2,3,3);
	}
	
	@Test
	void testsales()
	{
		assertEquals("Shiva",sales.name);
	}
	@Test
	void testSalesPersonConstructed()
	{
		assertEquals("Shiva",sales.getName());
		assertEquals(5,sales.getYearsOfService());
	}
	@Test
	void testNameChanged()
	{
		SalesPerson person = new SalesPerson("John",0,0,0,0); 
		person.setName("Tom");
		assertEquals("Tom",person.getName());
	}
	@Test
	void testYearsOfServiceChanged()
	{
		SalesPerson person = new SalesPerson("John",5,0,0,0); 
		person.setYearsOfService(2);;
		assertEquals(2,person.getYearsOfService());
	}
	@Test
	void testTotalSales()
	{
		SalesPerson person = new SalesPerson("John",4,10,10,10); 
		assertEquals(1000,person.getTotalSales());
	}
	@Test
	void testCommissionSalesLessOrEqual1000()
	{
		SalesPerson person = new SalesPerson("John",4,5,5,5); 
		assertEquals(50,person.getCommissionOnSales());
	}
	@Test
	void testCommissionSalesMoreThan1000()
	{
		SalesPerson person = new SalesPerson("John",4,20,20,20); 
		assertEquals(250,person.getCommissionOnSales());
	}
	@Test
	void testShouldBeDismissedLocksTrue()
	{
		SalesPerson person = new SalesPerson("John",4,0,5,5); 
		assertEquals(true,person.shouldBeDismissed());
	}
	@Test
	void testShouldBeDismissedStocksTrue()
	{
		SalesPerson person = new SalesPerson("John",4,5,0,5); 
		assertEquals(true,person.shouldBeDismissed());
	}
	@Test
	void testShouldBeDismissedBarrelsTrue()
	{
		SalesPerson person = new SalesPerson("John",4,5,5,0); 
		assertEquals(true,person.shouldBeDismissed());
	}
	@Test
	void testShouldBeDismissedFalse()
	{
		SalesPerson person = new SalesPerson("John",4,1,4,1); 
		assertEquals(false,person.shouldBeDismissed());
	}
	@Test
	void testEligibleForBonusTrue()
	{
		SalesPerson person = new SalesPerson("John",4,51,1,1); 
		assertEquals(true,person.shouldGetBonus());
	}
	@Test
	void testEligibleForBonusFalseMoreThan5Years()
	{
		SalesPerson person = new SalesPerson("John",6,6,100,1); 
		assertEquals(false,person.shouldGetBonus());
	}
	@Test
	void testEligibleForBonusFalseLessThan50Stock()
	{
		SalesPerson person = new SalesPerson("John",2,2,40,1); 
		assertEquals(false,person.shouldGetBonus());
	}
	@Test
	void testDivide()
	{
		Exception exception = assertThrows(RuntimeException.class, () -> sales.divide(1, 0));
		System.out.println(exception.getMessage());
		assertEquals("/ by zero",exception.getMessage());
	}
	
	
}
