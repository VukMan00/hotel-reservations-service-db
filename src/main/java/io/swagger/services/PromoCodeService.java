package io.swagger.services;

import io.swagger.exception.NotFoundException;
import io.swagger.model.Guest;
import io.swagger.model.PromoCode;
import io.swagger.repository.PromoCodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromoCodeService {

    private final PromoCodeRepository promoCodeRepository;

    public PromoCodeService(PromoCodeRepository promoCodeRepository){
        this.promoCodeRepository = promoCodeRepository;
    }

    public List<PromoCode> getAll(){
        return promoCodeRepository.findAll();
    }

    public List<PromoCode> getGuestPromoCodes(Guest guest) throws NotFoundException {
        List<PromoCode> promoCodes = promoCodeRepository.findByPromoCodePK_Jmbg(guest.getJmbg());
        if(!promoCodes.isEmpty()){
            return promoCodes;
        }
        else{
            throw new NotFoundException(404,"Promo Codes not found for Guest: " + guest);
        }
    }

    public void savePromoCode(PromoCode promoCode){
        promoCodeRepository.save(promoCode);
    }
}
