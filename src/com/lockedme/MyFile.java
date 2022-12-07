package com.lockedme;

public class MyFile {
	private int id;
	private String fileName;
	public MyFile() {
	}
	public MyFile(int id, String fileName)
	{
		super();
		this.id = id;
		this.fileName = fileName;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getId()
	{
		return id;
	}
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	public String getFileName()
	{
		return fileName;
	}
}
