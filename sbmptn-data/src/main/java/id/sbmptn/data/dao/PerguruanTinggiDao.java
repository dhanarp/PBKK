package id.sbmptn.data.dao;

import java.util.List;
import java.util.UUID;

import id.sbmptn.domain.perguruantinggi.*;

public interface PerguruanTinggiDao {
	public List<PerguruanTinggi> list();
	public PerguruanTinggi findById(UUID id_perguruan_tinggi);
	public void save(PerguruanTinggi data);
	public void delete(String nama_perguruan_tinggi);
	public List<PerguruanTinggi> findByName(String nama_perguruan_tinggi);
}
