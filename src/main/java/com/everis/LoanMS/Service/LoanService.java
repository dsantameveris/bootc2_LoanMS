package com.everis.LoanMS.Service;

import com.everis.LoanMS.Model.Loan;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LoanService
{
    //Create Loan
    public Mono<Loan> addLoan(Loan loan);

    //Delete Loan
    public Mono<Void> delLoan(Loan loan);

    //Get all Loans from DB
    public Flux<Loan> findAllLoans();
}