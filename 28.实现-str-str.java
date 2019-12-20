/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */
class Solution {
    /**
     * 74 / 74, 4ms(40.35%), 36MB(83.88%)
     */
    // public int strStr(String haystack, String needle) {
    // if (haystack == null || needle == null) {
    // return -1;
    // }
    // if (haystack.length() == 0) {
    // return needle.length() == 0 ? 0 : -1;
    // }
    // if (needle.length() == 0) {
    // return 0;
    // }
    // char c = needle.charAt(0);
    // int j = 0;
    // int index = 0;
    // int length = haystack.length() - needle.length();
    // for (int i = 0; i <= length; ++i) {
    // if (haystack.charAt(i) == c) {
    // index = i + 1;
    // for (j = 1; j < needle.length(); ++j) {
    // if (haystack.charAt(index) != needle.charAt(j)) {
    // index = -1;
    // break;
    // }
    // ++index;
    // }
    // if (index != -1) {
    // return i;
    // }
    // }
    // }
    // return -1;
    // }

    /**
     * 使用原本的indexOf 74 / 74, 0ms(100%), 37.2MB(56.36%)
     */
    // public int strStr(String haystack, String needle) {
    // return haystack.indexOf(needle);
    // }

    /**
     * 使用相关字符串操作函数 substring和equals 74 / 74, 1ms(99.41%), 36.6MB(80.47%)
     */
    // public int strStr(String haystack, String needle) {
    // int len = needle.length();
    // int lenhay = haystack.length();
    // if (lenhay < len) {
    // return -1;
    // }
    // int start = 0;
    // int end = len - 1;
    // while (end < lenhay) {
    // if (haystack.substring(start, end + 1).equals(needle)) {
    // return start;
    // }
    // ++end;
    // ++start;
    // }
    // return -1;
    // }

    /**
     * BF算法，暴力破解，时间复杂度O(M*N) 74 / 74, 8ms(19.89%), 36.5MB(82.5%)
     */
    // public int strStr(String haystack, String needle) {
    // if (needle.isEmpty()) {
    // return 0;
    // }
    // int i = 0, j = 0;
    // while (i < haystack.length() && j < needle.length()) {
    // if (haystack.charAt(i) == needle.charAt(j)) {
    // ++i;
    // ++j;
    // } else {
    // i = i - j + 1;
    // j = 0;
    // }
    // }
    // if (j == needle.length()) {
    // return i - j;
    // }
    // return -1;
    // }

    // #region [0] KMP算法
    /**
     * KMP算法，时间复杂度O(M + N) 未优化：74 / 74, 6ms(24.88%), 36.6MB(80.47%) 优化后：74 / 74,
     * 8ms(19.89%), 37.2MB(58.13%)
     */
    // public int strStr(String haystack, String needle) {
    // if (needle.isEmpty()) {
    // return 0;
    // }
    // int i = 0; // haystack
    // int j = 0; // needle
    // int len0 = haystack.length();
    // int len1 = needle.length();
    // // int[] next = getNext0(needle); // 未优化的getNext方法
    // int[] next = getNext1(needle); // 优化后的getNext方法
    // while (i < len0 && j < len1) {
    // if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
    // ++i;
    // ++j;
    // } else {
    // // i不变，needle的j移动到下一次匹配位置
    // j = next[j];
    // }
    // }
    // if (j == len1) {
    // return i - j;
    // }
    // return -1;
    // }

    // /** 未优化的getNext方法 */
    // public int[] getNext0(String str) {
    // int len = str.length();
    // int[] next = new int[len];
    // // 第一个值默认为-1，即起始索引0 - 1
    // next[0] = -1;
    // int i = 0, j = -1;
    // --len;
    // while (i < len) {
    // if (j == -1 || str.charAt(i) == str.charAt(j)) {
    // next[++i] = ++j;
    // } else {
    // j = next[j];
    // }
    // }
    // return next;
    // }

    // /** 优化后的getNext方法，当字符失配时，回到相同字符无意义 */
    // public int[] getNext1(String str) {
    // int len = str.length();
    // int[] next = new int[len];
    // next[0] = -1;
    // int i = 0, j = -1;
    // --len;
    // while (i < len) {
    // // 当字符失配时，回到相同的字符无意义
    // if (j == -1 || str.charAt(i) == str.charAt(j)) {
    // if (str.charAt(++i) != str.charAt(++j)) {
    // next[i] = j;
    // } else {
    // next[i] = next[j];
    // }
    // } else {
    // j = next[j];
    // }
    // }
    // return next;
    // }
    // #endregion

