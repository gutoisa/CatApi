package br.com.itau.catApi.services;

import br.com.itau.catApi.entity.BreedEntity;
import br.com.itau.catApi.exception.NotFoundException;
import br.com.itau.catApi.repository.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreedServiceImpl implements BreedService {

    //Injeção de dependencia
    @Autowired
    BreedRepository breedRepository;

    @Override
    public void save(BreedEntity breedEntity) {

        breedRepository.save(breedEntity);
    }

    @Override
    public BreedEntity findByName(String name) {
        BreedEntity allByName = breedRepository.findByName(name);

        if(allByName == null){
            throw new NotFoundException("Pesquisa não encontrada");
        }
        return allByName;

    }

    @Override
    public List findAllByTemperamentContains(String temperament) {
        List allByTemperamentContains = breedRepository.findAllByTemperamentContains(temperament);

        if(allByTemperamentContains.isEmpty()){
            throw new NotFoundException("Pesquisa não encontrada");
        }
        return allByTemperamentContains;
    }

    @Override
    public List findAllByOrigin(String origin) {
        List allByOrigin = breedRepository.findAllByOrigin(origin);

        if(allByOrigin.isEmpty()){
            throw new NotFoundException("Pesquisa não encontrada");
        }
        return allByOrigin;
    }




}
