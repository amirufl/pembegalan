package pembegalan.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pembegalan.entity.Lokasi;

public interface LokasiRepository extends PagingAndSortingRepository<Lokasi, Integer>{
    
    Lokasi findByKota(String kota);
}
