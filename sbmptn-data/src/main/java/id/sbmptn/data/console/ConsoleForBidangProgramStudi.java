package id.sbmptn.data.console;

import java.util.List;
import java.util.UUID;

import org.springframework.context.support.GenericXmlApplicationContext;

import id.sbmptn.domain.studi.BidangProgramStudi;
import id.sbmptn.data.dao.BidangProgramStudiDao;

public class ConsoleForBidangProgramStudi {
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx=new GenericXmlApplicationContext();
		ctx.load("classpath:datasource.xml");
		ctx.refresh();
        BidangProgramStudiDao bidangprogramstudidao = ctx.getBean("bidangprogramstudidao",BidangProgramStudiDao.class);
        BidangProgramStudi data1 = new BidangProgramStudi("Matematika");
        BidangProgramStudi data2 = new BidangProgramStudi("Fisika");
        BidangProgramStudi data3 = new BidangProgramStudi("Kimia");
        bidangprogramstudidao.save(data1);
        bidangprogramstudidao.save(data2);
        bidangprogramstudidao.save(data3);
        List <BidangProgramStudi> data = bidangprogramstudidao.list();
        for (BidangProgramStudi bidang : data) {
			System.out.println(bidang);
		}
        data =bidangprogramstudidao.findByName("Matematika");
		for(BidangProgramStudi c:data)
		{
			System.out.println(c);
		}
		bidangprogramstudidao.delete("Matematika");
		data = bidangprogramstudidao.list();
        for (BidangProgramStudi a : data) {
			System.out.println(a);
		}
		ctx.close();
        System.out.println("Silahkan Lihat database PostgreSQL anda");
    }
    
	
}
