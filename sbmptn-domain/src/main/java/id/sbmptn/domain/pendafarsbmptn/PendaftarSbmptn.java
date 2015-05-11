package id.sbmptn.domain.pendafarsbmptn;
import id.sbmptn.domain.lokasiujian.*;
import id.sbmptn.domain.statuspembayaran.*;
import id.sbmptn.domain.pesertadidik.*;
import id.sbmptn.domain.programstudi.*;
import id.sbmptn.domain.hasilseleksi.*;
import id.sbmptn.domain.panitialokal.*;

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
@Entity(name="pendaftar_sbmptn")
@Table(name="pendaftar_sbmptn")

public class PendaftarSbmptn {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name="id_pendaftar_sbmptn",nullable=false)
	private UUID id_pendaftar_sbmptn;
	@Column(name="status_terhapus", nullable=false)
	private int status_terhapus;
	@Column(name="update_terakhir", nullable=false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime update_terakhir;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_status_pembayaran", nullable=false)
	private StatusPembayaran statuspembayaran;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_peserta_didik", nullable=false)
	private PesertaDidik pesertadidik;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_program_studi1", nullable=false)
	private ProgramStudi programstudi1;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_program_studi2", nullable=false)
	private ProgramStudi programstudi2;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_program_studi3", nullable=false)
	private ProgramStudi programstudi3;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_panitia_lokal", nullable=false)
	private PanitiaLokal panlok;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_hasil_seleksi", nullable=false)
	private HasilSeleksi hasilseleksi;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_lokasi_ujian",nullable=false)
	private LokasiUjian lokasiujian;
	
	
	public PendaftarSbmptn()
	{
		this.setId_pendaftar_sbmptn(id_pendaftar_sbmptn);
		this.setStatus_terhapus(0);
		this.setUpdate_terakhir(DateTime.now());
	}
	
	
	public UUID getId_pendaftar_sbmptn() {
		return id_pendaftar_sbmptn;
	}
	public void setId_pendaftar_sbmptn(UUID id_pendaftar_sbmptn) {
		this.id_pendaftar_sbmptn = id_pendaftar_sbmptn;
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
	public StatusPembayaran getStatuspembayaran() {
		return statuspembayaran;
	}
	public void setStatuspembayaran(StatusPembayaran statuspembayaran) {
		this.statuspembayaran = statuspembayaran;
	}
	public PesertaDidik getPesertadidik() {
		return pesertadidik;
	}
	public void setPesertadidik(PesertaDidik pesertadidik) {
		this.pesertadidik = pesertadidik;
	}
	public ProgramStudi getProgramstudi1() {
		return programstudi1;
	}
	public void setProgramstudi1(ProgramStudi programstudi1) {
		this.programstudi1 = programstudi1;
	}
	public ProgramStudi getProgramstudi2() {
		return programstudi2;
	}
	public void setProgramstudi2(ProgramStudi programstudi2) {
		this.programstudi2 = programstudi2;
	}
	public ProgramStudi getProgramstudi3() {
		return programstudi3;
	}
	public void setProgramstudi3(ProgramStudi programstudi3) {
		this.programstudi3 = programstudi3;
	}
	public PanitiaLokal getPanlok() {
		return panlok;
	}
	public void setPanlok(PanitiaLokal panlok) {
		this.panlok = panlok;
	}
	public HasilSeleksi getHasilseleksi() {
		return hasilseleksi;
	}
	public void setHasilseleksi(HasilSeleksi hasilseleksi) {
		this.hasilseleksi = hasilseleksi;
	}
	public LokasiUjian getLokasiujian() {
		return lokasiujian;
	}
	public void setLokasiujian(LokasiUjian lokasiujian) {
		this.lokasiujian = lokasiujian;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PendaftarSbmptn  [id=");
		builder.append(id_pendaftar_sbmptn);
		builder.append(", status pembayaran=");
		builder.append(statuspembayaran);
		builder.append(", peserta didik= ");
		builder.append(pesertadidik);
		builder.append(", prodi1= ");
		builder.append(programstudi1);
		builder.append(", prodi2= ");
		builder.append(programstudi2);
		builder.append(", prodi3= ");
		builder.append(programstudi3);
		builder.append(", panlok=");
		builder.append(panlok);
		builder.append(", hasil seleksi=");
		builder.append(hasilseleksi);
		builder.append(", lokasi ujian");
		builder.append(lokasiujian);
		builder.append(", status_terhapus=");
		builder.append(status_terhapus);
		builder.append(", update_terakhir");
		builder.append(update_terakhir);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
