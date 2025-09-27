package com.jawwad.jobapp_with_react.controllers;

import com.jawwad.jobapp_with_react.model.JobPost;
import com.jawwad.jobapp_with_react.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService){
        this.jobService = jobService;
    }

    @GetMapping("jobPosts")
    private List<JobPost> viewAllJobs(){
        return jobService.getAllJobs();
    }

}