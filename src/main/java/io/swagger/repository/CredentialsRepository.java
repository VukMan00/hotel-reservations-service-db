package io.swagger.repository;

import io.swagger.model.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialsRepository extends JpaRepository<Credentials,String> {
}
