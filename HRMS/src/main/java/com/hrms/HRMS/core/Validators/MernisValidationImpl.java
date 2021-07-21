package com.hrms.HRMS.core.Validators;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

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
