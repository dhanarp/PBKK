package id.sbmptn.data.dao.impl;

import id.sbmptn.data.dao.BidangProgramStudiDao;
import id.sbmptn.domain.studi.BidangProgramStudi;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository("bidangprogramstudidao")

public class HibBidangProgramStudiDao implements BidangProgramStudiDao{

	private SessionFactory sessionFactory;
	
	
	public HibBidangProgramStudiDao() {}
	@Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Transactional(readOnly = true)
	public List<BidangProgramStudi> list() {
		//String query="select id_bidang_program_studi,nama_bidang_program_studi,status_terhapus from bidang_program_studi";
		List<BidangProgramStudi> data=this.getSessionFactory()
				.getCurrentSession()
				.createQuery("from bidang_program_studi where status_terhapus!=1")
				.list();
		return data;
	}

	public BidangProgramStudi findById(UUID Id) {
		//throw new UnsupportedOperationException("Not supported yet.");
		return null;
	}

	public void save(BidangProgramStudi data) {
		this.getSessionFactory().getCurrentSession().save(data);
		
	}
	
	
	public void delete(String nama_bidang_program_studi) {
		
		int tes=this.getSessionFactory().getCurrentSession().
				createQuery("update bidang_program_studi set status_terhapus=1 where nama_bidang_program_studi=:nama_bidang_program_studi")
				.setParameter("nama_bidang_program_studi", nama_bidang_program_studi).executeUpdate();
		//System.out.println(tes);
	}
	
	
	@Transactional(readOnly=true)
	public List<BidangProgramStudi> findByName(String nama_bidang_program_studi) {
		//String query = "select id_bidang_program_Studi,nama_bidang_program_studi from bidang_program_Studi where nama_bidang_program_studi=" + nama_bidang_program_studi + " and status_terhapus!=1";
		List<BidangProgramStudi> data = this.getSessionFactory().
				getCurrentSession()
				.createQuery("from bidang_program_studi where nama_bidang_program_studi=:nama_bidang_program_studi  and status_terhapus!=1")
				.setParameter("nama_bidang_program_studi", nama_bidang_program_studi)
				.list();
		return data;
	}
	

}
