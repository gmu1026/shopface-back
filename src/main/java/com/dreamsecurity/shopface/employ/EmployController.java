package com.dreamsecurity.shopface.employ;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class EmployController {
    private final EmployService employService;

    @PostMapping("/employ")
    public ResponseEntity addEmploy(Employ employ) {
        HttpStatus result = employService.addEmploy(employ);
        return new ResponseEntity(result);
    }

    @GetMapping(value = "/employ/{branchNo}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employ>> getEmployList(@PathVariable int branchNo, Employ employ) {
        return new ResponseEntity<>(employService.getEmployList(employ), HttpStatus.OK);
    }

    @GetMapping(value = "/employ", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employ> getEmploy(Employ employ) {
        HttpStatus result = HttpStatus.OK;

        Employ getResult = employService.getEmploy(employ);
        if (getResult == null) {
            result = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(getResult, result);
    }

    @PutMapping(value = "/employ")
    public ResponseEntity editEmploy(Employ employ) {
        HttpStatus result = employService.editEmploy(employ);

        return new ResponseEntity<>(result);
    }

    @DeleteMapping("/employ")
    public ResponseEntity removeEmploy(Employ employ) {
        return new ResponseEntity(employService.removeEmploy(employ));
    }

    @PutMapping("/employ/invite")
    public Map<String, Object> resendInviteMessage(@RequestBody Employ employ) {
        boolean isSuccess = employService.resendInviteMessage(employ);
        Map<String, Object> responseMap = new HashMap<String, Object>();
        responseMap.put("isSuccess", isSuccess);

        return responseMap;
    }

    //질문 필요
    @GetMapping("/employ/auth")
    public ModelAndView certificationCode(@RequestParam("date") String expiredDate) {
        ModelAndView modelAndView = new ModelAndView("member/authenticationCode");
        modelAndView.addObject("date", expiredDate);

        return modelAndView;
    }
    
    //이해 못함 질문 필요
    @GetMapping(value = "/employ/check", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> checkCertiCode(Employ employ, @RequestParam("expiredDate") String expiredDate) {
        Map<String, Object> result = new HashMap<String, Object>();

        String checker = employService.checkCertiCode(employ, expiredDate);
        result.put("checker", checker);

        return result;
    }
}