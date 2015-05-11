package id.sbmptn.data.dao.impl;

import id.sbmptn.domain.wilayah.*;
import id.sbmptn.domain.perguruantinggi.*;
import id.sbmptn.data.dao.PerguruanTinggiDao;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository("perguruantinggidao")
public class HibPerguruanTinggiDao implements PerguruanTinggiDao {

private SessionFactory sessionFactory;
	
	public HibPerguruanTinggiDao() {}
	@Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Transactional(readOnly = true)
	public List<PerguruanTinggi> list() {
		List<PerguruanTinggi> data =  this.getSessionFactory().getCurrentSession().createQuery("from perguruan_tinggi where status_terhapus!=1")
				.list();
		return data;
	}

	public PerguruanTinggi findById(UUID id_perguruan_tinggi) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(PerguruanTinggi data) {
		this.getSessionFactory().getCurrentSession().save(data);
		
	}

	public void delete(String nama_perguruan_tinggi_negeri) {
		int tes=this.getSessionFactory().getCurrentSession().
				createQuery("update perguruan_tinggi set status_terhapus=1 where nama_perguruan_tinggi_negeri=:nama_perguruan_tinggi_negeri")
				.setParameter("nama_perguruan_tinggi_negeri", nama_perguruan_tinggi_negeri).executeUpdate();
		
	}
	@Transactional(readOnly = true)
	public List<PerguruanTinggi> findByName(String nama_perguruan_tinggi_negeri) {
		List<PerguruanTinggi> data = this.getSessionFactory().
				getCurrentSession()
				.createQuery("from perguruan_tinggi where nama_perguruan_tinggi_negeri=:nama_perguruan_tinggi_negeri and status_terhapus!=1")
				.setParameter("nama_perguruan_tinggi_negeri", nama_perguruan_tinggi_negeri)
				.list();
		return data;
	}

}
