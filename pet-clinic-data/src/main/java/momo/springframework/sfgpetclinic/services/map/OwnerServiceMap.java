package momo.springframework.sfgpetclinic.services.map;

import momo.springframework.sfgpetclinic.model.Owner;
import momo.springframework.sfgpetclinic.model.Pet;
import momo.springframework.sfgpetclinic.services.OwnerService;
import momo.springframework.sfgpetclinic.services.PetService;
import momo.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        Owner result;

        if (null != owner) {
            if (null != owner.getPets()) {
                owner.getPets().forEach(pet -> {
                    if (null != pet.getPetType()) {
                        if (null == pet.getPetType().getId()) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if (null == pet.getId()) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }

            result =  super.save(owner);
        } else {
            result = null;
        }

        return result;
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
