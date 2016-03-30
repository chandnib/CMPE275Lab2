package lab2.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import lab2.persistence.Profile;

@Repository
@Transactional(readOnly = false)
public class ProfileDao{
	
  @PersistenceContext	
  EntityManager entityManager;	
  
  public void saveUserDetail(Profile profile){
	  entityManager.persist(profile);
  }
} 