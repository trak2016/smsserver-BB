package service;

import java.util.List;

import model.SMS;

public interface SMSService {

	public boolean addSMS(SMS sms) throws Exception;

	public SMS getSMSById(long id) throws Exception;

	public List<SMS> getSMSList() throws Exception;

	public boolean deleteSMS(long id) throws Exception;
}
