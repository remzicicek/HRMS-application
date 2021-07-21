package com.hrms.HRMS.core.converter;

import com.hrms.HRMS.entities.concretes.CandidateEntity;
import com.hrms.HRMS.models.CandidateModel;

import java.util.List;

public interface CandidateMapper {

    CandidateModel convertToModel(CandidateEntity candidateEntity);

    CandidateEntity convertToEntity(CandidateModel candidateModel);

    List<CandidateModel> converToModelList(List<CandidateEntity> candidateEntities);

    List<CandidateEntity> convertToEntityList(List<CandidateModel> candidateModels);
}
