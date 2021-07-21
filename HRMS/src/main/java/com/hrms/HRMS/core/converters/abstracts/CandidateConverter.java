package com.hrms.HRMS.core.converters.abstracts;

import com.hrms.HRMS.entities.concretes.CandidateEntity;
import com.hrms.HRMS.models.concretes.CandidateModel;

import java.util.List;

public interface CandidateConverter {

    CandidateModel convertToModel(CandidateEntity candidateEntity);

    CandidateEntity convertToEntity(CandidateModel candidateModel);

    List<CandidateModel> converToModelList(List<CandidateEntity> candidateEntities);

    List<CandidateEntity> convertToEntityList(List<CandidateModel> candidateModels);
}
