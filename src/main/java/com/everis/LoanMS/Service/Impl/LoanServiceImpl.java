package com.everis.LoanMS.Service.Impl;

import com.everis.LoanMS.Model.Loan;
import com.everis.LoanMS.Repository.LoanRepo;
import com.everis.LoanMS.Service.LoanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LoanServiceImpl implements LoanService{

    @Autowired
    private LoanRepo repo;

    //Create Account
    @Override
    public Mono<Loan> addLoan(Loan loan) {
        return repo.save(loan);
    }

    //DeleteAccount
    @Override
    public Mono<Void> delLoan(Loan loan) {
        return repo.delete(loan);
    }

    //Get All Accounts
    @Override
    public Flux<Loan> findAllLoans() {
        return repo.findAll();
    }    
}