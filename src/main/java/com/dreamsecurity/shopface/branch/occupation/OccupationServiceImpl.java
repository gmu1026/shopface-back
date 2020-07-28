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

        try {
            //TODO branchNo 값 수신시 수정
            //if ((occupation.getName() != null && occupation.getName() != "") && (occupation.getBranchNo() != 0))
            if (occupation.getName() != null
                    && occupation.getName() != "") {
                occupationMapper.insert(occupation);

                isSuccess = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return isSuccess;
        }

    }

    @Override
    public List<Occupation> getOccupationList(Occupation occupation) {
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
