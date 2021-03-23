package com.salon.visibleelegance.controllers;

import com.salon.visibleelegance.models.Business;
import com.salon.visibleelegance.repos.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class BusinessController {

    @Autowired
    private BusinessRepository businessDao;

      @GetMapping("/business")
      public String showEditBusiness(Model model) {
          Business business = businessDao.getFirstById(1L);

          model.addAttribute("business", business);
          // check if logged in user is the profile owner

          return "pos/business";
      }

    @PostMapping("/business")
    public String postEditBusiness(
            @Valid @ModelAttribute Business businessToUpdate,
            Errors validation,
            Model model) {
        // RECIPE MODEL VALIDATIONS
        Business business = businessDao.getOne(1L);
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            System.err.println(validation.getAllErrors());
            model.addAttribute("business", businessToUpdate);
            System.err.println("Page has errors");
            return "pos/business";
        }

        // ADD FIELDS TO EXISTING RECIPE
        business.setName(businessToUpdate.getName());
        business.setEmail(businessToUpdate.getEmail());
        business.setLogo(businessToUpdate.getLogo());
        business.setOperator(businessToUpdate.getOperator());
        business.setWebsite(businessToUpdate.getWebsite());
        business = businessDao.save(business);
        model.addAttribute("business", business);

        return "redirect:/";
    }
}
