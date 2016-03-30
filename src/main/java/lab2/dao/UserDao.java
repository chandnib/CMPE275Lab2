package lab2.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import lab2.persistence.User;

@Repository
@Transactional(readOnly = false)
public class UserDao {
  @PersistenceContext	
  EntityManager entityManager;	
  public void saveUserDetail(User user){
	  entityManager.persist(user);
	  System.out.println("--Data Saved--");
  }
} 