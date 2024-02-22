package AutoLedger.Smart.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
@Data
@Entity
public class transactions {
    @Id
    @GeneratedValue
    private int id;
    private String description;
    public double amount;
    private Date date;
    private double weight;
    public String type;
    public String batch;
}
