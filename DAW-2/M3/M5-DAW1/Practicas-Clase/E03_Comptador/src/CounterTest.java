import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CounterTest {

	@Test
	void test01() {
		Counter counter1 = new Counter();
		
		assertEquals(100, counter1.getValor());
	}
	
	@Test
	void test02() {
		Counter counter2 = new Counter(500);
		
		assertEquals(500, counter2.getValor());
	}
	
	@Test
	void test03() {
		Counter counter2 = new Counter(500);
		Counter counter3 = new Counter(counter2);
		
		assertEquals(counter2.getValor(), counter3.getValor());
	}
	
	@Test
	void test04() {
		Counter counter4 = new Counter(25);
		
		assertEquals(100, counter4.getValor());
	}
	
	@Test
	void test05() {
		Counter counter5 = new Counter(1200);
		
		assertEquals(900, counter5.getValor());
	}
	
	@Test
	void test06() {
		Counter counter6 = new Counter(400);
		counter6.incrementar();
		
		assertEquals(401, counter6.getValor());
	}
	
	@Test
	void test07() {
		Counter counter7 = new Counter(400);
		counter7.decrementar();
		
		assertEquals(399, counter7.getValor());
	}
	
	@Test
	void test08() {
		Counter counter8 = new Counter(900);
		counter8.incrementar();
		
		assertEquals(900, counter8.getValor());
	}
	
	@Test
	void test09() {
		Counter counter9 = new Counter(100);
		counter9.decrementar();
		
		assertEquals(100, counter9.getValor());
	}

}
