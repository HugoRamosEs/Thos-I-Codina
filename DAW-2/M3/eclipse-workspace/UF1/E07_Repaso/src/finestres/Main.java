package finestres;

import java.awt.Point;

public class Main {

	public static void main(String[] args) {
		OkWindow okW = new OkWindow(600, 400, new Point(100, 100), "adeu");
		
		YesNoWindow yesNoW = new YesNoWindow(600, 400, new Point(100, 100), "hola");
		
		DialogWindow dW = new DialogWindow(600, 400, new Point(100, 100), "Would you like some green eggs to go with that ham?");
		Button YesPlease = new Button(50, 20, new Point(400, 350), "Yes, please");
		Button NoThanks = new Button(50, 20, new Point(450, 350), "No, thanks");
		Button NoEggs = new Button(50, 20, new Point(450, 350), "No eggs, ho ham");
		dW.add(YesPlease);
		dW.add(NoThanks);
		dW.add(NoEggs);
		
		okW.clone();
		
		StringBuilder sb = new StringBuilder();
		sb.append(okW);
		sb.append("--------------------------------------------------------------\n");
		sb.append(yesNoW);
		sb.append("--------------------------------------------------------------\n");
		sb.append(dW);
		sb.append("--------------------------------------------------------------\n");
		sb.append(okW.clone());
		
		System.out.println(sb);
	}
}
