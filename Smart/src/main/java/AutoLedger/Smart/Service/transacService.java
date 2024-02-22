package AutoLedger.Smart.Service;

import AutoLedger.Smart.Dao.transacDao;
import AutoLedger.Smart.Entities.transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class transacService {
    @Autowired
    transacDao tDao;

    public List<transactions> getall(String b){
        return tDao.findByBatch(b);
    }
    public void addtrans(transactions t){
        tDao.save(t);
    }
}

