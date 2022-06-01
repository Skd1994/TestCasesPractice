package RegisterTestcases;

import org.testng.annotations.Test;

import com.tescases.POMRepository.ViewBasketPage;
import com.testcase.genericUtility.BaseClass;

public class AddtoBasket extends BaseClass {
	
	
	
	
	@Test
	public void addtoBasket() {
		homePage.clickShop(driver);
		shopPage.clickHome(driver);
		thinkinginHTMLPage.clickonThinkinginHTML(driver);
		html5WebDevPage.clickonHTML5WebAppDev(driver);
		addtoBasketPage.clickonAddtoBasket(driver);
		viewBasketPage.clickonViewBasket(driver);
		proceedtoCheckoutPage.clickonProceedtoCheckout(driver);
		
		
		
	
		
	}

}
