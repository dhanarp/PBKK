package id.sbmptn.data.console;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.springframework.context.support.GenericXmlApplicationContext;

import id.sbmptn.domain.jurusan12.Jurusan;
import id.sbmptn.domain.pesertadidik.*;
import id.sbmptn.data.dao.JurusanDao;
import id.sbmptn.data.dao.PesertaDidikDao;

public class ConsoleForPesertaDidik {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx=new GenericXmlApplicationContext();
		ctx.load("classpath:datasource.xml");
		ctx.refresh();
        PesertaDidikDao pesertadidikdao= ctx.getBean("pesertadidikdao",PesertaDidikDao.class);
        Jurusan jur = new Jurusan("TMJ");
        PesertaDidik data1 = new PesertaDidik("77123123123","Testing","g jelas");
        data1.setJurusan(jur);
        PesertaDidik data2 = new PesertaDidik("77123123133","Testing1","g jelas1");
        data2.setJurusan(jur);
        PesertaDidik data3 = new PesertaDidik("77123123143","Testing2","g jelas2");
        data3.setJurusan(jur);
        pesertadidikdao.save(data1);
        pesertadidikdao.save(data2);
        pesertadidikdao.save(data3);
        List <PesertaDidik> data = pesertadidikdao.list();
        for (PesertaDidik bidang : data) {
			System.out.println(bidang);
		}
        data =pesertadidikdao.findByName("Testing");
		for(PesertaDidik c:data)
		{
			System.out.println(c);
		}
		pesertadidikdao.delete("Testing");
		data = pesertadidikdao.list();
        for (PesertaDidik a : data) {
			System.out.println(a);
		}
		ctx.close();
        System.out.println("Silahkan Lihat database PostgreSQL anda");
        
    }

	
	
}
