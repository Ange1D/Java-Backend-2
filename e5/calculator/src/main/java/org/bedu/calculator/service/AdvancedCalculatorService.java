package org.bedu.calculator.service;

import org.bedu.calculator.exception.NegativeNumberException;
import org.springframework.stereotype.Service;

@Service
public class AdvancedCalculatorService {

    //Para n >=0
    //n! = n * (n-1) * (n-2) * ... * 1
    public int factorial(int n){
        if (n < 0) {
            throw new NegativeNumberException();
        }
        
        if (n == 0)
            return 1;

        return n * factorial(n - 1);
    }
}
