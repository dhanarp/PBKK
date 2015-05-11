package id.sbmptn.data.dao;
import java.util.List;
import java.util.UUID;

import id.sbmptn.domain.wilayah.*;

import id.sbmptn.domain.panitialokal.*;

public interface PanitiaLokalDao {
	public List<PanitiaLokal> list();
	public PanitiaLokal findById(UUID id_panitia_lokal);
	public void save(PanitiaLokal data);
	public void delete(String alamat_panitia_lokal);
	public List<PanitiaLokal> findByName(String alamat_panitia_lokal);
}
