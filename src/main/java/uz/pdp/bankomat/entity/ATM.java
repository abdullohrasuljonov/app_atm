package uz.pdp.bankomat.entity;

import uz.pdp.bankomat.entity.enums.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ATM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private CardType cardTypes;

    @ManyToOne
    private Bank bank;

    private double balance;

    private double nativeCommission = 0.05;//BANKOMAT ORNATGAN BANK UCHUN KOMISSIYA MIQDORI

    private double foreignCommission = 0.1;//BOSHQA BANK KARTALARI UCHUN COMISSIYA MIQDORI

    private double maxWithdrawal; //Maksimum yechish mumkin bo'lgan summa

    private double alertAmount; //minimum - shunga yetib kelganda bank hodimiga message boradi

    private String address;

    @OneToMany
    private List<Banknotes> banknotes;
}
