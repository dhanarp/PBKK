package id.sbmptn.data.console;
import id.sbmptn.domain.studi.*;
import id.sbmptn.domain.wilayah.Wilayah;
import id.sbmptn.domain.perguruantinggi.*;
import id.sbmptn.domain.programstudi.*;
import id.sbmptn.data.dao.ProgramStudiDao;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;
public class ConsoleForProgramStudi {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx=new GenericXmlApplicationContext();
		ctx.load("classpath:datasource.xml");
		ctx.refresh();
		ProgramStudiDao programstudidao = ctx.getBean("programstudidao",ProgramStudiDao.class);
        PerguruanTinggi perguruantinggi = new PerguruanTinggi("Narotama","narotama@narotama.ac.id","NARO");
        Wilayah wil15= new Wilayah("501");
        perguruantinggi.setWilayah(wil15);
        BidangProgramStudi studi = new BidangProgramStudi("Aljabar");
        ProgramStudi data1 = new ProgramStudi("KI1315001","Alin",50,20,"g ada");
        data1.setPerguruantinggi(perguruantinggi);
        data1.setStudi(studi);
        ProgramStudi data2 = new ProgramStudi("KI1315002","PT",30,10,"g ada");
        data2.setPerguruantinggi(perguruantinggi);
        data2.setStudi(studi);
        ProgramStudi data3 = new ProgramStudi("KI1315003","SD",10,5,"g ada");
        data3.setStudi(studi);
        data3.setPerguruantinggi(perguruantinggi);
        programstudidao.save(data1);
        programstudidao.save(data2);
        programstudidao.save(data3);
        List <ProgramStudi> data = programstudidao.list();
        for (ProgramStudi bidang : data) {
			System.out.println(bidang);
		}
        data =programstudidao.findByName("PT");
		for(ProgramStudi c:data)
		{
			System.out.println(c);
		}
		programstudidao.delete("PT");
		data = programstudidao .list();
        for (ProgramStudi a : data) {
			System.out.println(a);
		}
		ctx.close();
        System.out.println("Silahkan Lihat database PostgreSQL anda");
    }

}
