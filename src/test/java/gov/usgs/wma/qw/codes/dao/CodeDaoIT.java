package gov.usgs.wma.qw.codes.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.github.springtestdbunit.annotation.DatabaseSetup;

import gov.usgs.wma.qw.BaseIT;
import gov.usgs.wma.qw.codes.Code;
import gov.usgs.wma.qw.codes.CodeType;
import gov.usgs.wma.qw.codes.dao.CodeDao;
import gov.usgs.wma.qw.springinit.DBTestConfig;

@SpringBootTest(webEnvironment=WebEnvironment.NONE,
		classes={DBTestConfig.class, CodeDao.class})
public class CodeDaoIT extends BaseIT {

	@Autowired
	private CodeDao codeDao;

	@Test
	@DatabaseSetup("classpath:/testData/assemblage.xml")
	public void assemblageTest() {
		List<Code> codes = codeDao.getCodes(CodeType.ASSEMBLAGE);
		assertNotNull(codes);
		assertEquals(11, codes.size());
		assertEquals("Invertebrates", codes.get(7).getValue());
		assertNull(codes.get(7).getDesc());
		assertEquals("NWIS STEWARDS STORET", codes.get(0).getProviders());
		assertEquals("NWIS STEWARDS STORET", codes.get(1).getProviders());
		assertEquals("NWIS STEWARDS", codes.get(2).getProviders());
		assertEquals("NWIS", codes.get(3).getProviders());
		assertEquals("STEWARDS", codes.get(4).getProviders());
		assertEquals("NWIS STORET", codes.get(5).getProviders());
		assertEquals("STEWARDS STORET", codes.get(6).getProviders());
		assertEquals("STEWARDS", codes.get(7).getProviders());
		assertEquals("STEWARDS", codes.get(8).getProviders());
		assertEquals("NWIS STEWARDS STORET", codes.get(9).getProviders());
		assertEquals("STORET", codes.get(10).getProviders());

		Map<String, Object> parms = new HashMap<String, Object>();
		int cnt = codeDao.getRecordCount(CodeType.ASSEMBLAGE, parms);
		assertEquals(11, cnt);

		parms.put("text", "te");
		codes = codeDao.getCodes(CodeType.ASSEMBLAGE, parms);
		assertNotNull(codes);
		assertEquals(4, codes.size());
		assertEquals("Bacteria/Virus", codes.get(1).getValue());
		assertNull(codes.get(1).getDesc());
		assertEquals("NWIS STEWARDS", codes.get(1).getProviders());

		cnt = codeDao.getRecordCount(CodeType.ASSEMBLAGE, parms);
		assertEquals(4, cnt);

		Code code = codeDao.getCode(CodeType.ASSEMBLAGE, null);
		assertNull(code);
		code = codeDao.getCode(CodeType.ASSEMBLAGE, "xxx");
		assertNull(code);
		code = codeDao.getCode(CodeType.ASSEMBLAGE, "Fish/Nekton");
		assertEquals("Fish/Nekton", code.getValue());
		assertNull(code.getDesc());
		assertEquals("STEWARDS STORET", code.getProviders());

		parms.clear();
		parms.put("fetchSize", 3);
		parms.put("offset", 9);
		codes = codeDao.getCodes(CodeType.ASSEMBLAGE, parms);
		assertNotNull(codes);
		assertEquals(2, codes.size());
		assertEquals("Phytoplankton/Zooplankton", codes.get(0).getValue());
		assertNull(codes.get(0).getDesc());
		assertEquals("NWIS STEWARDS STORET", codes.get(0).getProviders());
	}

	@Test
	@DatabaseSetup("classpath:/testData/charName.xml")
	public void charNameTest() {
		List<Code> codes = codeDao.getCodes(CodeType.CHARACTERISTICNAME);
		assertNotNull(codes);
		assertEquals(11, codes.size());
		assertEquals("Ammonium-Nitrogen", codes.get(7).getValue());
		assertNull(codes.get(7).getDesc());
		assertEquals("NWIS STEWARDS STORET", codes.get(0).getProviders());
		assertEquals("NWIS STEWARDS STORET", codes.get(1).getProviders());
		assertEquals("NWIS STEWARDS", codes.get(2).getProviders());
		assertEquals("NWIS", codes.get(3).getProviders());
		assertEquals("STEWARDS", codes.get(4).getProviders());
		assertEquals("NWIS STORET", codes.get(5).getProviders());
		assertEquals("STEWARDS STORET", codes.get(6).getProviders());
		assertEquals("STEWARDS", codes.get(7).getProviders());
		assertEquals("STEWARDS", codes.get(8).getProviders());
		assertEquals("NWIS STEWARDS STORET", codes.get(9).getProviders());
		assertEquals("STORET", codes.get(10).getProviders());

		Map<String, Object> parms = new HashMap<String, Object>();
		int cnt = codeDao.getRecordCount(CodeType.CHARACTERISTICNAME, parms);
		assertEquals(11, cnt);

		parms.put("text", "al");
		codes = codeDao.getCodes(CodeType.CHARACTERISTICNAME, parms);
		assertNotNull(codes);
		assertEquals(4, codes.size());
		assertEquals("Alachlor", codes.get(1).getValue());
		assertNull(codes.get(1).getDesc());
		assertEquals("NWIS STEWARDS STORET", codes.get(1).getProviders());

		cnt = codeDao.getRecordCount(CodeType.CHARACTERISTICNAME, parms);
		assertEquals(4, cnt);

		Code code = codeDao.getCode(CodeType.CHARACTERISTICNAME, null);
		assertNull(code);
		code = codeDao.getCode(CodeType.CHARACTERISTICNAME, "xxx");
		assertNull(code);
		code = codeDao.getCode(CodeType.CHARACTERISTICNAME, "Alkalinity");
		assertEquals("Alkalinity", code.getValue());
		assertNull(code.getDesc());
		assertEquals("NWIS STEWARDS", code.getProviders());

		parms.clear();
		parms.put("fetchSize", 3);
		parms.put("offset", 9);
		codes = codeDao.getCodes(CodeType.CHARACTERISTICNAME, parms);
		assertNotNull(codes);
		assertEquals(2, codes.size());
		assertEquals("Atrazine", codes.get(0).getValue());
		assertNull(codes.get(0).getDesc());
		assertEquals("NWIS STEWARDS STORET", codes.get(0).getProviders());
	}

