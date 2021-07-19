package com.crowdfunding.investmentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    private String id;
    private String name;
    private String description;
    private String shortIdea;
    private Double fundGoal;
    private Date creationDate = new Date();
    private Date endDate;
    private String category;
    private String imgUrl;
    private List<Announcement> announcements = new ArrayList<>();
    private String projectOwner;
}
