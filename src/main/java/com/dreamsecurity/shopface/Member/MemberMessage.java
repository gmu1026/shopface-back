package com.dreamsecurity.shopface.Member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberMessage {
    private boolean isDuplicate;
    private String message;
}
