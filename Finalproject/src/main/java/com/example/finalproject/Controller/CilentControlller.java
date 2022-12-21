package com.example.finalproject.Controller;

import com.example.finalproject.Dto.Api;
import com.example.finalproject.Model.Cilent;
import com.example.finalproject.Service.CilentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/api/cil")
@RestController
public class CilentControlller {
    private final CilentService cservice;

    @GetMapping("/get")
    public ResponseEntity get(){
        List<Cilent> c= cservice.getC();
        return ResponseEntity.status(200).body(c);
    }
    @PostMapping("/add")
    public ResponseEntity addc(@RequestBody @Valid Cilent c){

        cservice.addc(c);
        return ResponseEntity.status(200).body (new Api("Add cilent"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updatec(@PathVariable Integer id, @Valid @RequestBody Cilent c){

        cservice.updateC(id,c);

        return ResponseEntity.status(200).body(new Api(" cilent Updated"));

    }
    @DeleteMapping("/delete/{id}")
    public String deletec (@PathVariable  Integer id){
        cservice.deletec(id);
        return "  cilent DELETED";}
    @GetMapping("/byid/{id}")
    public ResponseEntity  getId(@PathVariable Integer id )
    {
        Cilent c= cservice.getId(id);
        return ResponseEntity.status(200).body(c);
    }
    @GetMapping("/get/{name}")
    public ResponseEntity getCilentByName(@RequestBody String name)
    {
        return ResponseEntity.status(200).body(name);
    }
}
