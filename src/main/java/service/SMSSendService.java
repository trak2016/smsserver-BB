package service;

import java.util.List;

import model.SMS;

public interface SMSSendService {

	public boolean addSendSMS(SMS sms) throws Exception;


	public List<SMS> getSendSMSList() throws Exception;

	public boolean deleteSendSMS(long id) throws Exception;
}
