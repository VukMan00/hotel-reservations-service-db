package io.swagger.services;

import io.swagger.exception.NotFoundException;
import io.swagger.model.Credentials;
import io.swagger.model.Guest;
import io.swagger.model.PromoCode;
import io.swagger.repository.CredentialsRepository;
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

    private final CredentialsRepository credentialsRepository;

    @Autowired
    public GuestsService(GuestRepository guestRepository, PromoCodeService promoCodeService, CredentialsRepository credentialsRepository){
        this.guestRepository = guestRepository;
        this.promoCodeService = promoCodeService;
        this.credentialsRepository = credentialsRepository;
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

    public void saveGuest(Guest guest) throws HttpClientErrorException{
        Credentials credentials = guest.getCredentials();
        if(credentialsRepository.findByUsername(credentials.getUsername())==null){
            if(guestRepository.findByJmbg(guest.getJmbg())==null){
                credentialsRepository.save(guest.getCredentials());
                guestRepository.save(guest);
            } else{
                throw new HttpClientErrorException(HttpStatus.CONFLICT,"Guest with this JMBG already exists");
            }
        }else{
            throw new HttpClientErrorException(HttpStatus.CONFLICT,"Credentials with this username already exists");
        }

    }

    public void saveQuestPromoCode(String guestJMBG, PromoCode promoCode) throws NotFoundException,HttpClientErrorException{
        Guest guest = getGuest(guestJMBG);

        promoCode.setGuest(guest);
        promoCode.getPromoCodePK().setJmbg(guestJMBG);

        promoCodeService.savePromoCode(promoCode);
    }

}
