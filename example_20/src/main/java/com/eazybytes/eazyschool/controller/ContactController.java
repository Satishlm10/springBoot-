package com.eazybytes.eazyschool.controller;

import com.eazybytes.eazyschool.model.ContactDto;
import com.eazybytes.eazyschool.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ContactController {
    private static Logger log = LoggerFactory.getLogger(ContactController.class);
    @Autowired
    private ContactService contactService;

    @RequestMapping("/contact")
    public String displayContact(){
        return "contact.html";
    }
    /* using RequestParam
    @RequestMapping(value = "/saveMsg",method = RequestMethod.POST)
    public ModelAndView saveMessage(@RequestParam String name,@RequestParam String mobileNum,@RequestParam String email
            ,@RequestParam String subject,@RequestParam String message){
        log.info("Name:"+ name);
        log.info("Mobile Number:"+ mobileNum);
        log.info("Email:"+ email);
        log.info("Subject:"+ subject);
        log.info("Message:"+ message);
        return new ModelAndView("redirect:/contact");
    }

     */

    @RequestMapping(value = "/saveMsg",method = RequestMethod.POST)
    public ModelAndView saveMessage( ContactDto contact) {
         contactService.saveMessageDetails(contact);
        return new ModelAndView("redirect:/contact");
    }

}
