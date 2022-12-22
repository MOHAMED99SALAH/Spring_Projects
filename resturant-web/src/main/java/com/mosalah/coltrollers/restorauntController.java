package com.mosalah.coltrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mosalah.DAO.ReserveDAO;
import com.mosalah.models.reservation;

@Controller
public class restorauntController {

	

	
	@Autowired
	private ReserveDAO  reserveDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
	 
		return "home";
	}


	@RequestMapping(value = "/reserve", method = RequestMethod.POST)
	public String homee(@RequestParam String nameRR ,@RequestParam  int tableN , @RequestParam  int  chairN,@RequestParam  String date ,@RequestParam  String time) {
	 
		reservation reserve= new  reservation();
	    reserve.setId(1);
	    reserve.setCustomerName(getName());
	    reserve.setResturantName(nameRR);
	    reserve.setnOFtables(tableN);
	    reserve.setnOFchairs(chairN);
	    reserve.setDate(date);
	    reserve.setTime(time);
		
	    reserveDAO.saveReservation(reserve);
	    
		return "home";
	}


	@RequestMapping(value = "/serve", method = RequestMethod.GET)
	public String serve(@RequestParam String  name ,ModelMap model ) {
	 
		model.addAttribute("namee", name);
		
		return "reserve";
	}
	
	

	@RequestMapping(value = "/reservations", method = RequestMethod.GET)
	public String reservations(Model model) {
	 
		if(islogged())
		{
			
			String name = getName();
			List<reservation>reservations=reserveDAO.getAllreservation(name);
			model.addAttribute("reservations",reservations);
			System.out.println(reservations);
			
			return "reservations";
			
			
		}
		else
		{
			return "login";
		}
	}
	

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam int id ,Model model) {
	 
		reservation reserve =new reservation();
		
		
		reserve=reserveDAO.getRserveById(id);
	model.addAttribute("reserve",reserve);	
		
		
		
		return "update";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatee(Model model,@RequestParam int ID,@RequestParam String CustN,@RequestParam int tableNN  , 
			@RequestParam  int  chairNN,@RequestParam  String datee ,@RequestParam  String timee,@RequestParam  String ResN) {
	 
		reservation  reserve = new reservation();
		
		reserve.setId(ID);
		reserve.setCustomerName(CustN);
		reserve.setResturantName(ResN);
		reserve.setnOFtables(tableNN);
		reserve.setnOFchairs(chairNN);
		reserve.setDate(datee);
		reserve.setTime(timee);
		
		reserveDAO.update(reserve);
		
		String name = getName();
		List<reservation>reservations=reserveDAO.getAllreservation(name);
		model.addAttribute("reservations",reservations);
		
		return "reservations";
		
		
	}
	

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam int id,Model model ) {
	
		
		
		
		reserveDAO.delete(id);
		
		
		String name = getName();
		List<reservation>reservations=reserveDAO.getAllreservation(name);
		model.addAttribute("reservations",reservations);
		
return "reservations";		

	}
	
	
	
	private String getName()
	{
       Object principal =SecurityContextHolder.getContext().getAuthentication().getPrincipal();

       if(principal instanceof UserDetails)
         {
	
	        return ((UserDetails)principal).getUsername();
         }
             return principal.toString();		
	}
	
	
	
	private boolean islogged()
	{
      Object principal =SecurityContextHolder.getContext().getAuthentication().getPrincipal();

      if(principal instanceof UserDetails)
           {
	
	          return true;
           } 
      return false ;	
	}

}