	@Test
	@DatabaseSetup("classpath:/testData/charType.xml")
	public void charTypeTest() {
		List<Code> codes = codeDao.getCodes(CodeType.CHARACTERISTICTYPE);
		assertNotNull(codes);
		assertEquals(11, codes.size());
		assertEquals("Organics, PCBs", codes.get(7).getValue());
		assertNull(codes.get(7).getDesc());
		assertEquals("NWIS STEWARDS STORET", codes.get(0).getProviders());
		assertEquals("NWIS STEWARDS STORET", codes.get(1).getProviders());
		assertEquals("NWIS STEWARDS", codes.get(2).getProviders());
		assertEquals("NWIS", codes.get(3).getProviders());
		assertEquals("STEWARDS", codes.get(4).getProviders());
		assertEquals("NWIS STORET", codes.get(5).getProviders());
		assertEquals("STEWARDS STORET", codes.get(6).getProviders());
		assertEquals("STEWARDS", codes.get(7).getProviders());
		assertEquals("STEWARDS", codes.get(8).getProviders());
		assertEquals("NWIS STEWARDS STORET", codes.get(9).getProviders());
		assertEquals("STORET", codes.get(10).getProviders());

		Map<String, Object> parms = new HashMap<String, Object>();
		int cnt = codeDao.getRecordCount(CodeType.CHARACTERISTICTYPE, parms);
		assertEquals(11, cnt);

		parms.put("text", "org");
		codes = codeDao.getCodes(CodeType.CHARACTERISTICTYPE, parms);
		assertNotNull(codes);
		assertEquals(7, codes.size());
		assertEquals("Organics, Other", codes.get(1).getValue());
		assertNull(codes.get(1).getDesc());
		assertEquals("STEWARDS STORET", codes.get(1).getProviders());

		cnt = codeDao.getRecordCount(CodeType.CHARACTERISTICTYPE, parms);
		assertEquals(7, cnt);

		Code code = codeDao.getCode(CodeType.CHARACTERISTICTYPE, null);
		assertNull(code);
		code = codeDao.getCode(CodeType.CHARACTERISTICTYPE, "xxx");
		assertNull(code);
		code = codeDao.getCode(CodeType.CHARACTERISTICTYPE, "Inorganics, Major, Non-metals");
		assertEquals("Inorganics, Major, Non-metals", code.getValue());
		assertNull(code.getDesc());
		assertEquals("NWIS STEWARDS STORET", code.getProviders());

		parms.clear();
		parms.put("fetchSize", 3);
		parms.put("offset", 9);
		codes = codeDao.getCodes(CodeType.CHARACTERISTICTYPE, parms);
		assertNotNull(codes);
		assertEquals(2, codes.size());
		assertEquals("Physical", codes.get(0).getValue());
		assertNull(codes.get(0).getDesc());
		assertEquals("NWIS STEWARDS STORET", codes.get(0).getProviders());
	}

	@Test
	@DatabaseSetup("classpath:/testData/countryCode.xml")
	public void countryCodeTest() {
		List<Code> codes = codeDao.getCodes(CodeType.COUNTRYCODE);
		assertNotNull(codes);
		assertEquals(19, codes.size());
		assertEquals("AH", codes.get(7).getValue());
		assertEquals("AH COUNTRY", codes.get(7).getDesc());
		assertEquals("NWIS STEWARDS STORET", codes.get(0).getProviders());
		assertEquals("NWIS STEWARDS STORET", codes.get(1).getProviders());
		assertEquals("NWIS STEWARDS", codes.get(2).getProviders());
		assertEquals("NWIS", codes.get(3).getProviders());
		assertEquals("STEWARDS", codes.get(4).getProviders());
		assertEquals("NWIS STORET", codes.get(5).getProviders());
		assertEquals("STEWARDS STORET", codes.get(6).getProviders());
		assertEquals("STEWARDS", codes.get(7).getProviders());
		assertEquals("STEWARDS", codes.get(8).getProviders());
		assertEquals("NWIS STEWARDS STORET", codes.get(9).getProviders());
		assertEquals("STORET", codes.get(10).getProviders());

		Map<String, Object> parms = new HashMap<String, Object>();
		int cnt = codeDao.getRecordCount(CodeType.COUNTRYCODE, parms);
		assertEquals(19, cnt);

		parms.put("text", "ca");
		codes = codeDao.getCodes(CodeType.COUNTRYCODE, parms);
		assertNotNull(codes);
		assertEquals(3, codes.size());
		assertEquals("US", codes.get(2).getValue());
		assertEquals("UNITED STATES OF AMERICA", codes.get(2).getDesc());
		assertEquals("NWIS STEWARDS STORET", codes.get(2).getProviders());

		cnt = codeDao.getRecordCount(CodeType.COUNTRYCODE, parms);
		assertEquals(3, cnt);

		Code code = codeDao.getCode(CodeType.COUNTRYCODE, null);
		assertNull(code);
		code = codeDao.getCode(CodeType.COUNTRYCODE, "xxx");
		assertNull(code);
		code = codeDao.getCode(CodeType.COUNTRYCODE, "US");
		assertEquals("US", code.getValue());
		assertEquals("UNITED STATES OF AMERICA", code.getDesc());
		assertEquals("NWIS STEWARDS STORET", code.getProviders());

		parms.clear();
		parms.put("fetchSize", 3);
		parms.put("offset", 17);
		codes = codeDao.getCodes(CodeType.COUNTRYCODE, parms);
		assertNotNull(codes);
		assertEquals(2, codes.size());
		assertEquals("RM", codes.get(0).getValue());
		assertEquals("MARSHALL ISLANDS", codes.get(0).getDesc());
		assertEquals("NWIS", codes.get(0).getProviders());
	}

