package id.sbmptn.domain.studi;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity(name="bidang_program_studi")
@Table(name="bidang_program_studi")
public class BidangProgramStudi {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name="id_bidang_program_studi",nullable=false)
	private UUID id_bidang_program_studi;
	
	@Column(name="nama_bidang_program_studi",nullable=false)
	private String nama_bidang_program_studi;
	
	@Column(name="status_terhapus",nullable=false)
	private int status_terhapus;

	public BidangProgramStudi() {
	}

	public BidangProgramStudi(String nama_bidang_program_studi) {
		this.setNama_bidang_program_studi(nama_bidang_program_studi);
		this.setStatus_terhapus(0);
	}

	public UUID getId_bidang_program_studi() {
		return id_bidang_program_studi;
	}

	public void setId_bidang_program_studi(UUID id_bidang_program_studi) {
		this.id_bidang_program_studi = id_bidang_program_studi;
	}
                         
	public String getNama_bidang_program_studi() {
		return nama_bidang_program_studi;
	}

	public void setNama_bidang_program_studi(String nama_bidang_program_studi) {
		this.nama_bidang_program_studi = nama_bidang_program_studi;
	}

	public int getStatus_terhapus() {
		return status_terhapus;
	}

	public void setStatus_terhapus(int status_terhapus) {
		this.status_terhapus = status_terhapus;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bidang_program_Studi [id=");
		builder.append(id_bidang_program_studi);
		builder.append(", Nama_bidang_Program_Studi=");
		builder.append(nama_bidang_program_studi);
		builder.append(", status_terhapus=");
		builder.append(status_terhapus);
		builder.append("]");
		return builder.toString();
	}
	

}
