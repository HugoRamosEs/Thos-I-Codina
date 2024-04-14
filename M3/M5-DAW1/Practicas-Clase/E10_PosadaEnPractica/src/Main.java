import java.awt.Point;

public class Main {

	public static void main(String[] args) throws Exception {
        OkWindow okWindow = new OkWindow(640,400, new Point(100,100), "Eggs aren't supposed to be green");
        System.out.println(okWindow);
        
        System.out.println("------------------------------------------------------------------------------------------------------------------------");

        YesNoDialogWindow yesNoWindow = new YesNoDialogWindow(640,400, new Point(100,100), "the only way to close this dialog is by pressing one of the following buttons. Do you underrstand?");
        System.out.println(yesNoWindow);
        
        System.out.println("------------------------------------------------------------------------------------------------------------------------");

        DialogWindow dialogWindow = new DialogWindow(640,400, new Point(100,100), "Would you like some green eggs to go with that ham?");
        
        Button yesPlease = new Button(50,20,new Point(400, 350), "Yes, please");
        Button noThanks = new Button(50,20,new Point(450, 350), "No, thanks");
        Button noEggsNoHam = new Button(50,20,new Point(500, 350), "No eggs, no ham");
		dialogWindow.addComponent(yesPlease);
		dialogWindow.addComponent(noThanks);
		dialogWindow.addComponent(noEggsNoHam);
		
		System.out.println(dialogWindow);
    }
}

