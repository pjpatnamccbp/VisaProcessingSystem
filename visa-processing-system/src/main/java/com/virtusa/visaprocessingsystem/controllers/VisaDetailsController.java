package com.virtusa.visaprocessingsystem.controllers;

import com.virtusa.visaprocessingsystem.dto.VisaDetailsDto;
import com.virtusa.visaprocessingsystem.services.VisaDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/visa")
@AllArgsConstructor
public class VisaDetailsController {
    private VisaDetailsService visaDetailsService;

    @PostMapping("/apply")
    public ResponseEntity<VisaDetailsDto> saveVisaDetails(@RequestBody VisaDetailsDto visaDetailsDto){
        return new ResponseEntity<>(visaDetailsService.saveVisaDetails(visaDetailsDto), HttpStatus.CREATED);
    }
    //api/visa/query?id=1&status=approved
    @PutMapping("/query")
    public ResponseEntity<VisaDetailsDto> approveVisaDetails(@RequestParam("id") Long visaId,
                                                             @RequestParam String status,
                                                             @RequestBody VisaDetailsDto visaDetailsDto){
        return new ResponseEntity<>(visaDetailsService.approveVisaDetails(visaId,status,visaDetailsDto),HttpStatus.OK);
    }
    @PutMapping("/query1")
    public ResponseEntity<VisaDetailsDto> rejectVisaDetails(@RequestParam("id") Long visaId,
                                                             @RequestParam String status,
                                                             @RequestBody VisaDetailsDto visaDetailsDto){
        return new ResponseEntity<>(visaDetailsService.rejectVisaDetails(visaId,status,visaDetailsDto),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<VisaDetailsDto>> getAllVisaDetails(){
        return new ResponseEntity<>(visaDetailsService.getAllVisaDetails(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<VisaDetailsDto> getVisaDetails(@PathVariable("id") Long visaId){
        return new ResponseEntity<>(visaDetailsService.getVisaDetailsById(visaId),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteVisaDetails(@PathVariable("id") Long visaId){
        return new ResponseEntity<>(visaDetailsService.deleteVisaById(visaId),HttpStatus.OK);
    }
}
