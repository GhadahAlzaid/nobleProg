package day2;

public class DemoAmazon {
	
	public static void main(String[] args) {
		Amazon amazonProject = new Amazon();
		
		amazonProject.invokrBrowser();
		
	
		amazonProject.searchProduct("Apple Watch", "Electronics");
		
		String result = amazonProject.getNthProduct(7);
		
		System.out.println(result);
		
		amazonProject.getAllProductsViaJavaScript();
	}

}
