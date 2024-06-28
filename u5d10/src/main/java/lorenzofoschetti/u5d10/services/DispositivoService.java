package lorenzofoschetti.u5d10.services;

import lorenzofoschetti.u5d10.entities.Dispositivo;
import lorenzofoschetti.u5d10.exceptions.NotFoundException;
import lorenzofoschetti.u5d10.payloads.NewDispositivoPayload;
import lorenzofoschetti.u5d10.repositories.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    @Autowired
    private DipendenteService dipendenteService;


    public Dispositivo save(NewDispositivoPayload body) {

        Dispositivo nuovoDispositivo = new Dispositivo(body.type(), body.state(), null);
        return dispositivoRepository.save(nuovoDispositivo);
    }

    public Dispositivo findDispositivoById(UUID id) {
        return dispositivoRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }


    public Page<Dispositivo> getDispositiviList(int page, int size, String sortBy) {
        if (size > 20) size = 20;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return dispositivoRepository.findAll(pageable);
    }
}
