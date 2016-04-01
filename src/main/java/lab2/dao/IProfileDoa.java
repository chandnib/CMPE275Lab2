package lab2.dao;

import lab2.persistence.Profile;

public interface IProfileDoa 
{
	public int saveUserDetail(Profile profile);
	public Profile getProfile(int id);
	public Profile updateProfile(int id,Profile profile);
	public boolean deleteProfile(int id);
}