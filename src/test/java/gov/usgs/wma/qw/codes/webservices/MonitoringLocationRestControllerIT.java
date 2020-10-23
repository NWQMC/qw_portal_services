package gov.usgs.wma.qw.codes.webservices;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.github.springtestdbunit.annotation.DatabaseSetup;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@DatabaseSetup("classpath:/testData/monitoringLocation.xml")
public class MonitoringLocationRestControllerIT extends BaseCodesRestControllerTest{

	public static String TEST_ENDPOINT = "/monitoringlocation";
	public static String CODE_VALUE = "USGS-07083000";
	public static String CODE_JSON = "{\"value\":\"USGS-07083000\",\"desc\":\"HALFMOON CREEK NEAR MALTA, CO\",\"providers\":\"NWIS\"}";
	public static String CODE_XML = XML_HEADER + "<Code value=\"USGS-07083000\" desc=\"HALFMOON CREEK NEAR MALTA, CO\" providers=\"NWIS\"/>";

	public static String SEARCH_TEXT = "USGS-070837";
	public static String SEARCH_JSON = "{\"codes\":[{\"value\":\"USGS-07083710\",\"desc\":\"ARKANSAS RIVER BELOW EMPIRE GULCH NEAR MALTA, CO\",\"providers\":\"NWIS\"}],\"recordCount\":2}";
	public static String SEARCH_XML = XML_HEADER + "<Codes><Code value=\"USGS-07083710\" desc=\"ARKANSAS RIVER BELOW EMPIRE GULCH NEAR MALTA, CO\" providers=\"NWIS\"/><recordCount>2</recordCount></Codes>"; 	

	public static String SEARCH_TEXT_WITH_ORGID="USGS&organizationid=USGS-CO";
	public static String SEARCH_JSON_WITH_ORGID = "{\"codes\":[{\"value\":\"USGS-07083200\",\"desc\":\"HALFMOON CR BL HALFMOON DIVERSION NR LEADVILLE, CO\",\"providers\":\"NWIS\"}],\"recordCount\":3}";
	public static String SEARCH_XML_WITH_ORGID = XML_HEADER + "<Codes><Code value=\"USGS-07083200\" desc=\"HALFMOON CR BL HALFMOON DIVERSION NR LEADVILLE, CO\" providers=\"NWIS\"/><recordCount>3</recordCount></Codes>"; 	

	public static String SEARCH_TEXT_WITH_PROVIDER="USGS&provider=NWIS";
	public static String SEARCH_JSON_WITH_PROVIDER = "{\"codes\":[{\"value\":\"USGS-07083200\",\"desc\":\"HALFMOON CR BL HALFMOON DIVERSION NR LEADVILLE, CO\",\"providers\":\"NWIS\"}],\"recordCount\":5}";
	public static String SEARCH_XML_WITH_PROVIDER= XML_HEADER + "<Codes><Code value=\"USGS-07083200\" desc=\"HALFMOON CR BL HALFMOON DIVERSION NR LEADVILLE, CO\" providers=\"NWIS\"/><recordCount>5</recordCount></Codes>"; 	

	public static String COMPARE_FILE_JSON = "monitoringLocation.json";
	public static String COMPARE_FILE_XML = "monitoringLocation.xml";

	@Test
	public void getListAsJsonTest() throws Exception {
		runGetListAsJsonTest(TEST_ENDPOINT, SEARCH_TEXT, COMPARE_FILE_JSON, SEARCH_JSON);
		runGetListAsJsonTest(TEST_ENDPOINT, SEARCH_TEXT_WITH_ORGID, COMPARE_FILE_JSON, SEARCH_JSON_WITH_ORGID);
		runGetListAsJsonTest(TEST_ENDPOINT, SEARCH_TEXT_WITH_PROVIDER, COMPARE_FILE_JSON, SEARCH_JSON_WITH_PROVIDER);
	}

	@Test
	public void getListAsXmlTest() throws Exception {
		runGetListAsXmlTest(TEST_ENDPOINT, SEARCH_TEXT, COMPARE_FILE_XML, SEARCH_XML);
		runGetListAsXmlTest(TEST_ENDPOINT, SEARCH_TEXT_WITH_ORGID, COMPARE_FILE_XML, SEARCH_XML_WITH_ORGID);
		runGetListAsXmlTest(TEST_ENDPOINT, SEARCH_TEXT_WITH_PROVIDER, COMPARE_FILE_XML, SEARCH_XML_WITH_PROVIDER);
	}

	@Test
	public void getCodeAsJsonTest() throws Exception {
		runGetCodeAsJson(TEST_ENDPOINT, CODE_VALUE, CODE_JSON);
	}

	@Test
	public void getCodeAsXmlTest() throws Exception {
		runGetCodeAsXml(TEST_ENDPOINT, CODE_VALUE, CODE_XML);
	}

}
