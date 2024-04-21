package com.project.ottshare.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BankType {

    KAKAObank("카카오뱅크"),
    NH("NH농협은행"),
    KB("KB국민은행"),
    SHINHAN("신한은행"),
    WOORI("우리은행"),
    SAEMAEUL("새마을금고"),
    BUSAN("부산은행"),
    IBK("IBK기업은행"),
    TOS("토스뱅크"),
    etc("Other Banks");

    private final String value;

}
