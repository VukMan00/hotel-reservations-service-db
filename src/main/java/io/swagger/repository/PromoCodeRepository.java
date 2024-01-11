package io.swagger.repository;

import io.swagger.model.PromoCode;
import io.swagger.model.PromoCodePK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromoCodeRepository extends JpaRepository<PromoCode, PromoCodePK> {

    PromoCode findPromoCodeByPromoCodePK(PromoCodePK promoCodePK);
    List<PromoCode> findByPromoCodePK_Jmbg(String jmbg);
}
