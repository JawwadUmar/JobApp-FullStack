package com.jawwad.jobapp_with_react.controllers;

import com.jawwad.jobapp_with_react.model.JobPost;
import com.jawwad.jobapp_with_react.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@CrossOrigin(
//        origins = "http://localhost:3000",
//        methods = {RequestMethod.GET, RequestMethod.POST},
//        allowedHeaders = {"Content-Type"},
//        allowCredentials = "true",
//        maxAge = 3600
//)

@CrossOrigin(origins = {"http://localhost:3000"})
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


    @GetMapping("jobPost/{postId}")
    private JobPost getJob(@PathVariable("postId") int id){
        return jobService.getJob(id);
    }

    @PostMapping("jobPost")
//    @RequestBody is used to convert the JSON (request sent by client) to POJO
    private JobPost addJob(@RequestBody JobPost jobPost){
        jobService.addJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    //Client Requests
    //Server Responds

}