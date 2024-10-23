package eyeclear;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Random;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PrescriptionTest {

	@Test //test for everything is correct
	void test1() throws IOException {
		
		Prescription presc = new Prescription();

		presc.setFirstName("Jeffersen");
		presc.setLastName("Simanjuntak");
		presc.setAddress("121 Rosslyn Street, West Melbourne");
		presc.setSphere(1);
		presc.setCylinder(1);
		presc.setAxis(1);
		presc.setOptometrist("optsnamesohng");
		
		
		assertTrue(presc.addPrescription());
		
		
		
	}
	
	@Test //test for nothing is filled
	void test2() throws IOException {
		
		Prescription presc = new Prescription();
		
		assertFalse(presc.addPrescription());

		
	}
	
	@Test //test for nothing the float variables are not set
	void test3() throws IOException {
		
		Prescription presc = new Prescription();
		
		presc.setFirstName("Jeffersen");
		presc.setLastName("Simanjuntak");
		presc.setAddress("121 Rosslyn Street, West Melbourne");
		presc.setOptometrist("optsnamesohng");
		
		assertFalse(presc.addPrescription());

		
	}
	
	@Test //test if first name is less than 4 character
	void test4() throws IOException {
		
		Prescription presc = new Prescription();
		
		presc.setFirstName("Jef");
		presc.setLastName("Simanjuntak");
		presc.setAddress("121 Rosslyn Street, West Melbourne");
		presc.setSphere(1);
		presc.setCylinder(1);
		presc.setAxis(1);
		presc.setOptometrist("optsnamesohng");
		
		assertFalse(presc.addPrescription());

		
	}
	
	@Test //test if last name is less than 4 character
	void test5() throws IOException {
		
		Prescription presc = new Prescription();
		
		presc.setFirstName("Jeffersen");
		presc.setLastName("Sim");
		presc.setAddress("121 Rosslyn Street, West Melbourne");
		presc.setSphere(1);
		presc.setCylinder(1);
		presc.setAxis(1);
		presc.setOptometrist("optsnamesohng");
		
		assertFalse(presc.addPrescription());

		
	}
	
	@Test //test if last name is more than 15 character
	void test6() throws IOException {
		
		Prescription presc = new Prescription();
		
		presc.setFirstName("Jeffersen");
		presc.setLastName("Simanjuntakxxxxx");
		presc.setAddress("121 Rosslyn Street, West Melbourne");
		presc.setSphere(1);
		presc.setCylinder(1);
		presc.setAxis(1);
		presc.setOptometrist("optsnamesohng");
		
		assertFalse(presc.addPrescription());

	}
	
	@Test //test if address is less than 20 character
	void test7() throws IOException {
		
		Prescription presc = new Prescription();
		
		presc.setFirstName("Jeffersen");
		presc.setLastName("Sim");
		presc.setAddress("121 Rosslyn");
		presc.setSphere(1);
		presc.setCylinder(1);
		presc.setAxis(1);
		presc.setOptometrist("optsnamesohng");
		
		assertFalse(presc.addPrescription());

		
	}
	
	@Test //test if axis value could go to 180
	void test8() throws IOException {
		
		Prescription presc = new Prescription();
		
		presc.setFirstName("Jeffersen");
		presc.setLastName("Simanjuntak");
		presc.setAddress("121 Rosslyn st, West Melbourne");
		presc.setSphere(1);
		presc.setCylinder(1);
		presc.setAxis(180);
		presc.setOptometrist("optsnamesohng");
		
		assertTrue(presc.addPrescription());

		
	}
	
	@Test //random number test inside the range
	void test9() throws IOException {
		
		Prescription presc = new Prescription();
		Random rand = new Random();
		
		presc.setFirstName("Jeffersen");
		presc.setLastName("Simanjuntak");
		presc.setAddress("121 Rosslyn st, West Melbourne");
		presc.setSphere(rand.nextFloat(40)-20);
		presc.setCylinder(rand.nextFloat(8)-4);
		presc.setAxis(rand.nextFloat(180));
		presc.setOptometrist("optsnamesohng");
		
		assertTrue(presc.addPrescription());

		
	}
	
	@Test //random number test outside the range
	void test10() throws IOException {
		
		Prescription presc = new Prescription();
		Random rand = new Random();
		
		presc.setFirstName("Jeffersen");
		presc.setLastName("Simanjuntak");
		presc.setAddress("121 Rosslyn st, West Melbourne");
		presc.setSphere(rand.nextFloat(60)-40);
		presc.setCylinder(rand.nextFloat(15)-5);
		presc.setAxis(rand.nextFloat(100)+180);
		presc.setOptometrist("optemis");
		
		assertFalse(presc.addPrescription());

		
	}
	
	
	
	
	
	
	

}
