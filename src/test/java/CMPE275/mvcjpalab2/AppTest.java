package CMPE275.mvcjpalab2;

import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.junit.runners.MethodSorters;
import junit.framework.Assert;
import lab2.config.MainApplicationConfig;
import lab2.dao.IProfileDoa;
import lab2.persistence.Profile;

/**
 * Unit test for simple App.
 */
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MainApplicationConfig.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest
{
	/**
	 * Dao Object for making CRUD operations
	 */
	@Autowired
	private IProfileDoa profileDoa;
	
	private Profile profile ;
	
	private static int  id=0;
	
	@Before
	public void setUp(){
		profile = new Profile("Chandni", "Balchandani", "chandni.balchandani@sjsu.edu","San Jose","SJSU", "Hi.I am Chandni");
	}
	
	/**
	 * Unit Test for Saving a Profile
	 */
	@Test
	public void testASaveUserDetail()
	{
	    profileDoa.saveUserDetail(profile);
		Assert.assertNotNull(id);
		id=profile.getId();
		Assert.assertEquals(profileDoa.getProfile(id), profile);
	}
	
	/**
	 * Unit test for updating profile
	 */
	@Test
	public void testBUpdateProfile()
	{
		profile.setFirst_name("Mooney");
		profile.setAddress("Raleigh");
		Profile updatedProfile = profileDoa.updateProfile(id, profile);
		Assert.assertEquals(profile, updatedProfile);
	}
	
	/**
	 * Unit test for retrieving profile by Id
	 */
	@Test
	public void testCGetProfile()
	{
		Profile prof = profileDoa.getProfile(id);
		Assert.assertNotNull(prof);
	}
	
	/**
	 * Unit test for Deleting profile
	 */
	@Test
	public void testDDeleteProfile()
	{
		Assert.assertTrue(profileDoa.deleteProfile(id));
		
	}
	
}