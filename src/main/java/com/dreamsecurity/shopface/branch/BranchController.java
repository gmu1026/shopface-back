package com.dreamsecurity.shopface.branch;

import com.dreamsecurity.shopface.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class BranchController {
    private final BranchService branchService;

    @GetMapping(value = "/branch")
    public ResponseEntity<Message> listBranch(Branch branch) {
        return new ResponseEntity<Message>(new Message()
                .builder()
                .status(HttpStatus.OK.toString())
                .message("Success")
                .data(this.branchService.getBranchList(branch))
                .build(), HttpStatus.OK);
    }

    @GetMapping(value = "/branch/{no}")
    public ResponseEntity<Message> getBranch(@PathVariable(value = "no") int no) {
        return new ResponseEntity<Message>(new Message()
                .builder()
                .status(HttpStatus.OK.toString())
                .message("Success")
                .data(this.branchService.getBranch(no))
                .build(), HttpStatus.OK);
    }

    @PostMapping(value = "/branch")
    public ResponseEntity<Message> addBranch(Branch branch) {
        if (this.branchService.addBranch(branch)) {
            return new ResponseEntity<Message>(new Message()
                    .builder()
                    .status(HttpStatus.OK.toString())
                    .message("Success")
                    .data(null)
                    .build(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Message>(new Message()
                    .builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                    .message("Fail")
                    .data(null)
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/branch/{no}")
    public ResponseEntity<Message> updateBranch(Branch branch, MultipartFile licenseImage) {
        try {
            if (this.branchService.editBranch(branch, licenseImage)) {
                return new ResponseEntity<Message>(new Message()
                        .builder()
                        .status(HttpStatus.OK.toString())
                        .message("Success")
                        .data(null)
                        .build(), HttpStatus.OK);
            } else {
                return new ResponseEntity<Message>(new Message()
                        .builder()
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                        .message("Fail")
                        .data(null)
                        .build(), HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<Message>(new Message()
                    .builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                    .message("Fail")
                    .data(null)
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/branch/{no}")
    public ResponseEntity<Message> removeBranch(Branch branch) {
        if (this.branchService.removeBranch(branch)) {
            return new ResponseEntity<Message>(new Message()
                    .builder()
                    .status(HttpStatus.OK.toString())
                    .message("Success")
                    .data(null)
                    .build(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Message>(new Message()
                    .builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                    .message("Fail")
                    .data(null)
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
