package id.sbmptn.data.dao.impl;
import java.util.List;
import java.util.UUID;

import id.sbmptn.domain.jurusan12.Jurusan;
import id.sbmptn.domain.pesertadidik.PesertaDidik;
import id.sbmptn.data.dao.PesertaDidikDao;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository("pesertadidikdao")
public class HibPesertaDidikDao  implements PesertaDidikDao {

private SessionFactory sessionFactory;
	
	public HibPesertaDidikDao() {}
	@Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Transactional(readOnly = true)
	public List<PesertaDidik> list() {
		List<PesertaDidik> data =  this.getSessionFactory().getCurrentSession().createQuery("from peserta_didik where status_terhapus!=1")
				.list();
		return data;
	}

	public PesertaDidik findById(UUID id_peserta_didik) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(PesertaDidik data) {
		this.getSessionFactory().getCurrentSession().save(data);
		
	}

	public void delete(String nama_peserta_didik) {
		int tes=this.getSessionFactory().getCurrentSession().
				createQuery("update peserta_didik set status_terhapus=1 where nama_peserta_didik=:nama_peserta_didik")
				.setParameter("nama_peserta_didik", nama_peserta_didik).executeUpdate();
		
	}
	@Transactional(readOnly = true)
	public List<PesertaDidik> findByName(String nama_peserta_didik) {
		List<PesertaDidik> data = this.getSessionFactory().
				getCurrentSession()
				.createQuery("from peserta_didik where nama_peserta_didik=:nama_peserta_didik and status_terhapus!=1")
				.setParameter("nama_peserta_didik", nama_peserta_didik)
				.list();
		return data;
	}
}
