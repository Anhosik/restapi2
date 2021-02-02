package kdjsystem.mllink.api;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kdjsystem.mllink.dto.wemarket.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
@Validated
@RequestMapping("/wemarket/api/v1/")
public class WemarketProductController {
    private static final String Host = "https://w-api.wemakeprice.com/";



    // 배송정책..
    @GetMapping("getShipAPI")
    public Shippingpolicy getShipAPI( @RequestHeader("apiKey") String apiKey)
            throws IOException, JsonParseException, JsonMappingException {

        String path = "/product/out/getSellerShipPolicy";
        System.out.println(apiKey);

        Response response = null;

        ObjectMapper mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder().url(Host.concat(path)).method("GET", null)
                .addHeader("apiKey", apiKey).build();

        response = client.newCall(request).execute();

        Shippingpolicy shipPolicy = mapper.readValue(response.body().string().toString(), Shippingpolicy.class);

        return shipPolicy;


    }

    // 브랜드..
    @GetMapping("getBrandAPI")
    public Brands getBrandAPI( @RequestHeader("apiKey") String apiKey, @RequestParam("brandName") String brandname)
            throws IOException, JsonParseException, JsonMappingException {

        String path = "/product/out/getBrand?" + "brandName=" + brandname;

        Response response = null;

        ObjectMapper mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder().url(Host.concat(path)).method("GET", null)
                .addHeader("apiKey", apiKey).build();

        response = client.newCall(request).execute();

        Brands brands = mapper.readValue(response.body().string().toString(), Brands.class);

        return brands;

    }

    // 메이커..
    @GetMapping("getMakerAPI")
    public Makers getMakerAPI( @RequestHeader("apiKey") String apiKey, @RequestParam("makerName") String makername)
            throws IOException, JsonParseException, JsonMappingException {

        String path = "/product/out/getMaker?" + "makerName=" + makername;

        Response response = null;

        ObjectMapper mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder().url(Host.concat(path)).method("GET", null)
                .addHeader("apiKey", apiKey).build();

        response = client.newCall(request).execute();

        Makers makers = mapper.readValue(response.body().string().toString(), Makers.class);

        return makers;

    }

    // 상품정보 고시조회..
    @GetMapping("getNoticeAPI")
    public Notice getNoticeAPI( @RequestHeader("apiKey") String apiKey )
            throws IOException, JsonParseException, JsonMappingException {

        String path = "/product/out/getNotice";
        System.out.println(apiKey);

        Response response = null;

        ObjectMapper mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder().url(Host.concat(path)).method("GET", null)
                .addHeader("apiKey", apiKey).build();

        response = client.newCall(request).execute();

        Notice notice = mapper.readValue(response.body().string().toString(), Notice.class);
//        Notice notice = null;
        return notice;
    }

    // 상품등록..
    @PostMapping("setProductAPI")
    public ProductResult setProductAPI(@RequestHeader("apiKey") String apiKey, @RequestBody String json)
            throws IOException, JsonParseException, JsonMappingException {
//    // 상품등록..
//    @PostMapping("setProductAPI")
//    public ProductResult setProductAPI(@RequestHeader("apiKey") String apiKey, @RequestBody ProductData.WeMarketProductReg data)
//            throws IOException, JsonParseException, JsonMappingException {
        String path = "/product/in/setProduct";

        System.out.println(json);

        MediaType mediaType = MediaType.parse("application/json");
        okhttp3.RequestBody body = okhttp3.RequestBody.create(mediaType, json);

        Response response = null;

        ObjectMapper mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder().url(Host.concat(path))
                .method("POST", body)
                .addHeader("apiKey", apiKey)
                .addHeader("application", "json;charset=UTF-8")
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .build();

        response = client.newCall(request).execute();
        ProductResult prodResult = mapper.readValue(response.body().string().toString(), ProductResult.class);

        return prodResult;
    }

    // 위메프상품코드로 검색..
    @GetMapping("getProductAPI")
    public String getProductAPI( @RequestHeader("apiKey") String apiKey, @RequestParam("productNo") String productno)
            throws IOException, JsonParseException, JsonMappingException {

        String path = "/product/out/getProduct?" + "productNo=" + productno;

        System.out.println(path);

        Response response = null;

        ObjectMapper mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder().url(Host.concat(path)).method("GET", null)
                .addHeader("apiKey", apiKey)
                .addHeader("application", "json;charset=UTF-8")
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .build();

        response = client.newCall(request).execute();
//        ProductData2 prodData = mapper.readValue(response.body().string().toString(), ProductData2.class);

        return response.body().string().toString();

    }

    // 업체상품코드로 검색..
    @GetMapping("getProductListAPI")
    public ProductList getProductListAPI( @RequestHeader("apiKey") String apiKey, @RequestParam("code") String code)
            throws IOException, JsonParseException, JsonMappingException {

        String path = "/product/out/sellerProdCode/getProductList?code=" + code;

        System.out.println(path);

        Response response = null;

        ObjectMapper mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder().url(Host.concat(path))
                .method("GET", null)
                .addHeader("apiKey", apiKey)
                .addHeader("application", "json;charset=UTF-8")
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .build();

        response = client.newCall(request).execute();
        ProductList prodList = mapper.readValue(response.body().string().toString(), ProductList.class);

        return prodList;

    }

    // 전체상품조회.
    @GetMapping("getProductList")
    public ProductData getProductList( @RequestHeader("apiKey") String apiKey, @RequestParam("code") String code)
            throws IOException, JsonParseException, JsonMappingException {

        String path = "/product/out/getProductList?" + code;

        System.out.println(path);

        Response response = null;

        ObjectMapper mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder().url(Host.concat(path))
                .method("GET", null)
                .addHeader("apiKey", apiKey)
                .addHeader("application", "json;charset=UTF-8")
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .build();

        response = client.newCall(request).execute();
        ProductData prodList = mapper.readValue(response.body().string().toString(), ProductData.class);

        return prodList;

    }

    // 상품상태수정..
    @PostMapping("setProductStatusAPI")
    public ProductResult setProductStatusAPI(@RequestHeader("apiKey") String apiKey, @RequestBody String json)
            throws IOException, JsonParseException, JsonMappingException {

        String path = "/product/in/setProductStatus";

        System.out.println(json);

        MediaType mediaType = MediaType.parse("application/json");
        okhttp3.RequestBody body = okhttp3.RequestBody.create(mediaType, json);

        Response response = null;

        ObjectMapper mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder().url(Host.concat(path))
                .method("POST", body)
                .addHeader("apiKey", apiKey)
                .addHeader("application", "json;charset=UTF-8")
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .build();

        response = client.newCall(request).execute();
        ProductResult prodResult = mapper.readValue(response.body().string().toString(), ProductResult.class);

        return prodResult;
    }
}
