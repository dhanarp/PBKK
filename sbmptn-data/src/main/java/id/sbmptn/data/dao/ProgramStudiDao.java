package id.sbmptn.data.dao;
import id.sbmptn.domain.studi.*;
import id.sbmptn.domain.perguruantinggi.*;
import id.sbmptn.domain.programstudi.*;

import java.util.List;
import java.util.UUID;
public interface ProgramStudiDao {
	public List<ProgramStudi> list();
	public ProgramStudi findById(UUID id_program_studi);
	public void save(ProgramStudi data);
	public void delete(String nama_program_studi);
	public List<ProgramStudi> findByName(String nama_program_studi);


}
