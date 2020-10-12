package com.innowatts.util;

import java.util.Scanner;

public class Utils {
	public static boolean isInteger(String x) {
		if (null == x || x.trim().isEmpty())
			return false;

		try (Scanner scanner = new Scanner(x)) {
			if (scanner.hasNextInt())
				return true;
			else
				return false;

		}

	}

	public static boolean isDouble(String x) {
		if (null == x || x.trim().isEmpty())
			return false;
		try (Scanner scanner = new Scanner(x)) {
			if (scanner.hasNextDouble())
				return true;
			else
				return false;
		}
	}

	public static boolean isString(String x) {
		if (null == x || x.trim().isEmpty())
			return false;
		try (Scanner scanner = new Scanner(x)) {
			if (scanner.hasNextLine())
				return true;
			else
				return false;
		}
	}

	public static int minimum(int a, int b, int c) {
		return Integer.min(a, Integer.min(b, c));
	}
}
