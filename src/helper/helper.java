package helper;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class helper {
	
	public static void optionpanechangebuttontext() {
		
		UIManager.put("OptionPane.cancelButtonText", "İptal");
		UIManager.put("OptionPane.noButtonText", "Hayır");
		UIManager.put("OptionPane.okButtonText", "Tamam");
		UIManager.put("OptionPane.yesButtonText", "Evet");



		
	}
	
	public static void ShowMsg(String str) {
		
		String msg;
		optionpanechangebuttontext();
		switch (str) {
		case "Fill":
			msg = "lütfen tüm alanları doldurunuz.";
			break;
		case "success":
			msg = "işlem başarılı !";
			break;
			default:
				msg = str;
		}
        
		JOptionPane.showMessageDialog(null, msg,"Mesaj",JOptionPane.INFORMATION_MESSAGE);
}
	public static boolean confirm(String str) {
		String msg;
		optionpanechangebuttontext();

		switch(str) {
		case "sure":
			msg = "Bu işlemi gerçekleştirmek istiyor musun ?";
			break;
			default:
				msg = str;
				break;
		}
		
		
		int res = JOptionPane.showConfirmDialog(null, msg,"Dikkat !", JOptionPane.YES_NO_OPTION);
		if(res ==0) {
			return true;
		}else {
			return false;
		}
		
		
	}
}