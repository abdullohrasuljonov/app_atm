package uz.pdp.bankomat.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import uz.pdp.bankomat.entity.Card;
import uz.pdp.bankomat.repository.CardRepository;
import uz.pdp.bankomat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@Service
public class MyAuthService implements UserDetailsService {
    @Autowired
    CardRepository cardRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String number) throws UsernameNotFoundException {
        Optional<Card> optionalCard = cardRepository.findByNumber(number);
        return optionalCard.orElse(null);
    }
}
