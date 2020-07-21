package com.dreamsecurity.shopface.businessman.occupation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Alias("occupation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Occupation {
    private int no;
    private int branchNo;
    private String name;
    private String color;
}
