package com.hrms.HRMS.services.concretes;

import com.hrms.HRMS.core.Validators.abstracts.MailValidationService;
import com.hrms.HRMS.core.exception.EmployerException;
import com.hrms.HRMS.core.results.Constant.ErrorDataResult;
import com.hrms.HRMS.core.results.Constant.ErrorResult;
import com.hrms.HRMS.core.results.Constant.SuccessDataResult;
import com.hrms.HRMS.core.results.Constant.SuccessResult;
import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.EmployerEntity;
import com.hrms.HRMS.repositories.EmployerRepository;
import com.hrms.HRMS.services.abstracts.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerServiceImpl implements EmployerService {
    
    private EmployerRepository employerRepository;
    private MailValidationService mailValidationService;

    @Autowired
    public EmployerServiceImpl(EmployerRepository employerRepository, MailValidationService mailValidationService) {
        this.employerRepository = employerRepository;
        this.mailValidationService = mailValidationService;
    }

    @Override
    public DataResult<List<EmployerEntity>> getList(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return new SuccessDataResult<>(this.employerRepository.findAll(pageable).getContent(), "Page is sucessfully viewed");
    }

    @Override
    public DataResult<List<EmployerEntity>> getAll() {
        return new SuccessDataResult<>(this.employerRepository.findAll(), "Employers are successfully received");
    }

    @Override
    public DataResult<List<EmployerEntity>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "companyName");
        return new SuccessDataResult<>(employerRepository.findAll(sort), "Employers are successfully sorted");
    }

    @Override
    public DataResult<EmployerEntity> save(EmployerEntity employerEntity) {
        if(employerEntity != null && emailChecked(employerEntity.getEmail())){
            return new SuccessDataResult<>(employerRepository.save(employerEntity));
        }
        return new ErrorDataResult<>("Employer could not be added");
    }

    @Override
    public DataResult<EmployerEntity> update(EmployerEntity employerEntity) {
        if(employerRepository.existsById(employerEntity.getId()) && emailChecked(employerEntity.getEmail())){
            return new SuccessDataResult<>(employerRepository.save(employerEntity));
        }
        return new ErrorDataResult<>(employerEntity,"Employer could not be found");

    }

    @Override
    public Result delete(Long id) {
        if(employerRepository.existsById(id)){
            return new SuccessResult("Employer is sucessfully deleted");
        }
        return new ErrorResult("Employer could not be found");
    }

    private boolean emailChecked(String email){
        if(!mailValidationService.isEmailVerificate(email)){
            throw new EmployerException("Employer's email is not verified");
        }
        return true;
    }
}
