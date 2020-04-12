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

    @Parameterized.Parameters
    public static Collection Testcase(){
        return Arrays.asList(new int[][] {
                {9,4,6,8,7,10},{951,3154,1,999,888,7},{55,33,22,77,44,99,11},{987,321,654,876,543,999,0},{456,123,789,1234,7890,4567}
        });
    }
    public PriorityQueueTest(int[] input){
        this.INPUT = input;
    }
    @Test
    public void test(){
        PriorityQueue<Integer> Q = new PriorityQueue<>();
        for (int i:INPUT) {
            Q.add(i);
//            System.out.println(i);
        }
        int out[] = new int[INPUT.length];
        int x=0;
        while(!Q.isEmpty()){
            out[x] = Q.poll();
//            System.out.println(out[x]);
            x++;
        }
        int tmp[][] = new int[][]{{4,6,7,8,9,10},{1,7,888,951,999,3154},{11,22,33,44,55,77,99},{0,321,543,654,876,987,999},{123,456,789,1234,4567,7890}};
        if(INPUT[0]==9){
            for (int i=0;i<out.length;i++) {
                assertEquals(tmp[0][i],out[i]);
            }
        }
        else if(INPUT[0]==951){
            for (int i=0;i<out.length;i++) {
                assertEquals(tmp[1][i],out[i]);
            }
        }
        else if(INPUT[0]==55){
            for (int i=0;i<out.length;i++) {
                assertEquals(tmp[2][i],out[i]);
            }
        }
        else if(INPUT[0]==987){
            for (int i=0;i<out.length;i++) {
                assertEquals(tmp[3][i],out[i]);
            }
        }
        else if(INPUT[0]==456){
            for (int i=0;i<out.length;i++) {
                assertEquals(tmp[4][i],out[i]);
            }
        }
    }
    @Test
    public void Exception_1(){
        PriorityQueue<Integer> Q = new PriorityQueue<>();
        Exception exception = assertThrows(NullPointerException.class, ()->{
            Q.offer(null);
        });
    }
    @Test
    public void Exception_2(){
        Exception exception = assertThrows(NullPointerException.class, ()->{
            PriorityQueue<Integer> Q = new PriorityQueue<>();
            Q.addAll(null);
        });
    }
    @Test
    public void Exception_3(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
            PriorityQueue<Integer> Q = new PriorityQueue<>();
            Q.addAll(Q);
        });
    }
}