package id.sbmptn.data.console;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import id.sbmptn.domain.wilayah.*;
import id.sbmptn.domain.perguruantinggi.*;
import id.sbmptn.data.dao.PerguruanTinggiDao;
import id.sbmptn.data.dao.impl.HibPerguruanTinggiDao;

public class ConsoleForPerguruanTinggi {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx=new GenericXmlApplicationContext();
		ctx.load("classpath:datasource.xml");
		ctx.refresh();
        PerguruanTinggiDao perguruantinggidao= ctx.getBean("perguruantinggidao",PerguruanTinggiDao.class);
        Wilayah wil = new Wilayah("14");
        PerguruanTinggi data1 = new PerguruanTinggi("UNESA","unesa@unesa.ac.id","UNESA");
        data1.setWilayah(wil);
        PerguruanTinggi data2 = new PerguruanTinggi("ITS","its@its.ac.id","ITS");
        data2.setWilayah(wil);
        PerguruanTinggi data3 = new PerguruanTinggi("UNAIR","unair@unair.ac.id","UNAIR");
        data3.setWilayah(wil);
        perguruantinggidao.save(data1);
        perguruantinggidao.save(data2);
        perguruantinggidao.save(data3);
        List <PerguruanTinggi> data = perguruantinggidao.list();
        for (PerguruanTinggi bidang : data) {
			System.out.println(bidang);
		}
        data =perguruantinggidao.findByName("UNAIR");
		for(PerguruanTinggi c:data)
		{
			System.out.println(c);
		}
		perguruantinggidao.delete("UNAIR");
		data = perguruantinggidao.list();
        for (PerguruanTinggi a : data) {
			System.out.println(a);
		}
		ctx.close();
        System.out.println("Silahkan Lihat database PostgreSQL anda");
        
    }

}
