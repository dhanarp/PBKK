package id.sbmptn.data.console;
import java.util.List;
import java.util.UUID;

import org.springframework.context.support.GenericXmlApplicationContext;
import id.sbmptn.domain.hasilseleksi.*;
import id.sbmptn.data.dao.HasilSeleksiDao;

public class ConsoleForHasilSeleksi {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx=new GenericXmlApplicationContext();
		ctx.load("classpath:datasource.xml");
		ctx.refresh();
		HasilSeleksiDao hasilseleksidao = ctx.getBean("hasilseleksidao",HasilSeleksiDao.class);
		HasilSeleksi data1 = new HasilSeleksi("Freddy");
		HasilSeleksi data2 = new HasilSeleksi("Tadji");
        HasilSeleksi data3 = new HasilSeleksi("Dewangga");
        hasilseleksidao.save(data1);
        hasilseleksidao.save(data2);
        hasilseleksidao.save(data3);
        List <HasilSeleksi> data = hasilseleksidao.list();
        for (HasilSeleksi bidang : data) {
			System.out.println(bidang);
		}
        data =hasilseleksidao.findByName("Tadji");
		for(HasilSeleksi c:data)
		{
			System.out.println(c);
		}
		hasilseleksidao.delete("Tadji");
		data = hasilseleksidao.list();
        for (HasilSeleksi a : data) {
			System.out.println(a);
		}
		ctx.close();
        System.out.println("Silahkan Lihat database PostgreSQL anda");
    }

}
