package day2;

public class DemoAmazonLinkScenario {

	public static void main(String[] args) {
		Amazon amazonProject = new Amazon();

		amazonProject.invokrBrowser();

		System.out.println(amazonProject.getLinksCount());
		
		amazonProject.getUrlFromLinkText("Gift Cards");
	}

}
