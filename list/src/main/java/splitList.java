import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

public class splitList {
    public static void main(String[] args) {
        List<String> tempList = Arrays.asList("水星", "金星", "地球", "火星",
                "冥王星", "土星", "天王星", "海王星", "冥王星", "木星");
// size 是把集合拆分的大小，size 为表示拆分成拆分的集合大小为3，
// 后面不足3的有多少算多少
        List<List<String>> partition = Lists.partition(tempList, 3);
        System.out.println(partition);
    }
}
