package eyeclear;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class remarkTest {

	@Test //if everything is according to condition
	void test1() throws IOException {
		
		Prescription presc = new Prescription();
		
		presc.setPrescId(001);
		presc.setRemarkType("client");
		presc.setRemarks("This is a remark");
		
		assertTrue(presc.addRemark());
		
	}
	
	@Test //if the type is not mentioned
	void test2() throws IOException {
		
		Prescription presc = new Prescription();
		
		presc.setPrescId(002);
		presc.setRemarks("This is a remark");
		
		assertFalse(presc.addRemark());
		
	}
	
	@Test //if the Remark type is written with capital 
	void test3() throws IOException {
		
		Prescription presc = new Prescription();
		
		presc.setPrescId(003);
		presc.setRemarkType("Client");
		presc.setRemarks("This is a remark");
		
		assertTrue(presc.addRemark());
		
	}
	
	@Test //if the Remark type is optometrist
	void test4() throws IOException {
		
		Prescription presc = new Prescription();
		
		presc.setPrescId(004);
		presc.setRemarkType("Optometrist");
		presc.setRemarks("This is a remark");
		
		assertTrue(presc.addRemark());
		
	}
	
	@Test //if the Remark type is optometrist
	void test5() throws IOException {
		
		Prescription presc = new Prescription();
		
		presc.setPrescId(005);
		presc.setRemarkType("Optometrist");
		presc.setRemarks("this is a remark");
		
		assertFalse(presc.addRemark());
		
	}
	
	@Test //if the Remark type is optometrist
	void test6() throws IOException {
		
		Prescription presc = new Prescription();
		
		presc.setPrescId(006);
		presc.setRemarkType("Optometrist");
		presc.setRemarks("this is a remark");
		
		assertFalse(presc.addRemark());
		
	}
	
	@Test //if the remark is made more than 2 times
	void test7() throws IOException {
		
		Prescription presc = new Prescription();
		
		presc.setPrescId(007);
		presc.setRemarkType("Optometrist");
		presc.setRemarks("This is a remark");
		
		assertTrue(presc.addRemark());
		assertTrue(presc.addRemark());
		
		assertFalse(presc.addRemark());
		
	}
	
	@Test //if the remark is made more than 2 times then made remark for another id
	void test8() throws IOException {
		
		Prescription presc = new Prescription();
		
		presc.setPrescId(012);
		presc.setRemarkType("Optometrist");
		presc.setRemarks("This is a remark");
		
		assertTrue(presc.addRemark());
		assertTrue(presc.addRemark());
		
		assertFalse(presc.addRemark());
		
		presc.setPrescId(011);
		presc.setRemarkType("Client");
		presc.setRemarks("This is a remark");
		
		assertTrue(presc.addRemark());
		
	}


}
