package day1;

public class DemoGuru99 {
	
	public static void main(String[] args) {
		Guru99Project guru = new Guru99Project();
		
		guru.invokrBrowser();
		
		guru.getTitleOfThePage();
		
		guru.loginToGuru99();
		
		guru.addCustomer();
		
		//guru.closeBrowser();
		
		String customerId = guru.getCustomerId();
		
		System.out.println(customerId);
		
		guru.newAccount(customerId);
		
		guru.logOut();
	}
	


}
