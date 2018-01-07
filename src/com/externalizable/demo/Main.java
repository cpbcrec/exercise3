package com.externalizable.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main 
{
	private String filePath = "person.ser"; 

	public static void main(String args[]) throws IOException, ClassNotFoundException
	{
		Main obj = new Main();
		obj.serialize();
		obj.deserialize();
	}
	public void serialize() throws IOException 
	{
		Person person = new Person("James", 134121, "01-01-1980", "james@gmail.com"); 
 
        FileOutputStream fos = new FileOutputStream(filePath);
        ObjectOutputStream outputStream = new ObjectOutputStream(fos);
        outputStream.writeObject(person);
        outputStream.close();
 
        System.out.println("person's details before serialization:\n" + person);
    }
 
    public void deserialize() throws ClassNotFoundException, IOException 
    {
        FileInputStream fis = new FileInputStream(filePath);
        ObjectInputStream inputStream = new ObjectInputStream(fis);
        Person person = (Person) inputStream.readObject();
        inputStream.close();
 
        System.out.println("Person's details after de-serialization:\n" + person);
    }
}
