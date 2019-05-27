package grassdorAutomation;

import java.util.Random;

public class UserData {
	public String firstName, lastName, email, phoneNumber, roleName, roleDescription, vendorName, vendorAddress, invoiceNumber, customerName;
	public int age;

	public UserData() {
		this.firstName = "test" + randomStringGenerator(randomRangeInt(4,7));
		this.lastName =  "test" + randomStringGenerator(randomRangeInt(3,6));
		this.email = this.firstName + "." + this.lastName + "@grassdoor.com";
		this.age = randomRangeInt(20, 50);
		this.phoneNumber = phoneNumberGenerator(10);
		this.roleName = randomStringGenerator(randomRangeInt(4,7));
		this.roleDescription = randomStringGenerator(randomRangeInt(4,7));
		this.vendorName = "test" + randomStringGenerator(randomRangeInt(4,9));
		this.vendorAddress = "test" + randomStringGenerator(randomRangeInt(4,9));
		this.invoiceNumber = "test" + randomStringGenerator(randomRangeInt(4,9));
		this.customerName = "test" + randomStringGenerator(randomRangeInt(5,8));
	}
	
	public static int randomRangeInt(int from, int to) {
		return new Random().nextInt(to - from) + from;
	}
	
	public static String phoneNumberGenerator(int phoneNumberLength) {
		String phoneNumber ="";
		for (int i = 0; i < phoneNumberLength; i++) {
			phoneNumber += Integer.toString(new Random().nextInt(9));
		}
		
		return phoneNumber;
	}
	
	public static String  randomStringGenerator(int targetStringLength) {
		  
		    int leftLimit = 97; // letter 'a'
		    int rightLimit = 122; // letter 'z'
		    Random random = new Random();
		    StringBuilder buffer = new StringBuilder(targetStringLength);
		    for (int i = 0; i < targetStringLength; i++) {
		        int randomLimitedInt = leftLimit + (int) 
		          (random.nextFloat() * (rightLimit - leftLimit + 1));
		        buffer.append((char) randomLimitedInt);
		    }
		    String generatedString = buffer.toString();
		    
		    return generatedString;
		 
		}
	
	
}