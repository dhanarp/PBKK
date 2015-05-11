package id.sbmptn.data.console;
import id.sbmptn.domain.*;
import id.sbmptn.domain.hasilseleksi.HasilSeleksi;
import id.sbmptn.domain.jurusan12.Jurusan;
import id.sbmptn.domain.lokasiujian.LokasiUjian;
import id.sbmptn.domain.panitialokal.PanitiaLokal;
import id.sbmptn.domain.pendafarsbmptn.PendaftarSbmptn;
import id.sbmptn.domain.perguruantinggi.PerguruanTinggi;
import id.sbmptn.domain.pesertadidik.PesertaDidik;
import id.sbmptn.domain.programstudi.ProgramStudi;
import id.sbmptn.domain.statuspembayaran.StatusPembayaran;
import id.sbmptn.domain.studi.BidangProgramStudi;
import id.sbmptn.domain.wilayah.Wilayah;
import id.sbmptn.data.dao.PendaftarSbmptnDao;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ConsoleForPendaftarSbmptn {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx=new GenericXmlApplicationContext();
		ctx.load("classpath:datasource.xml");
		ctx.refresh();
		PendaftarSbmptnDao pendaftarsbmptndao= ctx.getBean("pendaftarsbmptndao",PendaftarSbmptnDao.class);
		StatusPembayaran statuspembayaran = new StatusPembayaran("Transfer Bank");
		PesertaDidik pesertadidik = new PesertaDidik("77122123103","Tadji","p5");
		Jurusan jurusan = new Jurusan("Sipil");
		pesertadidik.setJurusan(jurusan);
		ProgramStudi programstudi1 = new ProgramStudi("KIBO90921","pbkk",40,50,"tidak ada");
		ProgramStudi programstudi2 = new ProgramStudi("KIBO10921","RURAL",40,50,"tidak ada");
		ProgramStudi programstudi3 = new ProgramStudi("KIBO91921","KB",40,50,"tidak ada");
		Wilayah wil15= new Wilayah("504");
		PerguruanTinggi perguruantinggi = new PerguruanTinggi("UBAYA","ubaya@narotama.ac.id","UBAYA");
        perguruantinggi.setWilayah(wil15);
        BidangProgramStudi studi = new BidangProgramStudi("BI");
        programstudi1.setPerguruantinggi(perguruantinggi);
        programstudi1.setStudi(studi);
        programstudi2.setPerguruantinggi(perguruantinggi);
        programstudi2.setStudi(studi);
        programstudi3.setPerguruantinggi(perguruantinggi);
        programstudi3.setStudi(studi);
        PanitiaLokal panlok =  new PanitiaLokal("lokal1999@panlok.ac.id","jalan tidak tau55 surabaya","031990322567","031008332443");
        panlok.setWilayah(wil15);
        HasilSeleksi hasilseleksi = new HasilSeleksi("cadangan");
        LokasiUjian lokasiujian = new LokasiUjian("Kebraon 2 Surabaya");
        lokasiujian.setPanlok(panlok);
        //PerguruanTinggi perguruantinggi = new PerguruanTinggi("UBAYA","ubaya@narotama.ac.id","UBAYA");
        //Wilayah wil15= new Wilayah("502");
        //perguruantinggi.setWilayah(wil15);
        //BidangProgramStudi studi = new BidangProgramStudi("Aljabar");
        PendaftarSbmptn data1 = new PendaftarSbmptn();
        data1.setProgramstudi1(programstudi1);
        data1.setProgramstudi2(programstudi2);
        data1.setProgramstudi3(programstudi3);
        data1.setPanlok(panlok);
        data1.setLokasiujian(lokasiujian);
        data1.setHasilseleksi(hasilseleksi);
        data1.setPesertadidik(pesertadidik);
        data1.setStatuspembayaran(statuspembayaran);
        //data1.setPerguruantinggi(perguruantinggi);
        //data1.setStudi(studi);
        PendaftarSbmptn data2 = new PendaftarSbmptn();
        data2.setProgramstudi1(programstudi1);
        data2.setProgramstudi2(programstudi2);
        data2.setProgramstudi3(programstudi3);
        data2.setPesertadidik(pesertadidik);
        data2.setPanlok(panlok);
        data2.setLokasiujian(lokasiujian);
        data2.setHasilseleksi(hasilseleksi);
        data2.setStatuspembayaran(statuspembayaran);
        //data2.setPerguruantinggi(perguruantinggi);
        //data2.setStudi(studi);
        PendaftarSbmptn data3 = new PendaftarSbmptn();
        data3.setProgramstudi1(programstudi1);
        data3.setProgramstudi2(programstudi2);
        data3.setProgramstudi3(programstudi3);
        data3.setPanlok(panlok);
        data3.setLokasiujian(lokasiujian);
        data3.setHasilseleksi(hasilseleksi);
        data3.setPesertadidik(pesertadidik);
        data3.setStatuspembayaran(statuspembayaran);
        //data3.setStudi(studi);
        //data3.setPerguruantinggi(perguruantinggi);
        pendaftarsbmptndao.save(data1);
        pendaftarsbmptndao.save(data2);
        pendaftarsbmptndao.save(data3);
        List <PendaftarSbmptn> data = pendaftarsbmptndao.list();
        for (PendaftarSbmptn bidang : data) {
			System.out.println(bidang);
		}
		ctx.close();
        System.out.println("Silahkan Lihat database PostgreSQL anda");
    }


}
