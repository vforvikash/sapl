package com.sapl.util;


public class URLUtil {

	/**
	 * Parses the action out of a url path.
	 * @param urlPath
	 * @return String with action
	 */
	public static String parseAction(String urlPath){
		String methodName = urlPath;
		int slashIndex = methodName.lastIndexOf('/');
		if (slashIndex != -1) {
			methodName = methodName.substring(slashIndex+1);
		}
		int dotIndex = methodName.indexOf('.');
		if (dotIndex != -1) {
			methodName = methodName.substring(0, dotIndex);
		}
		return methodName;
	}

	/**
	 * Substitute the action in url path.
	 * @param urlPath
	 * @return String with substituted action url
	 */
	public static String substituteAction(String urlPath, String newAction){
		StringBuffer newUrl = new StringBuffer(urlPath);
		int slashIndex = urlPath.lastIndexOf('/');
		slashIndex = (0>slashIndex) ? 0 : slashIndex;
		int dotIndex = urlPath.indexOf('.', slashIndex);
		dotIndex = (0>dotIndex) ? 0 : dotIndex;
		return newUrl.replace(slashIndex+1, dotIndex, newAction).substring(slashIndex).toString();
	}

	/**
	 * Parses the object type out of a url path.
	 * @param urlPath
	 * @return String with type
	 */
	public static String parseType(String urlPath) {
		String type = urlPath;
		int slashIndex = type.lastIndexOf('/');
		if (slashIndex != -1) {
			type = type.substring(slashIndex+1);
		}
		int dotIndex = type.indexOf('.');
		if (dotIndex == -1) {
			return "";
		}
		int dotSecondIndex = type.indexOf('.', dotIndex +1);
		if (dotSecondIndex == -1) {
			return "";
		}
		return type.substring(dotIndex+1, dotSecondIndex);
	}

	/**
	 * Parses the property by which portlet should be sorted by.
	 * Never returns null.
	 * @param urlPath
	 * @return String with property name, or empty String.
	 */
	public static String parsePortletSorting(String urlPath, String portletID){
		final String SORTING_PARAM_PREFIX="sort_";
		final String SORTING_PARAM_SUFFIX="_by";
		String keyword = SORTING_PARAM_PREFIX+portletID+SORTING_PARAM_SUFFIX+"=";
		String propName = "";
		
		if (null != urlPath) { 
			int beginIndex = urlPath.lastIndexOf('/');
			if (beginIndex != -1) {
				urlPath = urlPath.substring(beginIndex+1);
			}
			beginIndex = urlPath.indexOf(keyword);
			if (beginIndex != -1) {
				urlPath = urlPath.substring(beginIndex+keyword.length());
	
				int endIndex = urlPath.indexOf('&');
				if (endIndex != -1) {
					urlPath = urlPath.substring(0, endIndex);
				}
				propName = urlPath;
			}
		}
		return propName;
	}
}
