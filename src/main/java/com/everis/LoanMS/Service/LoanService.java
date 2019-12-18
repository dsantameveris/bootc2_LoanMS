package com.everis.LoanMS.Service;

import com.everis.LoanMS.Model.Loan;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LoanService
{
    //Get all Loans from DB
    public Flux<Loan> findAllLoans();

    //Get loan by number
    public Mono<Loan> findLoanByNumber(String number);

    //Get loan by owner
    public Mono<Loan> findLoanByOwner(String owner);

    //Create Loan
    public Mono<Loan> addLoan(Loan loan);

    //Delete Loan
    public Mono<Void> delLoan(Loan loan);
}