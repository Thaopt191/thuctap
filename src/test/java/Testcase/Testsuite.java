package Testcase;

import Core.AbtractPreDefine;
import Core.OrderInfo;
import Page.*;
import org.testng.annotations.Test;

public class Testsuite extends AbtractPreDefine {
    public class ConsultTest extends AbtractPreDefine {

        @Test(description = "TA-6775#일반회원 렌탈상품 상담신청")
        public void consultRentalProduct() throws Exception {
            SplashPage splashPage = new SplashPage(driver);
            HomePage homePage = new HomePage(driver);
            try {
                splashPage.agreeWithGsshopContent();
                homePage = splashPage.acceptPushNotification();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //  In case app is running for the first time
            homePage.closePromotionNotification();

            //step 2: search box select
            homePage.clickSearchBox();

        /* step 3:
        * search word input
        - korean : 렌탈
        - english : rental
        * */
            SearchPage searchPage = homePage.searchData("rental");  //렌탈

            //step 4: select rental product
            //- check key word : 상담전용상품
            ProductDetailPage productDetailPage = searchPage.clickOnAProduct();

        /*step 5:
        1. consult button click
        2. random option select
        3. consult button click
        * */
            LoginPage loginPage = productDetailPage.clickBtn();

            //step 6: general accout logining
            ItemConsultDetailPage itemConsultDetailPage = loginPage.doLogin("", "");

        /* step 7:
        * check the default applicant date from consult detail page item
        1. user name
        2. phone number
        3. address
        * */
            itemConsultDetailPage.checkDefaultInfo();

            //step 8: consult complete button click
            itemConsultDetailPage.clickConsultComplete();
        }
    }

    @Test(description = "TA-6785#일반회원 방송 중 단품 무통장 입금")
    public void singleOnAirProductOder() throws Exception {
        SplashPage splashPage = new SplashPage(driver);
        HomePage homePage = new HomePage(driver);
        try {
            splashPage.agreeWithGsshopContent();
            homePage = splashPage.acceptPushNotification();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //In case app is running for the first time
        homePage.closePromotionNotification();

        //step 2: Click order now button in on-air product
        homePage.checkDefaultTabName();
        homePage.assertOnAirTimer();
        homePage.checkButtonText4Skip("바로구매", homePage.getHomePageObject().BTN_PURCHASE);
        homePage.clickPurchase();
        //step 3: Click order now button
        //check the presence of the options
        SingleOnAirPrdPage singleOnAirPrdPage = new SingleOnAirPrdPage(driver);
        singleOnAirPrdPage.selectOptions();
        singleOnAirPrdPage.clickSingleBuy();

        //step 4: do Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin("gl.han.thi1@gmail.com", "cuongnm15");
        OrderDetailPage orderDetailPage = new OrderDetailPage(driver);
        //Check if CheckBoxAgreeTerm is present or not ?
        orderDetailPage.isCheckBoxAgreeTermPresent();
        orderDetailPage.isSelectGiftOptionChangePresent();
        //step 5: check the default order date from order detail page item
        orderDetailPage.checkDefaultInfo();
        //step 6: Click payment option
        orderDetailPage.clickChangePaymentMethod();
        //step 7: Select deposit without bankbook of payment option
        orderDetailPage.clickBankTransfer();
        orderDetailPage.assertBankBookItems();
        //step 8: Select kookmin bank of unique bankbook list
        orderDetailPage.clickBankBookList();
        orderDetailPage.selectItemInPopUp("국민은행(전용계좌)");
        //step 9: Check depositor input box
        orderDetailPage.checkDepositorInput();

        //step 10: deposit wothout bankbook guide check box select
        //- check box that get SMS information of account number guide
        //- check box that get SMS information of deposit history guide
        orderDetailPage.selectPaySmsAcc();
        orderDetailPage.selectPaySmsCmp();

        // step 11: select 'No' of request cash receipt radio button
        orderDetailPage.selectNoCashReceipt();
        //step 12: payment option check complete button click
        //- korean : '결제수단 선택완료'
        orderDetailPage.clickCompletedPayment();

        //step 13: agreement check box select
        //- product, price, shipping information agreement check box
        //- payment service clause agreement check box
        orderDetailPage.clickAgreeCheckBox();

        //step 14: Click Payment button
        orderDetailPage.clickOrderButton();
        //step 15: check order number and validation from order confirm page item information
        // - order number
        //- shipping address
        //- selected discount item information and price
        //- Etc
        OrderInfo orderInfo = orderDetailPage.getOrderInfo();
        OrderConfirmPage orderConfirmPage = new OrderConfirmPage(driver, orderInfo);
        orderConfirmPage.assertInformation();
        //step 16: click my order list button
        orderConfirmPage.getOrderNumber();
        orderConfirmPage.clickViewOrderList();
    }
}
