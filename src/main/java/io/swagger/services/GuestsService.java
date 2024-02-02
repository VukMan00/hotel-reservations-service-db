package io.swagger.services;

import io.swagger.exception.NotFoundException;
import io.swagger.model.Guest;
import io.swagger.model.PromoCode;
import io.swagger.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class GuestsService {

    private final GuestRepository guestRepository;

    private final PromoCodeService promoCodeService;

    @Autowired
    public GuestsService(GuestRepository guestRepository, PromoCodeService promoCodeService){
        this.guestRepository = guestRepository;
        this.promoCodeService = promoCodeService;
    }

    public Guest getGuest(String guestJMBG) throws NotFoundException{
        Optional<Guest> guest = Optional.ofNullable(guestRepository.findByJmbg(guestJMBG));
        if(guest.isPresent()) {
            return guest.get();
        }
        else{
            throw new NotFoundException(404,"Guest not found");
        }
    }

    public Guest getGuestFromUsername(String username) throws NotFoundException {
        Optional<Guest> guest = Optional.ofNullable(guestRepository.findByUsername(username));
        if(guest.isPresent()) {
            return guest.get();
        }
        else{
            throw new NotFoundException(404,"Guest not found");
        }
    }

    public List<PromoCode> getPromoCodes(String guestJMBG) throws NotFoundException{
        Guest guest = getGuest(guestJMBG);
        return promoCodeService.getGuestPromoCodes(guest);
    }

    public void saveGuest(Guest guest) throws HttpClientErrorException{
        System.out.println(guest);
        if(guestRepository.findByJmbg(guest.getJmbg())==null){
            System.out.println("USAO SAM");
            guestRepository.save(guest);
        } else{
            throw new HttpClientErrorException(HttpStatus.CONFLICT,"Guest with this JMBG already exists");
        }
    }

    public void saveGuestPromoCode(String guestJMBG, PromoCode promoCode) throws NotFoundException,HttpClientErrorException{
        Guest guest = getGuest(guestJMBG);

        promoCode.setGuest(guest);
        promoCode.getPromoCodePK().setJmbg(guestJMBG);
        promoCodeService.savePromoCode(promoCode);
    }

    public PromoCode getPromoCode(String guestJMBG, String code) throws NotFoundException {
        getGuest(guestJMBG);
        return promoCodeService.getGuestPromoCode(code);
    }

    public void delete(String guestJMBG) throws NotFoundException {
        Guest guest = getGuest(guestJMBG);
        guestRepository.delete(guest);
    }
}
