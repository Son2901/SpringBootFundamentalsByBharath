package com.bharath.springweb.health;

import com.bharath.springweb.entities.Product;
import com.bharath.springweb.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CustomInfoIndicator implements InfoContributor {
    @Autowired
    ProductRepo repo;

    @Override
    public void contribute(Info.Builder builder) {
        List<Product> all = repo.findAll();
        Map<String, Object> infoMap= new HashMap<>();
        all.forEach(product -> infoMap.put(String.valueOf(product.getId()), (Object)product));

        builder.withDetails(infoMap);


    }
}
