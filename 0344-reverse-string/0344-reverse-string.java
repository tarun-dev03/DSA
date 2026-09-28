class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while(start < end){
            swap(s,start , end);
            start++;
            end--;
        }

    }
    public void swap(char[] s,int st , int e){
        char temp = s[st];
        s[st] = s[e];
        s[e] = temp;

    }
}