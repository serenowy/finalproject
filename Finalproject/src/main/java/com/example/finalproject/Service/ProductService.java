package com.example.finalproject.Service;

import com.example.finalproject.Dto.Api;
import com.example.finalproject.Exception.ApiException;
import com.example.finalproject.Model.Product;
import com.example.finalproject.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository pRepository;

    public List<Product> getP() {
        return pRepository.findAll();
    }
    public void addp(Product p){
        pRepository.save(p);
    }
    public Product updatep(Integer code,Product p){
        Product oldp=pRepository.findProductByCode(code);
        if(oldp==null){
            throw new ApiException("wrong Code");
        }
        oldp.setCode(p.getCode());
        oldp.setName(p.getName());
        oldp.setNumber(p.getNumber());
        oldp.setPrice(p.getPrice());
        oldp.setAge(p.getAge());
        pRepository.save(oldp);
        return oldp;
    }
    public Product deletep(Integer code){
        Product p=pRepository.findProductByCode(code);
        if(p==null){
            throw new ApiException("wrong code");

        }
        pRepository.delete(p);
        return p;
    }
    public Product getProByCode(Integer code){
     Product p =pRepository.findProductByCode(code);
        if(p==null){throw new ApiException("wrong code");}
        return p;
    }
    public Product getProductByNameAndAge(String n ,Integer e) {

   Product pro =pRepository.findProductByNameAndAge(n,e);
        if(pRepository.findProductByNameAndAge(n,e)==null)
        {throw new ApiException("wrong username or password");}
        return pro;
    }

}
