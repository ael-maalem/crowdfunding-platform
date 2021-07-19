package com.crowdfunding.investmentservice.Controller;

import com.crowdfunding.investmentservice.Service.FundProjectService;
import com.crowdfunding.investmentservice.model.FundProject;
import com.crowdfunding.investmentservice.model.Project;
import com.crowdfunding.investmentservice.model.ProjectCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/investment")
public class FundProjectController {

    private final static String URI_PROJECT_SERVICE = "http://PROJECTS-SERVICE/projects/";
//    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private FundProjectService fundProjectService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getFundProject/{id}")
    public FundProject getFundProject(@PathVariable String id){
        return fundProjectService.getByProjectId(id);
    }

    @PostMapping("/addFund/{userId}/{fund}")
    public FundProject fundProject(@RequestBody FundProject fundProject, @PathVariable("userId") String funderId, @PathVariable("fund") Long fund){
        String projectId = fundProject.getProjectId();
        if ((getProjectById(projectId) !=null) && (getFunderById(funderId) != null)){
            return fundProjectService.saveFund(projectId, funderId, fund);
        }
        return null;
    }

    public Project getProjectById(String id){
//        return restTemplate.getForObject("http://PROJECT-SERVICE/projects/" + id, Project.class);
        return restTemplate.getForObject(URI_PROJECT_SERVICE + id, Project.class);
    }

    public ProjectCreator getFunderById(String id){
//        return restTemplate.getForObject("http://PROJECT-SERVICE/projects/projectCreator/" + id, ProjectCreator.class);
        return restTemplate.getForObject(URI_PROJECT_SERVICE+ "projectCreator/" + id, ProjectCreator.class);
    }

}
