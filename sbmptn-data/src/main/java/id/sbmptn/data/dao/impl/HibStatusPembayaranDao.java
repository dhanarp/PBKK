package id.sbmptn.data.dao.impl;
import id.sbmptn.domain.hasilseleksi.*;
import id.sbmptn.domain.jurusan12.Jurusan;
import id.sbmptn.domain.statuspembayaran.StatusPembayaran;
import id.sbmptn.data.dao.StatusPembayaranDao;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository("statuspembayarandao")

public class HibStatusPembayaranDao implements StatusPembayaranDao {

private SessionFactory sessionFactory;
	
	public HibStatusPembayaranDao() {}
	@Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Transactional(readOnly = true)
	public List<StatusPembayaran> list() {
		List<StatusPembayaran> data =  this.getSessionFactory().getCurrentSession().createQuery("from status_pembayaran where status_terhapus!=1")
				.list();
		return data;
	}

	public StatusPembayaran findById(UUID id_status_pembayaran) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(StatusPembayaran data) {
		// TODO Auto-generated method stub
		this.getSessionFactory().getCurrentSession().save(data);
	}

	public void delete(String nama_status_pembayaran) {
		// TODO Auto-generated method stub
		int tes=this.getSessionFactory().getCurrentSession().
				createQuery("update status_pembayaran set status_terhapus=1 where nama_status_pembayaran=:nama_status_pembayaran")
				.setParameter("nama_status_pembayaran", nama_status_pembayaran).executeUpdate();
	}

	public List<StatusPembayaran> findByName(String nama_status_pembayaran) {
		List<StatusPembayaran> data = this.getSessionFactory().
				getCurrentSession()
				.createQuery("from status_pembayaran where nama_status_pembayaran=:nama_status_pembayaran and status_terhapus!=1")
				.setParameter("nama_status_pembayaran", nama_status_pembayaran)
				.list();
		return data;
	}
	

}
