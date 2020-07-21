package com.dreamsecurity.shopface.businessman.branch;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BranchService {
    public boolean addBranch(Branch branch);
    public List<Branch> getBranchList(Branch branch);
    public Branch getBranch(int no);
    public boolean editBranch(Branch branch, MultipartFile licenseImage) throws IOException;
    public boolean removeBranch(Branch branch);
}
