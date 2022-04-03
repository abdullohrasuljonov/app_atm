package uz.pdp.bankomat.controller;

import uz.pdp.bankomat.service.ATMHistoryService;
import uz.pdp.bankomat.payload.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.bankomat.service.ATMService;

@RestController
@RequestMapping("/api/director")
public class ReportDirectorController {
    @Autowired
    ATMHistoryService atmHistoryService;

    @Autowired
    ATMService atmService;

    @GetMapping("/{id}")
    public HttpEntity<?> getAtmHistory(@PathVariable Integer id){
        ApiResponse atmHistory = atmHistoryService.getAtmHistory(id);
        return ResponseEntity.status(atmHistory.isSuccess()? HttpStatus.OK:HttpStatus.CONFLICT).body(atmHistory);
    }
    @GetMapping("/dailyIncome/{id}")
    public HttpEntity<?> getAtmDailyIncome(@PathVariable Integer id) {
        ApiResponse atmHistory = atmHistoryService.getDailyIncome(id);
        return ResponseEntity.status(atmHistory.isSuccess()? HttpStatus.OK:HttpStatus.CONFLICT).body(atmHistory);
    }
    @GetMapping("/dailyOngoings/{id}")
    public HttpEntity<?> getAtmDailyOutgoings(@PathVariable Integer id){
        ApiResponse atmHistory = atmHistoryService.getDailyOutgoings(id);
        return ResponseEntity.status(atmHistory.isSuccess()? HttpStatus.OK:HttpStatus.CONFLICT).body(atmHistory);
    }

    @GetMapping("/banknotes/{id}")
    public HttpEntity<?> getBanknotesByATMid(@PathVariable Integer id){
        ApiResponse atmHistory = atmService.getBanknotes(id);
        return ResponseEntity.status(atmHistory.isSuccess()? HttpStatus.OK:HttpStatus.CONFLICT).body(atmHistory);
    }
}