class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        
        int n = num.length();
        
        for(int i=0;i<n;i++)
        {
            char c = num.charAt(i);
            
            while(!st.isEmpty() && k>0 && st.peek()>c)
            {
                st.pop();
                k--;
            }
            
            st.push(c);
        }
        
        while(k>0)
        {
            st.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        
        char arr[] = new char[st.size()];
        
        int j  = arr.length-1;
        
        while(!st.isEmpty())
        {
            arr[j--] = st.pop();
        }
        
        int i = 0;
        
        while(i<arr.length && arr[i]=='0')
        {
            i++;
        }
        
        int nn = arr.length;
        
        while(i<nn)
        {
            sb.append(arr[i++]);
        }
        
        if(sb.length()<1)
        {
            return "0";
        }
        
        return sb.toString();
    }
}
