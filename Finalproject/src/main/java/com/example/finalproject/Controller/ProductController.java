package com.example.finalproject.Controller;

import com.example.finalproject.Dto.Api;
import com.example.finalproject.Model.Product;
import com.example.finalproject.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RequiredArgsConstructor
@RequestMapping("/api/pro")
@RestController
public class ProductController {
    private final ProductService pservice;

    @GetMapping("/get")
    public ResponseEntity getP(){
        List<Product> p= pservice.getP();
        return ResponseEntity.status(200).body(p);
    }
    @PostMapping("/add")
    public ResponseEntity addP(@RequestBody @Valid Product pro){

       pservice.addp(pro);
        return ResponseEntity.status(200).body (new Api("Add product"));
    }
    @PutMapping("/update/{code}")
    public ResponseEntity updateP(@PathVariable Integer code, @Valid @RequestBody Product pro){

        pservice.updatep(code,pro);

        return ResponseEntity.status(200).body(new Api(" product Updated"));

    }
    @DeleteMapping("/delete/{code}")
    public String deleteP (@PathVariable  Integer code){
        pservice.deletep(code);
        return "product DELETED";}
    @GetMapping("/byc/{code}")
    public ResponseEntity  getProByCode(@PathVariable Integer code )
    {
        Product pro= pservice.getProByCode(code);
        return ResponseEntity.status(200).body(pro);
    }
    @GetMapping("/getna/{n}/{a}")
    public ResponseEntity getProductByNameAndAge(@PathVariable String  n  , @PathVariable Integer a )
    {
       Product pro =pservice.getProductByNameAndAge(n,a);
        return ResponseEntity.status(200).body(pro);
    }
}
