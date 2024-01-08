package io.swagger.services;

import io.swagger.exception.NotFoundException;
import io.swagger.model.Guest;
import io.swagger.model.PromoCode;
import io.swagger.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<PromoCode> getPromoCodes(String guestJMBG) throws NotFoundException{
        Guest guest = getGuest(guestJMBG);
        return promoCodeService.getGuestPromoCodes(guest);
    }

    public void saveGuest(Guest guest){
        guestRepository.save(guest);
    }

    public void saveQuestPromoCode(String guestJMBG, PromoCode promoCode) throws NotFoundException{
        Guest guest = getGuest(guestJMBG);

        promoCode.setGuest(guest);
        promoCode.getPromoCodePK().setJmbg(guestJMBG);

        promoCodeService.savePromoCode(promoCode);
    }

}
