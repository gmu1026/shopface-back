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
        return false;
    }

    @Override
    public List<Occupation> getOccupationList(Occupation occupation) {
        return null;
    }

    @Override
    public boolean editOccupation(Occupation occupation) {
        return false;
    }

    @Override
    public boolean removeOccupation(Occupation occupation) {
        return false;
    }
}
