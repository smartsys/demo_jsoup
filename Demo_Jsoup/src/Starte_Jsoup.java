import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.net.IDN;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.bcel.generic.NEW;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;

import de.smartsys.datum.DoDatum;
import de.smartsys.domain.DoDomain;
import de.smartsys.logic.DoLogic;
import de.smartsys.objekte.obj_AuftragSeitenCrawler_v2;
import de.smartsys.objekte.obj_Proxy;
import de.smartsys.sql.DoSQL;
import de.smartsys.string.DoString;

public class Starte_Jsoup
{
	static int anzahlDurschlauf = 0;
	static ArrayList AuftragsListeDB = new ArrayList();

	public static void main(String[] args)
	{				
		
		Response QuelleDocumentResponse = null;
		
		try
		{
			
			String url = "grüneliebe.de/hundefutter-barf-und-fertigfutter/";
			
			System.out.println(url);
			
			url = IDN.toASCII(url);
			 
			System.out.println(url);
			 
			QuelleDocumentResponse = Jsoup
										.connect("http://"+url)
										.method(Method.GET)
										.userAgent("User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64; rv:31.0) Gecko/20100101 Firefox/31.0")
										.ignoreHttpErrors(true)
										.ignoreContentType(true)
										.followRedirects(false)
										.timeout(40000)
										.execute();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	
		System.out.println(QuelleDocumentResponse.statusCode());
		System.out.println(QuelleDocumentResponse.contentType());
		

	}


}
