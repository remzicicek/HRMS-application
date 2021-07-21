package com.hrms.HRMS.core.Validators.concretes;

import com.hrms.HRMS.core.Validators.abstracts.MernisValidationService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MernisValidationImpl implements MernisValidationService {

    @Override
    public boolean isPersonReal(String identityNumber, LocalDate birthDate){
        if (identityNumber.length() == 11 && birthDate.compareTo(LocalDate.parse("1970-01-01")) > 0) {
            return true;
        }
        return false;

    }
}
