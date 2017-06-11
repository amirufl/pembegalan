package pembegalan.repository;

import pembegalan.repository.LokasiRepository;
import pembegalan.entity.Lokasi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LokasiRepositoryTest {
    
    @Autowired
    private LokasiRepository lokasiRepository;
    
    @Test
    @Transactional
    public void testTambahDataLokasi() {
        Lokasi b = new Lokasi("Banjar", "Selasa", "Siang");
        lokasiRepository.save(b);
        Lokasi lokasi = this.lokasiRepository.findByKota("Banjar");
        assertThat(lokasi.getHari()).isEqualTo("Selasa");
        assertThat(lokasi.getWaktu()).isEqualTo("Siang");
    }
}
