package utility;

import java.util.ListResourceBundle;

public class Dictionary_ta extends ListResourceBundle{
	
	private Object[][] contents= {
			{"username","உன் பெயர் "},
			{"password","கடவுச் சொல் "},
			{"submit","சமர்ப்பிக்கவும்"},
	};
	
	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}

}
