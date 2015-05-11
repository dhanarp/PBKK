package id.sbmptn.data.dao.impl;
import id.sbmptn.domain.studi.*;
import id.sbmptn.domain.perguruantinggi.*;
import id.sbmptn.domain.programstudi.*;
import id.sbmptn.data.dao.ProgramStudiDao;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository("programstudidao")
public class HibProgramStudiDao implements ProgramStudiDao {

	private SessionFactory sessionFactory;
	public HibProgramStudiDao() {}
	@Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Transactional(readOnly = true)
	public List<ProgramStudi> list() {
		List<ProgramStudi> data =  this.getSessionFactory().getCurrentSession().createQuery("from program_studi where status_terhapus!=1")
				.list();
		return data;
	}

	public ProgramStudi findById(UUID id_program_studi) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(ProgramStudi data) {
		this.getSessionFactory().getCurrentSession().save(data);
		
	}

	public void delete(String nama_program_studi) {
		int tes=this.getSessionFactory().getCurrentSession().
				createQuery("update program_studi set status_terhapus=1 where nama_program_studi=:nama_program_studi")
				.setParameter("nama_program_studi", nama_program_studi).executeUpdate();
		
	}

	public List<ProgramStudi> findByName(String nama_program_studi) {
		List<ProgramStudi> data = this.getSessionFactory().
				getCurrentSession()
				.createQuery("from program_studi where nama_program_studi=:nama_program_studi and status_terhapus!=1")
				.setParameter("nama_program_studi", nama_program_studi)
				.list();
		return data;
	}

}
