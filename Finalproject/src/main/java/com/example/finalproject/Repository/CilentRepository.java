package com.example.finalproject.Repository;

import com.example.finalproject.Model.Cilent;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface CilentRepository  extends JpaRepository<Cilent,Integer>{
    Cilent findCilentByName(String name);
   Cilent findCilentById(Integer id);

}