package com.dreamsecurity.shopface.branch;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BranchServiceImpl implements BranchService {
    private final BranchMapper branchMapper;

    @Override
    public boolean addBranch(Branch branch) {
        return false;
    }

    @Override
    public List<Branch> getBranchList(Branch branch) {
        return null;
    }

    @Override
    public Branch getBranch(int no) {
        return null;
    }

    @Override
    public boolean editBranch(Branch branch, MultipartFile licenseImage) throws IOException {
        return false;
    }

    @Override
    public boolean removeBranch(Branch branch) {
        return false;
    }
}
