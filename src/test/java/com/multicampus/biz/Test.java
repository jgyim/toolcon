package test.java.com.multicampus.biz;


import java.nio.charset.Charset;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws Exception{
        Test test = new Test();
        String testResult = test.getTempPassword();
        System.out.println("*** testResult :"+ testResult);
    }

    public static String getTempPassword() {
        Random rnd = new Random();
        StringBuffer buf =new StringBuffer();
        for(int i=0;i<12;i++){
            if(i == 0) { // 첫자리는 특수문자로 설정함. (#, $, %)
                buf.append((char)((int)(rnd.nextInt(3))+35));
            }
            if(rnd.nextBoolean()){
                if(rnd.nextBoolean()){
                    buf.append((char)((int)(rnd.nextInt(26))+97));
                }else{
                    buf.append((char)((int)(rnd.nextInt(26))+65));
                }
            }else{
                if(rnd.nextBoolean()){
                    buf.append((char)((int)(rnd.nextInt(26))+97));
                }else{
                    buf.append((rnd.nextInt(10)));
                }
            }
        }
        //UTF-8 인코딩 표기로 버전을 업데이트 시도
        return new String(buf.toString().getBytes(Charset.forName("UTF-8")), Charset.forName("UTF-8"));

    }
}
