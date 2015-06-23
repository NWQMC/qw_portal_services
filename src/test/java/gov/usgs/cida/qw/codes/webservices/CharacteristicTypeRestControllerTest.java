package gov.usgs.cida.qw.codes.webservices;

import gov.usgs.cida.qw.IntegrationTest;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseSetups;

@Category(IntegrationTest.class)
@DatabaseSetups({
	@DatabaseSetup("classpath:/testData/clearAll.xml"),
	@DatabaseSetup("classpath:/testData/charType.xml")
})
public class CharacteristicTypeRestControllerTest extends BaseCodesRestControllerTest {

	public static String TEST_ENDPOINT = "/codes/characteristictypes";
	public static String TEST_LEGACY_ENDPOINT = "/codes/characteristictype";
	public static String CODE_VALUE = "Population/Community";
	public static String CODE_JSON = "{\"value\":\"Population/Community\",\"providers\":\"STORET\"}";
	public static String CODE_XML = XML_HEADER +"<Code value=\"Population/Community\" providers=\"STORET\"/>";
	public static String SEARCH_TEXT = "Inorganics";
	public static String SEARCH_JSON = "{\"codes\":[{\"value\":\"Inorganics, Minor, Metals\",\"providers\":\"NWIS STEWARDS\"}],\"recordCount\":4}";
	public static String SEARCH_XML = XML_HEADER + "<Codes><Code value=\"Inorganics, Minor, Metals\" providers=\"NWIS STEWARDS\"/><recordCount>4</recordCount></Codes>"; 
	public static String COMPARE_FILE_JSON = "charType.json";
	public static String COMPARE_FILE_XML = "charType.xml";
	
	@Test
	public void getListAsJsonTest() throws Exception {
		runGetListAsJsonTest(TEST_ENDPOINT, SEARCH_TEXT, COMPARE_FILE_JSON, SEARCH_JSON);
		runGetListAsJsonTest(TEST_LEGACY_ENDPOINT, SEARCH_TEXT, COMPARE_FILE_JSON, SEARCH_JSON);
    }

	@Test
	public void getListAsXmlTest() throws Exception {
		runGetListAsXmlTest(TEST_ENDPOINT, SEARCH_TEXT, COMPARE_FILE_XML, SEARCH_XML);
		runGetListAsXmlTest(TEST_LEGACY_ENDPOINT, SEARCH_TEXT, COMPARE_FILE_XML, SEARCH_XML);
	}

	@Test
	public void getCodeAsJsonTest() throws Exception {
		runGetCodeAsJson(TEST_ENDPOINT, CODE_VALUE, CODE_JSON);
		runGetCodeAsJson(TEST_LEGACY_ENDPOINT, CODE_VALUE, CODE_JSON);
	}

	@Test
	public void getCodeAsXmlTest() throws Exception {
		runGetCodeAsXml(TEST_ENDPOINT, CODE_VALUE, CODE_XML);
		runGetCodeAsXml(TEST_LEGACY_ENDPOINT, CODE_VALUE, CODE_XML);
	}

}