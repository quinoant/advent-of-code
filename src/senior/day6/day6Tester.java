package src.senior.day6;


import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.Test;

public class day6Tester{
    @Test
    public void test1(){
       assertEquals(5,PacketFinder.processor("bvwbjplbgvbhsrlpgdmjqwftvncz"));
    }

    @Test
    public void test2(){
       assertEquals(7,PacketFinder.processor("mjqjpqmgbljsphdztnvjfqwrcgsmlb"));
    }

    @Test
    public void test3(){
       assertEquals(11,PacketFinder.processor("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"));
    }

    @Test
    public void test4(){
       assertEquals(10,PacketFinder.processor("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"));
    }
}
