import java.util.Stack;

public class StringReverse {

    static public void main(String args[]){

        String str = "BANANA";

        System.out.println("Loop: " + Solution_loop(str));
        System.out.println("Builder: " +Solution_Builder_Buffer(str));
        System.out.println("Stack: "+ Solution_Stack(str));

    }

    /*for문과 String.charAt() 의 메서드를 이용하여 Reverse */
    static public String Solution_loop(String str){

        String rvs ="";

        /* 파라미터로 전달 받은 String의 길이-1을 i로 지정하여 하나씩 - */
        for(int i = str.length()-1; i>=0; i--){
            //끝 자리에 있는 글자부터 하나씩 변수에 저장
            rvs += str.charAt(i);
        }
        return rvs;
    }

    /*StringBuilder, StringBuffer의 reverse() 메소드를 이용한 Reverse. */
    static public String Solution_Builder_Buffer(String str){
        return new StringBuilder(str).reverse().toString();
        //return new StringBuffer(str).reverse().toString();//StringBuffer에도 같은 기능이 있다.
    }

    /*Last In First Out의 특징을 가진 Stack을 이용한 Reverse */
    static public String Solution_Stack(String str){
        //Stack 인스턴스 생성.
        Stack<Character> stk = new Stack<>();

        //String.toCharArray()를 이용하여 String의 요소를 char 배열로 저장.
        char[] ch = str.toCharArray();//['B','A','N','A','N','A']

        int k=0;

        for(int i =0; i<str.length(); i++){
            stk.push(ch[i]);
        }

        while(!stk.isEmpty()){
            ch[k++] = stk.pop();//LIFO의 성질을 이용한다.
        }
        //char array를 String으로 변환
        return String.copyValueOf(ch);
    }


}
