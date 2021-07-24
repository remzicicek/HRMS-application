package com.hrms.HRMS.services.concretes;

import com.hrms.HRMS.core.results.Constant.ErrorDataResult;
import com.hrms.HRMS.core.results.Constant.ErrorResult;
import com.hrms.HRMS.core.results.Constant.SuccessDataResult;
import com.hrms.HRMS.core.results.Constant.SuccessResult;
import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CompanyEntity;
import com.hrms.HRMS.repositories.CompanyRepository;
import com.hrms.HRMS.services.abstracts.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public DataResult<List<CompanyEntity>> getList(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return new SuccessDataResult<>(companyRepository.findAll(pageable).getContent(), "Page is sucessfully viewed");
    }

    @Override
    public DataResult<List<CompanyEntity>> getAll() {
        return new SuccessDataResult<>(companyRepository.findAll(), "Companies are successfully received");
    }

    @Override
    public DataResult<List<CompanyEntity>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "companyName");
        return new SuccessDataResult<>(companyRepository.findAll(sort), "Companies are successfully sorted");
    }

    @Override
    public DataResult<CompanyEntity> save(CompanyEntity companyEntity) {
        if(companyEntity != null){
            return new SuccessDataResult<>(companyRepository.save(companyEntity));
        }
        return new ErrorDataResult<>("Company could not be added");
    }

    @Override
    public DataResult<CompanyEntity> update(CompanyEntity companyEntity) {
        if(companyRepository.existsById(companyEntity.getId())){
            return new SuccessDataResult<>(companyRepository.save(companyEntity));
        }
        return new ErrorDataResult<>(companyEntity,"Company could not be found");
    }

    @Override
    public Result delete(Long id) {
        if(companyRepository.existsById(id)){
            return new SuccessResult("Company is sucessfully deleted");
        }
        return new ErrorResult("ompany could not be found");
    }
}
