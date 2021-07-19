package com.crowdfunding.investmentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
// pour extraire les informations de payements a partir de l'id de funder
public class ProjectCreator {

    private String id;
    private String user_id;
    //private PayementInformation payementInformation;
    private List<Project> myProjects = new ArrayList<>();
    private List<Project> myInvestments = new ArrayList<>();
}
