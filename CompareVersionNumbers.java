public class CompareVersionNumbers {
	public static int compareVersion(String version1, String version2) {
		int i = 0, j = 0;
		while (version1.length() > 0 && version1.charAt(0) == '0')
			version1 = version1.substring(1);
		while (version2.length() > 0 && version2.charAt(0) == '0')
			version2 = version2.substring(1);
		while (i < version1.length() && version1.charAt(i) != '.')
			i++;
		while (j < version2.length() && version2.charAt(j) != '.')
			j++;
		if (i > j)
			return 1;
		else if (i < j)
			return -1;
		else {
			if (version1.substring(0, i).equals(version2.substring(0, j))) {
				if (i < version1.length() && j == version2.length()) {
					version1 = version1.substring(i + 1);
					version2 = "0";
				} else if (i == version1.length() && j < version2.length()) {
					version1 = "0";
					version2 = version2.substring(j + 1);
				} else if (i < version1.length() && j < version2.length()) {
					version1 = version1.substring(i + 1);
					version2 = version2.substring(j + 1);
				} else
					return 0;
				return compareVersion(version1, version2);
			} else
				for (int s = 0, t = 0; s < i && t < j; s++, t++)
					if (version1.charAt(s) > version2.charAt(t))
						return 1;
					else if (version1.charAt(s) < version2.charAt(t))
						return -1;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compareVersion("1.0", "1"));
	}

}
