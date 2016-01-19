package service;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;


import model.SMS;

@Component
public class SMSSenderRunnable implements Runnable {

	@Autowired
	SMSSendService smsService;

	static final Logger logger = Logger.getLogger(SMSSenderRunnable.class);
	private static final String REGEX = "Sending SMS 1/1....waiting for network answer..OK, message reference=.[0-9]*";
	private static Pattern pattern = Pattern.compile(REGEX);
	private static Matcher matcher;

	@Override
	public void run() {
		logger.info("run");
		List<SMS> smsToSend = null;
		
		try {
			
			smsToSend = smsService.getSendSMSList();
			 for (SMS sms : smsToSend) {
				 logger.info(""+sms.getNumberTo());
				 System.out.println(sms.getNumberTo());
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 List<SMS> smsToSend = null;
		 try {
		
		 smsToSend = smsService.getSMSList();
		 for (SMS sms : smsToSend) {
		 String[] command = { "gammu", "sendsms", "TEXT", "531400360",
		 "-text",
		 "Nadawca: " + String.valueOf(sms.id) + " " +
		 String.valueOf(sms.numberTo) + "\n" + "Nadano: "
		 + " test " + "\n" + " test" };
		 System.out.println(command.toString());
		 Process proc;
		 proc = Runtime.getRuntime().exec(command);
		 // Read the output
		 BufferedReader reader = new BufferedReader(new
		 InputStreamReader(proc.getInputStream()));
		 String line = "";
		 while ((line = reader.readLine()) != null) {
		 matcher = pattern.matcher(line);
		 if (matcher.lookingAt()) {
		 } else
		 break;
		 }
		 }
		 } catch (Exception e1) {
		 // TODO Auto-generated catch block
		 e1.printStackTrace();
		 }
		*/

	}
}