package id.sbmptn.data.dao;
import java.util.List;
import java.util.UUID;

import id.sbmptn.domain.panitialokal.*;
import id.sbmptn.domain.lokasiujian.*;

public interface LokasiUjianDao {
	public List<LokasiUjian> list();
	public LokasiUjian findById(UUID id_lokasi_ujian);
	public void save(LokasiUjian data);
	public void delete(String alamat_lokasi_ujian);
	public List<LokasiUjian> findByName(String alamat_lokasi_ujian);

}
