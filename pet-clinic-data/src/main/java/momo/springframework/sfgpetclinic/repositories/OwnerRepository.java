package momo.springframework.sfgpetclinic.repositories;

import momo.springframework.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    public Owner findByLastName(String lastName);
}
