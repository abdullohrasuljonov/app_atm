package uz.pdp.bankomat.controller;

import uz.pdp.bankomat.entity.Card;
import uz.pdp.bankomat.entity.User;
import uz.pdp.bankomat.payload.ApiResponse;
import uz.pdp.bankomat.payload.ClientDto;
import uz.pdp.bankomat.repository.CardRepository;
import uz.pdp.bankomat.repository.RoleRepository;
import uz.pdp.bankomat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/card")
public class CardController {

    @Autowired
    CardRepository cardRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @PostMapping
    public HttpEntity<?> cardAddToClient(@RequestBody ClientDto clientDto) {

//        List<Card> all = cardRepository.findAll();
        List<Card> allByActiveIsTrue = cardRepository.findAllByActiveIsFalse();

        Card card = allByActiveIsTrue.get(0);

        User user = new User();
        user.setFullName(clientDto.getFullName());
        user.setRole(roleRepository.getOne(3));

        userRepository.save(user);
        card.setUser(user);
        card.setActive(true);
        card.setFullName(clientDto.getFullName());
        cardRepository.save(card);

        return ResponseEntity.ok().body(new ApiResponse("Success!", true));
    }
}

