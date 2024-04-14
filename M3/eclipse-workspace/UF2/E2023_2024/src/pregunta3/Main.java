package pregunta3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Stack;

import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException, SAXException {
		MusicParser myParser =  new MusicParser();
		myParser.run("src/pregunta3/musica01.xml");
		System.out.println(myParser);
		Stack pilaDeMusica = (Stack) myParser.getPila();
	}

}
