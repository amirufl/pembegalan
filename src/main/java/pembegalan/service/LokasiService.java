package pembegalan.service;

import pembegalan.entity.Lokasi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pembegalan.repository.LokasiRepository;

@Service
public class LokasiService {

    @Autowired
    LokasiRepository lokasiRepository;

    public Iterable<Lokasi> findAll() {
        return lokasiRepository.findAll();
    }

    public Page<Lokasi> findAll(Pageable pageable) {
        return lokasiRepository.findAll(pageable);
    }
    
    public Lokasi findOne(Integer id) {
        return lokasiRepository.findOne(id);
    }

    public void save(Lokasi lokasi) {
        lokasiRepository.save(lokasi);
    }

    public void delete(Integer id) {
        lokasiRepository.delete(id);
    }

}
