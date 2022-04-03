package uz.pdp.bankomat.component;

import uz.pdp.bankomat.entity.Card;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

@Component
public class CardChecker {
    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
    public boolean check(Card card){
        if (card.isActive() || card.isBlocked())
            return false;
        Date expireDate = card.getExpireDate();
        LocalDate expireLocalDate = convertToLocalDateViaInstant(expireDate);
        LocalDate localDate = LocalDate.now();
        return localDate.isBefore(expireLocalDate);
    }
}
