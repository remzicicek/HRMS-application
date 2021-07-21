package com.hrms.HRMS.core.Validators;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MailValidationImpl implements MailValidationService {
    @Override
    public boolean isEmailVerificate(String email) {
        return true;
    }
}
