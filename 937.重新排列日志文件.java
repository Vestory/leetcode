import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=937 lang=java
 *
 * [937] 重新排列日志文件
 */

// @lc code=start
class Solution {
    /**
     * https://leetcode-cn.com/problems/reorder-data-in-log-files/solution/java-3ms-ji-bai-9910-by-hervinka/
     * 63 / 63, 3ms(98.58%), 38.2MB(95.15%)
     */
    class LogFile {
        int index;
        boolean num_file;
        String identifier;
        String content;

        LogFile(int _index, String _file) {
            index = _index;
            int blank = _file.indexOf(" ");
            identifier = _file.substring(0, blank);
            content = _file.substring(blank + 1);
            char c = content.charAt(0);
            if (c >= '0' && c <= '9')
                num_file = true;
            else
                num_file = false;
        }
    }

    public String[] reorderLogFiles(String[] logs) {
        LogFile[] files = new LogFile[logs.length];
        for (int i = 0; i < files.length; ++i)
            files[i] = new LogFile(i, logs[i]);
        Arrays.sort(files, new Comparator<LogFile>() {
            public int compare(LogFile f1, LogFile f2) {
                if (f1.num_file && !f2.num_file)
                    return 1;
                if (!f1.num_file && f2.num_file)
                    return -1;
                if (f1.num_file && f2.num_file)
                    return f1.index - f2.index;
                if (!f1.content.equals(f2.content))
                    return f1.content.compareTo(f2.content);
                return f1.identifier.compareTo(f2.identifier);
            }
        });
        String[] res = new String[logs.length];
        for (int i = 0; i < res.length; ++i)
            res[i] = files[i].identifier + " " + files[i].content;
        return res;
    }
}
// @lc code=end

