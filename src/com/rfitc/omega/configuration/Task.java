package com.rfitc.omega.configuration;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("task")
public class Task
{
	@XStreamAlias("class")
	private String className;
	
	@XStreamAlias("method")
	private String methodName;
	
	@XStreamAlias("cron")
	private String cronString;
	
	public String getClassName ()
	{
		return className;
	}
	public void setClassName (String className)
	{
		this.className = className;
	}
	public String getMethodName ()
	{
		return methodName;
	}
	public void setMethodName (String methodName)
	{
		this.methodName = methodName;
	}
	public String getCronString ()
	{
		return cronString;
	}
	public void setCronString (String cronString)
	{
		this.cronString = cronString;
	}
}
