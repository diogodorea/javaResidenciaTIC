package Utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Util {
	
	public static int stringToInt(String str) {
		int retorno = -1;
		
		if (str != null && str != "") {
			retorno = Integer.parseInt(str);
		}
		
		return retorno;
	}
	public static String formatDate(Date date) {
        if (date == null) {
            return "";
        }
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }
	public static String formatCurrency(double amount) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return currencyFormat.format(amount);
    }
	
}
