package AutoLedger.Smart.Dao;

import AutoLedger.Smart.Entities.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface batchDao extends JpaRepository<Batch,String> {
    @Transactional
    @Modifying
    @Query(value="UPDATE batch SET purchases=(select SUM(amount) from transactions where type='purchase' and batch=:id) where batch_name=:id",nativeQuery = true)
    void totalpurchase(@Param("id")String id);

    @Transactional
    @Modifying
    @Query(value="UPDATE batch SET sales=(select SUM(amount) from transactions where type='sales' and batch=:id) where batch_name=:id",nativeQuery = true)
    void totalsales(@Param("id")String id);

    @Transactional
    @Modifying
    @Query(value="UPDATE batch SET expenses=(select SUM(amount) from transactions where type='expenses' and batch=:id) where batch_name=:id",nativeQuery = true)
    void totalexpenses(@Param("id")String id);

    @Transactional
    @Modifying
    @Query(value="UPDATE batch SET cash=(capital+sales)-(purchases+expenses) where batch_name=:id",nativeQuery = true)
    void totalcash(@Param("id")String id);

    @Transactional
    @Modifying
    @Query(value="UPDATE batch SET profit=(sales)-(purchases+expenses) where batch_name=:id",nativeQuery = true)
    void totalprofit(@Param("id")String id);
}
