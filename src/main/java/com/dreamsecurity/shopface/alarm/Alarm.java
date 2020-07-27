package com.dreamsecurity.shopface.alarm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Alias("Alarm")
public class Alarm {
    private long no;
    private String addresseeId;
    private String type;
    private String contents;
    private LocalDateTime registerDate;
    private String checkState;
}
