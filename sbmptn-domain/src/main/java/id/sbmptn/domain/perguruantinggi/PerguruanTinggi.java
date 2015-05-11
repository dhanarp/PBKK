package id.sbmptn.domain.perguruantinggi;
import id.sbmptn.domain.jurusan12.Jurusan;
import id.sbmptn.domain.wilayah.Wilayah;

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
@Entity(name="perguruan_tinggi")
@Table(name="perguruan_tinggi")

public class PerguruanTinggi {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name="id_perguruan_tinggi_negeri",nullable=false)
	private UUID id_perguruan_tinggi_negeri;
	@Column(name="nama_perguruan_tinggi_negeri", nullable=false)
	private String nama_perguruan_tinggi_negeri;
	@Column(name="email_perguruan_tinggi_negeri", nullable=false)
	private String email_perguruan_tinggi_negeri;
	@Column(name="kode_perguruan_tinggi_negeri", nullable=false)
	private String kode_perguruan_tinggi_negeri;
	@Column(name="status_terhapus", nullable=false)
	private int status_terhapus;
	@Column(name="update_terakhir", nullable=false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime update_terakhir;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_wilayah", nullable=false)
	private Wilayah wilayah;
	
	public PerguruanTinggi(){}
	
	
	public PerguruanTinggi(
			String nama_perguruan_tinggi_negeri,
			String email_perguruan_tinggi_negeri,
			String kode_perguruan_tinggi_negeri) {
		this.setId_perguruan_tinggi_negeri(id_perguruan_tinggi_negeri);
		this.setNama_perguruan_tinggi_negeri (nama_perguruan_tinggi_negeri);
		this.setEmail_perguruan_tinggi_negeri (email_perguruan_tinggi_negeri);
		this.setKode_perguruan_tinggi_negeri (kode_perguruan_tinggi_negeri);
		this.setStatus_terhapus (0);
		this.setUpdate_terakhir  (DateTime.now());
	}


	public UUID getId_perguruan_tinggi_negeri() {
		return id_perguruan_tinggi_negeri;
	}
	public void setId_perguruan_tinggi_negeri(UUID id_perguruan_tinggi_negeri) {
		this.id_perguruan_tinggi_negeri = id_perguruan_tinggi_negeri;
	}
	public String getNama_perguruan_tinggi_negeri() {
		return nama_perguruan_tinggi_negeri;
	}
	public void setNama_perguruan_tinggi_negeri(String nama_perguruan_tinggi_negeri) {
		this.nama_perguruan_tinggi_negeri = nama_perguruan_tinggi_negeri;
	}
	public String getEmail_perguruan_tinggi_negeri() {
		return email_perguruan_tinggi_negeri;
	}
	public void setEmail_perguruan_tinggi_negeri(
			String email_perguruan_tinggi_negeri) {
		this.email_perguruan_tinggi_negeri = email_perguruan_tinggi_negeri;
	}
	public String getKode_perguruan_tinggi_negeri() {
		return kode_perguruan_tinggi_negeri;
	}
	public void setKode_perguruan_tinggi_negeri(String kode_perguruan_tinggi_negeri) {
		this.kode_perguruan_tinggi_negeri = kode_perguruan_tinggi_negeri;
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
	public Wilayah getWilayah() {
		return wilayah;
	}
	public void setWilayah(Wilayah wilayah) {
		this.wilayah = wilayah;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Perguruan Tinggi Negeri [id=");
		builder.append(id_perguruan_tinggi_negeri);
		builder.append(", id wilayah=");
		builder.append(wilayah);
		builder.append(", Nama_perguruan Tinggi negeri");
		builder.append(nama_perguruan_tinggi_negeri);
		builder.append(", email perguruan tinggi negeri=");
		builder.append(email_perguruan_tinggi_negeri);
		builder.append(", kode perguruan tinggi negeri");
		builder.append(kode_perguruan_tinggi_negeri);
		builder.append(", status_terhapus=");
		builder.append(status_terhapus);
		builder.append(", update_terakhir");
		builder.append(update_terakhir);
		builder.append("]");
		return builder.toString();
	}
	
}
