package uz.pdp.bankomat.entity;

import uz.pdp.bankomat.entity.enums.USDBankNoteType;
import uz.pdp.bankomat.entity.enums.UZSBankNoteType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Banknotes {

    @Id
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    private USDBankNoteType usdBankNoteType;

    @Enumerated(value = EnumType.STRING)
    private UZSBankNoteType uzsBankNoteType;//10 000

    private Integer count;//5

}