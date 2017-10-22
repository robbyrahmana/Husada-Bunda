package com.cinovation.web.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cinovation.web.repository.patient.PatientAdministrationRepository;
import com.cinovation.web.repository.patient.PatientMedicineRepository;
import com.cinovation.web.repository.patient.PatientRepository;

@Component
public class HelperService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private PatientMedicineRepository patientMedicineRepository;
	
	@Autowired
	private PatientAdministrationRepository patientAdministrationRepository;
	
	final String date_format = "dd-MM-yyyy HH:mm:ss";
	final String prefixPasien = "HBPS";
	final String prefixRegistration = "RGPS";
	final String prefixMedicine = "MDPS";
	final String reg_date_format = "yyMMdd";
	
	public Date setDateFormat(Date date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(date_format);
		String d = "";
		d = sdf.format(date);
		return sdf.parse(d);
	}
	
	public String getPasienCode() {
		long count = patientRepository.count() + 1;
		String newCode = String.format("%6s", (count)).replace(' ', '0');
		return prefixPasien + "-" + newCode;
	}
	
	public String getRegistrasiCode(String id) {
		SimpleDateFormat sdf = new SimpleDateFormat(reg_date_format);
		Date a = new Date();
		long count = patientAdministrationRepository.countByCreateDate(new Date()) + 1;
		String newCode = id + sdf.format(a) + String.format("%4s", (count)).replace(' ', '0');
		return newCode.replace("HBPS", prefixRegistration);
	}
	
	public String getMedicineCode(String id) {
		SimpleDateFormat sdf = new SimpleDateFormat(reg_date_format);
		Date a = new Date();
		long count = patientMedicineRepository.countByCreateDate(new Date()) + 1;
		String newCode = id + sdf.format(a) + String.format("%4s", (count)).replace(' ', '0');
		return newCode.replace("HBPS", prefixMedicine);
	}
	
	public String plus(String a, String b) {
		Double a1 = Double.parseDouble(a);
		Double b1 = Double.parseDouble(b);
		
		return (a1 + b1) + "";
	}
	
	public String minus(String a, String b) {
		Double a1 = Double.parseDouble(a);
		Double b1 = Double.parseDouble(b);
		
		return (a1 - b1) + "";
	}
	
	public String dividedby(String a, String b) {
		Double a1 = Double.parseDouble(a);
		Double b1 = Double.parseDouble(b);
		
		return (a1 / b1) + "";
	}
	
	public String multiply(String a, String b) {
		Double a1 = Double.parseDouble(a);
		Double b1 = Double.parseDouble(b);
		
		return (a1 * b1) + "";
	}
}
