package id.sbmptn.domain.wilayah;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity(name="wilayah")
@Table(name="wilayah",uniqueConstraints = {@UniqueConstraint(columnNames = "nomor_wilayah")})

public class Wilayah {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name="id_wilayah",nullable=false)
	private UUID id_wilayah;
	@Column(name="nomor_wilayah", nullable=false)
	private String nomor_wilayah;
	@Column(name="status_terhapus", nullable=false)
	private int status_terhapus;
	@Column(name="update_terakhir", nullable=false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime update_terakhir;
	
	public Wilayah(){}

	public Wilayah(String nomor_wilayah) {
		this.setId_wilayah(id_wilayah);
		this.setNomor_wilayah(nomor_wilayah);
		this.setStatus_terhapus(0);
		this.setUpdate_terakhir(DateTime.now());
	}

	public UUID getId_wilayah() {
		return id_wilayah;
	}

	public void setId_wilayah(UUID id_wilayah) {
		this.id_wilayah = id_wilayah;
	}

	public String getNomor_wilayah() {
		return nomor_wilayah;
	}

	public void setNomor_wilayah(String nomor_wilayah) {
		this.nomor_wilayah = nomor_wilayah;
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
		builder.append("Wilayah [id=");
		builder.append(id_wilayah);
		builder.append(", Nomor_Wilayah=");
		builder.append(nomor_wilayah);
		builder.append(", status_terhapus=");
		builder.append(status_terhapus);
		builder.append(", update_terakhir");
		builder.append(update_terakhir);
		builder.append("]");
		return builder.toString();
	}

}
