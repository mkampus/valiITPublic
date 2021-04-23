package ee.bcs.valiit.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HibernateAccountRepository extends JpaRepository<HibernateAccount, String> {
//    HibernateAccount getByOwnerName(String name);
//    List<HibernateAccount> findAllByBlockFalse(Boolean block);


}