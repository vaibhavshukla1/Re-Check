package com.cg.mra.test;

import static org.junit.Assert.*;

import javax.security.auth.login.AccountException;
import org.junit.Test;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

//Testing
public class TestClass {

	public TestClass() {

	}

	@Test(expected = AccountException.class)
	public void ValidateMobileNumber_v1() throws AccountException {
		AccountService accservice = new AccountServiceImpl();
		accservice.validatemobNo(null);

	}

	@Test
	public void ValidateMobileNumber_v2() throws AccountException { // less than 10digits
		AccountService accservice = new AccountServiceImpl();
		boolean result = accservice.validatemobNo("95");
		assertEquals(false, result);

	}

	@Test
	public void ValidateMobileNumber_v3() throws AccountException { // not number digits
		AccountService accservice = new AccountServiceImpl();
		boolean result = accservice.validatemobNo("vaibhav");
		assertEquals(false, result);

	}

	@Test
	public void ValidateMobileNumber_v4() throws AccountException { // correct format
		AccountService accservice = new AccountServiceImpl();
		boolean result = accservice.validatemobNo("9598016816");
		assertEquals(true, result);

	}

	@Test
	public void ValidateMobileNumber_v5() throws AccountException {
		AccountService accservice = new AccountServiceImpl();
		boolean result = accservice.validatemobNo("95980168161616"); // greater than 10 digits
		assertEquals(false, result);

	}

	@Test
	public void ValidateRechargeAmount_v1() throws AccountException {
		AccountService accservice = new AccountServiceImpl();
		boolean result = accservice.validateReAmount(-140); // negative recharges amount
		assertEquals(false, result);

	}

	@Test
	public void ValidateRechargeAmount_v2() throws AccountException {
		AccountService accservice = new AccountServiceImpl();
		boolean result = accservice.validateReAmount(100); // correct recharge amount format
		assertEquals(true, result);

	}

	@Test(expected = AccountException.class)
	public void ValidateRechargeAmount_v3() throws AccountException {
		AccountService accservice = new AccountServiceImpl();
		accservice.validateReAmount(0);

	}

}
