package com.vivek.ycompany.client;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vivek.ycompany.client.dto.Appointment;
import com.vivek.ycompany.client.dto.Doctor;
import com.vivek.ycompany.client.dto.Patient;

@Controller
public class SiteController {
	private static final Logger logger = LoggerFactory.getLogger(SiteController.class);

	@Autowired
   	SearchServiceProxy searchServiceProxy;

  	@Autowired
   	AppointmentServiceProxy appointmentServiceProxy;
	
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String greetingForm(Model model) {
    	SearchQuery query = new  SearchQuery("please add here");
    	UIData uiData = new UIData();
    	uiData.setSearchQuery(query);
        model.addAttribute("uidata",uiData );
        return "search";
    }   

   @RequestMapping(value="/search", method=RequestMethod.POST)
   public String greetingSubmit(@ModelAttribute UIData uiData, Model model) {
		List<Doctor> doctors= searchServiceProxy.getDoctors(uiData.getSearchQuery()); 
		uiData.setDoctors(doctors);
		model.addAttribute("uidata", uiData);
       return "result";
   }
//   
   @RequestMapping(value="/doctor/{doctorId}/book", method=RequestMethod.GET)
   public String bookQuery(@PathVariable Long doctorId,
		   Model model) {
   		UIData uiData = new UIData();
   		Doctor doctor = appointmentServiceProxy.getDoctors(doctorId);
   		Appointment appointment = new Appointment(new Date(), new Patient("", ""), doctor);
   		
   		uiData.setNewAppointment(appointment);
	   model.addAttribute("uidata",uiData);
       return "book"; 
   }
//   
//   
   @RequestMapping(value="/confirm", method=RequestMethod.POST)
   public String ConfirmBooking(@ModelAttribute UIData uiData, Model model) {
	   	Appointment appointment= uiData.getNewAppointment();
		
		long appointmentId =0;
		try { 
			appointmentId = appointmentServiceProxy.book(appointment);
			logger.info("Appointment created "+ appointmentId);
		}catch (Exception e){
			logger.error("BOOKING SERVICE NOT AVAILABLE...!!!");
		}
		model.addAttribute("message", "Your Booking is confirmed. Reference Number is "+ appointmentId);
		return "confirm";
   }
  
   
}