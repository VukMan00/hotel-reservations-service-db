package io.swagger.repository;

import io.swagger.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest,String> {

    Guest findByJmbg(String jmbg);

    Guest findByUsername(String username);
}
