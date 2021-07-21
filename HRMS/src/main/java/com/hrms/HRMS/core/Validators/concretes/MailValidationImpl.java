package com.hrms.HRMS.core.Validators.concretes;
import com.hrms.HRMS.core.Validators.abstracts.MailValidationService;
import org.springframework.stereotype.Component;

@Component
public class MailValidationImpl implements MailValidationService {
    @Override
    public boolean isEmailVerificate(String email) {
        return true;
    }
}
