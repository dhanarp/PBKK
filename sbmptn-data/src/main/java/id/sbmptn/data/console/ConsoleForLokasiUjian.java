package id.sbmptn.data.console;
import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;
import id.sbmptn.domain.wilayah.*;
import id.sbmptn.domain.panitialokal.*;
import id.sbmptn.domain.lokasiujian.*;
import id.sbmptn.data.dao.LokasiUjianDao;

public class ConsoleForLokasiUjian {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx=new GenericXmlApplicationContext();
		ctx.load("classpath:datasource.xml");
		ctx.refresh();
        LokasiUjianDao lokasiujiandao = ctx.getBean("lokasiujiandao",LokasiUjianDao.class);
        PanitiaLokal panlok =new PanitiaLokal("lokal13@panlok.ac.id","jalan tidak tau surabaya","031990334567","031998332443");
        Wilayah wil12 = new Wilayah("400");
        panlok.setWilayah(wil12);
        LokasiUjian data1 = new LokasiUjian("Jalan Spanyol14 Surabaya");
        data1.setPanlok(panlok);
        LokasiUjian data2 = new LokasiUjian("Jalan Kambingraja 14 Surokerja");
        data2.setPanlok(panlok);;
        LokasiUjian data3 = new LokasiUjian("Jalan manyar sutirmo 89 sukokerjo");
        data3.setPanlok(panlok);
        lokasiujiandao.save(data1);
        lokasiujiandao.save(data2);
        lokasiujiandao.save(data3);
        List <LokasiUjian> data = lokasiujiandao.list();
        for (LokasiUjian bidang : data) {
			System.out.println(bidang);
		}
        data =lokasiujiandao.findByName("jalan tidak tau132 surabaya");
		for(LokasiUjian c:data)
		{
			System.out.println(c);
		}
		lokasiujiandao.delete("jalan tidak tau132 surabaya");
		data = lokasiujiandao.list();
        for (LokasiUjian a : data) {
			System.out.println(a);
		}
		ctx.close();
        System.out.println("Silahkan Lihat database PostgreSQL anda");
    }
}
