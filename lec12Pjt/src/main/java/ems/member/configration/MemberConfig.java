package ems.member.configration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ems.member.DataBaseConnectionInfo;
import ems.member.dao.StudentDao;
import ems.member.service.EMSInformationService;
import ems.member.service.StudentAllSelectService;
import ems.member.service.StudentDeleteService;
import ems.member.service.StudentModifyService;
import ems.member.service.StudentRegisterService;
import ems.member.service.StudentSelectService;

// XML로 만들던 스프링컨테이너 파일을 자바파일로 만든것이다. 
@Configuration
public class MemberConfig {
	
	@Bean
	public StudentDao studentDao() {
		return new StudentDao();
	}
	
	@Bean
	public StudentRegisterService registerSercice() {
		return new StudentRegisterService(studentDao());
	}
	
	@Bean
	public StudentModifyService modifySercice() {
		return new StudentModifyService(studentDao());
	}
	
	@Bean
	public StudentDeleteService deleteSercice() {
		return new StudentDeleteService(studentDao());
	}
	
	@Bean
	public StudentSelectService selectSercice() {
		return new StudentSelectService(studentDao());
	}
	
	@Bean
	public StudentAllSelectService allSelectSercice() {
		return new StudentAllSelectService(studentDao());
	}
	
	@Bean
	public DataBaseConnectionInfo dataBaseConnectionInfoDev() {
		DataBaseConnectionInfo infoDev = new DataBaseConnectionInfo();
		infoDev.setJdbcUrl("jdbc:oracle:thin:@192.168.0.1:1521:xe");
		infoDev.setUserId("scott");
		infoDev.setUserId("tiger");
		
		return infoDev;
	}
	
	@Bean
	public DataBaseConnectionInfo dataBaseConnectionInfoReal() {
		DataBaseConnectionInfo infoReal = new DataBaseConnectionInfo();
		infoReal.setJdbcUrl("jdbc:oracle:thin:@192.168.0.1:1521:xe");
		infoReal.setUserId("masterid");
		infoReal.setUserId("masterpw");
		
		return infoReal;
	}
	
	@Bean
	public EMSInformationService informationService() {
		EMSInformationService info = new EMSInformationService();
		info.setInfo("ducation Management System program was developed in 2015.");
		info.setCopyRight("OPYRIGHT(C) 2015 EMS CO., LTD. ALL RIGHT RESERVED. CONTACT MASTER FOR MORE INFORMATION.");
		info.setVer("The version is 1.0");
		info.setsYear(2015);
		info.setsMonth(1);
		info.setsDay(1);
		info.seteYear(2015);
		info.seteMonth(2);
		info.seteDay(28);
		
		ArrayList<String> developers = new ArrayList<String>();
		
		developers.add("Cheney.");
		developers.add("Eloy.");
		developers.add("Jaster.");
		developers.add("Dillon.");
		developers.add("Kian.");
		
		info.setDevelopers(developers);
		
		Map<String,String> administrator = new HashMap<String,String>();
		administrator.put("Cheney", "cheney@springPjt.org");
		administrator.put("Jasper", "jasper@springPjt.org");
		info.setAdministrators(administrator);
		
		Map<String,DataBaseConnectionInfo> dbInfos = new HashMap<String,DataBaseConnectionInfo>();
		dbInfos.put("dev", dataBaseConnectionInfoDev());
		dbInfos.put("real", dataBaseConnectionInfoReal());
		info.setDbInfos(dbInfos);
		
		return info;
	}
}
