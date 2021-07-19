package com.crowdfunding.investmentservice.Repository;

import com.crowdfunding.investmentservice.model.FundProject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundProjectRepository extends MongoRepository<FundProject, String> {

    FundProject findByProjectId(String projectId);
}
