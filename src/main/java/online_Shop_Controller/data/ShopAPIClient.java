package online_Shop_Controller.data;

import api.common.ApiClient;
import api.common.ApiRequest;
import api.common.ApiResponse;
import api.common.exception.InvalidResponseException;
import com.google.gson.GsonBuilder;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.http.Method;
import io.restassured.internal.mapping.GsonMapper;
import io.restassured.mapper.ObjectMapperType;


public class ShopAPIClient extends ApiClient {
    public ShopAPIClient(String baseUrl, String basePathOnlineShop) {
        super(baseUrl, basePathOnlineShop);
        ObjectMapperConfig config = new ObjectMapperConfig(ObjectMapperType.GSON)
                .gsonObjectMapperFactory((type, s) -> new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create());
        setObjectMapper(new GsonMapper(config.gsonObjectMapperFactory()));
    }

    //getProduct
    public int getResponce() throws InvalidResponseException {
        ApiResponse response = caller.executeRequest(getRequest(), Method.GET, Response.class);
        return response.getHttpStatusCode();
    }

    //getProductList
    public Response[] getProducts_List() throws InvalidResponseException {
        ApiResponse <Response[]> response = caller.executeRequest(getRequest(), Method.GET, Response[].class);
        return response.getContent();
    }


    //getproductCount
    public int getProductsCount() throws InvalidResponseException {
        ApiResponse<Response[]> response = caller.executeRequest(getRequest(), Method.GET, Response[].class);
        return response.getContent().length;
    }


    //createProduct
    public Response createdProduct(Response response) throws InvalidResponseException {
        ApiRequest request = getRequest().withBody(response).withHeader("Content-Type", "application/json");
        ApiResponse<Response> response1 = caller.executeRequest(request, Method.POST, Response.class);

        return response1.getContent();
    }

    //DELETE
    public ApiResponse<Response[]> deleteProduct() throws InvalidResponseException {
        ApiResponse<Response[]> response = caller.executeRequest(getRequest(), Method.DELETE, Response[].class);
        return response;
    }




}










