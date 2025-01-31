package com.example.banco_de_sangue.modules.candidate.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StateEnum {
    AC("AC"), AL("AL"), AP("AP"), AM("AM"), BA("BA"), CE("CE"),
    ES("ES"), GO("GO"), MA("MA"), MT("MT"), MS("MS"), MG("MG"),
    PA("PA"), PB("PB"), PR("PR"), PE("PE"), PI("PI"), RJ("RJ"),
    RN("RN"), RS("RS"), RO("RO"), RR ("RR"), SC("SC"), SP("SP"),
    SE("SE"), TO("TO"), DF("DF");

    private String state;
}
