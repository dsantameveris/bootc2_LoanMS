package com.everis.LoanMS.Controller;

import com.everis.LoanMS.Model.Loan;
import com.everis.LoanMS.Service.Impl.LoanServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class LoanController
{
    //Service Instance
    @Autowired
    private LoanServiceImpl service;

    //Create Loan
    @PostMapping("/loan/create")
    public Mono<Loan> createLoan(Loan loan)
    {
        return service.addLoan(loan);
    }

    //Delete Loan
    @DeleteMapping("/loan/delete")
    public Mono<Void> deleteLoan(Loan loan)
    {
        return service.delLoan(loan);
    }

    //Get all Loans
    @GetMapping("/loan/all")
    public Flux<Loan> getAllLoans()
    {
        return service.findAllLoans();
    }
}