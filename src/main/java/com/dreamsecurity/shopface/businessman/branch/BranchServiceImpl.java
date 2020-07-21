package com.dreamsecurity.shopface.businessman.branch;

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
class BranchServiceImple implements BranchService {
    private final BranchMapper branchMapper;
    private final EmployMapper employMapper;
//    private final AmazonS3 awsS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Override
    public boolean addBranch(Branch branch) {
        if (branch.getMemberId() != null
                && !"".equals(branch.getMemberId())
                && branch.getName() != null
                && !"".equals(branch.getName())
                && branch.getPhone() != null
                && !"".equals(branch.getPhone())
                && branch.getAddress() != null
                && !"".equals(branch.getAddress())
                && branch.getDetailAddress() != null
                && !"".equals(branch.getDetailAddress())
                && branch.getZipCode() != null
                && !"".equals(branch.getZipCode())) {
            this.branchMapper.insert(branch);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Branch> getBranchList(Branch branch) {
        if (branch != null) {
            if ("admin".equals(branch.getMemberId())) {
                branch.setMemberId(null);

                return this.branchMapper.selectAll(branch);
            }

            return this.branchMapper.selectAll(branch);
        }

        return null;
    }

    public Branch getBranch(int no) {
        //지점 조회한다
        Branch branch = new Branch();
        try {
            //1. 입력 값 조회(일련번호 0 이상)
            if (no > 0) {
                branch = this.branchMapper.select(no);
                if(branch == null) {
                }
                return branch;
            }

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            //2. 조회 중 오류 발생 시 널값 반환
            return null;
        }
    }

    @Override
    public boolean editBranch(Branch branch, MultipartFile licenseImage) throws IOException {
//        try {
//            if (branch.getNo() != 0
//                    && branch.getMemberId() != null
//                    && !"".equals(branch.getMemberId())
//                    && branch.getName() != null
//                    && !"".equals(branch.getName())) {
//                //2. 존재 시 지점 정보 수정 후 true값 밪환
//                if (licenseImage != null) {
//                    String fileName = licenseImage.getOriginalFilename();
//                    awsS3Client.putObject(new PutObjectRequest(this.bucket, fileName, licenseImage.getInputStream(), null));
//
//                    String url = awsS3Client.getUrl(this.bucket, fileName).toString();
//
//                    branch.setBusinessLPath(awsS3Client.getUrl(this.bucket, fileName).toString());
//                }
//                this.branchMapper.update(branch);
//                return true;
//            } else if (branch.getNo() != 0
//                    && !"".equals("" + branch.getApprovalStatus())){
//                this.branchMapper.update(branch);
//
//                return true;
//            }
//        } catch(Exception e) {
//            //3. 존재 안할 시 false값 반환
//            return false;
//        }
        return false;
    }

    @Override
    public boolean removeBranch(Branch branch) {
        boolean isSuccess = false;
        try{
            if (branch.getNo() > 0
                    && branch.getMemberId() != null
                    && !"".equals(branch.getMemberId())){
                Branch result = this.branchMapper.select(branch.getNo());

                if (result != null) {
                    String resultId = result.getMemberId();
                    if (resultId.equals(branch.getMemberId())) {
                        Employ employ = new Employ();
                        employ.setBranchNo(branch.getNo());

                        List<Employ> employs = this.employMapper.selectAll(employ);
                        if (employs != null && employs.size() >= 1) {
                            branch.setState('D');
                            this.branchMapper.update(branch);
                            isSuccess = true;
                        } else {
                            this.branchMapper.delete(branch);
                            isSuccess = true;
                        }
                    }
                }
            }
        } catch(Exception e) {
            isSuccess = false;
            e.printStackTrace();
        } finally {
            return isSuccess;
        }
    }
}