    // #region [0] BM算法 C++ 尚未研究
    /**
     * BM算法，时间复杂度最差和KMP一样，最佳是O(n)
     */
    // public:
    // void get_bmB(string& T,vector<int>& bmB)//坏字符
    // {
    // int tlen=T.size();
    // for(int i=0;i<256;i++)//不匹配直接移动子串
    // {
    // bmB.push_back(tlen);
    // }
    // for(int i=0;i<tlen-1;i++)//靠右原则
    // {
    // bmB[T[i]]=tlen-i-1;
    // }
    // }

    // void get_suff(string& T,vector<int>& suff)
    // {
    // int tlen=T.size();
    // int k;
    // for(int i=tlen-2;i>=0;--i)
    // {
    // k=i;
    // while(k>=0&&T[k]==T[tlen-1-i+k])
    // --k;
    // suff[i]=i-k;
    // }
    // }

    // void get_bmG(string& T,vector<int>& bmG)//好后缀
    // {
    // int i,j;
    // int tlen=T.size();
    // vector<int> suff(tlen+1,0);
    // get_suff(T,suff);//suff存储子串的最长匹配长度
    // //初始化 当没有好后缀也没有公共前缀时
    // for(i=0;i<tlen;i++)
    // bmG[i]=tlen;
    // //没有好后缀 有公共前缀 调用suff 但是要右移一位 类似KMP里的next数组
    // for(i=tlen-1;i>=0;--i)
    // if(suff[i]==i+1)
    // for(j=0;j<tlen-1;j++)
    // if(bmG[j]==tlen)//保证每个位置不会重复修改
    // bmG[j]=tlen-1-i;
    // //有好后缀 有公共前缀
    // for(i=0;i<tlen-1;i++)
    // bmG[tlen-1-suff[i]]=tlen-1-i;//移动距离
    // }

    // int strStr(string haystack, string needle) {
    // int i=0;
    // int j=0;
    // int tlen=needle.size();
    // int slen=haystack.size();
    // vector<int> bmG(tlen,0);
    // vector<int> bmB;
    // get_bmB(needle,bmB);
    // get_bmG(needle,bmG);
    // while(i<=slen-tlen)
    // {
    // for(j=tlen-1;j>-1&&haystack[i+j]==needle[j];--j);
    // if(j==(-1))
    // return i;
    // i+=max(bmG[j],bmB[haystack[i+j]]-(tlen-1-j));
    // }
    // return -1;
    // }

    // 作者：2227 链接：https://
    // leetcode-cn.com/problems/implement-strstr/solution/c5chong-jie-fa-ku-han-shu-bfkmpbmsunday-by-2227/
    // 来源：力扣（LeetCode）著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    // #endregion

    // #region [0] Sunday C++ 尚未研究
    /**
     * Sunday，时间复杂度最差O(m + n)，平均为O(n)
     */
    // public:
    // int strStr(string haystack, string needle) {
    // if(needle.empty())
    // return 0;
    // int slen=haystack.size();
    // int tlen=needle.size();
    // int i=0,j=0;//i指向源串首位 j指向子串首位
    // int k;
    // int m=tlen;//第一次匹配时 源串中参与匹配的元素的下一位
    // for(;i<slen;)
    // {
    // if(haystack[i]!=needle[j])
    // {
    // for(k=tlen-1;k>=0;--k)//遍历查找此时子串与源串[i+tlen+1]相等的最右位置
    // {
    // if(needle[k]==haystack[m])
    // break;
    // }
    // i=m-k;//i为下一次匹配源串开始首位 Sunday算法核心：最大限度跳过相同元素
    // j=0;//j依然为子串首位
    // m=i+tlen;//m为下一次参与匹配的源串最后一位元素的下一位
    // if(m>slen)//当下一次参与匹配的源串字数的最后一位的下一位超过源串长度时
    // return -1;
    // }
    // else
    // {
    // if(j==tlen-1)//若j为子串末位 匹配成功 返回源串此时匹配首位
    // return i-j;
    // ++i;
    // ++j;
    // }
    // }
    // return -1;//当超过源串长度时
    // }

    // 作者：2227 链接：https://
    // leetcode-cn.com/problems/implement-strstr/solution/c5chong-jie-fa-ku-han-shu-bfkmpbmsunday-by-2227/
    // 来源：力扣（LeetCode）著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    // #endregion
}
