package lab2.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import lab2.persistence.Profile;
/**
 * This is an implementation class of Profile interface
 * @author Group 19
 * @version 1.0
 */
@Repository
@Transactional(readOnly = false)
public class ProfileDao implements IProfileDoa
{

	@PersistenceContext
	EntityManager entityManager;//entitymanager instance associated with persistence context
	//The method saves the user profile into the database and returns the generated id
	public int saveUserDetail(Profile profile)
	{
		entityManager.persist(profile);
		entityManager.flush();//forces the data to persist in the database immediately
		return profile.getId();
	}

	@Override
	public Profile getProfile(int id)
	{
		//retrieves entity object by a combination of its class nad its id
		return entityManager.find(Profile.class, id);
	}

	//This method updates the user profile into the database provided the new profile and userid
	@Override
	public Profile updateProfile(int id, Profile profile)
	{
		Profile profile1 = entityManager.find(Profile.class, id);
		if (profile1 != null)//update profile to new non-null values
		{
			if (profile.getAbout_me() != null) profile1.setAbout_me(profile.getAbout_me());
			if (profile.getAddress() != null) profile1.setAddress(profile.getAddress());
			if (profile.getEmail() != null) profile1.setEmail(profile.getEmail());
			if (profile.getFirst_name() != null) profile1.setFirst_name(profile.getFirst_name());
			if (profile.getLast_name() != null) profile1.setLast_name(profile.getLast_name());
			if (profile.getOrganization() != null) profile1.setOrganization(profile.getOrganization());
			entityManager.merge(profile1);
		}
		return profile1;
	}

	//The method deletes the user profile given a particular id
	@Override
	public boolean deleteProfile(int id)
	{
		Profile profile = entityManager.find(Profile.class, id);
		if (profile == null) return false;
		entityManager.remove(profile); //physically deletes an entity from database
		return true;
	}
}