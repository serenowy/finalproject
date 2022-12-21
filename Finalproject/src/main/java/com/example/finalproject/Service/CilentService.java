package com.example.finalproject.Service;

import com.example.finalproject.Exception.ApiException;
import com.example.finalproject.Model.Cilent;
import com.example.finalproject.Repository.CilentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CilentService {
    private final CilentRepository cRepository;

    public List<Cilent> getC() {
        return cRepository.findAll();
    }
    public void addc(Cilent C){
        cRepository.save(C);
    }
    public Cilent updateC(Integer id,Cilent c){
      Cilent oldc=cRepository.findCilentById(id);
        if(oldc==null){
            throw new ApiException("wrong  id");
        }
        oldc.setId(c.getId());
        oldc.setName(c.getName());
        oldc.setUsername(c.getUsername());
        oldc.setPassword(c.getPassword());
        cRepository.save(oldc);
        return oldc;
    }
    public Cilent deletec(Integer id){
      Cilent c=cRepository.findCilentById(id);
        if(c==null){
            throw new ApiException("wrong code");

        }
        cRepository.delete(c);
        return c;
    }
    public Cilent getId (Integer id){
        Cilent c =cRepository.findCilentById(id);
        if(c==null){throw new ApiException("wrong code");}
        return c;
    }
    public Cilent getCilentByName(String name){

        if(cRepository.findCilentByName(name)==null){throw new ApiException("wrong name");}

        return  cRepository.findCilentByName(name);
    }

}
