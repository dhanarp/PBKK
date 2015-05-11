package id.sbmptn.domain.pesertadidik;
import id.sbmptn.domain.jurusan12.Jurusan;

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
@Entity(name="peserta_didik")
@Table(name="peserta_didik")

public class PesertaDidik {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name="id_peserta_didik",nullable=false)
	private UUID id_peserta_didik;
	@Column(name="nisn_peserta_didik", nullable=false)
	private String nisn_peserta_didik;
	@Column(name="nama_peserta_didik", nullable=false)
	private String nama_peserta_didik;
	@Column(name="sekolah_peserta_didik", nullable=false)
	private String sekolah_peserta_didik;
	@Column(name="status_terhapus", nullable=false)
	private int status_terhapus;
	@Column(name="update_terakhir", nullable=false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime update_terakhir;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_jurusan", nullable=false)
	private Jurusan jurusan;
	
	public PesertaDidik(){}
	

	public PesertaDidik(String nisn_peserta_didik,
			String nama_peserta_didik, String sekolah_peserta_didik) {
		this.setId_peserta_didik(id_peserta_didik);
		this.setNisn_peserta_didik (nisn_peserta_didik);
		this.setNama_peserta_didik (nama_peserta_didik);
		this.setSekolah_peserta_didik(sekolah_peserta_didik);
		this.setStatus_terhapus (0);
		this.setUpdate_terakhir(DateTime.now());
		//this.setId_jurusan(id_jurusan);
	}


	/*public UUID getId_jurusan() {
		return id_jurusan;
	}


	public void setId_jurusan(UUID id_jurusan) {
		this.id_jurusan = id_jurusan;
	}

*/
	public UUID getId_peserta_didik() {
		return id_peserta_didik;
	}

	public Jurusan getJurusan() {
		return jurusan;
	}


	public void setJurusan(Jurusan jurusan) {
		this.jurusan = jurusan;
	}


	public void setId_peserta_didik(UUID id_peserta_didik) {
		this.id_peserta_didik= id_peserta_didik;
	}

	public String getNisn_peserta_didik() {
		return nisn_peserta_didik;
	}

	public void setNisn_peserta_didik(String nisn_peserta_didik) {
		this.nisn_peserta_didik = nisn_peserta_didik;
	}

	public String getNama_peserta_didik() {
		return nama_peserta_didik;
	}

	public void setNama_peserta_didik(String nama_peserta_didik) {
		this.nama_peserta_didik = nama_peserta_didik;
	}

	public String getSekolah_peserta_didik() {
		return sekolah_peserta_didik;
	}

	public void setSekolah_peserta_didik(String sekolah_peserta_didik) {
		this.sekolah_peserta_didik = sekolah_peserta_didik;
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

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Peserta Didik [id=");
		builder.append(id_peserta_didik);
		builder.append(", id_jurusan");
		builder.append(jurusan);
		builder.append(", NISN Peserta didik");
		builder.append(nisn_peserta_didik);
		builder.append(", Nama_peserta_didik=");
		builder.append(nama_peserta_didik);
		builder.append(", Sekolah Peserta didik");
		builder.append(sekolah_peserta_didik);
		builder.append(", status_terhapus=");
		builder.append(status_terhapus);
		builder.append(", update_terakhir");
		builder.append(update_terakhir);
		builder.append("]");
		return builder.toString();
	}

		
}
