package org.wzq.bioplat.utils;

public class HtmlCSSHelper {
    public static String highLight(String oristr, String keyword){
        StringBuilder oristrbuilder = new StringBuilder(oristr);
        StringBuilder orilowerstrbuilder = new StringBuilder(oristr.toLowerCase());
        keyword=keyword.toLowerCase();
        String before="<span class='hlpart'>";
        String rear="</span>";
        int index = orilowerstrbuilder.indexOf(keyword);
        while (index != -1) {
            orilowerstrbuilder.insert(index, before);
            orilowerstrbuilder.insert(index + before.length() + keyword.length(), rear);
            oristrbuilder.insert(index, before);
            oristrbuilder.insert(index + before.length() + keyword.length(), rear);
            index = orilowerstrbuilder.indexOf(keyword, index + before.length() + keyword.length() + rear.length() - 1);
        }
        return oristrbuilder.toString();
//        oristr=sovleRegex(oristr);
//        String res=oristr.replaceAll("(?i)"+hlpart,"<span class='hlpart'>"+hlpart+"</span>");
//        System.out.println(res);
//        return res;
//        return oristr;
    }

    public static String sovleRegex(String oristr){
        oristr=oristr.replace("\\","\\\\");
        oristr=oristr.replace(".","\\.");
        oristr=oristr.replace("?","\\?");
        oristr=oristr.replace("$","\\$");
        oristr=oristr.replace("*","\\*");
        oristr=oristr.replace("+","\\+");
        oristr=oristr.replace("[","\\[");
        oristr=oristr.replace("]","\\]");
        oristr=oristr.replace("(","\\(");
        oristr=oristr.replace(")","\\)");
        oristr=oristr.replace("{","\\{");
        oristr=oristr.replace("}","\\}");
        oristr=oristr.replace("|","\\|");
        oristr=oristr.replace("^","\\^");
        return oristr;
    }
}
