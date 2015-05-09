package id.sbmptn.data.dao;


import id.sbmptn.domain.statuspembayaran.*;

import java.util.List;
import java.util.UUID;
public interface StatusPembayaranDao {
	public List<StatusPembayaran> list();
	public StatusPembayaran findById(UUID id_status_pembayaran);
	public void save(StatusPembayaran data);
	public void delete(String nama_status_pembayaran);
	public List<StatusPembayaran> findByName(String nama_status_pembayaran);
}
