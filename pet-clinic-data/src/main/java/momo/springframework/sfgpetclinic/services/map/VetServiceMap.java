package momo.springframework.sfgpetclinic.services.map;

import momo.springframework.sfgpetclinic.model.Speciality;
import momo.springframework.sfgpetclinic.model.Vet;
import momo.springframework.sfgpetclinic.services.SpecialityService;
import momo.springframework.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        Vet result = null;

        if (0 < vet.getSpecialities().size()) {
            vet.getSpecialities().forEach(speciality -> {
                if (null == speciality.getId()) {
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });

            result = super.save(vet);
        }

        return result;
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
