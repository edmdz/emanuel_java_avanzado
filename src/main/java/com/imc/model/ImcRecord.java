package com.imc.model;

import java.util.Calendar;
import java.util.Date;

public class ImcRecord {
	long imcRecordId;
	Calendar recorDate;
	double imcResult;
	long personId;
	public long getImcRecordId() {
		return imcRecordId;
	}
	public void setImcRecordId(long imcRecordId) {
		this.imcRecordId = imcRecordId;
	}
	public Calendar getRecorDate() {
		return recorDate;
	}
	public void setRecorDate(Calendar recorDate) {
		this.recorDate = recorDate;
	}
	public double getImcResult() {
		return imcResult;
	}
	public void setImcResult(double imcResult) {
		this.imcResult = imcResult;
	}
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
}
