package com.dreamsecurity.shopface.employ;

import com.dreamsecurity.shopface.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class EmployController {
    private final EmployService employService;

    @GetMapping(value = "/employ")
    public ResponseEntity listEmploy(Employ employ) {
        return new ResponseEntity<Message>(new Message()
                .builder()
                .status(HttpStatus.OK.toString())
                .message("Success")
                .data(this.employService.getEmployList(employ))
                .build(), HttpStatus.OK);
    }

    @GetMapping(value = "/employ/{no}")
    public ResponseEntity getEmploy(Employ employ) {
        return new ResponseEntity<Message>(new Message()
                .builder()
                .status(HttpStatus.OK.toString())
                .message("Success")
                .data(this.employService.getEmploy(employ))
                .build(), HttpStatus.OK);
    }

    @PostMapping(value = "/employ")
    public ResponseEntity addEmploy(@RequestBody Employ employ) {
        if (this.employService.addEmploy(employ)) {
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

    @PutMapping(value = "/employ/{no}")
    public ResponseEntity updateEmploy(@PathVariable long no, @RequestBody Employ employ) {
        employ.setNo(no);
        if (this.employService.editEmploy(employ)) {
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

    @DeleteMapping(value = "/employ/{no}")
    public ResponseEntity removeEmploy(@PathVariable long no) {
        Employ employ = new Employ();
        employ.setNo(no);
        if (this.employService.removeEmploy(employ)) {
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
