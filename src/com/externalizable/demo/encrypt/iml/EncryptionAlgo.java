package com.externalizable.demo.encrypt.iml;

public class EncryptionAlgo 
{
	private static final int userKey = 6;
	
	public static StringBuilder encrypt(String str)
    {
		StringBuilder valueToEncrypt = new StringBuilder(str);
		for (int i = 0; i < valueToEncrypt.length(); i ++) 
		{
			valueToEncrypt.setCharAt(i, (char) (valueToEncrypt.charAt(i) + userKey));
		}
		return valueToEncrypt;
    }
	
	public static String decrypt(StringBuilder str)
	{
		StringBuilder valueToEncrypt = new StringBuilder(str);
		for (int i = 0; i < valueToEncrypt.length(); i ++) 
		{
			valueToEncrypt.setCharAt(i, (char) (valueToEncrypt.charAt(i) - userKey));
		}
		return valueToEncrypt.toString();
	}
}
