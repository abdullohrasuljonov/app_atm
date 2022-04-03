package uz.pdp.bankomat.component;

import uz.pdp.bankomat.entity.Bank;
import uz.pdp.bankomat.entity.Card;
import uz.pdp.bankomat.entity.Role;
import uz.pdp.bankomat.entity.User;
import uz.pdp.bankomat.entity.enums.CardType;
import uz.pdp.bankomat.entity.enums.RoleName;
import uz.pdp.bankomat.repository.BankRepository;
import uz.pdp.bankomat.repository.CardRepository;
import uz.pdp.bankomat.repository.RoleRepository;
import uz.pdp.bankomat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Value("${spring.datasource.initialization-mode}")
    private String initialMode;


    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

//    @Autowired
//    PasswordEncoder passwordEncoder;

    @Autowired
    BankRepository bankRepository;

    @Autowired
    CardRepository cardRepository;

    @Override
    public void run(String... args) throws Exception {
        if (initialMode.equals("always")) {


            Role director = roleRepository.save(
                    new Role(1, RoleName.DIRECTOR));

            Role manager = roleRepository.save(
                    new Role(2, RoleName.MANAGER));

            Role user = roleRepository.save(
                    new Role(3, RoleName.USER));


            Bank universalBank = bankRepository.save(new Bank(1, "UniversalBank"));

            List<Card> cardList = new ArrayList<>();
            cardList.add(new Card(1, "8600", "111", universalBank, "TJU", "1234",
                    Date.valueOf("2021-03-05"), CardType.HUMO, false, false, 0));
            cardList.add(new Card(2, "8601", "111", universalBank, "AAA", "1111",
                    Date.valueOf("2021-05-04"), CardType.UZCARD, false, false, 0));
            cardList.add(new Card(3, "8602", "111", universalBank, "JJJ", "1111",
                    Date.valueOf("2021-05-04"), CardType.HUMO, false, false, 0));

            cardRepository.saveAll(cardList);
            userRepository.save(new User(1, "director", director));
            userRepository.save(new User(2, "manager", manager));
            userRepository.save(new User(3, "user", user));
        }
    }
}