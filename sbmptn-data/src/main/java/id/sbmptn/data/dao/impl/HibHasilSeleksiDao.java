package id.sbmptn.data.dao.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import id.sbmptn.domain.hasilseleksi.*;
import id.sbmptn.domain.jurusan12.Jurusan;
import id.sbmptn.data.dao.HasilSeleksiDao;
@Transactional
@Repository("hasilseleksidao")
public class HibHasilSeleksiDao  implements HasilSeleksiDao{

private SessionFactory sessionFactory;
	
	public HibHasilSeleksiDao() {}
	@Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Transactional(readOnly = true)
	public List<HasilSeleksi> list() {
		List<HasilSeleksi> data =  this.getSessionFactory().getCurrentSession().createQuery("from hasil_seleksi where status_terhapus!=1")
				.list();
		return data;
	}

	public HasilSeleksi findById(UUID id_hasil_seleksi) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(HasilSeleksi data) {
		// TODO Auto-generated method stub
		this.getSessionFactory().getCurrentSession().save(data);
	}

	public void delete(String nama_hasil_seleksi) {
		// TODO Auto-generated method stub
		int tes=this.getSessionFactory().getCurrentSession().
				createQuery("update hasil_seleksi set status_terhapus=1 where nama_hasil_seleksi=:nama_hasil_seleksi")
				.setParameter("nama_hasil_seleksi", nama_hasil_seleksi).executeUpdate();
	}

	public List<HasilSeleksi> findByName(String nama_hasil_seleksi) {
		// TODO Auto-generated method stub
		List<HasilSeleksi> data = this.getSessionFactory().
				getCurrentSession()
				.createQuery("from hasil_seleksi where nama_hasil_seleksi=:nama_hasil_seleksi and status_terhapus!=1")
				.setParameter("nama_hasil_seleksi",nama_hasil_seleksi)
				.list();
		return data;
	}

}
