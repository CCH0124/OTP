import java.util.*;
class  Data{
     /* Data */
    private static final char[] capitals =
    "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] lowers =
    "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] num =
    "0123456789".toCharArray();
    private static final char[] symbol =
    "!@#$%^&*()_+=\\|}{][\'\"><,./?".toCharArray(); 

    /* 利用 map 的 key -> value  */
    private Map<String,char[]> map = new HashMap<>();
    private void store(){
        map.put("capitals",capitals);
        map.put("lowers",lowers);
        map.put("num",num);
        map.put("symbol",symbol);
    }
    
    /*檢查參數*/
    public boolean comparison(String ...args){
        boolean bl = true;
        if(args.length > 4 || args.length == 0){
            bl = false;
        }
        for(int i=0; i<args.length; i++){
            if(map.containsKey(args[i].toString()) == false){
                bl = false;
                break;
            }
        }
        return bl;
    }
    public Map<String, char[]> getMap() {
        return map;
    }

    public Data() {
        store();
    }
}
class AllSelect {
    private Data data = new Data();
    private Map<String, char[]> map = data.getMap();

    public AllSelect(String ...value){
        String randomPassword = select(value);
        System.out.println(randomPassword);
    }

    /*使用者輸入*/
    private int input(){
        Scanner sc = new Scanner(System.in);
        int put = sc.nextInt();
        return put;
    }
    
    /*put 為產生長度 value 為輸入參數*/
    public String select(String ...value) {
        int put = input(); /*接收使用者輸入*/
        Boolean bl = data.comparison(value);
        if(bl){
            StringBuffer cipherKey = new StringBuffer();
            List<String> list = new ArrayList<>(); // 存放輸入參數
            for(int i=0 ;i <value.length; i++)
                list.add(value[i]);
            while(put > 0){
                int sw = (int)(Math.random()*value.length); //參數長度取亂數
                cipherKey.append((map.get(value[sw])[(int)(Math.random()*(map.get(value[sw]).length))]));
                put--;
            }
            return cipherKey.toString();
        }else{
            return "Error,Check the parameters";
        }
    }
}
public class OneTimePassword{
    public static void main(String[] args){
        System.out.println("input Password Length :"); 
        new AllSelect(args);    
    }
}
