package com.example.banco_de_sangue.modules.candidate.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.banco_de_sangue.modules.candidate.enums.SexEnum;
import com.example.banco_de_sangue.modules.candidate.enums.StateEnum;
import com.example.banco_de_sangue.modules.candidate.models.CandidateModel;
import com.example.banco_de_sangue.modules.candidate.repositories.CandidateRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CandidateService {
    private CandidateRepository candidateRepository;

    @Transactional
    public List<CandidateModel> saveAllCandidates(List<CandidateModel> candidates) {
        return candidateRepository.saveAll(candidates);
    }

    @Transactional
    public List<CandidateModel> listAvailableDonors() {
        return candidateRepository.listAvailableDonors();
    }

    @Transactional
    public Map<StateEnum, Long> countCandidatesByState() {
        List<Object[]> result = candidateRepository.countCandidatesByState();
        Map<StateEnum, Long> stateCountMap = new HashMap<>();
        for (Object[] row : result) {
            StateEnum state = (StateEnum) row[0];
            Long count = (Long) row[1];
            stateCountMap.put(state, count);
        }
        return stateCountMap;
    }

    @Transactional
    public Map<String, Double> averageImcByAgeRange() {
        List<Object[]> result = candidateRepository.averageImcByAgeRange();
        Map<String, Double> imcAgeMap = new HashMap<>();

        for (Object[] row : result) {
            String age = (String) row[0];
            Double imc = (Double) row[1];
            imcAgeMap.put(age, imc);
        }
        return imcAgeMap;
    }

    @Transactional
    public Map<SexEnum, Double> countObeseBySex() {
        Map<SexEnum, Double> obesityPercentages = new HashMap<>();

        Double maleObesityPercentage = candidateRepository.calculateObesityPercentageBySex(SexEnum.Masculino);
        obesityPercentages.put(SexEnum.Masculino, maleObesityPercentage);

        Double femaleObesityPercentage = candidateRepository.calculateObesityPercentageBySex(SexEnum.Feminino);
        obesityPercentages.put(SexEnum.Feminino, femaleObesityPercentage);

        return obesityPercentages;
    }

    @Transactional
    public Map<String, Double> averageAgeByBloodType() {
        List<Object[]> result = candidateRepository.averageAgeByBloodType();
        Map<String, Double> averageAgeMap = new HashMap<>();

        for (Object[] row : result) {
            String bloodType = (String) row[0];
            Double averageAge = (Double) row[1];
            averageAgeMap.put(bloodType, averageAge);
        }

        return averageAgeMap;
    }

    @Transactional
    public Map<String, Long> countPossibleDonors() {
        List<Object[]> result = candidateRepository.countPossibleDonors();
        Map<String, Long> countPossibleDonorsMap = new HashMap<>();
        for (Object[] row : result) {
            String bloodType = (String) row[0];
            Long count = (Long) row[1];
            countPossibleDonorsMap.put(bloodType, count);
        }

        Long totalAPlus = countPossibleDonorsMap.getOrDefault("A+", 0L)
                + countPossibleDonorsMap.getOrDefault("AB+", 0L);

        Long totalAMinus = countPossibleDonorsMap.getOrDefault("A+", 0L)
                + countPossibleDonorsMap.getOrDefault("AB+", 0L) + countPossibleDonorsMap.getOrDefault("A-", 0L)
                + countPossibleDonorsMap.getOrDefault("AB-", 0L);

        Long totalBPlus = countPossibleDonorsMap.getOrDefault("B+", 0L)
                + countPossibleDonorsMap.getOrDefault("AB+", 0L);

        Long totalBMinus = countPossibleDonorsMap.getOrDefault("B+", 0L)
                + countPossibleDonorsMap.getOrDefault("AB+", 0L) + countPossibleDonorsMap.getOrDefault("B-", 0L)
                + countPossibleDonorsMap.getOrDefault("AB-", 0L);

        Long totalABPlus = countPossibleDonorsMap.getOrDefault("AB+", 0L);

        Long totalABMinus = countPossibleDonorsMap.getOrDefault("AB+", 0L)
                + countPossibleDonorsMap.getOrDefault("AB-", 0L);

        Long totalOPlus = countPossibleDonorsMap.getOrDefault("B+", 0L)
                + countPossibleDonorsMap.getOrDefault("AB+", 0L) + countPossibleDonorsMap.getOrDefault("A+", 0L)
                + countPossibleDonorsMap.getOrDefault("O+", 0L);

        Long totalOMinus = countPossibleDonorsMap.getOrDefault("B+", 0L)
                + countPossibleDonorsMap.getOrDefault("AB+", 0L) + countPossibleDonorsMap.getOrDefault("A+", 0L)
                + countPossibleDonorsMap.getOrDefault("O+", 0L) + countPossibleDonorsMap.getOrDefault("B-", 0L)
                + countPossibleDonorsMap.getOrDefault("AB-", 0L) + countPossibleDonorsMap.getOrDefault("A-", 0L)
                + countPossibleDonorsMap.getOrDefault("O-", 0L);
        ;

        countPossibleDonorsMap.put("A+", totalAPlus);
        countPossibleDonorsMap.put("A-", totalAMinus);

        countPossibleDonorsMap.put("B+", totalBPlus);
        countPossibleDonorsMap.put("B-", totalBMinus);

        countPossibleDonorsMap.put("AB+", totalABPlus);
        countPossibleDonorsMap.put("AB-", totalABMinus);

        countPossibleDonorsMap.put("O+", totalOPlus);
        countPossibleDonorsMap.put("O-", totalOMinus);

        return countPossibleDonorsMap;
    }

}
