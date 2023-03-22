package springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.Entities.CustomerEntity;

import java.util.UUID;

/**
 * @Created 22 03 2023 - 4:14 PM
 * @Author Hazeem Hassan
 */
public interface CustomerRepositoryS9 extends JpaRepository<CustomerEntity, UUID> {
}
