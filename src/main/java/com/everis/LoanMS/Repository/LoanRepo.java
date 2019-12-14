package com.everis.LoanMS.Repository;

import com.everis.LoanMS.Model.Loan;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface LoanRepo extends ReactiveMongoRepository<Loan, String>
{

}