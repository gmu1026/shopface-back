package com.dreamsecurity.shopface.businessman.branch;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class BranchController {
    private final BranchService branchService;

    @PostMapping("/branch")
    public String addBranch(RedirectAttributes redirect, Branch branch) {
        String result = "";

        try {
            boolean isSuccess = this.branchService.addBranch(branch);
            if (isSuccess == true) {
                result = "addSuccess";
            } else {
                result = "addFail";
            }
        } catch (Exception e) {
            result = "addFail";
        } finally {
           return result;
        }
    }

    @GetMapping(value = "/branch", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Branch> getBranchList(Branch branch) {
        return this.branchService.getBranchList(branch);
    }

    @GetMapping(value = "/branch/{no}")
    public Branch getBranch(
            @RequestParam(value = "result", required = false, defaultValue = "none") String result,
            @PathVariable(value = "no") int no) {

        try {
            Branch branch = this.branchService.getBranch(no);
            return branch;
        } catch (Exception e) {
            return new Branch();
        }
    }

    @PutMapping("/branch/{no}")
    public String editBranch(Branch branch, MultipartFile licenseImage, RedirectAttributes redirect) {
        String result = "editFail";

        try {
            boolean isSuccess = this.branchService.editBranch(branch, licenseImage);
            if (isSuccess == true) {
                result = "editSuccess";
            } else {
                result = "editFail";
            }
        } catch (Exception e) {
            result = "editFail";
        } finally {
            return result;
        }
    }

    @DeleteMapping("/branch/{no}")
    public String removeBranch(Branch branch) {
        String result = "";

        try {
            boolean isSuccess = this.branchService.removeBranch(branch);
            if (isSuccess) {
                result = "deleteSuccess";
            } else {
                result = "deleteFail";
            }

        } catch (Exception e) {
            result = "deleteFail";
        } finally {
            return result;
        }
    }

    @PutMapping(value = "/branch")
    public Map<String, Object> changeApprovalStatus(@RequestBody Branch branch) throws IOException {
        Map<String, Object> result = new HashMap<>();
        if (branchService.editBranch(branch, null)) {
            result.put("isSuccess", true);
        } else {
            result.put("isSuccess", false);
        }

        return result;
    }
}
