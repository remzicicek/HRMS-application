package com.hrms.HRMS.core.Validators;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;

public interface MernisValidationService<T> {

    boolean isPersonReal(String identityNumber, LocalDate birthDate);
}
