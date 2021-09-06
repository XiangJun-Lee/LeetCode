import org.junit.Test;

public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int length = Math.max(split1.length, split2.length);
        for (int i = 0; i < length; i++) {
            String v1 = i < split1.length ? split1[i] : "0";
            String v2 = i < split2.length ? split2[i] : "0";
            if (Integer.parseInt(v1) > Integer.parseInt(v2)) return 1;
            if (Integer.parseInt(v1) < Integer.parseInt(v2)) return -1;
        }
        return 0;
    }

    public int compareVersionOfficial(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; ++i) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            ++i; // 跳过点号
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; ++j) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            ++j; // 跳过点号
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }

    @Test
    public void test() {
        String version1 = "1.1";
        String version2 = "1.10";
        System.out.println(compareVersionOfficial(version1, version2));
    }
}
