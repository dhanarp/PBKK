package id.sbmptn.domain.programstudi;
import id.sbmptn.domain.studi.BidangProgramStudi;
import id.sbmptn.domain.perguruantinggi.*;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
@Entity(name="program_studi")
@Table(name="program_studi")
public class ProgramStudi {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name="id_program_studi",nullable=false)
	private UUID id_program_studi;
	@Column(name="kode_program_studi", nullable=false)
	private String kode_program_studi;
	@Column(name="nama_program_studi", nullable=false)
	private String nama_program_studi;
	@Column(name="daya_tampung_program_studi", nullable=false)
	private int daya_tampung_program_studi;
	@Column(name="peminat_tahun_sebelumnya_program_studi", nullable=false)
	private int peminat_tahun_sebelumnya_program_studi;
	@Column(name="kriteria_khusus_program_studi", nullable=false)
	private String kriteria_khusus_program_studi;
	@Column(name="status_terhapus", nullable=false)
	private int status_terhapus;
	@Column(name="update_terakhir", nullable=false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime update_terakhir;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_perguruan_tinggi_negeri", nullable=false)
	private PerguruanTinggi perguruantinggi;
	@ManyToOne(cascade=CascadeType.ALL)
	private BidangProgramStudi studi;
	
	public ProgramStudi(){}
	
	
	
	public ProgramStudi(String kode_program_studi,
			String nama_program_studi, int daya_tampung_program_studi,
			int peminat_tahun_sebelumnya_program_studi,
			String kriteria_khusus_program_studi) {
		this.setId_program_studi (id_program_studi);
		this.setKode_program_studi(kode_program_studi);
		this.setNama_program_studi (nama_program_studi);
		this.setDaya_tampung_program_studi (daya_tampung_program_studi);
		this.setPeminat_tahun_sebelumnya_program_studi (peminat_tahun_sebelumnya_program_studi);
		this.setKriteria_khusus_program_studi (kriteria_khusus_program_studi);
		this.setStatus_terhapus (0);
		this.setUpdate_terakhir (DateTime.now());
	}



	public UUID getId_program_studi() {
		return id_program_studi;
	}
	public void setId_program_studi(UUID id_program_studi) {
		this.id_program_studi = id_program_studi;
	}
	public String getKode_program_studi() {
		return kode_program_studi;
	}
	public void setKode_program_studi(String kode_program_studi) {
		this.kode_program_studi = kode_program_studi;
	}
	public String getNama_program_studi() {
		return nama_program_studi;
	}
	public void setNama_program_studi(String nama_program_studi) {
		this.nama_program_studi = nama_program_studi;
	}
	public int getDaya_tampung_program_studi() {
		return daya_tampung_program_studi;
	}
	public void setDaya_tampung_program_studi(int daya_tampung_program_studi) {
		this.daya_tampung_program_studi = daya_tampung_program_studi;
	}
	public int getPeminat_tahun_sebelumnya_program_studi() {
		return peminat_tahun_sebelumnya_program_studi;
	}
	public void setPeminat_tahun_sebelumnya_program_studi(
			int peminat_tahun_sebelumnya_program_studi) {
		this.peminat_tahun_sebelumnya_program_studi = peminat_tahun_sebelumnya_program_studi;
	}
	public String getKriteria_khusus_program_studi() {
		return kriteria_khusus_program_studi;
	}
	public void setKriteria_khusus_program_studi(
			String kriteria_khusus_program_studi) {
		this.kriteria_khusus_program_studi = kriteria_khusus_program_studi;
	}
	public int getStatus_terhapus() {
		return status_terhapus;
	}
	public void setStatus_terhapus(int status_terhapus) {
		this.status_terhapus = status_terhapus;
	}
	public DateTime getUpdate_terakhir() {
		return update_terakhir;
	}
	public void setUpdate_terakhir(DateTime update_terakhir) {
		this.update_terakhir = update_terakhir;
	}
	public PerguruanTinggi getPerguruantinggi() {
		return perguruantinggi;
	}
	public void setPerguruantinggi(PerguruanTinggi perguruantinggi) {
		this.perguruantinggi = perguruantinggi;
	}
	public BidangProgramStudi getStudi() {
		return studi;
	}
	public void setStudi(BidangProgramStudi studi) {
		this.studi = studi;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Program Studi  [id=");
		builder.append(id_program_studi);
		builder.append(", id perguruan tinggi=");
		builder.append(perguruantinggi);
		builder.append(", id bidang program studi");
		builder.append(studi);
		builder.append(", kode Program studi=");
		builder.append(kode_program_studi);
		builder.append(", nama program studi");
		builder.append(nama_program_studi);
		builder.append(", daya tampung program studi");
		builder.append(daya_tampung_program_studi);
		builder.append(", peminat prodi tahun sebelumnya");
		builder.append(peminat_tahun_sebelumnya_program_studi);
		builder.append(", kriteria khusus prodi");
		builder.append(kriteria_khusus_program_studi);
		builder.append(", status_terhapus=");
		builder.append(status_terhapus);
		builder.append(", update_terakhir");
		builder.append(update_terakhir);
		builder.append("]");
		return builder.toString();
	}
	

}
