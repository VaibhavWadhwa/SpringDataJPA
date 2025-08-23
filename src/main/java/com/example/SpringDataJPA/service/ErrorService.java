package com.example.SpringDataJPA.service;

import com.example.SpringDataJPA.model.Error;
import com.example.SpringDataJPA.repo.ErrorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ErrorService {

    @Autowired
    private ErrorRepo errorRepo;

    @Autowired
    private Error error;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void logError(String message){
            error.setMessage(message);
            errorRepo.save(error);
    }

}
