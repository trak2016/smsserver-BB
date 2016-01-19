package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.SMS;
import model.Status;
import service.SMSService;

@Controller
@RequestMapping("/api/")
public class ServiceController {

	@Autowired
	SMSService smsService;

	static final Logger logger = Logger.getLogger(ServiceController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status addSMS(@RequestBody SMS sms) {
		try {

			String[] command = { "gammu", "sendsms", "TEXT", String.valueOf(sms.getNumberTo()), "-text",
					String.valueOf(sms.getMessage()) };
			// System.out.println(String.valueOf(sms.getNumberTo()));
			// System.out.println(String.valueOf(sms.getMessage()));
			// System.out.println(command[0] + " " + command[1] + " " +
			// command[2] + " " + command[3] + " "
			// + command[4] + " " + command[5] + " ");
			Process proc;
			proc = Runtime.getRuntime().exec(command);
			// Read the output
			BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String line = "";

			smsService.addSMS(sms);
			return new Status(1, "SMS added");
		} catch (Exception e) {
			return new Status(0,
					e.toString() + "/nid: " + sms.getId() + " message: " + sms.getMessage() + " numberFrom: "
							+ sms.getNumberFrom() + " numberTo: " + sms.getNumberTo() + " date: " + sms.getDate());
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody SMS getSMSById(@PathVariable("id") long id) {
		SMS sms = null;
		try {
			sms = smsService.getSMSById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sms;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<SMS> getSMSList() {
		List<SMS> smsList = null;
		try {
			smsList = smsService.getSMSList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return smsList;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Status deleteBook(@PathVariable("id") long id) {
		try {
			smsService.deleteSMS(id);
			return new Status(1, "book deleted");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}
	}
}
