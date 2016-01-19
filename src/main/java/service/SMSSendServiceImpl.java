package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.SMSSendDao;
import model.SMS;

public class SMSSendServiceImpl implements SMSSendService {
	

	@Autowired
	SMSSendDao smsSendDao;

	@Override
	public boolean addSendSMS(SMS sms) throws Exception {
		return smsSendDao.addSendSMS(sms);
	}

	@Override
	public List<SMS> getSendSMSList() throws Exception {
		return smsSendDao.getSendSMSList();
	}

	@Override
	public boolean deleteSendSMS(long id) throws Exception {
		return smsSendDao.deleteSendSMS(id);
	}

	

}
