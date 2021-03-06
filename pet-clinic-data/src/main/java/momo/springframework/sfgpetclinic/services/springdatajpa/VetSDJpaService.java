package momo.springframework.sfgpetclinic.services.springdatajpa;

import momo.springframework.sfgpetclinic.model.Speciality;
import momo.springframework.sfgpetclinic.model.Vet;
import momo.springframework.sfgpetclinic.repositories.VetRepository;
import momo.springframework.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;
    private final SpecialitySDJpaService specialitySDJpaService;

    public VetSDJpaService(VetRepository vetRepository, SpecialitySDJpaService specialitySDJpaService) {
        this.vetRepository = vetRepository;
        this.specialitySDJpaService = specialitySDJpaService;
    }

    @Override
    public Set<Vet> findAll() {
        //TODO: Add speciality service
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);

        return vets;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        Vet result = null;

        if (0 < object.getSpecialities().size()) {
            object.getSpecialities().forEach(speciality -> {
                if (null == speciality.getId()) {
                    Speciality saveSpeciality = specialitySDJpaService.save(speciality);
                    speciality.setId(saveSpeciality.getId());
                }
            });

            result = vetRepository.save(object);
        }

        return result;
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
