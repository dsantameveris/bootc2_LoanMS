package com.everis.LoanMS.Repository;

import com.everis.LoanMS.Model.Loan;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;

public interface LoanRepo extends ReactiveMongoRepository<Loan, String>
{
    Mono<Loan> findByNumber(String number);

    Mono<Loan> findByOwner(String owner);
}