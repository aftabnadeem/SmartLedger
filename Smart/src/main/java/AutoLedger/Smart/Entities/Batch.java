package AutoLedger.Smart.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
@Data
@Entity
public class Batch {
    @Id
    public String batch_name;
    private Date date;
    public double capital;
    public double purchases;
    public double sales;
    public double expenses;
    public double cash;
    public double profit;

}
