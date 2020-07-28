package com.dreamsecurity.shopface.branch;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.dreamsecurity.shopface.employ.Employ;
import com.dreamsecurity.shopface.employ.EmployMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BranchServiceImpl implements BranchService {
    private final BranchMapper branchMapper;
    private final EmployMapper employMapper;
//    private final AmazonS3 awsS3Client;
//
//    @Value("${cloud.aws.s3.bucket}")
//    private String bucket;

    @Override
    public boolean addBranch(Branch branch) {
        boolean isSuccess = false;
        this.branchMapper.insert(branch);
        isSuccess = true;
        return isSuccess;
    }

    @Override
    public List<Branch> getBranchList(Branch branch) {
        return this.branchMapper.selectAll(branch);
    }

    @Override
    public Branch getBranch(int no) {
        return this.branchMapper.select(Branch.builder()
                                                        .no(no)
                                                        .build());
    }

    @Override
    public boolean editBranch(Branch branch, MultipartFile licenseImage) throws IOException {
        boolean isSuccess = false;
//        String fileName = licenseImage.getOriginalFilename();
//        awsS3Client.putObject(new PutObjectRequest(this.bucket, fileName, licenseImage.getInputStream(), null));
//
//        String url = awsS3Client.getUrl(this.bucket, fileName).toString();
//
//        branch.setBusinessLicensePath(awsS3Client.getUrl(this.bucket, fileName).toString());
//
//        this.branchMapper.update(branch);
//        isSuccess = true;
        return isSuccess;
    }

    @Override
    public boolean removeBranch(Branch branch) {
        if (branch.getNo() > 0
                && branch.getMemberId() != null
                && !"".equals(branch.getMemberId())){
            Branch result = this.branchMapper.select(Branch.builder()
                                                            .no(branch.getNo())
                                                            .build());
            if (result != null) {
                String resultId = result.getMemberId();
                if (resultId.equals(branch.getMemberId())) {
                    Employ employ = new Employ();
                    employ.setBranchNo(branch.getNo());

                    List<Employ> employs = this.employMapper.selectAll(employ);
                    if (employs != null && employs.size() >= 1) {
                        branch.setState("D");
                        this.branchMapper.update(branch);
                        return true;
                    } else {
                        this.branchMapper.delete(branch);
                        return true;
                    }
                } return false;
            } return false;
        } return false;
    }
}
