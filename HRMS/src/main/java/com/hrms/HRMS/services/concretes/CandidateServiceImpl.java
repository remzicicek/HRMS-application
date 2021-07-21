package com.hrms.HRMS.services.concretes;

import com.hrms.HRMS.core.Validators.abstracts.MailValidationService;
import com.hrms.HRMS.core.Validators.abstracts.MernisValidationService;
import com.hrms.HRMS.core.converters.abstracts.CandidateConverter;
import com.hrms.HRMS.core.exception.CandidateException;
import com.hrms.HRMS.core.results.Constant.ErrorDataResult;
import com.hrms.HRMS.core.results.Constant.ErrorResult;
import com.hrms.HRMS.core.results.Constant.SuccessDataResult;
import com.hrms.HRMS.core.results.Constant.SuccessResult;
import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.models.concretes.CandidateModel;
import com.hrms.HRMS.repositories.CandidateRepository;
import com.hrms.HRMS.services.abstracts.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    private CandidateRepository candidateRepository;
    private MernisValidationService mernisValidationService;
    private MailValidationService mailValidationService;
    private CandidateConverter candidateMapper;

    @Autowired
    public CandidateServiceImpl(CandidateRepository candidateRepository, CandidateConverter candidateMapper,
                                MernisValidationService mernisValidationService, MailValidationService mailValidationService) {
        this.candidateRepository = candidateRepository;
        this.mernisValidationService = mernisValidationService;
        this.mailValidationService = mailValidationService;
        this.candidateMapper = candidateMapper;
    }


    @Override
    public DataResult<List<CandidateModel>> getList(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return new SuccessDataResult<>(candidateMapper.converToModelList(candidateRepository.findAll(pageable).getContent()), "Page is sucessfully viewed");
    }

    @Override
    public DataResult<List<CandidateModel>> getAll() {
        return new SuccessDataResult<>(candidateMapper.converToModelList(candidateRepository.findAll()), "Candidates is successfully received");
    }

    @Override
    public DataResult<List<CandidateModel>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "firstName");
        return new SuccessDataResult<>(candidateMapper.converToModelList(candidateRepository.findAll(sort)), "Data is successfully sorted");
    }

    @Override
    public DataResult<CandidateModel> save(CandidateModel candidateModel) {

        if(candidateModel != null && emailChecked(candidateModel.getEmail()) && mernisChecked(candidateModel.getIdentityNumber(), candidateModel.getBirthDate())){
           if(candidateModel.getPassword().equals(candidateModel.getConfirmPassword())){
                return new SuccessDataResult<>(candidateMapper.convertToModel(candidateRepository.save(candidateMapper.convertToEntity(candidateModel))));
            }
            return new ErrorDataResult<>("Password confirm is wrong");
        }
        return new ErrorDataResult<>("Candidate could not be added");
    }

    @Override
    public DataResult<CandidateModel> update(CandidateModel candidateModel) {
        if(candidateRepository.existsById(candidateModel.getId()) && emailChecked(candidateModel.getEmail()) && mernisChecked(candidateModel.getIdentityNumber(), candidateModel.getBirthDate())){
            if(candidateModel.getConfirmPassword()!= null){
                if(candidateModel.getPassword().equals(candidateModel.getConfirmPassword())){
                    return new SuccessDataResult<>(candidateMapper.convertToModel(candidateRepository.save(candidateMapper.convertToEntity(candidateModel))));
                }
                return new ErrorDataResult<>("Password confirm is wrong");
            }
            return new SuccessDataResult<>(candidateMapper.convertToModel(candidateRepository.save(candidateMapper.convertToEntity(candidateModel))));
        }
        return new ErrorDataResult<>(candidateModel,"Candidate could not be found");
    }

    @Override
    public Result delete(Long id) {
        if(candidateRepository.existsById(id)){
            candidateRepository.deleteById(id);
            return new SuccessResult("Candidate is sucessfully deleted");
        }
        return new ErrorResult("Candidate could not be found");
    }

    private boolean emailChecked(String email){
        if(!mailValidationService.isEmailVerificate(email)){
            throw new CandidateException("Candidate's email is not verified");
        }
        return true;
    }

    private boolean mernisChecked(String identityNumber, LocalDate birthDate){
        if(!mernisValidationService.isPersonReal(identityNumber, birthDate)){
            throw new CandidateException("Candidate is not verified");
        }
        return true;
    }
}
