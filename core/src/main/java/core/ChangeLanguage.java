package core;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ChangeLanguage implements Menu {

	private ResourceBundle rb;

	{
		rb = ResourceBundle.getBundle(RESOURCE_BUNDLE_BASE_NAME);
	}

	@Override
	public void start() {
		System.out.println(rb.getString("change.language.header"));
		System.out.print(rb.getString("select.language.cta"));
		
		Scanner sc = new Scanner(System.in);
		int languageNum = sc.nextInt();
		switch (languageNum) {
		
		case 1:
			Locale.setDefault(new Locale("en"));
			break;
		
		case 2:
			Locale.setDefault(new Locale("ru"));
			break;
		}
		
		new MainMenu().start();
	}

		

}
