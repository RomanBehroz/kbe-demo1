package com.romanyou.KBE.demo1.controller;

import com.romanyou.KBE.demo1.exception.ProductNotFoundException;
import com.romanyou.KBE.demo1.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MainController {

    @GetMapping("/")
    public String test(){
        return "Hello World!";
    }


    @GetMapping("/products")
    public List<List<String>> getProducts(){
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("products.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(System.lineSeparator());
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return records;
    }


    @GetMapping("/products/{id}")
    public Product getProducts(@PathVariable("id") int id) throws ProductNotFoundException {
        List<List<String>> records = new ArrayList<>();

        List<Product> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("products.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(System.lineSeparator());
                records.add(Arrays.asList(values));
                Product p = new Product(values[0],values[1],values[2], Double.parseDouble(values[3]));
                System.out.println(p);
                list.add(p);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(id<0 || id >=records.size()){
            throw new ProductNotFoundException("Index not found");
        }

        return list.get(id);
    }
}
