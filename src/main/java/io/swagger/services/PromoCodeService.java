package io.swagger.services;

import io.swagger.exception.NotFoundException;
import io.swagger.model.Guest;
import io.swagger.model.PromoCode;
import io.swagger.repository.PromoCodeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class PromoCodeService {

    private final PromoCodeRepository promoCodeRepository;

    public PromoCodeService(PromoCodeRepository promoCodeRepository){
        this.promoCodeRepository = promoCodeRepository;
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
        if(promoCodeRepository.findPromoCodeByPromoCodePK(promoCode.getPromoCodePK())==null) {
            promoCodeRepository.save(promoCode);
        }else{
            throw new HttpClientErrorException(HttpStatus.CONFLICT,"PromoCode with this primary Key already exists");
        }
    }
}
