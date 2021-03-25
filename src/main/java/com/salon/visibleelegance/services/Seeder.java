package com.salon.visibleelegance.services;

import com.salon.visibleelegance.models.Address;
import com.salon.visibleelegance.models.Business;
import com.salon.visibleelegance.models.BusinessHour;
import com.salon.visibleelegance.repos.AddressRepository;
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

    @Autowired
    private AddressRepository addressDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(Seeder.class);
    boolean seederHasRun = false;
    private Business business = new Business();

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
            business = businessDao.getFirstById(1L);
            LOGGER.info(business.getName());
        }catch (Exception e){
            Business b = new Business();
            LOGGER.info("Creating Business");
            b.setName("Visible Elegance");
            b.setOperator("Sandy Briseno");
            b.setEmail("visible-elegance@gmail.com");
            b.setPhone("(210) 924-5700");
            business = businessDao.save(b);
            Address a = new Address();
            a.setBusiness(business);
            a.setAddressLine1("2926 Pitluk Ave");
            a.setCity("San Antonio");
            a.setState("Texas");
            a.setZip("78211");
            a.setBilling(false);
            a.setPhoneNumber("(210) 924-5700");
            addressDao.save(a);
        }
    }

    public void createHours(){
        if (hourDao.count() >= 7) return;
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
