package uz.pdp.bankomat.entity;

import uz.pdp.bankomat.entity.enums.ATMOperationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private ATM atm;

    @Column
    private Date date;

    @ManyToOne
    private Card card;

    @Column
    private double operationAmount;

    @Enumerated(value = EnumType.STRING)
    private ATMOperationType operationType;

    @OneToMany
    private List<Banknotes> banknotes;

}