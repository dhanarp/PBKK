package id.sbmptn.data.console;
import java.util.List;
import java.util.UUID;

import org.springframework.context.support.GenericXmlApplicationContext;
import id.sbmptn.domain.statuspembayaran.*;
import id.sbmptn.data.dao.StatusPembayaranDao;

public class ConsoleForStatusPembayaran {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx=new GenericXmlApplicationContext();
		ctx.load("classpath:datasource.xml");
		ctx.refresh();
		StatusPembayaranDao statuspembayarandao= ctx.getBean("statuspembayarandao",StatusPembayaranDao.class);
		StatusPembayaran data1 = new StatusPembayaran("Lunas");
		StatusPembayaran data2 = new StatusPembayaran("Utang");
		StatusPembayaran data3 = new StatusPembayaran("G jelas");
		statuspembayarandao.save(data1);
		statuspembayarandao.save(data2);
		statuspembayarandao.save(data3);
        List <StatusPembayaran> data = statuspembayarandao.list();
        for (StatusPembayaran bidang : data) {
			System.out.println(bidang);
		}
        data =statuspembayarandao.findByName("Utang");
		for(StatusPembayaran c:data)
		{
			System.out.println(c);
		}
		statuspembayarandao.delete("Utang");
		data = statuspembayarandao.list();
        for (StatusPembayaran a : data) {
			System.out.println(a);
		}
		ctx.close();
        System.out.println("Silahkan Lihat database PostgreSQL anda");
    }

}
