package service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class SMSSenderRunnable implements Runnable {

	// @Autowired
	// SMSService smsService;

	private static final String REGEX = "Sending SMS 1/1....waiting for network answer..OK, message reference=.[0-9]*";
	private static Pattern pattern = Pattern.compile(REGEX);
	private static Matcher matcher;

	public void run() {
		// List<SMS> smsToSend = null;
		// try {
		//
		// smsToSend = smsService.getSMSList();
		// for (SMS sms : smsToSend) {
		// String[] command = { "gammu", "sendsms", "TEXT", "535329583",
		// "-text",
		// "Nadawca: " + String.valueOf(sms.id) + " " +
		// String.valueOf(sms.numberTo) + "\n" + "Nadano: "
		// + " test " + "\n" + " test" };
		// System.out.println(command.toString());
		// Process proc;
		// proc = Runtime.getRuntime().exec(command);
		// // Read the output
		// BufferedReader reader = new BufferedReader(new
		// InputStreamReader(proc.getInputStream()));
		// String line = "";
		// while ((line = reader.readLine()) != null) {
		// matcher = pattern.matcher(line);
		// if (matcher.lookingAt()) {
		// } else
		// break;
		// }
		// }
		// } catch (Exception e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		// Map<String, ArrayList<String>> copyMap = new HashMap<String,
		// ArrayList<String>>();

		// copyMap = simpleRestController.map;

		// System.out.println(copyMap.size()); DateFormat dateFormat = new
		// SimpleDateFormat("HH:mm:ss.mmm");

		// List<SMS> smsToSend;
		// try {
		// smsToSend = smsService.getSMSList();
		// for (SMS sms : smsToSend) {
		// String[] command = { "gammu", "sendsms", "TEXT", sms.numberTo,
		// "-text",
		// "Nadawca:" + sms.numberFrom + "\n" + "Nadano: " + sms.date + "\n" +
		// sms.message };
		// Process proc;
		// proc = Runtime.getRuntime().exec(command);
		// // Read the output
		// BufferedReader reader = new BufferedReader(new
		// InputStreamReader(proc.getInputStream()));
		// String line = "";
		// while ((line = reader.readLine()) != null) {
		// matcher = pattern.matcher(line);
		// if (matcher.lookingAt()) {
		// smsService.deleteSMS(sms.getId());
		// } else
		// break;
		// }
		//
		// }
		// } catch (Exception e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }

	}
}