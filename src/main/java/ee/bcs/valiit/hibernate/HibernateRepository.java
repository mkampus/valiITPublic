package ee.bcs.valiit.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HibernateRepository extends JpaRepository<AccountEntity, String> {

//    HibernateAccount getByAccount_number(String account_number);

//    HibernateAccount getByOwnerName(String name);
//    List<HibernateAccount> findAllByBlockFalse(Boolean block);


}