	@Test
	@DatabaseSetup("classpath:/testData/countyCode.xml")
	public void countyCodeTest() {
		List<Code> codes = codeDao.getCodes(CodeType.COUNTYCODE);
		assertNotNull(codes);
		assertEquals(11, codes.size());
		assertEquals("US:24:011", codes.get(7).getValue());
		assertEquals("US, MARYLAND, CAROLINE", codes.get(7).getDesc());
		assertEquals("NWIS STEWARDS STORET", codes.get(0).getProviders());
		assertEquals("NWIS STEWARDS STORET", codes.get(1).getProviders());
		assertEquals("NWIS STEWARDS", codes.get(2).getProviders());
		assertEquals("NWIS", codes.get(3).getProviders());
		assertEquals("STEWARDS", codes.get(4).getProviders());
		assertEquals("NWIS STORET", codes.get(5).getProviders());
		assertEquals("STEWARDS STORET", codes.get(6).getProviders());
		assertEquals("STEWARDS", codes.get(7).getProviders());
		assertEquals("STEWARDS", codes.get(8).getProviders());
		assertEquals("NWIS STEWARDS STORET", codes.get(9).getProviders());
		assertEquals("STORET", codes.get(10).getProviders());

		Map<String, Object> parms = new HashMap<String, Object>();
		int cnt = codeDao.getRecordCount(CodeType.COUNTYCODE, parms);
		assertEquals(11, cnt);

		parms.put("text", "ne");
		codes = codeDao.getCodes(CodeType.COUNTYCODE, parms);
		assertNotNull(codes);
		assertEquals(3, codes.size());
		assertEquals("US:24:011", codes.get(2).getValue());
		assertEquals("US, MARYLAND, CAROLINE", codes.get(2).getDesc());
		assertEquals("STEWARDS", codes.get(2).getProviders());

		cnt = codeDao.getRecordCount(CodeType.COUNTYCODE, parms);
		assertEquals(3, cnt);

		parms.put("text", "cn");
		codes = codeDao.getCodes(CodeType.COUNTYCODE, parms);
		assertNotNull(codes);
		assertEquals(1, codes.size());
		assertEquals("CN:90:000", codes.get(0).getValue());
		assertEquals("CN, NEW BRUNSWICK, UNSPECIFIED",codes.get(0).getDesc());
		assertEquals("NWIS STEWARDS STORET", codes.get(0).getProviders());

		cnt = codeDao.getRecordCount(CodeType.COUNTYCODE, parms);
		assertEquals(1, cnt);

		Code code = codeDao.getCode(CodeType.COUNTYCODE, null);
		assertNull(code);
		code = codeDao.getCode(CodeType.COUNTYCODE, "xxx");
		assertNull(code);
		code = codeDao.getCode(CodeType.COUNTYCODE, "US:55:027");
		assertEquals("US:55:027", code.getValue());
		assertEquals("US, WISCONSIN, DODGE", code.getDesc());
		assertEquals("STORET", code.getProviders());

		parms.put("text", "ne");
		parms.put("statecode", states);
		codes = codeDao.getCodes(CodeType.COUNTYCODE, parms);
		assertNotNull(codes);
		assertEquals(2, codes.size());
		assertEquals("CN:90:000", codes.get(0).getValue());
		assertEquals("CN, NEW BRUNSWICK, UNSPECIFIED", codes.get(0).getDesc());
		assertEquals("NWIS STEWARDS STORET", codes.get(0).getProviders());
		assertEquals("US:19:015", codes.get(1).getValue());
		assertEquals("US, IOWA, BOONE", codes.get(1).getDesc());
		assertEquals("NWIS STORET", codes.get(1).getProviders());

		parms.clear();
		parms.put("fetchSize", 3);
		parms.put("offset", 9);
		codes = codeDao.getCodes(CodeType.COUNTYCODE, parms);
		assertNotNull(codes);
		assertEquals(2, codes.size());
		assertEquals("US:28:107", codes.get(0).getValue());
		assertEquals("US, MISSISSIPPI, PANOLA", codes.get(0).getDesc());
		assertEquals("NWIS STEWARDS STORET", codes.get(0).getProviders());
	}

