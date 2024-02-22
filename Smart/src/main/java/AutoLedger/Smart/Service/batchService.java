package AutoLedger.Smart.Service;

import AutoLedger.Smart.Dao.batchDao;
import AutoLedger.Smart.Entities.Batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class batchService {
    @Autowired
    batchDao batchdao;

    public List<Batch> getall(){
        return batchdao.findAll();
    }
    public void insert(Batch b){
        batchdao.save(b);
    }
    public Batch findbyid(String id){
        Optional <Batch> ob=batchdao.findById(id);
            return ob.get();
    }
    public void deletebatch(Batch b){
        batchdao.delete(b);
    }
    public void totalpurchase(String id){
        batchdao.totalpurchase(id);
    }
    public void totalsales(String id){ batchdao.totalsales(id); }
    public void totalexpenses(String id){ batchdao.totalexpenses(id); }
    public void totalcash(String id){ batchdao.totalcash(id); }
    public void totalprofit(String id){ batchdao.totalprofit(id); }
}
