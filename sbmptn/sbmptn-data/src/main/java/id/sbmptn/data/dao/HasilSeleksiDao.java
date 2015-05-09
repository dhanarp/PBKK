package id.sbmptn.data.dao;

import java.util.List;
import java.util.UUID;

import id.sbmptn.domain.hasilseleksi.*;

public interface HasilSeleksiDao {
	public List<HasilSeleksi> list();
	public HasilSeleksi findById(UUID id_hasil_seleksi);
	public void save(HasilSeleksi data);
	public void delete(String nama_hasil_seleksi);
	public List<HasilSeleksi> findByName(String nama_hasil_seleksi);
}
