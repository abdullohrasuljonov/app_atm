package uz.pdp.bankomat.service;

import uz.pdp.bankomat.entity.ATM;
import uz.pdp.bankomat.payload.ApiResponse;
import uz.pdp.bankomat.repository.ATMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ATMService {
    @Autowired
    ATMRepository atmRepository;

    public ApiResponse getBanknotes(Integer id){
        Optional<ATM> byId = atmRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("ATM not found",false);
        ATM atm = byId.get();
        List<Object> banknotes=new ArrayList<>();
        banknotes.add(atm.getBanknotes());
        banknotes.add(atm.getBanknotes());
        return new ApiResponse("Banknotes",true,banknotes);
    }
}