	@Test
	public void dataSourceTest() {
		List<Code> codes = codeDao.getCodes(CodeType.DATASOURCE);
		assertNotNull(codes);
		assertEquals(4, codes.size());
		assertEquals("BIODATA", codes.get(0).getValue());
		assertNull(codes.get(0).getDesc());
		assertNull(codes.get(0).getProviders());
		assertEquals("NWIS", codes.get(1).getValue());
		assertNull(codes.get(1).getDesc());
		assertNull(codes.get(1).getProviders());
		assertEquals("STEWARDS", codes.get(2).getValue());
		assertNull(codes.get(2).getDesc());
		assertNull(codes.get(2).getProviders());
		assertEquals("STORET", codes.get(3).getValue());
		assertNull(codes.get(3).getDesc());
		assertNull(codes.get(3).getProviders());

		Map<String, Object> parms = new HashMap<String, Object>();
		int cnt = codeDao.getRecordCount(CodeType.DATASOURCE, parms);
		assertEquals(4, cnt);

		parms.put("text", "st");
		codes = codeDao.getCodes(CodeType.DATASOURCE, parms);
		assertNotNull(codes);
		assertEquals(2, codes.size());
		assertEquals("STEWARDS", codes.get(0).getValue());
		assertNull(codes.get(0).getDesc());
		assertNull(codes.get(0).getProviders());
		assertEquals("STORET", codes.get(1).getValue());
		assertNull(codes.get(1).getDesc());
		assertNull(codes.get(1).getProviders());

		cnt = codeDao.getRecordCount(CodeType.DATASOURCE, parms);
		assertEquals(2, cnt);

		Code code = codeDao.getCode(CodeType.DATASOURCE, null);
		assertNull(code);
		code = codeDao.getCode(CodeType.DATASOURCE, "xxx");
		assertNull(code);
		code = codeDao.getCode(CodeType.DATASOURCE, "NWIS");
		assertEquals("NWIS", code.getValue());
		assertNull(code.getDesc());
		assertNull(code.getProviders());

		parms.clear();
		parms.put("fetchSize", 3);
		parms.put("offset", 2);
		codes = codeDao.getCodes(CodeType.DATASOURCE, parms);
		assertNotNull(codes);
		assertEquals(2, codes.size());
		assertEquals("STEWARDS", codes.get(0).getValue());
		assertNull(codes.get(0).getDesc());
		assertNull(codes.get(0).getProviders());
	}

	@Test
	@DatabaseSetup("classpath:/testData/organization.xml")
	public void organizationTest() {
		List<Code> codes = codeDao.getCodes(CodeType.ORGANIZATION);
		assertNotNull(codes);
		assertEquals(11, codes.size());
		assertEquals("USGS-VA", codes.get(7).getValue());
		assertEquals("USGS Virginia Water Science Center", codes.get(7).getDesc());
		assertEquals("NWIS STEWARDS STORET", codes.get(0).getProviders());
		assertEquals("NWIS STEWARDS STORET", codes.get(1).getProviders());
		assertEquals("NWIS STEWARDS", codes.get(2).getProviders());
		assertEquals("NWIS", codes.get(3).getProviders());
		assertEquals("STEWARDS", codes.get(4).getProviders());
		assertEquals("NWIS STORET", codes.get(5).getProviders());
		assertEquals("STEWARDS STORET", codes.get(6).getProviders());
		assertEquals("STEWARDS", codes.get(7).getProviders());
		assertEquals("STEWARDS", codes.get(8).getProviders());
		assertEquals("NWIS STEWARDS STORET", codes.get(9).getProviders());
		assertEquals("STORET", codes.get(10).getProviders());

		Map<String, Object> parms = new HashMap<String, Object>();
		int cnt = codeDao.getRecordCount(CodeType.ORGANIZATION, parms);
		assertEquals(11, cnt);

		parms.put("text", "in");
		codes = codeDao.getCodes(CodeType.ORGANIZATION, parms);
		assertNotNull(codes);
		assertEquals(5, codes.size());
		assertEquals("USGS-WA", codes.get(1).getValue());
		assertEquals("USGS Washington Water Science Center", codes.get(1).getDesc());
		assertEquals("STEWARDS", codes.get(1).getProviders());

		cnt = codeDao.getRecordCount(CodeType.ORGANIZATION, parms);
		assertEquals(5, cnt);

		parms.put("text", "ar");
		codes = codeDao.getCodes(CodeType.ORGANIZATION, parms);
		assertNotNull(codes);
		assertEquals(2, codes.size());
		assertEquals("ARS", codes.get(0).getValue());
		assertEquals("USDA Agricultural Research Service",codes.get(0).getDesc());
		assertEquals("NWIS STEWARDS", codes.get(0).getProviders());
		assertEquals("0800257_WQX", codes.get(1).getValue());
		assertEquals("Clear Creek  Superfund",codes.get(1).getDesc());
		assertEquals("NWIS STEWARDS STORET", codes.get(1).getProviders());

		cnt = codeDao.getRecordCount(CodeType.ORGANIZATION, parms);
		assertEquals(2, cnt);

		Code code = codeDao.getCode(CodeType.ORGANIZATION, null);
		assertNull(code);
		code = codeDao.getCode(CodeType.ORGANIZATION, "xxx");
		assertNull(code);
		code = codeDao.getCode(CodeType.ORGANIZATION, "USGS-WI");
		assertEquals("USGS-WI", code.getValue());
		assertEquals("USGS Wisconsin Water Science Center", code.getDesc());
		assertEquals("NWIS STEWARDS STORET", code.getProviders());

		parms.clear();
		parms.put("fetchSize", 3);
		parms.put("offset", 9);
		codes = codeDao.getCodes(CodeType.ORGANIZATION, parms);
		assertNotNull(codes);
		assertEquals(2, codes.size());
		assertEquals("USGS-WI", codes.get(0).getValue());
		assertEquals("USGS Wisconsin Water Science Center", codes.get(0).getDesc());
		assertEquals("NWIS STEWARDS STORET", codes.get(0).getProviders());
	}
	
