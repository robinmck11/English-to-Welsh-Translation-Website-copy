/*
	Program Title:  Hash
	Author:         Ryan O'Shea
	Created:        18/03/2017
	Version:        1.0
*/

package database;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;

@SuppressWarnings("WeakerAccess")
public class Hash
{
	private String originalString;
	private String stringToHash;
	
	private String salt;
	private String hashString;
	
	private SecureRandom random;
	
	/**
	 * Constructor for Hash
	 * @param originalString string to be hashed
	 */
	public Hash(String originalString)
	{
		this.originalString = originalString;
		
		random = new SecureRandom();
		
		performHash();
	}
	
	public void saltString()
	{
		salt = new BigInteger(100, random).toString(32);
		stringToHash = salt + originalString;
	}
	
	/**
	 * Creates a SHA-512 hash of the given file
	 */
	private void performHash()
	{
		try
		{
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(stringToHash.getBytes());
			
			byte byteData[] = md.digest();
			
			StringBuilder sb = new StringBuilder();
			for (byte aByteData : byteData)
				sb.append(Integer.toString((aByteData & 0xff) + 0x100, 16).substring(1));
			
			hashString = sb.toString();
		} catch (Exception e)
		{
			e.getMessage();
		}
	}
	
	public String getSalt()
	{
		return salt;
	}
	
	/**
	 * Gets SHA-512 hashString
	 * @return String containing hexadecimal hash of file
	 */
	public String getHashString()
	{
		return hashString;
	}
}
