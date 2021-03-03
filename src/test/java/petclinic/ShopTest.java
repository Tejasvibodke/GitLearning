package petclinic;

import api.common.ApiResponse;
import api.common.exception.InvalidResponseException;
import online_Shop_Controller.ShopAPIClient;
import online_Shop_Controller.data.Response;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class ShopTest {

    static String apiUrl;


    @BeforeAll
    static void getApiUrl() {
        apiUrl = System.getProperty("apiUrl");
    }

    @Test //getproducts
    public void getProducts_statuscode() throws Exception {

        ShopAPIClient client = new ShopAPIClient(apiUrl, "/api/shop/ordersummary");
        int statuscode = client.getResponce();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(statuscode).isEqualTo(200);
        softly.assertAll();


    }

    //create product
    @Test
    public void createProduct() throws InvalidResponseException {
        ShopAPIClient client = new ShopAPIClient(apiUrl, "/api/shop/addtocart");
        Response response1 = client.createdProduct(Response.builder()
                .name("Tejasvi b")
                .amount("206")
                .currency("INR")
                .id("89").build());
        SoftAssertions softly1 = new SoftAssertions();
        softly1.assertThat(response1.getName()).isEqualTo("Tejasvi b");
        softly1.assertThat(response1.getAmount()).isEqualTo("206");
        softly1.assertThat(response1.getCurrency()).isEqualTo("INR");
        softly1.assertThat(response1.getId()).isNotBlank();
        softly1.assertThat(response1.getId()).isGreaterThan("1");
        softly1.assertAll();
    }

    //Delete Product
    @Test
    public void deleteProduct() throws InvalidResponseException {
       //create a new product
        /*ShopAPIClient client = new ShopAPIClient(apiUrl, "/api/shop/addtocart/");
        Response createdProduct = client.createdProduct(Response.builder()
                .name("Rani b")
                .amount("206")
                .currency("INR")
                .id("90").build());*/
        //delete the created product
       ShopAPIClient client1 = new ShopAPIClient(apiUrl, "/api/shop/clearcart/");
        ApiResponse<Response[]> deletedProduct = client1.deleteProduct();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(deletedProduct.getHttpStatusCode()).as("The Status code is :").isEqualTo(200);
        softly.assertAll();
    }


}















