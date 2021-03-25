package com.salon.visibleelegance.services;

import com.salon.visibleelegance.models.Business;
import com.salon.visibleelegance.models.BusinessHour;
import com.salon.visibleelegance.repos.BuisnessHourRepository;
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

    @Autowired
    private BuisnessHourRepository hourDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(Seeder.class);
    boolean seederHasRun = false;

    @EventListener
    public void eventListener(ApplicationStartedEvent event){

        if(!seederHasRun) {
            LOGGER.info("Start Seeding");
            LOGGER.info("SEEDING BUSINESS");
            createBusiness();
            createHours();
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

    public void createHours(){
        System.err.println(hourDao.count());
        if (hourDao.count() >= 7) return;
        Business business = businessDao.getFirstById(1L);
        for ( int i = 1; i <=7; i++ ){
            BusinessHour bhour = new BusinessHour();
            bhour.setBusiness(business);
            switch (i){
                case 1:
                    bhour.setDay("Monday");
                    break;
                case 2:
                    bhour.setDay("Tuesday");
                    break;
                case 3:
                    bhour.setDay("Wednesday");
                    break;
                case 4:
                    bhour.setDay("Thursday");
                    break;
                case 5:
                    bhour.setDay("Friday");
                    break;
                case 6:
                    bhour.setDay("Saturday");
                    break;
                case 7:
                    bhour.setDay("Sunday");
                    break;
                default:
                    break;
            }
            hourDao.save(bhour);
        }
    }
}
