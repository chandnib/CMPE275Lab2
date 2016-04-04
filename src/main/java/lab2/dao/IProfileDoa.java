package lab2.dao;

import lab2.persistence.Profile;

/**
 * This is data access object which provides ability to perform specific
 * operations on the user profile without exposing details of database
 * 
 * @author Group 19
 * @version 1.0
 */

public interface IProfileDoa {
	/**
	 * The method saves the user profile into the database and returns the
	 * generated id
	 * 
	 * @param profile
	 * @return int
	 */
	public int saveUserDetail(Profile profile);

	/**
	 * This method gets profile based given the user id which is then rendered
	 * as HTML and text
	 * 
	 * @param id
	 * @return profile
	 */
	public Profile getProfile(int id);

	/**
	 * This method updates the user profile into the database provided the new
	 * profile and userid
	 * 
	 * @param id
	 * @param profile
	 * @return
	 */
	public Profile updateProfile(int id, Profile profile);

	/**
	 * The method deletes the user profile given a particular id
	 * 
	 * @param id
	 * @return boolean
	 */
	public boolean deleteProfile(int id);
}