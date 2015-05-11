package id.sbmptn.data.dao;

import java.util.List;
import java.util.UUID;

import id.sbmptn.domain.pesertadidik.*;

public interface PesertaDidikDao {
	public List<PesertaDidik> list();
	public PesertaDidik findById(UUID id_peserta_didik);
	public void save(PesertaDidik data);
	public void delete(String nama_peserta_didik);
	public List<PesertaDidik> findByName(String nama_peserta_didik);
}