	@Test
	@DatabaseSetup("classpath:/testData/monitoringLocation.xml")
	public void monitoringLocationTest() {
		List<Code> codes = codeDao.getCodes(CodeType.MONITORINGLOCATION);
		assertNotNull(codes);
		assertEquals(5, codes.size());
		assertEquals("USGS-07083000", codes.get(0).getValue());
		assertEquals("HALFMOON CREEK NEAR MALTA, CO", codes.get(0).getDesc());
		assertEquals("NWIS", codes.get(0).getProviders());
		
		Map<String, Object> parms = new HashMap<String, Object>();
		int cnt = codeDao.getRecordCount(CodeType.MONITORINGLOCATION, parms);
		assertEquals(5, cnt);
		
		parms.put("text", "USGS-070837");
		codes = codeDao.getCodes(CodeType.MONITORINGLOCATION, parms);
		assertNotNull(codes);
		assertEquals(2, codes.size());
		assertEquals("USGS-07083700", codes.get(0).getValue());
		assertEquals("USGS-07083710", codes.get(1).getValue());
		
		cnt = codeDao.getRecordCount(CodeType.MONITORINGLOCATION, parms);
		assertEquals(2, cnt);
		
		Code code = codeDao.getCode(CodeType.MONITORINGLOCATION, null);
		assertNull(code);
		code = codeDao.getCode(CodeType.MONITORINGLOCATION, "USGS");
		assertNull(code);
		code = codeDao.getCode(CodeType.MONITORINGLOCATION, "USGS-07083200");
		assertEquals("USGS-07083200", code.getValue());
		assertEquals("HALFMOON CR BL HALFMOON DIVERSION NR LEADVILLE, CO", code.getDesc());
		assertEquals("NWIS", code.getProviders());
		
		parms.clear();
		parms.put("organizationid", new String[]{"USGS-CO"});
		codes = codeDao.getCodes(CodeType.MONITORINGLOCATION, parms);
		assertNotNull(codes);
		assertEquals(3, codes.size());
		assertEquals("USGS-07083000", codes.get(0).getValue());
		cnt = codeDao.getRecordCount(CodeType.MONITORINGLOCATION, parms);
		assertEquals(3, cnt);
		
		parms.clear();
		parms.put("organizationid", new String[]{"USGS-CO", "USGS-AR"});
		codes = codeDao.getCodes(CodeType.MONITORINGLOCATION, parms);
		assertNotNull(codes);
		assertEquals(5, codes.size());
		assertEquals("USGS-07083000", codes.get(0).getValue());
		cnt = codeDao.getRecordCount(CodeType.MONITORINGLOCATION, parms);
		assertEquals(5, cnt);
		
		parms.clear();
		parms.put("organizationid", new String[]{"USGS-GO"});
		codes = codeDao.getCodes(CodeType.MONITORINGLOCATION, parms);
		assertEquals(0, codes.size());
		cnt = codeDao.getRecordCount(CodeType.MONITORINGLOCATION, parms);
		assertEquals(0, cnt);
		
		parms.clear();
		parms.put("provider", new String[]{"BIODATA"});
		codes = codeDao.getCodes(CodeType.MONITORINGLOCATION, parms);
		assertNotNull(codes);
		assertEquals(0, codes.size());
		cnt = codeDao.getRecordCount(CodeType.MONITORINGLOCATION, parms);
		assertEquals(0, cnt);
		
		parms.clear();
		parms.put("provider", new String[]{"BIODATA", "NWIS"});
		codes = codeDao.getCodes(CodeType.MONITORINGLOCATION, parms);
		assertNotNull(codes);
		assertEquals(5, codes.size());
		assertEquals("USGS-07083000", codes.get(0).getValue());
		cnt = codeDao.getRecordCount(CodeType.MONITORINGLOCATION, parms);
		assertEquals(5, cnt);
		
		parms.clear();
		parms.put("provider", new String[]{"STORET"});
		codes = codeDao.getCodes(CodeType.MONITORINGLOCATION, parms);
		assertEquals(0, codes.size());
		cnt = codeDao.getRecordCount(CodeType.MONITORINGLOCATION, parms);
		assertEquals(0, cnt);
		
		parms.clear();
		parms.put("fetchSize", 2);
		parms.put("offset", 1);
		codes = codeDao.getCodes(CodeType.MONITORINGLOCATION, parms);
		assertNotNull(codes);
		assertEquals(2, codes.size());
		assertEquals("USGS-07083200", codes.get(0).getValue());
		assertEquals("HALFMOON CR BL HALFMOON DIVERSION NR LEADVILLE, CO", codes.get(0).getDesc());
		assertEquals("NWIS", codes.get(0).getProviders());
		
	}

