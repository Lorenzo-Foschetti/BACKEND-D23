package lorenzofoschetti.u5d10.services;

import lorenzofoschetti.u5d10.entities.Dipendente;
import lorenzofoschetti.u5d10.exceptions.BadRequestException;
import lorenzofoschetti.u5d10.payloads.NewDipendentePayload;
import lorenzofoschetti.u5d10.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    public Page<Dipendente> getDipendentiList(int pageNumber, int pageSize, String sortBy) {
        if (pageSize > 20) pageSize = 20;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        return dipendenteRepository.findAll(pageable);
    }

    public Dipendente save(NewDipendentePayload body) {

        this.dipendenteRepository.findByEmail(body.email()).ifPresent(

                user -> {
                    throw new BadRequestException("L'email " + body.email() + " è già in uso!");
                }
        );


        Dipendente newDipendente = new Dipendente(body.name(), body.surname(), body.username(), body.email());

        newDipendente.setAvatar("https://ui-avatars.com/api/?name=" + body.name() + "+" + body.surname());


        return dipendenteRepository.save(newDipendente);
    }
}
