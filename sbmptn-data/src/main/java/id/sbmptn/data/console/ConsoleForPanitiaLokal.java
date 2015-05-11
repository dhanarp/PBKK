package id.sbmptn.data.console;
import java.util.List;
import java.util.UUID;

import org.springframework.context.support.GenericXmlApplicationContext;

import id.sbmptn.domain.wilayah.*;
import id.sbmptn.domain.panitialokal.*;
import id.sbmptn.data.dao.PanitiaLokalDao;
public class ConsoleForPanitiaLokal {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx=new GenericXmlApplicationContext();
		ctx.load("classpath:datasource.xml");
		ctx.refresh();
        PanitiaLokalDao panitialokaldao = ctx.getBean("panitialokaldao",PanitiaLokalDao.class);
        Wilayah wil1 = new Wilayah("90");
        PanitiaLokal data1 = new PanitiaLokal("lokal1@panlok.ac.id","jalan tidak tau surabaya","031990334567","031998332443");
        data1.setWilayah(wil1);
        PanitiaLokal data2 = new PanitiaLokal("lokal1123@panlok.ac.id","jalan tidak tau123 surabaya","031990334457","031998332445");
        data2.setWilayah(wil1);
        PanitiaLokal data3 = new PanitiaLokal("lokal133@panlok.ac.id","jalan tidak tau132 surabaya","031990444567","031998332123");
        data3.setWilayah(wil1);
        panitialokaldao.save(data1);
        panitialokaldao.save(data2);
        panitialokaldao.save(data3);
        List <PanitiaLokal> data = panitialokaldao.list();
        for (PanitiaLokal bidang : data) {
			System.out.println(bidang);
		}
        data =panitialokaldao.findByName("jalan tidak tau132 surabaya");
		for(PanitiaLokal c:data)
		{
			System.out.println(c);
		}
		panitialokaldao.delete("jalan tidak tau132 surabaya");
		data = panitialokaldao.list();
        for (PanitiaLokal a : data) {
			System.out.println(a);
		}
		ctx.close();
        System.out.println("Silahkan Lihat database PostgreSQL anda");
    }
}
