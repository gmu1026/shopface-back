package com.dreamsecurity.shopface.record;

import lombok.Builder;
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

    @Builder
    public Record(long no,
                  String businessmanId, String businessmanName,
                  long branchNo, String branchName, String branchPhone,
                  String memberId, String memberName, String memberPhone,
                  LocalDateTime workStartTime, LocalDateTime workEndTime,
                  LocalDateTime workingTime, LocalDateTime quittingTime,
                  String occupationName,
                  long salaryPlan, long salaryPay,
                  long evaluation, String note) {
        this.no = no;
        this.businessmanId = businessmanId;
        this.businessmanName = businessmanName;
        this.branchNo = branchNo;
        this.branchName = branchName;
        this.branchPhone = branchPhone;
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.workStartTime = workStartTime;
        this.workEndTime = workEndTime;
        this.workingTime = workingTime;
        this.quittingTime = quittingTime;
        this.occupationName = occupationName;
        this.salaryPlan = salaryPlan;
        this.salaryPay = salaryPay;
        this.evaluation = evaluation;
        this.note = note;
    }
}
