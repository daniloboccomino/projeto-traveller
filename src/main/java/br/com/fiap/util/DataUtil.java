/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @class DataUtil.java
 * @description: formatar data
 * @author daniloboccomino - RM85473
 * @since May 14, 2021
 */

package br.com.fiap.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {
	
	public static String formatDate(Calendar date) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.format(date.getTime());
	}

}
