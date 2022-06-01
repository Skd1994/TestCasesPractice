package RegisterTestcases;

import org.testng.annotations.Test;

import com.tescases.POMRepository.CheckoutPage;
import com.tescases.POMRepository.ViewBasketPage;
import com.testcase.genericUtility.BaseClass;
import com.testcase.genericUtility.WebDriverUtility;
import com.testcase.genericUtility.excelutility;

public class AddtoBasket extends BaseClass {
	
	
	
	
	@Test
	public void addtoBasket() {
		homePage.clickShop(driver);
		
		WebDriverUtility.waitUntillElementVisible(shopPage.getHomeLink(driver));
		
		shopPage.clickHome(driver);
		thinkinginHTMLPage.clickonThinkinginHTML(driver);
		html5WebDevPage.clickonHTML5WebAppDev(driver);
		addtoBasketPage.clickonAddtoBasket(driver);
		viewBasketPage.clickonViewBasket(driver);
		proceedtoCheckoutPage.clickonProceedtoCheckout(driver);
		
		
		checkoutPage.getFirstNameTextbox(driver).sendKeys(excelutility.getdataFromExcel("checkout", 1, 0));
		
		jutil.assertionThroughIfCondition(checkoutPage.getbillingDetails(driver),excelutility.getdataFromExcel("checkout", 0, 1) , "showed checked page");
		
	
		
	}

}