	@Test
	@DatabaseSetup("classpath:/testData/sampleMedia.xml")
	public void sampleMediaTest() {
		List<Code> codes = codeDao.getCodes(CodeType.SAMPLEMEDIA);
		assertNotNull(codes);
		assertEquals(11, codes.size());
		assertEquals("Soil", codes.get(7).getValue());
		assertNull(codes.get(7).getDesc());
		assertEquals("NWIS STEWARDS STORET", codes.get(0).getProviders());
		assertEquals("NWIS STEWARDS STORET", codes.get(1).getProviders());
		assertEquals("NWIS STEWARDS", codes.get(2).getProviders());
		assertEquals("NWIS", codes.get(3).getProviders());
		assertEquals("STEWARDS", codes.get(4).getProviders());
		assertEquals("NWIS STORET", codes.get(5).getProviders());
		assertEquals("STEWARDS STORET", codes.get(6).getProviders());
		assertEquals("STEWARDS", codes.get(7).getProviders());
		assertEquals("STEWARDS", codes.get(8).getProviders());
		assertEquals("NWIS STEWARDS STORET", codes.get(9).getProviders());
		assertEquals("STORET", codes.get(10).getProviders());

		Map<String, Object> parms = new HashMap<String, Object>();
		int cnt = codeDao.getRecordCount(CodeType.SAMPLEMEDIA, parms);
		assertEquals(11, cnt);

		parms.put("text", "is");
		codes = codeDao.getCodes(CodeType.SAMPLEMEDIA, parms);
		assertNotNull(codes);
		assertEquals(2, codes.size());
		assertEquals("Biological Tissue", codes.get(1).getValue());
		assertNull(codes.get(1).getDesc());
		assertEquals("NWIS STEWARDS", codes.get(1).getProviders());

		cnt = codeDao.getRecordCount(CodeType.SAMPLEMEDIA, parms);
		assertEquals(2, cnt);

		Code code = codeDao.getCode(CodeType.SAMPLEMEDIA, null);
		assertNull(code);
		code = codeDao.getCode(CodeType.SAMPLEMEDIA, "xxx");
		assertNull(code);
		code = codeDao.getCode(CodeType.SAMPLEMEDIA, "Other");
		assertEquals("Other", code.getValue());
		assertNull(code.getDesc());
		assertEquals("NWIS STORET", code.getProviders());

		parms.clear();
		parms.put("fetchSize", 3);
		parms.put("offset", 9);
		codes = codeDao.getCodes(CodeType.SAMPLEMEDIA, parms);
		assertNotNull(codes);
		assertEquals(2, codes.size());
		assertEquals("Water", codes.get(0).getValue());
		assertNull(codes.get(0).getDesc());
		assertEquals("NWIS STEWARDS STORET", codes.get(0).getProviders());
	}

	@Test
	@DatabaseSetup("classpath:/testData/project.xml")
	public void projectTest() {
		List<Code> codes = codeDao.getCodes(CodeType.PROJECT);
		assertNotNull(codes);
		assertEquals(11, codes.size());
		assertEquals("ggg", codes.get(6).getValue());
		assertEquals("čćžđš", codes.get(10).getValue());
		assertNull(codes.get(6).getDesc());
		assertEquals("NWIS STEWARDS STORET", codes.get(0).getProviders());
		assertEquals("NWIS STEWARDS STORET", codes.get(1).getProviders());
		assertEquals("NWIS STEWARDS", codes.get(2).getProviders());
		assertEquals("STEWARDS", codes.get(3).getProviders());
		assertEquals("NWIS STORET", codes.get(4).getProviders());
		assertEquals("STEWARDS STORET", codes.get(5).getProviders());
		assertEquals("STEWARDS", codes.get(6).getProviders());
		assertEquals("STEWARDS", codes.get(7).getProviders());
		assertEquals("NWIS STEWARDS STORET", codes.get(8).getProviders());
		assertEquals("STORET", codes.get(9).getProviders());
		assertEquals("NWIS", codes.get(10).getProviders());

		Map<String, Object> parms = new HashMap<String, Object>();
		int cnt = codeDao.getRecordCount(CodeType.PROJECT, parms);
		assertEquals(11, cnt);

		parms.put("text", "aa");
		codes = codeDao.getCodes(CodeType.PROJECT, parms);
		assertNotNull(codes);
		assertEquals(2, codes.size());
		assertEquals("Aab", codes.get(1).getValue());
		assertNull(codes.get(1).getDesc());
		assertEquals("NWIS STEWARDS STORET", codes.get(1).getProviders());

		cnt = codeDao.getRecordCount(CodeType.PROJECT, parms);
		assertEquals(2, cnt);

		Code code = codeDao.getCode(CodeType.PROJECT, null);
		assertNull(code);
		code = codeDao.getCode(CodeType.PROJECT, "xxx");
		assertNull(code);
		code = codeDao.getCode(CodeType.PROJECT, "eee");
		assertEquals("eee", code.getValue());
		assertNull(code.getDesc());
		assertEquals("NWIS STORET", code.getProviders());

		parms.clear();
		parms.put("fetchSize", 3);
		parms.put("offset", 9);
		codes = codeDao.getCodes(CodeType.PROJECT, parms);
		assertNotNull(codes);
		assertEquals(2, codes.size());
		assertEquals("jjj", codes.get(0).getValue());
		assertNull(codes.get(0).getDesc());
		assertEquals("STORET", codes.get(0).getProviders());
	}

