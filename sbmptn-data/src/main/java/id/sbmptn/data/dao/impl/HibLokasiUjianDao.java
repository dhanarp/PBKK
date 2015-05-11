package id.sbmptn.data.dao.impl;
import java.util.List;
import java.util.UUID;

import id.sbmptn.domain.panitialokal.*;
import id.sbmptn.domain.lokasiujian.*;
import id.sbmptn.data.dao.LokasiUjianDao;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository("lokasiujiandao")

public class HibLokasiUjianDao  implements LokasiUjianDao{

private SessionFactory sessionFactory;
	
	public HibLokasiUjianDao() {}
	@Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Transactional(readOnly = true)
	public List<LokasiUjian> list() {
		List<LokasiUjian> data =  this.getSessionFactory().getCurrentSession().createQuery("from lokasi_ujian where status_terhapus!=1")
				.list();
		return data;
	}

	public LokasiUjian findById(UUID id_lokasi_ujian) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(LokasiUjian data) {
		this.getSessionFactory().getCurrentSession().save(data);
		
	}

	public void delete(String alamat_lokasi_ujian) {
		int tes=this.getSessionFactory().getCurrentSession().
				createQuery("update lokasi_ujian set status_terhapus=1 where alamat_lokasi_ujian=:alamat_lokasi_ujian")
				.setParameter("alamat_lokasi_ujian", alamat_lokasi_ujian).executeUpdate();
		
	}
	@Transactional(readOnly = true)
	public List<LokasiUjian> findByName(String alamat_lokasi_ujian) {
		List<LokasiUjian> data = this.getSessionFactory().
				getCurrentSession()
				.createQuery("from lokasi_ujian where alamat_lokasi_ujian=:alamat_lokasi_ujian and status_terhapus!=1")
				.setParameter("alamat_lokasi_ujian", alamat_lokasi_ujian)
				.list();
		return data;
	}

}
