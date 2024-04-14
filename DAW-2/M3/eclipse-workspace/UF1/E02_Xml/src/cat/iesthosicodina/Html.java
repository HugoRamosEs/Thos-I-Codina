package cat.iesthosicodina;

public class Html {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*
<HTML>
<HEAD>
	<TITLE>Un Títol per al Browser de torn </TITLE>
</HEAD>
<BODY>
	<H1>Un altre títol, aquesta vegada més llarg.</H1>
 	<P> <IMG SRC= "./toni.gif "ALIGN= "MIDDLE " ALT= "EL Gato Felix "/>Hoola.</P>
	<P>Això és un paràgraf amb información super-important. 
	Has de veure que les línies surten enganxades fins i tot deixant
	espais, salts de línia, etc. <BR/> &#161 Si poso això
	si <STRONG>que canvia </STRONG> de línia!
	</P>
	<P>Un altre parÀGRAF, això ja és una mica rotllo.
	<H3>Posem un subtítol<H3>
	<P>Per cert, &#191 que pas amb les <A HREF= "#pepe ">ancores</A>?</P>
	<HR/>
	<UL>
		<LI> Això és una llista no ordenada.</LI>
		<LI> Les llistes queden millor si tenen diversos elements.</LI>
	</UL>
	</P>
</BODY>
</HTML> 
*/

//PROBES SIMPLES
/*
		ElementSimple title0 = new ElementSimple("title");		
		System.out.println(title0);
		
		ElementSimple title1 = new ElementSimple("title");
		title1.setContingut("Un contingut");
		System.out.println(title1);
		
		Atribut[] att = {new Atribut("src","./toni.gif"), new Atribut("align","middle"), new Atribut("alt","el gato Felix")};
		ElementSimple title2 = new ElementSimple("title");
		title2.setAtributs(att);
		title2.setContingut("Un Titulo per al Browser de torn");		
		System.out.println(title2);
		

 		Element[] eleLI =  {
				new ElementSimple("li", null, "Això és una llista no ordenada."),
				new ElementSimple("li", null, "Les llistes queden millor si tenen diversos elements.")
		};
		
		ElementComplex ul1 = new ElementComplex("ul");
		ul1.setContingut(eleLI);
		System.out.println(ul1);


		ElementComplex ul2 = new ElementComplex("ul");
		ul2.setAtributs(att);
		ul2.setContingut(eleLI);
		System.out.println(ul2);

*/
		
		
		//Definició del head
		ElementSimple title1 = new ElementSimple("title", "Un Títol per al Browser de torn");		
		Element[] contingutCapcelera = {title1};
		ElementComplex head = new ElementComplex("head");
		head.setContingut(contingutCapcelera);
		
		//definició del body
		ElementSimple h11 = new ElementSimple ("h1", "Un altre títol, aquesta vegada més llarg.. ");
		
		Atribut[] atributs = {new Atribut("src","./toni.gif"), new Atribut("align","middle"), new Atribut("alt","el gato Felix") };
		ElementSimple img = new ElementSimple("img", atributs, null);
		ElementText hola = new ElementText("Hoola.");
		Element[] contingutP11 = {img, hola};
		ElementComplex p11 = new ElementComplex("p");
		p11.setContingut(contingutP11);
		
		ElementText p21 = new ElementText("Això és un paràgraf amb información super-important.");
		ElementText p22 = new ElementText("Has de veure que les línies surten enganxades fins i tot deixant");
		ElementText p23 = new ElementText("espais, salts de línia, etc. ");
		ElementSimple br = new ElementSimple("br");
		ElementText p24 = new ElementText("&#161 Si poso això");
		ElementText p25 = new ElementText("si");		
		ElementSimple strong = new ElementSimple("strong","que canvia");
		ElementText p26 = new ElementText(" de línia!");
		Element[] contingutP2 = {p21,p22, p23, br, p24, p25, strong, p26};
		ElementComplex p2 = new ElementComplex("p");
		p2.setContingut(contingutP2);
		
		ElementText primerText = new ElementText("Un altre paràgraf, això ja és una mica rotllo.");
		ElementSimple h3Ultim = new ElementSimple("h3", "Posem un subtítol");
		
		ElementText abansA = new ElementText("Per cert, &#191 que pas amb les");
		Atribut[] attaPultim = {new Atribut("href", "#pepe")};
		ElementSimple aPultim = new ElementSimple("a", attaPultim, "ancores");
		ElementText interrogant = new ElementText("?");
		Element[] pamba = {abansA, aPultim, interrogant};
		ElementComplex pPultim = new ElementComplex("p");
		pPultim.setContingut(pamba);
		
		ElementSimple hr = new ElementSimple ("hr");
		
		ElementSimple li1 =new ElementSimple("li", "Això és una llista no ordenada.");
		ElementSimple li2 =new ElementSimple("li", "Les llistes queden millor si tenen diversos elements.");
		Element[] lis = {li1, li2};
		ElementComplex ul = new ElementComplex("ul");
		ul.setContingut(lis);
		
		Element[] ultimContingut = { primerText, h3Ultim, pPultim, hr, ul};
		ElementComplex ultim = new ElementComplex("p");
		ultim.setContingut(ultimContingut);
		
		Element[] contingutBody = {h11, p11, p2, ultim};
		ElementComplex body = new ElementComplex("body");
		body.setContingut(contingutBody);
		
		//Definició del document
		Element[] contingut = {head,body};
		ElementComplex html = new ElementComplex("html");
		html.setContingut(contingut);
		Document elMeuHTML = new Document(null,html);	
				
		System.out.println(elMeuHTML);

	}

}