	@Test
	@DatabaseSetup("classpath:/testData/siteType.xml")
	public void siteTypeTest() {
		List<Code> codes = codeDao.getCodes(CodeType.SITETYPE);
		assertNotNull(codes);
		assertEquals(11, codes.size());
		assertEquals("Spring", codes.get(7).getValue());
		assertNull(codes.get(7).getDesc());
		assertEquals("NWIS STEWARDS STORET", codes.get(0).getProviders());
		assertEquals("NWIS STEWARDS STORET", codes.get(1).getProviders());
		assertEquals("NWIS STEWARDS", codes.get(2).getProviders());
		assertEquals("NWIS", codes.get(3).getProviders());
		assertEquals("STEWARDS", codes.get(4).getProviders());
		assertEquals("NWIS STORET", codes.get(5).getProviders());
		assertEquals("STEWARDS STORET", codes.get(6).getProviders());
		assertEquals("STEWARDS", codes.get(7).getProviders());
		assertEquals("STEWARDS", codes.get(8).getProviders());
		assertEquals("NWIS STEWARDS STORET", codes.get(9).getProviders());
		assertEquals("STORET", codes.get(10).getProviders());

		Map<String, Object> parms = new HashMap<String, Object>();
		int cnt = codeDao.getRecordCount(CodeType.SITETYPE, parms);
		assertEquals(11, cnt);

		parms.put("text", "re");
		codes = codeDao.getCodes(CodeType.SITETYPE, parms);
		assertNotNull(codes);
		assertEquals(5, codes.size());
		assertEquals("Atmosphere", codes.get(1).getValue());
		assertNull(codes.get(1).getDesc());
		assertEquals("NWIS STEWARDS", codes.get(1).getProviders());

		cnt = codeDao.getRecordCount(CodeType.SITETYPE, parms);
		assertEquals(5, cnt);

		Code code = codeDao.getCode(CodeType.SITETYPE, null);
		assertNull(code);
		code = codeDao.getCode(CodeType.SITETYPE, "xxx");
		assertNull(code);
		code = codeDao.getCode(CodeType.SITETYPE, "Lake, Reservoir, Impoundment");
		assertEquals("Lake, Reservoir, Impoundment", code.getValue());
		assertNull(code.getDesc());
		assertEquals("STEWARDS", code.getProviders());

		parms.clear();
		parms.put("fetchSize", 3);
		parms.put("offset", 9);
		codes = codeDao.getCodes(CodeType.SITETYPE, parms);
		assertNotNull(codes);
		assertEquals(2, codes.size());
		assertEquals("Well", codes.get(0).getValue());
		assertNull(codes.get(0).getDesc());
		assertEquals("NWIS STEWARDS STORET", codes.get(0).getProviders());
	}

	@Test
	@DatabaseSetup("classpath:/testData/stateCode.xml")
	public void stateCodeTest() {
		List<Code> codes = codeDao.getCodes(CodeType.STATECODE);
		assertNotNull(codes);
		assertEquals(7, codes.size());
		assertEquals("US:78", codes.get(6).getValue());
		assertEquals("VIRGIN ISLANDS", codes.get(6).getDesc());
		for (int i=0; i<codes.size(); i++) {
			assertTrue(codes.get(i).getValue().startsWith("US:"));
			assertFalse(codes.get(i).getValue().startsWith("US, "));
		}

		Map<String, Object> parms = new HashMap<String, Object>();
		int cnt = codeDao.getRecordCount(CodeType.STATECODE, parms);
		assertEquals(7, cnt);

		parms.put("text", "te");
		codes = codeDao.getCodes(CodeType.STATECODE, parms);
		assertNotNull(codes);
		assertEquals(1, codes.size());
		assertEquals("US:48", codes.get(0).getValue());
		assertEquals("TEXAS", codes.get(0).getDesc());
		assertEquals("STEWARDS", codes.get(0).getProviders());

		cnt = codeDao.getRecordCount(CodeType.STATECODE, parms);
		assertEquals(1, cnt);

		Code code = codeDao.getCode(CodeType.STATECODE, null);
		assertNull(code);
		code = codeDao.getCode(CodeType.STATECODE, "xxx");
		assertNull(code);
		code = codeDao.getCode(CodeType.STATECODE, "US:49");
		assertEquals("US:49", code.getValue());
		assertEquals("US, UTAH", code.getDesc());
		assertEquals("NWIS STEWARDS STORET", code.getProviders());

		//This one will accept country code(s)
		parms.clear();
		parms.put("countrycode", countries1);
		codes = codeDao.getCodes(CodeType.STATECODE, parms);
		assertNotNull(codes);
		assertEquals(7, codes.size());
		assertEquals("US:78", codes.get(6).getValue());
		assertEquals("VIRGIN ISLANDS", codes.get(6).getDesc());
		for (int i=0; i<codes.size(); i++) {
			assertTrue(codes.get(i).getValue().startsWith("US:"));
			assertFalse(codes.get(i).getValue().startsWith("US, "));
		}

		parms.put("countrycode", countries2);
		codes = codeDao.getCodes(CodeType.STATECODE, parms);
		assertNotNull(codes);
		assertEquals(11, codes.size());
		assertEquals("NWIS STEWARDS STORET", codes.get(0).getProviders());
		assertEquals("NWIS STEWARDS STORET", codes.get(1).getProviders());
		assertEquals("NWIS STEWARDS", codes.get(2).getProviders());
		assertEquals("NWIS", codes.get(3).getProviders());
		assertEquals("STEWARDS", codes.get(4).getProviders());
		assertEquals("NWIS STORET", codes.get(5).getProviders());
		assertEquals("STEWARDS STORET", codes.get(6).getProviders());
		assertEquals("STEWARDS", codes.get(7).getProviders());
		assertEquals("STEWARDS", codes.get(8).getProviders());
		assertEquals("NWIS STEWARDS STORET", codes.get(9).getProviders());
		assertEquals("STORET", codes.get(10).getProviders());

		parms.put("text", "te");
		codes = codeDao.getCodes(CodeType.STATECODE, parms);
		assertNotNull(codes);
		assertEquals(3, codes.size());

		cnt = codeDao.getRecordCount(CodeType.STATECODE, parms);
		assertEquals(3, cnt);

		parms.clear();
		parms.put("countrycode", countries2);
		parms.put("fetchSize", 3);
		parms.put("offset", 9);
		codes = codeDao.getCodes(CodeType.STATECODE, parms);
		assertNotNull(codes);
		assertEquals(2, codes.size());
		assertEquals("US:49", codes.get(0).getValue());
		assertEquals("US, UTAH", codes.get(0).getDesc());
		assertEquals("NWIS STEWARDS STORET", codes.get(0).getProviders());
	}

