package br.jus.jfsp.leitorpdf;

import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.xml.sax.SAXException;

import br.jus.jfsp.leitorpdf.services.ParserService;

@SpringBootApplication
@ComponentScan ({"br.jus.jfsp.leitorpdf.services"})
public class App implements CommandLineRunner {
	
	@Autowired
	private ParserService parseService;
	
	private Logger LOG = LoggerFactory
		      .getLogger(App.class);
		 
		    public static void main(String[] args) {
		        SpringApplication.run(App.class, args);
		    }
		  
		    //@Override
		    public void run(String... args) {
		        LOG.info("EXECUTING : command line runner");
		        try {
					parseService.parse();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TikaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        for (int i = 0; i < args.length; ++i) {
		            LOG.info("args[{}]: {}", i, args[i]);
		        }
		    }
}
