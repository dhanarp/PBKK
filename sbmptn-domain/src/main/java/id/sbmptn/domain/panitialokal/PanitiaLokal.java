package id.sbmptn.domain.panitialokal;

import java.util.UUID;

import id.sbmptn.domain.wilayah.*;

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
@Entity(name="panitia_lokal")
@Table(name="panitia_lokal")
public class PanitiaLokal {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name="id_panitia_lokal",nullable=false)
	private UUID id_panitia_lokal;
	@Column(name="email_panitia_lokal", nullable=false)
	private String email_panitia_lokal;
	@Column(name="alamat_panitia_lokal", nullable=false)
	private String alamat_panitia_lokal;
	@Column(name="telepon_panitia_lokal", nullable=false)
	private String telepon_panitia_lokal;
	@Column(name="fax_panitia_lokal",nullable=false)
	private String fax_panitia_lokal;
	@Column(name="status_terhapus", nullable=false)
	private int status_terhapus;
	@Column(name="update_terakhir", nullable=false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime update_terakhir;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_wilayah", nullable=false)
	private Wilayah wilayah;
	
	
	public PanitiaLokal(){}
	
	
	public PanitiaLokal( String email_panitia_lokal,
			String alamat_panitia_lokal, String telepon_panitia_lokal,
			String fax_panitia_lokal) {
		this.setId_panitia_lokal (id_panitia_lokal);
		this.setEmail_panitia_lokal (email_panitia_lokal);
		this.setAlamat_panitia_lokal (alamat_panitia_lokal);
		this.setTelepon_panitia_lokal(telepon_panitia_lokal);
		this.setFax_panitia_lokal(fax_panitia_lokal);
		this.setStatus_terhapus (0);
		this.setUpdate_terakhir(DateTime.now());
	}


	public UUID getId_panitia_lokal() {
		return id_panitia_lokal;
	}
	public void setId_panitia_lokal(UUID id_panitia_lokal) {
		this.id_panitia_lokal = id_panitia_lokal;
	}
	public String getEmail_panitia_lokal() {
		return email_panitia_lokal;
	}
	public void setEmail_panitia_lokal(String email_panitia_lokal) {
		this.email_panitia_lokal = email_panitia_lokal;
	}
	public String getAlamat_panitia_lokal() {
		return alamat_panitia_lokal;
	}
	public void setAlamat_panitia_lokal(String alamat_panitia_lokal) {
		this.alamat_panitia_lokal = alamat_panitia_lokal;
	}
	public String getTelepon_panitia_lokal() {
		return telepon_panitia_lokal;
	}
	public void setTelepon_panitia_lokal(String telepon_panitia_lokal) {
		this.telepon_panitia_lokal = telepon_panitia_lokal;
	}
	public String getFax_panitia_lokal() {
		return fax_panitia_lokal;
	}
	public void setFax_panitia_lokal(String fax_panitia_lokal) {
		this.fax_panitia_lokal = fax_panitia_lokal;
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
		builder.append("Panitia Lokal [id=");
		builder.append(id_panitia_lokal);
		builder.append(", id wilayah=");
		builder.append(wilayah);
		builder.append(", email panitia lokal=");
		builder.append(email_panitia_lokal);
		builder.append(", alamat panitia lokal=");
		builder.append(alamat_panitia_lokal);
		builder.append(", telepon panitia lokal =");
		builder.append(telepon_panitia_lokal);
		builder.append(", fax panitia lokal");
		builder.append(fax_panitia_lokal);
		builder.append(", status_terhapus=");
		builder.append(status_terhapus);
		builder.append(", update_terakhir");
		builder.append(update_terakhir);
		builder.append("]");
		return builder.toString();
	}
}
