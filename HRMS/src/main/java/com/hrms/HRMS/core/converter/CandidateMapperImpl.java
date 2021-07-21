package com.hrms.HRMS.core.converter;

import com.hrms.HRMS.entities.concretes.CandidateEntity;
import com.hrms.HRMS.models.CandidateModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CandidateMapperImpl implements CandidateMapper{

    @Override
    public CandidateEntity convertToEntity(CandidateModel candidateModel){
        CandidateEntity candidateEntity = new CandidateEntity();

        candidateEntity.setFirstName(candidateModel.getFirstName());
        candidateEntity.setLastName(candidateModel.getLastName());
        candidateEntity.setIdentityNumber(candidateModel.getIdentityNumber());
        candidateEntity.setBirthDate(candidateModel.getBirthDate());
        candidateEntity.setGender(candidateModel.getGender());
        candidateEntity.setEmail(candidateModel.getEmail());
        candidateEntity.setPassword(candidateModel.getPassword());
        candidateEntity.setId(candidateModel.getId());
        candidateEntity.setCreatedDate(candidateModel.getCreatedDate());
        candidateEntity.setCreatedBy(candidateModel.getCreatedBy());
        candidateEntity.setUpdatedDate(candidateModel.getUpdatedDate());
        candidateEntity.setUpdatedBy(candidateModel.getUpdatedBy());
        candidateEntity.setTelephoneNumber(candidateModel.getTelephoneNumber());

        return candidateEntity;
    }

    @Override
    public CandidateModel convertToModel(CandidateEntity candidateEntity){
        CandidateModel candidateModel = new CandidateModel();

        candidateModel.setFirstName(candidateEntity.getFirstName());
        candidateModel.setLastName(candidateEntity.getLastName());
        candidateModel.setIdentityNumber(candidateEntity.getIdentityNumber());
        candidateModel.setBirthDate(candidateEntity.getBirthDate());
        candidateModel.setGender(candidateEntity.getGender());
        candidateModel.setEmail(candidateEntity.getEmail());
        candidateModel.setPassword(candidateEntity.getPassword());
        candidateModel.setId(candidateEntity.getId());
        candidateModel.setCreatedDate(candidateEntity.getCreatedDate());
        candidateModel.setCreatedBy(candidateEntity.getCreatedBy());
        candidateModel.setUpdatedDate(candidateEntity.getUpdatedDate());
        candidateModel.setUpdatedBy(candidateEntity.getUpdatedBy());
        candidateModel.setTelephoneNumber(candidateEntity.getTelephoneNumber());

        return candidateModel;
    }

    @Override
    public List<CandidateModel> converToModelList(List<CandidateEntity> candidateEntities) {

        List<CandidateModel> candidateModels = new ArrayList<>();

        for (CandidateEntity candidateEntity: candidateEntities) {
            candidateModels.add(convertToModel(candidateEntity));
        }
        return candidateModels;
    }

    @Override
    public List<CandidateEntity> convertToEntityList(List<CandidateModel> candidateModels) {
        List<CandidateEntity> candidateEntities = new ArrayList<>();

        for (CandidateModel candidateModel: candidateModels) {
            candidateEntities.add(convertToEntity(candidateModel));
        }
        return candidateEntities;
    }

}
