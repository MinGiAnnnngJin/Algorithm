class Solution {
    public long solution(long n) {
        // 숫자를 문자열로 변환 후 각 자릿수를 배열에 넣음
        String numberStr = String.valueOf(n);
        int[] digits = new int[numberStr.length()];

        // 문자열의 각 자릿수를 숫자로 변환하여 배열에 저장
        for (int i = 0; i < numberStr.length(); i++) {
            digits[i] = Character.getNumericValue(numberStr.charAt(i));
        }

        // 배열을 내림차순으로 정렬 (버블 정렬 사용)
        for (int i = 0; i < digits.length - 1; i++) {
            for (int j = 0; j < digits.length - i - 1; j++) {
                if (digits[j] < digits[j + 1]) {
                    // 자리 바꾸기
                    int temp = digits[j];
                    digits[j] = digits[j + 1];
                    digits[j + 1] = temp;
                }
            }
        }

        // 정렬된 배열을 문자열로 합치기
        StringBuilder sortedStr = new StringBuilder();
        for (int digit : digits) {
            sortedStr.append(digit);
        }

        // 문자열을 숫자로 변환하여 반환
        return Long.parseLong(sortedStr.toString());
    }
}
