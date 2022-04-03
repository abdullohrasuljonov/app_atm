package uz.pdp.bankomat.service;

import uz.pdp.bankomat.entity.ATM;
import uz.pdp.bankomat.entity.Operation;
import uz.pdp.bankomat.payload.ApiResponse;
import uz.pdp.bankomat.repository.OperationRepository;
import uz.pdp.bankomat.repository.ATMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static uz.pdp.bankomat.entity.enums.ATMOperationType.PULKIRITAWAL;
import static uz.pdp.bankomat.entity.enums.ATMOperationType.WITHDRAWAL;

@Service
public class ATMHistoryService {
    @Autowired
    OperationRepository operationRepository;
    @Autowired
    ATMRepository atmRepository;


    public ApiResponse getAtmHistory(Integer id) {
        Optional<ATM> byId = atmRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("ATM not found", false);
        ATM atm = byId.get();
        List<Operation> allByAtmId = operationRepository.findAllByAtmId(atm.getId());
        return new ApiResponse("ATM buyicha kirim chiqim", true, allByAtmId);
    }

    public ApiResponse getDailyIncome(Integer id) {
        Optional<ATM> byId = atmRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("ATM not found", false);
        ATM atm = byId.get();
        LocalDate localDate = LocalDate.now();
        List<Operation> allByAtmIdAndDateStartsWith = operationRepository.findAllByAtmIdAndDateAndOperationType(id, localDate,PULKIRITAWAL);
        return new ApiResponse("ATM buyicha kunlik kirim", true, allByAtmIdAndDateStartsWith);
    }
    public ApiResponse getDailyOutgoings(Integer id){
        Optional<ATM> byId = atmRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("ATM not found", false);
        ATM atm = byId.get();
        LocalDate localDate = LocalDate.now();
        List<Operation> allByAtmIdAndDateStartsWith = operationRepository.findAllByAtmIdAndDateAndOperationType(id, localDate,WITHDRAWAL);
        return new ApiResponse("ATM buyicha kunlik chiqim", true, allByAtmIdAndDateStartsWith);
    }
}