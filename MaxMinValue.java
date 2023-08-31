import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/*
    [최댓값과 최솟값]

    문자열 S는 공백으로 구분된 숫자들 저장.
    구분된 숫자들 중 최솟값, 최대값을 찾아서
    "최솟값 최대값" 형태의 문자열 반환

    입출력 예
    s	| return
    "1 2 3 4" | "1 4"
    "-1 -2 -3 -4" | "-4 -1"
    "-1 -1"	| "-1 -1"
     */

public class MaxMinValue {

    //split한 배열 for문으로 하나씩 읽어오면서 최대값 최솟값 즉시 비교.
    public static String getMaxMinValue(String str) {

        String[] tmp = str.split(" ");// 공백 문자열 split
        int min, max, n; // 최대값, 최솟값, 현재값

        min = max = Integer.parseInt(tmp[0]);// 비교를 위한 최대,최솟값 초기화

        //split 된 요소를 인덱스로 하나씩 불러오면서 즉시 최대값 최솟값과 비교.
        for (int i = 1; i < tmp.length; i++) {
            n = Integer.parseInt(tmp[i]); // 현재 i 인덱스의 값
            if (min > n) min = n; //현재 값이 min보다 작다면 최솟값
            if (max < n) max = n; // 크다면 최대값
        }

        return min + " " + max;
    }

    //Arrays.sort 를 이용하여 오름차순 정렬 후 첫 값과 끝 값으로 처리
    public static String getMaxMinValue_sort(String str){
        String[] tmp = str.split(" ");// 공백 문자열 split
        int[] arr = new int[tmp.length];

        //String 형태에서 int로 변환 후 int 배열 요소로 넣어주기
        for(int i = 0; i< tmp.length; i++ ){
            arr[i] = Integer.parseInt(tmp[i]);
        }

        Arrays.sort(arr); // 오름차순 정렬

        return arr[0] + " " + arr[tmp.length -1] ; // 오름차순 정렬 후 첫 값, 끝 값 출력.

    }

    public static void main(String[] args) {
        String str = "1 3 2 4";

        System.out.println(getMaxMinValue(str));
        System.out.println(getMaxMinValue_sort(str));
    }
}




