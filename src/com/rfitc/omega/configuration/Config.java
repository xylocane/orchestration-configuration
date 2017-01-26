package com.rfitc.omega.configuration;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("configuration")
public class Config
{
	@XStreamAlias("module")
	private String moduleName;
	
	@XStreamAlias("description")
	private String moduleDescription;
	
	@XStreamImplicit
	private List<Task> tasks = new ArrayList<>();

	public String getModuleName ()
	{
		return moduleName;
	}

	public void setModuleName (String moduleName)
	{
		this.moduleName = moduleName;
	}

	public String getModuleDescription ()
	{
		return moduleDescription;
	}

	public void setModuleDescription (String moduleDescription)
	{
		this.moduleDescription = moduleDescription;
	}
	
	public List<Task> getTasks ()
	{
		return tasks;
	}

	public void setTasks (List<Task> tasks)
	{
		this.tasks = tasks;
	}
	
	public static Config fromXML(String xml)
	{
		Config config = null;
		XStream x = new XStream();
		x.alias("configuration", Config.class);
		x.autodetectAnnotations(true);
		config = (Config) x.fromXML(xml);
		return config;
	}
	
	public String toXML()
	{
		XStream x = new XStream();
		x.autodetectAnnotations(true);
		return x.toXML(this);
	}
	
	public static void main(String[] args)
	{
		Config c = new Config();
		c.setModuleName("Test Module");
		c.setModuleDescription("Test module description");
		
		List<Task> tasks = new ArrayList<Task>();
		Task t1 = new Task();
		t1.setClassName("com.rfitc.module.Test");
		t1.setMethodName("test");
		t1.setCronString("0/5 * * * * ?");
		tasks.add(t1);
		
		c.setTasks(tasks);
		
		String xml = c.toXML();
		
		Config c2 = Config.fromXML(xml);
		
		System.out.println(c2.toXML());
		
		
	}

	
}
