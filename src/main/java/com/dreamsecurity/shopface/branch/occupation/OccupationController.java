package com.dreamsecurity.shopface.branch.occupation;

import com.dreamsecurity.shopface.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class OccupationController {
    private final OccupationService occupationService;

    @GetMapping(value = "/occupation/{no}")
    public ResponseEntity<Message> listOccupation(@PathVariable("no") long branchNo) {
        return new ResponseEntity<Message>(new Message()
                .builder()
                .status(HttpStatus.OK.toString())
                .message("Success")
                .data(occupationService.getOccupationList(branchNo))
                .build(), HttpStatus.OK);
    }

    @PostMapping(value = "/occupation")
    public ResponseEntity<Message> addOccupation(@RequestBody Occupation occupation) {
        return new ResponseEntity<Message>(new Message()
                .builder()
                .status(HttpStatus.OK.toString())
                .message("Success")
                .data(occupationService.addOccupation(occupation))
                .build(), HttpStatus.OK);
    }

    @PutMapping(value = "/occupation/{no}")
    public ResponseEntity<Message> updateOccupation(@PathVariable long no, @RequestBody Occupation occupation) {
        occupation.setNo(no);
        if (occupationService.editOccupation(occupation)) {
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

    @DeleteMapping(value = "/occupation/{no}")
    public ResponseEntity<Message> removeOccupation(@PathVariable long no) {
        Occupation occupation = new Occupation();
        occupation.setNo(no);
        if (occupationService.removeOccupation(occupation)) {
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
