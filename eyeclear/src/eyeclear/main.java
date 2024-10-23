package eyeclear;

import java.io.File;
import java.util.Date;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Prescription presc = new Prescription();
		Random rand = new Random();
		
		System.out.println(rand.nextFloat(40)-20);
		System.out.println(rand.nextFloat(8)-4);
		System.out.print(rand.nextFloat(180));

		
		presc.setFirstName("Jeffersen");
		presc.setLastName("Simanjuntak");
		presc.setAddress("121 Rosslyn st, West Melbourne");
		presc.setSphere(rand.nextFloat(40)-20);
		presc.setCylinder(rand.nextFloat(8)-4);
		presc.setAxis(rand.nextFloat(180));
		presc.setOptometrist("optsnamesohng");
		
		presc.setRemarkType("client");
		presc.setRemarks("this is correct");
		
		
		System.out.print(presc.addPrescription());
		presc.addRemark();
		

	}

}
