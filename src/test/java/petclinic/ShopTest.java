package petclinic;

import api.common.ApiResponse;
import api.common.exception.InvalidResponseException;
import online_Shop_Controller.data.Response;
import online_Shop_Controller.data.ShopAPIClient;
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

    @Test //getproductsList
    public void getProductList() throws Exception {

        ShopAPIClient client = new ShopAPIClient(apiUrl, "/api/shop/getproducts");
        Response[] cartproducts = client.getProducts_List();
        SoftAssertions softly = new SoftAssertions();
        softly.assertAll();
        System.out.println("Product details at index 2" + cartproducts[2]);


    }

    @Test //getproducts
    public void getProductCount() throws Exception {

        ShopAPIClient client = new ShopAPIClient(apiUrl, "/api/shop/getproducts");
        int productcount = client.getProductsCount();
        System.out.println("Total Product count" + productcount);

    }



    //create product
   @Test
    public void createProduct() throws InvalidResponseException {
        ShopAPIClient client = new ShopAPIClient(apiUrl, "/api/shop/addtocart");
        Response response1 = client.createdProduct(Response.builder()
                .name("Pedigree")
                .amount("300")
                .currency("INR")
                .id("20").build());
        SoftAssertions softly1 = new SoftAssertions();
        softly1.assertThat(response1.getName()).isEqualTo("Pedigree");
        softly1.assertThat(response1.getAmount()).isEqualTo("300");
        softly1.assertThat(response1.getCurrency()).isEqualTo("INR");
        softly1.assertThat(response1.getId()).isNotBlank();
        softly1.assertThat(response1.getId()).isGreaterThan("1");
        softly1.assertAll();
    }

    //Delete Product
    @Test
    public void deleteProduct() throws InvalidResponseException {
       ShopAPIClient client1 = new ShopAPIClient(apiUrl, "/api/shop/clearcart/");
        ApiResponse<Response[]> deletedProduct = client1.deleteProduct();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(deletedProduct.getHttpStatusCode()).as("The Status code is :").isEqualTo(200);
        softly.assertAll();
    }


}















