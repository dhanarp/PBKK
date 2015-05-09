package id.sbmptn.data.dao;

import java.util.List;
import java.util.UUID;
import id.sbmptn.domain.jurusan12.Jurusan;
public interface JurusanDao {
	public List<Jurusan> list();
	public Jurusan findById(UUID id_jurusan);
	public void save(Jurusan data);
	public void delete(String nama_jurusan);
	public List<Jurusan> findByName(String nama_jurusan);
	
}
