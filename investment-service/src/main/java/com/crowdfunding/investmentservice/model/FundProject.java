package com.crowdfunding.investmentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "fundProject")
public class FundProject implements Serializable {

    @Id
    private String id;
    private Long raisedFunds = 0L;
    private String projectId;
    private List<String> funders = new ArrayList<>();// list of creators = user_id
}