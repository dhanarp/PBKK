package id.sbmptn.domain.jurusan12;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity(name="jurusan")
@Table(name="jurusan")

public class Jurusan {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name="id_jurusan",nullable=false)
	private UUID id_jurusan;
	@Column(name="nama_jurusan", nullable=false)
	private String nama_jurusan;
	@Column(name="status_terhapus", nullable=false)
	private int status_terhapus;
	@Column(name="update_terakhir", nullable=false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime update_terakhir;
	
	public Jurusan(){}
	
	
	
	public Jurusan(String nama_jurusan) {
		
		this.setNama_jurusan(nama_jurusan);
		this.setStatus_terhapus(0);
		this.setUpdate_terakhir(DateTime.now());
	}



	public UUID getId_jurusan() {
		return id_jurusan;
	}
	public void setId_jurusan(UUID id_jurusan) {
		this.id_jurusan = id_jurusan;
	}
	public String getNama_jurusan() {
		return nama_jurusan;
	}
	public void setNama_jurusan(String nama_jurusan) {
		this.nama_jurusan = nama_jurusan;
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
		builder.append("Jurusan [id=");
		builder.append(id_jurusan);
		builder.append(", Nama_Jurusan=");
		builder.append(nama_jurusan);
		builder.append(", status_terhapus=");
		builder.append(status_terhapus);
		builder.append(", update_terakhir");
		builder.append(update_terakhir);
		builder.append("]");
		return builder.toString();
	}
}
