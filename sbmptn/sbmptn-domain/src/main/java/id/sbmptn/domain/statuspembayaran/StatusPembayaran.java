package id.sbmptn.domain.statuspembayaran;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity(name="status_pembayaran")
@Table(name="status_pembayaran")

public class StatusPembayaran {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name="id_status_pembayaran",nullable=false)
	private UUID id_status_pembayaran;
	@Column(name="nama_status_pembayaran", nullable=false)
	private String nama_status_pembayaran;
	@Column(name="status_terhapus", nullable=false)
	private int status_terhapus;
	
	public StatusPembayaran(){}
	
	
	public StatusPembayaran(String nama_status_pembayaran ) {
		this.setId_status_pembayaran(id_status_pembayaran);
		this.setNama_status_pembayaran (nama_status_pembayaran);
		this.setStatus_terhapus(0);
	}


	public UUID getId_status_pembayaran() {
		return id_status_pembayaran;
	}
	public void setId_status_pembayaran(UUID id_status_pembayaran) {
		this.id_status_pembayaran = id_status_pembayaran;
	}
	public String getNama_status_pembayaran() {
		return nama_status_pembayaran;
	}
	public void setNama_status_pembayaran(String nama_status_pembayaran) {
		this.nama_status_pembayaran = nama_status_pembayaran;
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
		builder.append("Status Pembayaran[id=");
		builder.append(id_status_pembayaran);
		builder.append(", Nama_status_pembayaran=");
		builder.append(nama_status_pembayaran);
		builder.append(", status_terhapus=");
		builder.append(status_terhapus);
		builder.append("]");
		return builder.toString();
	}
}
