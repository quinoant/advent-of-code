

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class PacketFinder {
    public static int processor(String text){
        int concurrentSuccess = 0;
        Character[] currFourteen = new Character[14];
        boolean fail = true;
        for(int i = 0; i< text.length(); i++){
            if(i>12){
                if(fail){
                    fail = false;
                    currFourteen[13] = text.charAt(i);
                }else{
                    for(int k = 0; k< 13;k++){
                        currFourteen[k] = currFourteen[k+1];
                    }
                    currFourteen[13] = text.charAt(i);
                }
                
                for(int j = 0; j < 14; j++){
                    int matches = 0;
                    for(int x = 0; x < 14; x++){
                        if (currFourteen[j] == currFourteen[x]){
                            matches++;
                            if(matches > 1){
                                System.out.println(Arrays.toString(currFourteen));
                                System.out.println(i);
                                fail = true;
                                break;
                            }
                        }
                    }
                    if(fail){
                        break;
                    }
                }
                if(!fail){
                    return(i+1);
                }
                fail = false;
            }else{
                currFourteen[i] = text.charAt(i);
            }
            
            
        }
        System.out.println(currFourteen);
        return 0;
    }
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner sc1 = new Scanner(file);
        System.out.println(processor("rqwqtwwrmrqqrcrtrpppjrjgrgjgqgttgbbhppftpfpdpmpsstffqvfqvvdjjpllltqltqtrrzlllbldbdsdqqgpqggzccgbgnnmjmljmljldjldjjlnnhndhdmmslmslmlhmmntnrtnrnbrbqrqhqfftwftfsfzfcfrrzllchcwwtwstwwjwrjjfwwgzwzqzpzhzqhqbhqhssltsszhsszdssrwssdppjcpjjrwjwnwjnnzjjhsjhsjsjvvtffffqfflglwglgbgpbgbgghfghfhdfhdfhfssqppvlvslltwwhwvwpwgggnpnnmqnntqnnlhhdbhdbbtvvcrrcgrrdrvrjvvlmlnmndnmnrncnznsnsqnsswrwzwmwzzbpbhphqhpqpbpqpjpjvpvwpvwppdvdhdccqbccfncctrcrjcjjdsdhdnhhwpwlwwbmbhmbhhpzhhccvffqqnsqqmnnspnnpfpzppspgsppgbbdwbbdcchfhgfhfllljtllnjlnlddvcdvdqvvqwqppprtpthtthqqfbqqpfpzfpfcfsscrsccbgbngbbgdbbpgpqqlmqlmmgffqqqsbqbtblbwbqqvbqvbqvvnzvzpvvqhvqqtltptllbflbflbflltddlblflvfvbffmsffhlhshmmgbbgjjdndqqmqllzjzvvhjhnhcnchhznnhhppwqpwpffwvwzzppwpfwftwtnnqbnqnrnrzznffzzblzlvzlzrrszscsqcssbggcgvvddsttgqqgwgcclzzszddlvddvbddrlrcllrblrrhlldzdtdccqllsblsszlszzdllhjljhhhzhffdwfdwfddwdtdrtdtntddldsllqffdvdhdpdhdrdprprrhggdqgghggmwgmghhchlhmllrnrdrcrqccbqqfbqbccjpjhhvppcwpwffmmzzfqflfjfdfbfqqtmthmttwftwwpmpzplzzpvvgppsbpbccbtcbcddzbzwwmsscrcctgtgjgtjthhjzzcqqmmmvccwjcwjwzzwnnwgwtgwwbsbvbccrscccnggfjfwfjfrfsfddncdncndnqqwzzmssbdsbswswdddpdqdbddcvcmmwwssrtrrlddndmdtmtdmttwwmsmffwqwvwbwhbbqfqqgcqcmctctntjntnbnrbrmbbqtqccqbcbvbnbqnnghgbbmfmwmdwmdmpmwppdwpdwwnzwnwrnwrnntqnttcmcqqbrqrttsjtstcscpcspsnswsggrhggjrjjbhhbnbmmdlmddtqdtdrdwwjvjgjjdhjdddbwwsfflppbwbcbpbjjzqznnrwnnvmvjvwvqqrlljgjmjjqhjhwjhwjjsvsnvvlwlqqjpjjbsjjcddtfthffrqfrqrfqfrfllfzzqllztltnltntpttqmmgwmwwwjjdrjrzrlrwlwzzzzphpphvphvphvpvdvfdflljgglrlrqlrrfpfqpqnpqpmmblbflbfbpfpwpjwpjpbjpjmjljblldbllnrnjjjljrlrcrrgzgbbzrznzzhnzhhtmhmqhmqqnzzvfzvzfftjftfvvpmvppwzzhnzhzvvwzwwqcwctwwgrrtgglgngsgvgwvwpvpbbrvrvwrvwvbwwpsprrrcbbpqppfjjjqnjndnmddvsvlslmmwwdwcchmmrjmjwwsrwrhwwpcgmpmvbdmlmqbnblbbgtmtgqslnvcnmwrflrnwhqzrsnwhncwdvbcpjrqsscwzrjvslhscpvmqjnltwhshjmbhgttbzllrvpnhgdmwtddbwmpgbhrndpgwzfvqdmpcvhlnjnqbwqmshgwhmfjgsbscsjtfbfvmlljqwwjtnltbzjpcqdfmdldvmsnmzqmghcvhlpjzzszcpvldrflbcppzwgppfpbslplrqwgbfwpwbtbnrmbrrrpqndzvhmlhvtlnjvhdrhhvmwzjntsgffjsdpdlhnlslnbmbsmdsvpmpbjpjcwhbpfnhbmttfglglnnhhcqvbpvnrwcszwjsdhqwctrpgsrcbfpzhbnrbllrlflqdlgzwpwgwwvmbsppbcjcdltbgwfndqjlvndhtclfmwnqrbfvvqdzspfcslplhtmsqqtrcdvbhfscvnmzplcglwnzbvgflclclqmdgfzjqqrrmpcqrzgqcnzbmncmvdzrmmvfqrrqzqbjmjgjwmfbnmmgvmzsgjjspjqbvfhrdvllgqsffjnfqdthjbjwhwqdqhsnctwgbszvrsbwbpptcjjvftnhdmwmhtjrjrlrdrqjznhqftgtldnpbrlprjmplmwdbzqpmwwvcqccjlhqbhcjprvrfmmfmljwmbrlhcglthgbmrfmbpsztfcglpzlfbpjhmvcmvrprmvmrvvgbbllzschwshhfbnmgwrbhlqvsdjdmmbtjzthwssghtqvhtqcswdhbwhphhsrwhwwtslwvrhpgqfmftnrtqpwfqqdgftdlqfndjlzhvlrthnqdqrzpprdgwwqlplrmqtdqgbdntmjcjhlbbmctvnnhtppfbjpsbmndbdplqlfqfhzqvtqcvmprwbhdtjrqrqvmcssqnfqwtchmjfjlpwsghplbthdnbhfbhhphdmlmtjcvmzjbnqbfldrvlmjfnnrlsnwrtnrpfqdhchltmbvjzhgjwzblqdthmffztqvzzfszmdqdzlfpbfgjfdjqscrhvjflbllnlghncczrlpcbwpnmzcnqhbfnlmnbqvmwvbchwhlfcssctsdcwmtfdgbhljwprfncdgwlgzzmvfqrdsmlwbrmbmtzqqdqdpzvtbstscglrwdpndnstrhgjchnpzsvcjngmzsddwsbllpvqqzzjlmsbncbndqmqphzqzcngjzpfnjmsvngtcvhhjsssrnhjrsmvbsrdjcrppvgsqbqjzbrhjqlgmqfclbrdhwwjdlsjnmjcjrmsstngswrhmdqthprcbrndfpdjgpqtfmmfvbztqdhzhzbzhjjpfgnvrmspdvmhfvbvztmlrhfqfdcfnzzndlfldpfhrbjrwlwnprdmqjwppbrdjhpbvnrvjlrbwdwttzhqqgcclbwghbgrhcvwjrrchqgzztrjgrltcpdscjdfcphndfzdqsbpsjrljdnflfvrzcrjflddfgpvnpmdqbhzwbfrpzsnpbcbgfchvvmqpnfpvvdvhfnpbfzwmbnlpqzgrpwtsjbpzdrsfmnfqwqvpgnrjhmvmphlfdpfhdjljlzftdzdvhjrvjdctwfrctglwmrtdlrvmhcqvfvpgmstghczmvclptzspdsrlvrgvjtvflhsmqswdpqjrrnhgrggzmcpqsctqbhpqrsbstwzgzghqgltcpbrhbcdqlhfjhlcrnhrpjdzlzqqprvzntbjztqgdqqttmbpbcfbjmdjqsflbczmfnsjdzcnnmjjllhvwbwlgrlpvbffwjvctwnrsfqdnwntscpsjnshhdmcqmcpscrmzltldwlmfnbhbtprsgtsbvzfrsfpvmqjzjqqhwdjjzvbhrvtbscrcpzrqsbgfbpwqfmbsrlhhtntjmtrtlwqsdbmgtdlrwfdnmwwzlltbrjgghbstbnffzmzzdlcdgvmrzsjnqjvczmhrgwbrblrqfmzbbcnfsbfpgjsmptzbclfdnwfgbzlpbgqrdhdmfjdnlzczdpvtbzdmrthslngbrldllfcjplhglmwsfpqjnrgpgqfmbbwchbrqqsncfwnmgdmtchdhlzzqjvtvtvgqbtwvwpsjqwdqhrlfmdgdzchvfbcmqjllpjtnphwqvfwpcjmzqhsbwlcmbsgththrsjtnzlsrcptgtrfcwptbstcsdzbwjljzjztzbqsjdvwglpbpgdjtthjjmsnljltglqcszbzqmblfpncntjzzhmjffldcrcvjjswvzlfffrmsgjtpzggtlpfwpwbmhmggpnmzwrgdjrhglnhfdcjdfjtdjvrnlgqtfqmpgjcvcmnwhhbczwwntfbmgssglngqlttfpcznswvmbprsrzljtlwlljnbbrnwdvvlsbdv"));
    }
}


