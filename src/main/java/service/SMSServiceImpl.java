package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.SMSDao;
import model.SMS;

public class SMSServiceImpl implements SMSService {
	

	@Autowired
	SMSDao smsDao;

	@Override
	public boolean addSMS(SMS sms) throws Exception {
		return smsDao.addSMS(sms);
	}

	@Override
	public SMS getSMSById(long id) throws Exception {
		return smsDao.getSMSById(id);
	}

	@Override
	public List<SMS> getSMSList() throws Exception {
		return smsDao.getSMSList();
	}

	@Override
	public boolean deleteSMS(long id) throws Exception {
		return smsDao.deleteSMS(id);
	}
}