package id.sbmptn.data.dao;

import java.util.List;
import java.util.UUID;
import id.sbmptn.domain.wilayah.*;
public interface WilayahDao {
	public List<Wilayah> list();
	public Wilayah findById(UUID id_wilayah);
	public void save(Wilayah data);
	public void delete(String nomor_wilayah);
	public List<Wilayah> findByName(String nomor_wilayah);
	
}
