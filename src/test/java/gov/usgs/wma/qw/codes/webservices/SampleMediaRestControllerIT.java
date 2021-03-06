package gov.usgs.wma.qw.codes.webservices;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.github.springtestdbunit.annotation.DatabaseSetup;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@DatabaseSetup("classpath:/testData/sampleMedia.xml")
public class SampleMediaRestControllerIT extends BaseCodesRestControllerTest {

	public static String TEST_ENDPOINT = "/samplemedia";
	public static String CODE_VALUE = "Biological Tissue";
	public static String CODE_JSON = "{\"value\":\"Biological Tissue\",\"providers\":\"NWIS STEWARDS\"}";
	public static String CODE_XML = XML_HEADER +"<Code value=\"Biological Tissue\" providers=\"NWIS STEWARDS\"/>";
	public static String SEARCH_TEXT = "is";
	public static String SEARCH_JSON = "{\"codes\":[{\"value\":\"Biological Tissue\",\"providers\":\"NWIS STEWARDS\"}],\"recordCount\":2}";
	public static String SEARCH_XML = XML_HEADER + "<Codes><Code value=\"Biological Tissue\" providers=\"NWIS STEWARDS\"/><recordCount>2</recordCount></Codes>"; 
	public static String COMPARE_FILE_JSON = "sampleMedia.json";
	public static String COMPARE_FILE_XML = "sampleMedia.xml";

	@Test
	public void getListAsJsonTest() throws Exception {
		runGetListAsJsonTest(TEST_ENDPOINT, SEARCH_TEXT, COMPARE_FILE_JSON, SEARCH_JSON);
	}

	@Test
	public void getListAsXmlTest() throws Exception {
		runGetListAsXmlTest(TEST_ENDPOINT, SEARCH_TEXT, COMPARE_FILE_XML, SEARCH_XML);
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
