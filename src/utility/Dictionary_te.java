package utility;

import java.util.ListResourceBundle;

public class Dictionary_te extends ListResourceBundle{
	
	private Object[][] contents= {
			{"username","వినియోగదారు పేరు"},
			{"password","పాస్వర్డ్"},
			{"submit","సమర్పించండి"},
	};
	
	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
}
