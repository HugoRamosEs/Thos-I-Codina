import java.awt.Point;

public class Main {
	public static void main(String[] args) {
		OkWindow ok = new OkWindow(600, 400, new Point(100, 100), "Eggs aren't supposed to be green");
		System.out.println(ok);
		
		YesNoWindow yesNoWindow = new YesNoWindow(600, 400, new Point(100, 100), "the only way to close this dialig is by pressing one of the following buttons. Do you underrstand?");
		System.out.println(yesNoWindow);
		
		DialogWindow dialogWindow = new DialogWindow(600, 400, new Point(100, 100), "Would you like some green eggs to go with that ham?");
		Button yesPlease = new Button(50, 20, new Point(400, 350), "Yes, please");
		Button noThanks = new Button(50, 20, new Point(450, 350), "No, thanks");
		Button noEggs = new Button(50, 20, new Point(500, 350), "No eggs, ho ham");
		
		dialogWindow.addComponent(yesPlease);
		dialogWindow.addComponent(noThanks);
		dialogWindow.addComponent(noEggs);
		
		System.out.println(dialogWindow);
	}
}
