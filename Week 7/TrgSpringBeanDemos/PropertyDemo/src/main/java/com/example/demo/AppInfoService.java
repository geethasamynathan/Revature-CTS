package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AppInfoService {

	@Value("${app.name}")
	private String appName;
	
	@Value("${app.version}")
	private String versin;
	
	@Value("${app.owner}")
	private String owner;
	
	public String getAppInfo() {
		return " App : "+appName +"<br/>App Version : "+versin +"<br/>App Owner : "+owner;
	}
}
