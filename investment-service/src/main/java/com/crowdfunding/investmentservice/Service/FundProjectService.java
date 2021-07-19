package com.crowdfunding.investmentservice.Service;

import com.crowdfunding.investmentservice.Repository.FundProjectRepository;
import com.crowdfunding.investmentservice.model.FundProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FundProjectService {

    @Autowired
    private FundProjectRepository fundProjectRepository;

    // funderId =  project_creator_id for getting paymentinformations
    public FundProject saveFund(String projectId, String funderId, Long fund) {
        FundProject fundProjectUpdate = getByProjectId(projectId);
        //check if project already funded
        if(fundProjectUpdate != null){
            Long raisedFunds = fundProjectUpdate.getRaisedFunds() + fund;
            fundProjectUpdate.setRaisedFunds(raisedFunds);//add funds
            // check if funder already exist before updating the funders list
            if(!(fundProjectUpdate.getFunders().contains(funderId))){
                fundProjectUpdate.getFunders().add(funderId);
            }
            return fundProjectRepository.save(fundProjectUpdate);

        }else{
            FundProject fundProjectSave = new FundProject();
            fundProjectSave.setRaisedFunds(fund);
            fundProjectSave.setProjectId(projectId);
            fundProjectSave.getFunders().add(funderId);
            return fundProjectRepository.save(fundProjectSave);
        }
    }

    public FundProject getByProjectId(String projectId){
        return fundProjectRepository.findByProjectId(projectId);
    }

    public Optional<FundProject> getById(String id){
        return fundProjectRepository.findById(id);
    }
}
