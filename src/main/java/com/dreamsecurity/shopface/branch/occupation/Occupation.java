package com.dreamsecurity.shopface.branch.occupation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@NoArgsConstructor
@Alias("Occupation")
public class Occupation {
    private long no;
    private long branchNo;
    private String name;
    private String color;
}
