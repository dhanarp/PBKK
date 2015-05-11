package id.sbmptn.data.dao.impl;
import id.sbmptn.domain.wilayah.*;
import id.sbmptn.domain.panitialokal.*;

import id.sbmptn.data.dao.PanitiaLokalDao;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository("panitialokaldao")
public class HibPanitiaLokalDao implements PanitiaLokalDao {

private SessionFactory sessionFactory;
	
	public HibPanitiaLokalDao() {}
	@Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Transactional(readOnly = true)
	public List<PanitiaLokal> list() {
		List<PanitiaLokal> data =  this.getSessionFactory().getCurrentSession().createQuery("from panitia_lokal where status_terhapus!=1")
				.list();
		return data;
	}

	public PanitiaLokal findById(UUID id_panitia_lokal) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(PanitiaLokal data) {
		this.getSessionFactory().getCurrentSession().save(data);
		
	}

	public void delete(String alamat_panitia_lokal) {
		int tes=this.getSessionFactory().getCurrentSession().
				createQuery("update panitia_lokal set status_terhapus=1 where alamat_panitia_lokal=:alamat_panitia_lokal")
				.setParameter("alamat_panitia_lokal", alamat_panitia_lokal).executeUpdate();
		
	}

	public List<PanitiaLokal> findByName(String alamat_panitia_lokal) {
		List<PanitiaLokal> data = this.getSessionFactory().
				getCurrentSession()
				.createQuery("from panitia_lokal where  alamat_panitia_lokal=:alamat_panitia_lokal and status_terhapus!=1")
				.setParameter("alamat_panitia_lokal", alamat_panitia_lokal)
				.list();
		return data;
	}

}
