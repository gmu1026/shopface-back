package com.dreamsecurity.shopface.branch.occupation;

import java.util.List;

public interface OccupationService {
    public boolean addOccupation(Occupation occupation);
    public List<Occupation> getOccupationList(Occupation occupation);
    public boolean editOccupation(Occupation occupation);
    public boolean removeOccupation(Occupation occupation);
}
