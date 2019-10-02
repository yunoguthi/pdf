package br.jus.jfsp.leitorpdf.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

//public class ParserService extends AbstractParser {
@Service
public class ParserService {

//	private static final Set<MediaType> SUPPORTED_TYPES = Collections.singleton(MediaType.application("pdf"));
//    public static final String HELLO_MIME_TYPE = "application/pdf";
//    
//    public Set<MediaType> getSupportedTypes(ParseContext context) {
//            return SUPPORTED_TYPES;
//    }

//    public void parse(
//                    InputStream stream, ContentHandler handler,
//                    Metadata metadata, ParseContext context)
//                    throws IOException, SAXException, TikaException {
//
//            metadata.set(Metadata.CONTENT_TYPE, HELLO_MIME_TYPE);
//            metadata.set("Hello", "World");
//
//            XHTMLContentHandler xhtml = new XHTMLContentHandler(handler, metadata);
//            xhtml.startDocument();
//            xhtml.endDocument();
//    }
    
    public void parse() throws IOException, SAXException, TikaException {

        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        FileInputStream inputstream = new FileInputStream(new File("Dimensions of DevOps_XP2015.pdf"));
        ParseContext pcontext = new ParseContext();
        
        //parsing the document using PDF parser
        PDFParser pdfparser = new PDFParser(); 
        pdfparser.parse(inputstream, handler, metadata,pcontext);
        
        //getting the content of the document
        System.out.println("Contents of the PDF :" + handler.toString());
        
        //getting metadata of the document
        System.out.println("Metadata of the PDF:");
        String[] metadataNames = metadata.names();
        
        for(String name : metadataNames) {
           System.out.println(name+ " : " + metadata.get(name));
        }
     }
    
}
