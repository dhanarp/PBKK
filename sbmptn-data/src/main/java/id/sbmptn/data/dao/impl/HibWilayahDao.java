package id.sbmptn.data.dao.impl;

import java.util.List;
import java.util.UUID;

import id.sbmptn.domain.jurusan12.Jurusan;
import id.sbmptn.domain.statuspembayaran.StatusPembayaran;
import id.sbmptn.domain.wilayah.*;
import id.sbmptn.data.dao.WilayahDao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository("wilayahdao")

public class HibWilayahDao implements WilayahDao {

	private SessionFactory sessionFactory;
	
	public HibWilayahDao() {}
	@Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Transactional(readOnly = true)
	public List<Wilayah> list() {
		List<Wilayah> data =  this.getSessionFactory().getCurrentSession().createQuery("from wilayah where status_terhapus!=1")
				.list();
		return data;
	}

	public Wilayah findById(UUID id_wilayah) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Wilayah data) {
		this.getSessionFactory().getCurrentSession().save(data);
		
	}

	public void delete(String nomor_wilayah) {
		int tes=this.getSessionFactory().getCurrentSession().
				createQuery("update wilayah set status_terhapus=1 where nomor_wilayah=:nomor_wilayah")
				.setParameter("nomor_wilayah", nomor_wilayah).executeUpdate();
		
	}
	@Transactional(readOnly = true)
	public List<Wilayah> findByName(String nomor_wilayah) {
		List<Wilayah> data = this.getSessionFactory().
				getCurrentSession()
				.createQuery("from wilayah where nomor_wilayah=:nomor_wilayah and status_terhapus!=1")
				.setParameter("nomor_wilayah", nomor_wilayah)
				.list();
		return data;
	}

}
