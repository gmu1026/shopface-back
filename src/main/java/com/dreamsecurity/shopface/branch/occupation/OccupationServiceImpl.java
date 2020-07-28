package com.dreamsecurity.shopface.branch.occupation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OccupationServiceImpl implements OccupationService {
    private final OccupationMapper occupationMapper;

    @Override
    public boolean addOccupation(Occupation occupation) {
        boolean isSuccess = false;

        //TODO branchNo 값 수신시 수정
        //if ((occupation.getName() != null && occupation.getName() != "") && (occupation.getBranchNo() != 0))
        if (occupation.getName() != null
                && occupation.getName() != "") {
            occupationMapper.insert(occupation);

            isSuccess = true;
        }

        return isSuccess;
    }

    @Override
    public List<Occupation> getOccupationList(long branchNo) {
        Occupation occupation = new Occupation();
        occupation.setBranchNo(branchNo);

        return occupationMapper.selectAll(occupation);
    }

    @Override
    public boolean editOccupation(Occupation occupation) {
        boolean isSuccess = false;
        if ((occupation.getName() != null && occupation.getName() != "")
                && (occupation.getNo() != 0)) {
            occupationMapper.update(occupation);

            isSuccess = true;
        }

        return isSuccess;
    }

    @Override
    public boolean removeOccupation(Occupation occupation) {
        boolean isSuccess = false;
        if(occupation.getNo() != 0) {
            occupationMapper.delete(occupation);

            isSuccess = true;
        }

        return isSuccess;
    }
}
