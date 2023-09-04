public class CurrectParentheses {

    /* 올바른 괄호
    
    괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 
    예를 들어        
    "()()" 또는 "(())()" 는 올바른 괄호입니다.
    ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
    '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
     */
    
    // 내 풀이, 효율성 체크에서 실패.
    public static boolean solution(String s){
        boolean answer = false;

        //()로 짝지어서 replace를 ""로 했는데도 남아있는게있는지 확인
        while(s.contains("()")){
            s = s.replace("()", "");
        }

        if(s.isEmpty()){
            answer = true;
        }

        return answer;
    }

    //효율성 포함 통과 풀이
    public static boolean solution2(String s) {
        char[] str = s.toCharArray();
        boolean answer = false;
        int cnt = 0;
        for (char c : str) {
            // '('이걸 만나면 +1 ')' 이걸 만나면 -1을 한다.
            cnt += c == '(' ? 1 : -1;
            // 이 때 cnt가 음수가 되는 순간이 오면
            // 괄호가 열리지 않았는데 닫히는 케이스 이므로 false를 리턴한다.
            if(cnt < 0) return false;
        }
        // 짝이 맞으면 cnt는 무조건 0이므로 true를 리턴
        return cnt == 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("(()("));
        System.out.println(solution2("(()("));
    }


}
