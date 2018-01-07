package com.externalizable.demo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import com.externalizable.demo.encrypt.iml.EncryptionAlgo;

public class Person implements Externalizable 
{
	private String personName;
	private Integer personId;
	private String dateOfBirth;
	private String emailId;
	
	public Person() {}
	
	public Person(String personName, Integer personAge, String dateOfBirth, String emailId) {
		super();
		this.personName = personName;
		this.personId = personAge;
		this.dateOfBirth = dateOfBirth;
		this.emailId = emailId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException 
	{
		out.writeObject(personName); 
		StringBuilder encrypted = EncryptionAlgo.encrypt(dateOfBirth);
		System.out.println("Ecrypted value of dateOfBirth is : " + encrypted);
		out.writeObject(encrypted);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException 
	{
		String name = (String)in.readObject();
		StringBuilder dateOfBirth = (StringBuilder)in.readObject();
		
		this.personName = name;
		this.dateOfBirth = EncryptionAlgo.decrypt(dateOfBirth);
	}

	@Override
	public String toString() {
		return "Person [personName=" + personName + ", personId=" + personId + ", dateOfBirth=" + dateOfBirth
				+ ", emailId=" + emailId + "]";
	}
}
