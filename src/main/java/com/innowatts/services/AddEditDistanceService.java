package com.innowatts.services;

import java.util.WeakHashMap;

import org.springframework.stereotype.Service;

import com.innowatts.util.Constants;
import com.innowatts.util.Utils;

@Service(value = "addEditDistanceService")
public class AddEditDistanceService {

	public Object concatenate(WeakHashMap<String, String> request) {
		String a = request.get(Constants.A);
		String b = request.get(Constants.B);
		if (Utils.isInteger(a) && Utils.isInteger(b)) {
			return Integer.parseInt(a) + Integer.parseInt(b);
		} else if (Utils.isDouble(a) && Utils.isDouble(b)) {
			return Double.parseDouble(a) + Double.parseDouble(b);
		} else if ((Utils.isDouble(a) && Utils.isInteger(b)) || ((Utils.isInteger(a) && Utils.isDouble(b)))) {
			return Utils.isDouble(a) && Utils.isInteger(b) ? Double.parseDouble(a) + Integer.parseInt(b)
					: Integer.parseInt(a) + Double.parseDouble(b);
		} else if (!a.matches(Constants.DIGIT_REG) && !b.matches(Constants.DIGIT_REG)) {
			return a + Constants.BLANK_SPACE + b;
		} else {
			return Constants.ILLEGAL_INPUT;
		}
	}

	public Object editDistance(WeakHashMap<String, String> request) {
		String a = request.get(Constants.A);
		String b = request.get(Constants.B);
		if(1 <= a.length()&& b.length() <= 450) {
			return minStepsAtoB(a, a.length(), b, b.length());
		}else {
			return Constants.A_AND_B_ILLEGAL_INPUT;
		}
		
	}

	private int minStepsAtoB(String x, int m, String y, int n) {
		if (m == 0 || n == 0) {
			return m == 0 ? n : m;
		}
		int cost = (x.charAt(m - 1) == y.charAt(n - 1)) ? 0 : 1;
		return Utils.minimum(minStepsAtoB(x, m - 1, y, n) + 1, minStepsAtoB(x, m, y, n - 1) + 1, minStepsAtoB(x, m - 1, y, n - 1) + cost);
	}

}
