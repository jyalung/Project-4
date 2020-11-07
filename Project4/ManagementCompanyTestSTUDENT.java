package Project4;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	ManagementCompany m;
	Property p1, p2, p3, p4, p5, p6;

	@Before
	public void setUp() throws Exception {
		//student create a management company
		m = new ManagementCompany("Company", "4545", 15);
		//student add three properties, with plots, to mgmt co
		Property p1 = new Property("Mason Hills", "Rockville", 5000, "Bob Dylan", 1, 2, 2, 2);
		Property p2 = new Property("Lebinsen", "Silver Spring", 4300, "Bob Dylan", 3, 2, 2, 2);
		Property p3 = new Property("Third Day", "New York", 3900, "Bob Dylan", 4, 4, 2, 2);

		m.addProperty(p1);
		m.addProperty(p2);
		m.addProperty(p3);
		
	}

	@After
	public void tearDown() {
		//student set mgmt co to null
		m = null;
		p1 = null;
		p2 = null;
		p3 = null;
		p4 = null;
		p5 = null;
		p6 = null;

	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//student should add property with 4 args & default plot (0,0,1,1)
		p4 = new Property("Fourth Day", "Rockville", 3443, "Bob Dylan");
		assertEquals(m.addProperty(p4), 3, 0);
		//student should add property with 8 args
		p5 = new Property("Fifth Day", "New York", 4500, "Bob Dylan", 4, 6, 2, 2);
		assertEquals(m.addProperty(p5), 4, 0);
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1
		p6 = new Property("Not Added", "Does not exist City", 50505, "Bob Dylan", 9, 9, 1, 1);
		assertEquals(m.addProperty(p6), -1, 0);
	}
 
	@Test
	public void testMaxRentProp() {
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(m.maxRentProp(), 5000, 0);
		
	}

	@Test
	public void testTotalRent() {
		//student should test if totalRent returns the total rent of properties
		assertEquals(m.totalRent(), 13200, 0);
	}

 }