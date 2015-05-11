package id.sbmptn.data.dao;
import java.util.List;
import java.util.UUID;


import id.sbmptn.domain.pendafarsbmptn.PendaftarSbmptn;

public interface PendaftarSbmptnDao {
	public List<PendaftarSbmptn> list();
	public List<PendaftarSbmptn> findById(UUID id_pendaftar_sbmptn);
	public void save(PendaftarSbmptn data);
	//public List<PendaftarSbmptn> findByName(String nama_program_studi);

}
