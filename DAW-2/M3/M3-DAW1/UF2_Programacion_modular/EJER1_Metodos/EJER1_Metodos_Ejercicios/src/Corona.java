
public class Corona{
	Cercle interior;
	Cercle exterior;
	
	Corona(){
		
	}
	
	Corona (Cercle inte, Cercle exte){
		interior = inte;
		exterior = exte;
	}
	
	double area() {
		return exterior.area() - interior.area();
	}
}