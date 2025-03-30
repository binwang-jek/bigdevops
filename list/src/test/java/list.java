import org.junit.Test;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class list {

//    @Test
//    public void givenList_whenParitioningIntoNSublists_thenCorrect() {
//        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
//        List<List<Integer>> subSets = ListUtils.predicatedList(intList, 3);
//
//        List<Integer> lastPartition = subSets.get(2);
//        List<Integer> expectedLastPartition = Lists.<Integer> newArrayList(7, 8);
//        assertThat(subSets.size(), equalTo(3));
//        assertThat(lastPartition, equalTo(expectedLastPartition));
//    }

    @Test
    public void givenList_whenSplittingBySeparator_thenCorrect() {
        List<Integer> intList = Lists.newArrayList(1, 2, 3, 0, 4, 5, 6, 0, 7, 8);

        int[] indexes = Stream.of(IntStream.of(-1), IntStream.range(0, intList.size())
                        .filter(i -> intList.get(i) == 0), IntStream.of(intList.size()))
                        .flatMapToInt(s -> s).toArray();
        List<List<Integer>> subSets = IntStream.range(0, indexes.length - 1)
                        .mapToObj(i -> intList.subList(indexes[i] + 1, indexes[i + 1]))
                        .collect(Collectors.toList());

        List<Integer> lastPartition = subSets.get(2);
        List<Integer> expectedLastPartition = Lists.<Integer> newArrayList(7, 8);
        assertThat(subSets.size(), equalTo(4));
        assertThat(lastPartition, equalTo(expectedLastPartition));
    }

    @Test
    public void givenList_whenParitioningIntoNSublists_thenCorrect() {
        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        List<List<Integer>> subSets = Lists.partition(intList, 3);

        List<Integer> lastPartition = subSets.get(2);
        List<Integer> expectedLastPartition = Lists.<Integer> newArrayList(7, 8);
        assertThat(subSets.size(), equalTo(3));
        assertThat(lastPartition, equalTo(expectedLastPartition));
    }
}
