# Read from the file file.txt and output all valid phone numbers to stdout.
# https://leetcode-cn.com/problems/valid-phone-numbers/solution/ni-men-zi-ji-bu-ce-ce-ma-by-yanjiechen/
# 26 / 26, 12ms(10.48%), 3.1MB(52.82%)
grep -P '^(\d{3}-|\(\d{3}\) )\d{3}-\d{4}$' file.txt