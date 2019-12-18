package com.everis.LoanMS.Controller;

import com.everis.LoanMS.Model.Loan;
import com.everis.LoanMS.Service.Impl.LoanServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/loan")
public class LoanController
{
    //Service Instance
    @Autowired
    private LoanServiceImpl service;

    //Get all Loans
    @GetMapping("/all")
    public Flux<Loan> getAllLoans()
    {
        return service.findAllLoans();
    }

    //Get loan by number
    @GetMapping("/number/{number}")
    public Mono<Loan> getLoanByNumber(@PathVariable String number)
    {
        return service.findLoanByNumber(number);
    }

    //Get loan by owner
    @GetMapping("/owner/{owner}")
    public Mono<Loan> getLoanByOwner(@PathVariable String owner)
    {
        return service.findLoanByOwner(owner);
    }

    //Create loan data
    @PostMapping
    public Mono<Loan> createLoan(@RequestBody Loan loan)
    {
        return service.addLoan(loan);
    }

    //Update Loan data
    @PutMapping("/edit/{number}")
    public Mono<Loan> editLoan(@RequestBody Loan loan,@PathVariable String number)
    {
        return service.findLoanByNumber(number)
                        .flatMap(l -> 
                        {
                            l.setOwner(loan.getOwner());
                            return service.addLoan(l);
                        });
    }

    //Delete loan data
    @DeleteMapping("/delete/{number}")
    public Mono<Void> deleteLoan(@PathVariable String number)
    {
        return service.findLoanByNumber(number).flatMap(loan -> service.delLoan(loan));
    }
}