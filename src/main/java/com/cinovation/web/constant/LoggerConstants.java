package com.cinovation.web.constant;

import org.springframework.data.domain.Pageable;

public class LoggerConstants {

	public String ListTableLogger(Pageable pageable, String filter1, String filter2, String filter3, String filter4, String filter5) {
		StringBuilder str = new StringBuilder();
		str.append("[pageable] => " + pageable);
		str.append("[filter1]  => " + filter1);
		str.append("[filter2]  => " + filter2);
		str.append("[filter3]  => " + filter3);
		str.append("[filter4]  => " + filter4);
		str.append("[filter5]  => " + filter5);
		return str.toString();
	}
}
