package com.geekbrains.backend.test;

import java.io.IOException;

import com.geekbrains.backend.test.miniMarket.MiniMarketService;
import com.geekbrains.backend.test.miniMarket.model.ProductResponse;
import retrofit2.http.Body;

public class Test {
    public static void main(String[] args) throws IOException {
        MiniMarketService service = new MiniMarketService();
        ProductResponse product = service.getProduct(1L);
        System.out.println("Get product" + product);
        ProductResponse object = service.deleteProduct(2L);
        System.out.println("Delete " + object);
        ProductResponse object2 = service.createProduct(2L, "cat", 150, "FOOD");
        System.out.println("Delete " + object2);
        ProductResponse object3 = service.updateProduct();
        System.out.println("Delete " + object3);

    }
}
