package com.jawwad.jobapp_with_react.service;

import com.jawwad.jobapp_with_react.model.JobPost;
import com.jawwad.jobapp_with_react.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    private final JobRepository jobRepository;

    @Autowired
    JobService(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

    public void addJob(JobPost jobPost){
        jobRepository.addJob(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return jobRepository.getAllJobs();
    }
}
