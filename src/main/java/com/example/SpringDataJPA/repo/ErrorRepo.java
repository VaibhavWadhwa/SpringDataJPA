package com.example.SpringDataJPA.repo;

import com.example.SpringDataJPA.model.Error;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorRepo extends JpaRepository<Error,Integer> {

}
