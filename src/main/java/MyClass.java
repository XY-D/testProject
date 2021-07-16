import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MyClass
 *
 * @author qihuan
 * @version 1.00
 * @time 2021/7/15 下午3:40
 */
public class MyClass {
    public static void main(String[] args) {
        String solution = "建议对该监听配置健康检查[用户指南](https://help.aliyun.com/document_detail/85959.html?spm=a2c4g.11186623.6.752.673a7503RlDkCu)";
//        solution = "[链接](URL)";

        String markdown = "";
        String pattern = "\\[[\\s\\S]*?\\]\\([\\s\\S]*?\\)";

//        String pattern = "/\\[[\\s\\S]*?\\]\\([\\s\\S]*?\\)/g";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(solution);
        while (m.find()){



            markdown = m.group(0);
            Matcher matcher_title = Pattern.compile("\\[(.*?)\\]").matcher(markdown);
            String title = matcher_title.find() ? matcher_title.group(1):"";
            Matcher matcher_url = Pattern.compile("\\((.*?)\\)").matcher(markdown);
            String url = (matcher_url.find()?matcher_url.group(1):"");
            solution = solution.replace(markdown,"<a href=" + url + " target='_blank'>" + title + "</a>");

        }
        System.out.println(solution);
    }
}
