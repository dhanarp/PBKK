package id.sbmptn.domain.lokasiujian;
import java.util.UUID;

import id.sbmptn.domain.panitialokal.*;

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
@Entity(name="lokasi_ujian")
@Table(name="lokasi_ujian")
public class LokasiUjian {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name="id_lokasi_ujian",nullable=false)
	private UUID id_lokasi_ujian;
	@Column(name="alamat_lokasi_ujian", nullable=false)
	private String alamat_lokasi_ujian;
	@Column(name="status_terhapus", nullable=false)
	private int status_terhapus;
	@Column(name="update_terakhir", nullable=false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime update_terakhir;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_panitia_lokal", nullable=false)
	private PanitiaLokal panlok;
	
	public LokasiUjian(){}
	
	
	public LokasiUjian(String alamat_lokasi_ujian) {
		this.setId_lokasi_ujian (id_lokasi_ujian);
		this.setAlamat_lokasi_ujian (alamat_lokasi_ujian);
		this.setStatus_terhapus(0);
		this.setUpdate_terakhir(DateTime.now());
	}


	public UUID getId_lokasi_ujian() {
		return id_lokasi_ujian;
	}
	public void setId_lokasi_ujian(UUID id_lokasi_ujian) {
		this.id_lokasi_ujian = id_lokasi_ujian;
	}
	public String getAlamat_lokasi_ujian() {
		return alamat_lokasi_ujian;
	}
	public void setAlamat_lokasi_ujian(String alamat_lokasi_ujian) {
		this.alamat_lokasi_ujian = alamat_lokasi_ujian;
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
	public PanitiaLokal getPanlok() {
		return panlok;
	}
	public void setPanlok(PanitiaLokal panlok) {
		this.panlok = panlok;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Lokasi Ujian [id=");
		builder.append(id_lokasi_ujian);
		builder.append(", id panitia lokal=");
		builder.append(panlok);
		builder.append(", alamat lokasi ujian=");
		builder.append(alamat_lokasi_ujian);
		builder.append(", status_terhapus=");
		builder.append(status_terhapus);
		builder.append(", update_terakhir");
		builder.append(update_terakhir);
		builder.append("]");
		return builder.toString();
	}
	
}
