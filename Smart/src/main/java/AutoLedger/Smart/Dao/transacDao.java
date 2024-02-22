package AutoLedger.Smart.Dao;

import AutoLedger.Smart.Entities.transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface transacDao extends JpaRepository<transactions,Integer> {
    public List<transactions> findByBatch(String batch);

}
