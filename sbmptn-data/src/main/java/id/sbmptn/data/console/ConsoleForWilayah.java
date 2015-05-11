package id.sbmptn.data.console;
import java.util.List;
import java.util.UUID;

import org.springframework.context.support.GenericXmlApplicationContext;
import id.sbmptn.domain.wilayah.*;
import id.sbmptn.data.dao.WilayahDao;

public class ConsoleForWilayah {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx=new GenericXmlApplicationContext();
		ctx.load("classpath:datasource.xml");
		ctx.refresh();
		WilayahDao wilayahdao= ctx.getBean("wilayahdao",WilayahDao.class);
		Wilayah data1 = new Wilayah("12");
		Wilayah data2 = new Wilayah("15");
		Wilayah data3 = new Wilayah("20");
		wilayahdao.save(data1);
		wilayahdao.save(data2);
		wilayahdao.save(data3);
        List <Wilayah> data = wilayahdao.list();
        for (Wilayah bidang : data) {
			System.out.println(bidang);
		}
        data =wilayahdao.findByName("20");
		for(Wilayah c:data)
		{
			System.out.println(c);
		}
		wilayahdao.delete("15");
		data = wilayahdao.list();
        for (Wilayah a : data) {
			System.out.println(a);
		}
		ctx.close();
        System.out.println("Silahkan Lihat database PostgreSQL anda");
    }

}
