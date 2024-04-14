import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TempsTest {
	
	@Test
    public void test01() {
		Temps tiempo1 = new Temps();
        Temps tiempoEsperado = new Temps(0,0,0);
        assertEquals(tiempo1.getHoras(), tiempoEsperado.getHoras());
        assertEquals(tiempo1.getMinutos(), tiempoEsperado.getMinutos());
        assertEquals(tiempo1.getSegundos(), tiempoEsperado.getSegundos());
    }

	@Test
    public void test02() {
		Temps tiempo2 = new Temps(2,30,57);
		Temps tiempo3 = new Temps(1,15,34);
        Temps tiempoSuma = tiempo2.sumaTiempo(tiempo3, tiempo2);
        Temps tiempoEsperado = new Temps(3,46,31);
        assertEquals(tiempoSuma.getHoras(), tiempoEsperado.getHoras() );
        assertEquals(tiempoSuma.getMinutos(), tiempoEsperado.getMinutos());
        assertEquals(tiempoSuma.getSegundos(), tiempoEsperado.getSegundos());
    }

    @Test
    public void test03() throws Exception {
    	Temps tiempo4 = new Temps(2,26,19);
    	Temps tiempo5 = new Temps(300,120,400);
        Temps tiempoResta = tiempo4.restaTiempo(tiempo5, tiempo4);
        Temps tiempoEsperado = new Temps(299,40,21);
        assertEquals(tiempoResta.getHoras(), tiempoEsperado.getHoras());
        assertEquals(tiempoResta.getMinutos(), tiempoEsperado.getMinutos());
        assertEquals(tiempoResta.getSegundos(), tiempoEsperado.getSegundos());
    }

    @Test
    public void test04() {
    	Temps tiempo6 = new Temps(2,30,57);
    	Temps tiempo7 = new Temps(3,17,32);
        Temps tiempoSuma = Temps.sumaTiempoEstatico(tiempo6, tiempo7);
        Temps tiempoEsperado = new Temps(5,48,29);
        assertEquals(tiempoSuma.getHoras(), tiempoEsperado.getHoras() );
        assertEquals(tiempoSuma.getMinutos(), tiempoEsperado.getMinutos());
        assertEquals(tiempoSuma.getSegundos(), tiempoEsperado.getSegundos());
    }
    
    @Test
    public void test05() throws Exception {
    	Temps tiempo8 = new Temps(5,25,55);
		Temps tiempo9 = new Temps(1,15,34);
        Temps tiempoResta = Temps.restaTiempoEstatico(tiempo8, tiempo9);
        Temps tiempoEsperado = new Temps(4,10,21);
        assertEquals(tiempoResta.getHoras(), tiempoEsperado.getHoras());
        assertEquals(tiempoResta.getMinutos(), tiempoEsperado.getMinutos());
        assertEquals(tiempoResta.getSegundos(), tiempoEsperado.getSegundos());
    }
    
    @Test
    public void test06() throws Exception {
    	Temps tiempo10 = new Temps(4,48,13);
		Temps tiempo11 = new Temps(1,11,4);
    	Exception thrown = assertThrows(Exception.class, () -> {
            tiempo10.restaTiempo(tiempo11, tiempo10);
        });
        assertEquals("El primer tiempo debe ser mayor o igual que el segundo", thrown.getMessage());
    }
    
    @Test
    public void test07() throws Exception {
    	Temps tiempo12 = new Temps(9,36,8);
		Temps tiempo13 = new Temps(0,10,7);
    	Exception thrown = assertThrows(Exception.class, () -> {
            Temps.restaTiempoEstatico(tiempo13, tiempo12);
        });
        assertEquals("El primer tiempo debe ser mayor o igual que el segundo", thrown.getMessage());
    }
    
    @Test
    public void test08() throws Exception {
    	Temps tiempo14 = new Temps(2,30,57);
    	Temps tiempo15 = new Temps(2,30,57);
    	Temps tiempo16 = new Temps(3,17,32);
    	assertTrue(tiempo14.compareTo(tiempo15) == 0);
    	assertTrue(tiempo14.compareTo(tiempo16) < 0);
    	assertTrue(tiempo16.compareTo(tiempo14) > 0);

    }

}
