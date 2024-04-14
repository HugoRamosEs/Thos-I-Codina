import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CotxeTest {

	@Test
	void test01() {
		Cotxe cotxe1 = new Cotxe();
		Cotxe cotxe2 = new Cotxe();
		
		assertNotEquals(cotxe1.getMatricula(), cotxe2.getMatricula());
		assertNotNull(cotxe1.getMatricula());
		assertNotNull(cotxe2.getMatricula());
	}

}
