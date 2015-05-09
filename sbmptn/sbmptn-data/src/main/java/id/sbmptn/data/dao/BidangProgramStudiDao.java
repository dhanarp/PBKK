package id.sbmptn.data.dao;

import id.sbmptn.domain.studi.BidangProgramStudi;

import java.util.List;
import java.util.UUID;

public interface BidangProgramStudiDao {
	public List<BidangProgramStudi> list();
	public BidangProgramStudi findById(UUID id_bidang_program_studi);
	public void save(BidangProgramStudi data);
	public void delete(String nama_bidang_program_studi);
	public List<BidangProgramStudi> findByName(String nama_bidang_program_studi);
	
}
