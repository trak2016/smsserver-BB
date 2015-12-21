package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import model.SMS;

public class SMSDaoImpl implements SMSDao {
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addSMS(SMS sms) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(sms);
		tx.commit();
		session.close();
		return false;
	}

	@Override
	public SMS getSMSById(long id) throws Exception {
		session = sessionFactory.openSession();
		SMS sms = (SMS) session.load(SMS.class, new Long(id));
		tx = session.getTransaction();
		tx = session.beginTransaction();
		tx.commit();
		return sms;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SMS> getSMSList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<SMS> smsList = session.createCriteria(SMS.class).list();
		tx.commit();
		session.close();
		return smsList;
	}

	public boolean deleteSMS(long id) throws Exception {
		session = sessionFactory.openSession();
		Object sms = session.load(SMS.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(sms);
		tx.commit();
		return false;
	}
}
