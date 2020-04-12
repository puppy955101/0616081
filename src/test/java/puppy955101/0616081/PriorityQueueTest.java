import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(Parameterized.class)
public class PriorityQueueTest {
    private int[] INPUT;
    private int[] OUTPUT;

    public PriorityQueueTest(int[] input, int[] output){
        this.INPUT = input;
        this.OUTPUT = output;
    }
    @Parameterized.Parameters
    public static Collection Testcase(){
        return Arrays.asList(new int[][][] {
                {{9,40,6,8,7,10},{4,6,7,8,9,10}},
                {{951,3154,1,999,888,7},{1,7,888,951,999,3154}},
                {{55,33,22,77,44,99,11},{11,22,33,44,55,77,99}},
                {{987,321,654,876,543,999,0},{0,321,543,654,876,987,999}},
                {{456,123,789,1234,7890,4567},{123,456,789,1234,4567,7890}}
        });
    }
    @Test
    public void test(){
        PriorityQueue Q = new PriorityQueue();
        for (int i:INPUT) {
            Q.add(i);
//            System.out.println(i);
        }
        int x=0;
        while(!Q.isEmpty()){
            assertEquals(OUTPUT[x],Q.poll());
            x++;
        }
    }
    @Test
    public void Exception_1(){
        PriorityQueue Q = new PriorityQueue();
        Exception exception = assertThrows(NullPointerException.class, ()->{
            Q.offer(null);
        });
    }
    @Test
    public void Exception_2(){
        Exception exception = assertThrows(NullPointerException.class, ()->{
            PriorityQueue Q = new PriorityQueue();
            Q.addAll(null);
        });
    }
    @Test
    public void Exception_3(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
            PriorityQueue Q = new PriorityQueue();
            Q.addAll(Q);
        });
    }
}