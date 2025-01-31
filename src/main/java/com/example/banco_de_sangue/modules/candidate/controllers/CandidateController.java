package com.example.banco_de_sangue.modules.candidate.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.banco_de_sangue.modules.candidate.enums.SexEnum;
import com.example.banco_de_sangue.modules.candidate.enums.StateEnum;
import com.example.banco_de_sangue.modules.candidate.models.CandidateModel;
import com.example.banco_de_sangue.modules.candidate.services.CandidateService;

import lombok.AllArgsConstructor;

@RestControllerAdvice
@RestController
@RequestMapping("/candidate")
@AllArgsConstructor
public class CandidateController {
    private CandidateService candidateService;

    @GetMapping("/list")
    public List<CandidateModel> listAvailableDonors() {
        return candidateService.listAvailableDonors();
    }

    @PostMapping("/register")
    public List<CandidateModel> saveAllCandidates(@RequestBody List<CandidateModel> candidates) {
        return candidateService.saveAllCandidates(candidates);
    }

    @GetMapping("/by-states")
    public Map<StateEnum, Long> countCandidatesByState() {
        return candidateService.countCandidatesByState();
    }

    @GetMapping("/imc-by-age")
    public Map<String, Double> averageImcByAgeRange() {
        return candidateService.averageImcByAgeRange();
    }

    @GetMapping("/sex-obsessed")
    public Map<SexEnum, Double> countObeseBySex() {
        return candidateService.countObeseBySex();
    }

    @GetMapping("/average-age-blood")
    public Map<String, Double> averageAgeByBloodType() {
        return candidateService.averageAgeByBloodType();
    }

    @GetMapping("/possible-donors")
    public Map<String, Long>  countPossibleDonors() {
        return candidateService.countPossibleDonors();
    }
}
