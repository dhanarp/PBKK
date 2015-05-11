package id.sbmptn.data.dao.impl;

import id.sbmptn.domain.jurusan12.Jurusan;
import id.sbmptn.data.dao.JurusanDao;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository("jurusandao")

public class HibJurusanDao implements JurusanDao {

	private SessionFactory sessionFactory;
	
	public HibJurusanDao() {}
	@Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Transactional(readOnly = true)
	public List<Jurusan> list() {
		List<Jurusan> data =  this.getSessionFactory().getCurrentSession().createQuery("from jurusan where status_terhapus!=1")
				.list();
		return data;
	}

	public Jurusan findById(UUID id_jurusan) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Jurusan data) {
		this.getSessionFactory().getCurrentSession().save(data);
		
	}

	public void delete(String nama_jurusan) {
		int tes=this.getSessionFactory().getCurrentSession().
				createQuery("update jurusan set status_terhapus=1 where nama_jurusan=:nama_jurusan")
				.setParameter("nama_jurusan", nama_jurusan).executeUpdate();
		
	}
	@Transactional(readOnly = true)
	public List<Jurusan> findByName(String nama_jurusan) {
		List<Jurusan> data = this.getSessionFactory().
				getCurrentSession()
				.createQuery("from jurusan where nama_jurusan=:nama_jurusan and status_terhapus!=1")
				.setParameter("nama_jurusan", nama_jurusan)
				.list();
		return data;
	}

}
