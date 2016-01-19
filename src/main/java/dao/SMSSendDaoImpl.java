package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import model.SMS;

public class SMSSendDaoImpl implements SMSSendDao {
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addSendSMS(SMS sms) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(sms);
		tx.commit();
		session.close();
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SMS> getSendSMSList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<SMS> smsList = session.createCriteria(SMS.class).list();
		tx.commit();
		session.close();
		return smsList;
	}

	@Override
	public boolean deleteSendSMS(long id) throws Exception {
		session = sessionFactory.openSession();
		Object sms = session.load(SMS.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(sms);
		tx.commit();
		return false;
	}

}
