package id.sbmptn.data.console;
import java.util.List;
import java.util.UUID;

import org.springframework.context.support.GenericXmlApplicationContext;
import id.sbmptn.domain.jurusan12.Jurusan;
import id.sbmptn.data.dao.JurusanDao;

public class ConsoleForJurusan {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx=new GenericXmlApplicationContext();
		ctx.load("classpath:datasource.xml");
		ctx.refresh();
        JurusanDao jurusandao = ctx.getBean("jurusandao",JurusanDao.class);
        Jurusan data1 = new Jurusan("Siskal");
        Jurusan data2 = new Jurusan("TC");
        Jurusan data3 = new Jurusan("Tekkim");
        jurusandao.save(data1);
        jurusandao.save(data2);
        jurusandao.save(data3);
        List <Jurusan> data = jurusandao.list();
        for (Jurusan bidang : data) {
			System.out.println(bidang);
		}
        data =jurusandao.findByName("Siskal");
		for(Jurusan c:data)
		{
			System.out.println(c);
		}
		jurusandao.delete("Siskal");
		data = jurusandao.list();
        for (Jurusan a : data) {
			System.out.println(a);
		}
		ctx.close();
        System.out.println("Silahkan Lihat database PostgreSQL anda");
    }

}