	@Test
	@DatabaseSetup("classpath:/testData/countryCode.xml")
	public void pagingTest() {
		//no fetchsize = all
		Map<String, Object> parms = new HashMap<String, Object>();
		List<Code> codes = codeDao.getCodes(CodeType.COUNTRYCODE, parms);
		assertNotNull(codes);
		assertEquals(19, codes.size());

		parms.put("offset", 10);
		codes = codeDao.getCodes(CodeType.COUNTRYCODE, parms);
		assertNotNull(codes);
		assertEquals(19, codes.size());

		//null or zero offset starts at beginning
		parms.clear();
		parms.put("fetchSize", 3);
		codes = codeDao.getCodes(CodeType.COUNTRYCODE, parms);
		assertNotNull(codes);
		assertEquals(3, codes.size());
		assertEquals("AA", codes.get(0).getValue());

		parms.put("offset", 0);
		codes = codeDao.getCodes(CodeType.COUNTRYCODE, parms);
		assertNotNull(codes);
		assertEquals(3, codes.size());
		assertEquals("AA", codes.get(0).getValue());

		//Try getting next three
		parms.put("offset", 14);
		codes = codeDao.getCodes(CodeType.COUNTRYCODE, parms);
		assertNotNull(codes);
		assertEquals(3, codes.size());
		assertEquals("IZ", codes.get(0).getValue());

		//Try getting last bunch
		parms.put("offset", 17);
		codes = codeDao.getCodes(CodeType.COUNTRYCODE, parms);
		assertNotNull(codes);
		assertEquals(2, codes.size());
		assertEquals("RM", codes.get(0).getValue());
	}

	@Test
	@DatabaseSetup("classpath:/testData/subjectTaxonomicName.xml")
	public void subjectTaxonomicNameTest() {
		List<Code> codes = codeDao.getCodes(CodeType.SUBJECTTAXONOMICNAME);
		assertNotNull(codes);
		assertEquals(11, codes.size());
		assertEquals("Ichthyomyzon unicuspis", codes.get(7).getValue());
		assertNull(codes.get(7).getDesc());
		assertEquals("NWIS STEWARDS STORET", codes.get(0).getProviders());
		assertEquals("NWIS STEWARDS STORET", codes.get(1).getProviders());
		assertEquals("NWIS STEWARDS", codes.get(2).getProviders());
		assertEquals("NWIS", codes.get(3).getProviders());
		assertEquals("STEWARDS", codes.get(4).getProviders());
		assertEquals("NWIS STORET", codes.get(5).getProviders());
		assertEquals("STEWARDS STORET", codes.get(6).getProviders());
		assertEquals("STEWARDS", codes.get(7).getProviders());
		assertEquals("STEWARDS", codes.get(8).getProviders());
		assertEquals("NWIS STEWARDS STORET", codes.get(9).getProviders());
		assertEquals("STORET", codes.get(10).getProviders());

		Map<String, Object> parms = new HashMap<String, Object>();
		int cnt = codeDao.getRecordCount(CodeType.SUBJECTTAXONOMICNAME, parms);
		assertEquals(11, cnt);

		parms.put("text", "pa");
		codes = codeDao.getCodes(CodeType.SUBJECTTAXONOMICNAME, parms);
		assertNotNull(codes);
		assertEquals(3, codes.size());
		assertEquals("Bugula pacifica", codes.get(1).getValue());
		assertNull(codes.get(1).getDesc());
		assertEquals("STEWARDS", codes.get(1).getProviders());

		cnt = codeDao.getRecordCount(CodeType.SUBJECTTAXONOMICNAME, parms);
		assertEquals(3, cnt);

		Code code = codeDao.getCode(CodeType.SUBJECTTAXONOMICNAME, null);
		assertNull(code);
		code = codeDao.getCode(CodeType.SUBJECTTAXONOMICNAME, "xxx");
		assertNull(code);
		code = codeDao.getCode(CodeType.SUBJECTTAXONOMICNAME, "Fallacia sublucidula");
		assertEquals("Fallacia sublucidula", code.getValue());
		assertNull(code.getDesc());
		assertEquals("STEWARDS STORET", code.getProviders());

		parms.clear();
		parms.put("fetchSize", 3);
		parms.put("offset", 9);
		codes = codeDao.getCodes(CodeType.SUBJECTTAXONOMICNAME, parms);
		assertNotNull(codes);
		assertEquals(2, codes.size());
		assertEquals("Panomya ampla", codes.get(0).getValue());
		assertNull(codes.get(0).getDesc());
		assertEquals("NWIS STEWARDS STORET", codes.get(0).getProviders());
	}

}
