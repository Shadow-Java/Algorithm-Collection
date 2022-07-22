package intermittent.lying.continuous.progress.deprecated;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 */
public class RemoveAllAdjacentDuplicates {

    public String removeDuplicates(String S) {

        int now =S.length();
        int next = 1;
        while(now != next){
            now =  S.length();

            S=S.replace("aa","").replace("bb","").replace("cc","").replace("dd","").replace("ee","").replace("ff","").replace("gg","").replace("hh","").replace("ii","").replace("jj","").replace("kk","").replace("ll","").replace("mm","").replace("nn","").replace("oo","").replace("pp","").replace("qq","").replace("rr","").replace("ss","").replace("tt","").replace("uu","").replace("vv","").replace("ww","").replace("xx","").replace("yy","").replace("zz","");

            next =  S.length();

        }


        return S;
    }
    public static String removeDuplicates_2(String S) {
        StringBuffer stack = new StringBuffer();//需要返回的结果
        int top = -1;
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {//这样做的好处的就是：删除了栈顶,其该字符也没有加入；注意该题是两个相邻的字母，如aaab去除后是ab
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }


}
