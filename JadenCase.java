import java.util.Locale;

public class JadenCase {

    //내 풀이
    public static String getJadenCase(String s){

        String[] split = s.split(" ");//공백으로 나눈다

        char[] tmp;// 제일 앞글자를 핸들링하기 위해 char 배열

        StringBuffer sb = new StringBuffer();// 최종적으로 넘겨줄 스트링

        int first_char; // 첫번 째 char의 int

        for(int i = 0; i< split.length; i++){

                // 공백으로 구분했을 때 공백인 부분은 ""로 표시되나 이 또한 포함되어야한다는 문제의 조건
                if(split[i].equals("")) {
                    sb.append(" ");
                }else {
                    //소문자 처리
                    tmp = (split[i].toLowerCase()).toCharArray();

                    first_char = tmp[0];

                    //숫자 ASCII가 아니라면
                    if (!(48 <= first_char && first_char <= 57)) {
                        //첫번째 글자를 대문자로
                        tmp[0] = (char) (first_char - 32);
                    }
                    // 사이사이 공백 추가.
                    if (i <= split.length && i != 0) {
                        sb.append(" ");
                    }
                        sb.append(new String(tmp));
                }
            }
        //마지막 공백있을 때 추가.
        if(s.substring(s.length() - 1).equals(" ")) {
            sb.append(" ");
        }

        return sb.toString();
    }

    //우수 풀이
    public static String getJadenCase_simp(String s) {
        String answer = "";
        //한 글자씩 나눌 수 있다.
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;

        for(String ss : sp) {
            //숫자는 UpperCase가 안먹는다.
            answer += flag ? ss.toUpperCase() : ss;
            //현재 char가 공백이라면 다음 글자는 대문자.
            flag = ss.equals(" ") ? true : false;
        }

        return answer;
    }




    public static void main(String args[]){

        String str = "3for     d ";

        System.out.println(getJadenCase(str));
        System.out.println(getJadenCase_simp(str));


    }
}
