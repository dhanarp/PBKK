package id.sbmptn.domain.hasilseleksi;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity(name="hasil_seleksi")
@Table(name="hasil_seleksi")
public class HasilSeleksi {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name="id_hasil_seleksi",nullable=false)
	private UUID id_hasil_seleksi;
	@Column(name="nama_hasil_seleksi", nullable=false)
	private String nama_hasil_seleksi;
	@Column(name="status_terhapus", nullable=false)
	private int status_terhapus;
	
	public HasilSeleksi(){}
	
	public HasilSeleksi( String nama_hasil_seleksi) {
		
		this.setId_hasil_seleksi(id_hasil_seleksi);
		this.setNama_hasil_seleksi(nama_hasil_seleksi);
		this.setStatus_terhapus(0);
	}
	public UUID getId_hasil_seleksi() {
		return id_hasil_seleksi;
	}
	public void setId_hasil_seleksi(UUID id_hasil_seleksi) {
		this.id_hasil_seleksi = id_hasil_seleksi;
	}
	public String getNama_hasil_seleksi() {
		return nama_hasil_seleksi;
	}
	public void setNama_hasil_seleksi(String nama_hasil_seleksi) {
		this.nama_hasil_seleksi = nama_hasil_seleksi;
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
		builder.append("Hasil_seleksi [id=");
		builder.append(id_hasil_seleksi);
		builder.append(", Nama_hasil_seleksi=");
		builder.append(nama_hasil_seleksi);
		builder.append(", status_terhapus=");
		builder.append(status_terhapus);
		builder.append("]");
		return builder.toString();
	}
}
