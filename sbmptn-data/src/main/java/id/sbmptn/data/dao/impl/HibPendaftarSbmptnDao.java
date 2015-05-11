package id.sbmptn.data.dao.impl;
import id.sbmptn.domain.pendafarsbmptn.*;
import id.sbmptn.domain.programstudi.ProgramStudi;
import id.sbmptn.data.dao.PendaftarSbmptnDao;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository("pendaftarsbmptndao")
public class HibPendaftarSbmptnDao implements PendaftarSbmptnDao {

	private SessionFactory sessionFactory;
	public HibPendaftarSbmptnDao() {}
	@Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Transactional(readOnly = true)
	public List<PendaftarSbmptn> list() {
		List<PendaftarSbmptn> data =  this.getSessionFactory().getCurrentSession().createQuery("from pendaftar_sbmptn where status_terhapus!=1")
				.list();
		return data;
	}

	public List<PendaftarSbmptn> findById(UUID id_pendaftar_sbmptn) {
		List<PendaftarSbmptn> data = this.getSessionFactory().
				getCurrentSession()
				.createQuery("from pendaftar_sbmptn where id_pendaftar_sbmptn=:id_pendaftar_sbmptn and status_terhapus!=1")
				.setParameter("id_pendaftar_sbmptn", id_pendaftar_sbmptn)
				.list();
		return data;
	}

	public void save(PendaftarSbmptn data) {
		this.getSessionFactory().getCurrentSession().save(data);
		
	}
	
}
