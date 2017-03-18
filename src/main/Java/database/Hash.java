/*
	Program Title:  Hash
	Author:         Ryan O'Shea
	Created:        18/03/2017
	Version:        1.0
*/

package database;

import java.io.FileInputStream;
import java.security.MessageDigest;

@SuppressWarnings("WeakerAccess")
public class Hash
{
	private String hashString;
	private FileInputStream fileInputStream;
	
	/**
	 * Constructor for Hash
	 * @param fileInputStream of file to hash
	 */
	public Hash(FileInputStream fileInputStream)
	{
		this.fileInputStream = fileInputStream;
		
		performHash();
		saltHash();
	}
	
	/**
	 * Creates a SHA-512 hash of the given file
	 */
	private void performHash()
	{
		try
		{
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] dataBytes = new byte[1024];
			
			int numberRead;
			while ((numberRead = fileInputStream.read(dataBytes)) != -1)
				md.update(dataBytes, 0, numberRead);
			
			byte[] byteData = md.digest();
			
			StringBuilder sb = new StringBuilder();
			for (byte aByteData : byteData)
				sb.append(Integer.toString((aByteData & 0xff) + 0x100, 16).substring(1));
			
			hashString = sb.toString();
		} catch (Exception e)
		{
			e.getMessage();
		}
	}
	
	private void saltHash()
	{
		
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
