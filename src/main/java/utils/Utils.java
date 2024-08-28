package utils;

public class Utils {

	/**
	 * 문자열이 null, 빈 문자열, 숫자로 변환할 수 없는 문자열인 경우
	 * defaultValue로 설정한 값을 반환한다.
	 * @param value 문자열
	 * @param defaultValue 설정한 값
	 * @return
	 */
	public static int toInt(String value, int defaultValue) {
		// 문자열이 null인 경우 defaultValue로 설정한 정수를 반환한다.
		if (value == null) {
			return defaultValue;
		}
		// 문자열이 빈 문자열인 경우 defaultValue로 설정한 정수를 반환한다.
		if (value.isBlank()) {
			return defaultValue;
		}
		try {
			// 변환할 수 있는 경우 parseInt로 변환한 값 반환
			return Integer.parseInt(value.trim());
			// 문자열이 숫자로 변환할 수 없는 경우
		} catch (NumberFormatException ex) {
			return defaultValue;
		}
	} 
	
	/**
	 * 문자열을 전달받아서 정수로 변환후에 반환한다.
	 * @param value 문자열
	 * @return 정수, 기본값은 0으로 설정
	 */
	public static int toInt(String value) {
		return Utils.toInt(value, 0);
	}
}
