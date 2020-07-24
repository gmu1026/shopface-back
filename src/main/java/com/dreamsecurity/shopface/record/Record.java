package com.dreamsecurity.shopface.record;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Alias("Record")
public class Record {
    private long no;
    private String businessmanId;
    private String businessmanName;
    private long branchNo;
    private String branchName;
    private String branchPhone;
    private String memberId;
    private String memberName;
    private String memberPhone;
    private LocalDateTime workStartTime;
    private LocalDateTime workEndTime;
    private LocalDateTime workingTime;
    private LocalDateTime quittingTime;
    private String occupationName;
    private long salaryPlan;
    private long salaryPay;
    private long evaluation;
    private String note;
}
