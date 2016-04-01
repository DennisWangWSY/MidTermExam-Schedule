import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class ScheduleTest {
	private Schedule sch = null;
	private List<Work> workList = null;
	private Work work = null;
	@Before
	public void setUp() throws Exception {
		sch = new Schedule();
		workList = new ArrayList();
		workList.add(new Work("1",0,10));
		workList.add(new Work("2",5,5));
		workList.add(new Work("3",10,2));
		workList.add(new Work("4",11,1));
		work = new Work("4",11,1);
		work.getPriority();
	}

	@Test
	public void testFCFS() {
		List<Double> result = new ArrayList();
		result.add(8.5);result.add(3.375);
		assertEquals(result,sch.FCFS(workList));
	}

	@Test
	public void testSJF() {
		List<Double> result = new ArrayList();
		result.add(6.75);result.add(1.65);
		assertEquals(result,sch.SJF(workList));
	}
	
	@Test
	public void testSJF2() {
		workList = new ArrayList();
		workList.add(new Work("1",2,1));
		List<Double> result = new ArrayList();
		result.add(1.0);result.add(1.0);
		assertEquals(result,sch.SJF(workList));
	}
	@Test
	public void testSJF3() {
		workList = new ArrayList();
		workList.add(new Work("1",0,4));
		workList.add(new Work("2",1,1));
		workList.add(new Work("2",2,2));
		workList.add(new Work("2",3,2));
		List<Double> result = new ArrayList();
		result.add(4.75);result.add(2.625);
		assertEquals(result,sch.SJF(workList));
	}

}
