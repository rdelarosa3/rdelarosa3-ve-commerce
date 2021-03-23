package com.salon.visibleelegance.services;

import com.salon.visibleelegance.models.Business;
import com.salon.visibleelegance.repos.BusinessRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class Seeder {
    @Autowired
    private BusinessRepository businessDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(Seeder.class);
    boolean seederHasRun = false;

    @EventListener
    public void eventListener(ApplicationStartedEvent event){

        if(!seederHasRun) {
            LOGGER.info("Start Seeding");
            LOGGER.info("SEEDING BUSINESS");
            createBusiness();
        }
    }
    public void createBusiness(){
        try{
            Business business = businessDao.getFirstById(1L);
            LOGGER.info(business.getName());
        }catch (Exception e){
            LOGGER.info("Creating Business");
            Business business = new Business();
            business.setName("Visible Elegance");
            business.setOperator("Sandy Briseno");
            business.setEmail("visible-elegance@gmail.com");
            business.setPhone("(210) 924-5700");
            businessDao.save(business);
        }
    }
}
