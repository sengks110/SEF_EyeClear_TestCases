package eyeclear;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Prescription {
	private int prescID;
	private String firstName;
	private String lastName;
	private String address;
	private float sphere = -99;
	private float axis = -99;
	private float cylinder = -99;
	private Date examinationDate = new Date();
	private String optometrist;
	private String[] remarkTypes= {"Client", "Optometrist"};
	private Random rand = new Random();
	private ArrayList <String> postRemarks= new ArrayList<>();
	private String remark;
	private int remarkTypeNum = -1;
	private int remarkCount = 0;
	
	public void setPrescId(int id) { //function to set prescription id
		
		prescID = id;
		remarkCount = 0;
		
	}
	
	public void setRemarks(String rem) { //function to set remarks
		
		remark = rem;
		
	}
	
	public void setRemarkType(String type) { //function to set remark type
		
		if(type == "Client") {
			
			remarkTypeNum = 0;
			
		} else if(type == "client"){
			
			remarkTypeNum = 0;
			
		} else if(type == "Optometrist") {
			
			remarkTypeNum = 1;
			
		} else if(type == "optometrist") {
			
			remarkTypeNum = 1;
			
		} else {}
		
		
	}
	
	public void setFirstName(String name) { //function to set first name
		
		firstName = name;
	
		
		
	}
	
	public void setLastName(String name) { //function to set last name
		
		lastName = name;
		
	}
	
	public void setAddress(String addrs) { //function to set address
		
		address = addrs;
		
	}
	
	public void setSphere(float num) { //function to set sphere value
		
		sphere = num;
		
	}
	
	public void setCylinder(float num) { //function to set cylinder value
		
		cylinder = num;
		
	}
	
	public void setAxis(float num) { //function to set axis value
		
		axis = num;
		
	}
	
	public void setOptometrist(String name) { //function to set optometrist name
		
		optometrist = name;
		
	}
	
	
	
	public boolean addPrescription() throws IOException{ // add prescription function
		
		boolean retVal = true;
		
		
		if(firstName == null) { //function to see if first name is null
			
			retVal = false;
			
		} else {}
		
		if(lastName == null) { //function to see if last name is null
			
			retVal = false;
			
			
		} else {}
		
		if(address == null) { //function to see if address is null
			
			retVal = false;

		} else {}
		
		
		if(optometrist == null) { //function to see if opt name is null
			
			retVal = false;
			
		} else {}
		
		
		if(retVal) { //function to check if all variable is within condition and required range
			
			
			retVal = checkPrescriptionCondition();
			
			
		}
		
		
		if(retVal){ //print prescription into txt file
			
			// Generate random integers in range 0 to 999
			
			prescID = rand.nextInt(1000);
			printPrescription();
			
		}
		
		
		return retVal;
	}
	
	public boolean addRemark() throws IOException{ //function to add remark
		
		boolean retVal = true;
		
		if(remarkCount == 2) { //function to count if there are already 2 remark
			
			retVal = false;
			
		}
		
		if(remark == null) { //function to see if remark is null
			
			retVal = false;
			
		}
		
		if(retVal) { //function to check remark condition
		
			retVal = checkRemarkCondition();
		
		}
		
		if(retVal) { //function to print remark to the txt files
			
			printRemarks();
			remarkCount++;
		
		}
		
		return retVal;
	}
	

	
	public void printPrescription() throws IOException {
		
	    
		try {
		    Files.write(Paths.get("prescription.txt"), ("\nprescription id: " + prescID + "\nname:" + firstName + " " + lastName + "\naddress: " + address).getBytes(), StandardOpenOption.APPEND);
		    Files.write(Paths.get("prescription.txt"), ("\noptometrist: " + optometrist + "\ndate: " + examinationDate).getBytes(), StandardOpenOption.APPEND);
		    Files.write(Paths.get("prescription.txt"), ("\nsphere: " + sphere + "\ncylinder:" + cylinder + "\naxis: " + axis + "\n").getBytes(), StandardOpenOption.APPEND);
		}catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
	    
	}
	
	public void printRemarks() throws IOException {
		
	    
		try {
		    Files.write(Paths.get("remark.txt"), ("\nprescription id: " + prescID + "\nremark type: " + remarkTypes[remarkTypeNum] + "\nremark:" + remark + "\n").getBytes(), StandardOpenOption.APPEND);
		    
		}catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
	    
	    
	}
	
	public boolean checkRemarkCondition() {
		
		boolean retVal = true;
		
		if(remarkTypeNum < 0 || remarkTypeNum > 1) {
			
			retVal = false;
			
		}
		
		if(remark.length() < 6 || remark.length() > 20) {
			
			retVal = false;
			
		}
		
		if(!Character.isUpperCase(remark.charAt(0))){
			
			retVal = false;
			
		}
		
		
		return retVal;
		
	}
	
	
	public boolean checkPrescriptionCondition() {
		
		boolean retVal = true;
		
		if(firstName.length() < 4 || firstName.length() > 15) {
			
			retVal = false;
			
		}
		
		if(lastName.length() < 4 || lastName.length() > 15) {
			
			retVal = false;
			
		}
		
		if(address.length() < 20) {
			
			retVal = false;
			
		}
		
		
//		if(examinationDate == null) {
//			
//			retVal = false;
//			
//		}
		
		
		if(optometrist.length() < 8 || optometrist.length() > 25) {
			
			retVal = false;
			
	
		}
		
		
		if(sphere < -20 || sphere > 20) {
			
			retVal = false;
					
		}
		
		if(cylinder < -4 || cylinder > 4) {
			
			retVal = false;
					
		}
		
		if(axis < 0 || axis > 180) {
			
			retVal = false;
					
		}
		
		
		return retVal;
	}
}
