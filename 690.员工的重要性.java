import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=690 lang=java
 *
 * [690] 员工的重要性
 */

// @lc code=start
/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    /**
     * 108 / 108, 7ms(97.99%), 46.7MB(98.26%)
     */
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = employees.size(), idx = -1, t0, t1, res;
        while (++idx < len) {
            t0 = employees.get(idx).id;
            map.put(t0, idx);
            if (t0 == id) {
                break;
            }
        }
        Employee emp = employees.get(idx);
        List<Integer> list = emp.subordinates, subList;
        res = emp.importance;
        if (list != null) {
            for (int i = 0; i < list.size(); ++i) {
                t0 = list.get(i);
                t1 = map.getOrDefault(t0, -1);
                if (t1 == -1) {
                    while (++idx < len) {
                        t1 = employees.get(idx).id;
                        map.put(t1, idx);
                        if (t1 == t0) {
                            t1 = idx;
                            break;
                        }
                    }
                }
                emp = employees.get(t1);
                res += emp.importance;
                subList = emp.subordinates;
                if (subList != null) {
                    for (int j = 0; j < subList.size(); ++j) {
                        list.add(subList.get(j));
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end

