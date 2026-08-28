class Solution {
    TreeMap<Character,Integer>f1,f2;
  int temp=-1;
    int check (String s,String t )
    {

        if(s.charAt(0)!=t.charAt(0))
        {
            if(!f1.containsKey(t.charAt(0))) return 2;
            
        }
        
     for(int i=0;i<s.length();i++)
     {
        //char a=s.charAt(i);
        char b=t.charAt(i);
        if((!f1.containsKey(b))||f1.get(b)!=f2.get(b)) return 1;
     }

        return 3;

        
        
        
    }
    public String lexGreaterPermutation(String s, String target) {
        int n=s.length();
       
        f1=new TreeMap<>();
        f2=new TreeMap<>();

        for(int i=0;i<n;i++)
    {
         f1.put(s.charAt(i),f1.getOrDefault(s.charAt(i),0)+1);
         f2.put(target.charAt(i),f2.getOrDefault(target.charAt(i),0)+1);

    }
        int x=check(s,target);
       //  char [] ch= new char[n];
         StringBuilder str= new StringBuilder("");
         int  index=0;
      if (x == 1)
{
    int i = 0;

    // First try to follow target as much as possible
    for (; i < n; i++) {

        char q = target.charAt(i);

        // If exact character is available, match it
        if (f1.containsKey(q)) {

            str.append(q);

            f1.put(q, f1.get(q) - 1);

            if (f1.get(q) == 0) {
                f1.remove(q);
            }

        } else {
            break;
        }
    }

    // If exact matching failed, try to make current position greater
    if (i < n) {

        Character w = f1.higherKey(target.charAt(i));

        if (w != null) {

            str.append(w);

            f1.put(w, f1.get(w) - 1);

            if (f1.get(w) == 0) {
                f1.remove(w);
            }

            // Append remaining characters in sorted order
            for (char c : f1.keySet()) {
                str.append(String.valueOf(c).repeat(f1.get(c)));
            }

            return str.toString();
        }
    }

    // Cannot make current position greater
    // So backtrack
    while (str.length() > 0) {

        int pos = str.length() - 1;

        char removed = str.charAt(pos);

        // Restore removed character
        f1.put(
            removed,
            f1.getOrDefault(removed, 0) + 1
        );

        str.deleteCharAt(pos);

        // Try to increase this position
        Character w =
            f1.higherKey(target.charAt(pos));

        if (w != null) {

            str.append(w);

            f1.put(w, f1.get(w) - 1);

            if (f1.get(w) == 0) {
                f1.remove(w);
            }

            // Remaining characters should be smallest
            for (char c : f1.keySet()) {
                str.append(
                    String.valueOf(c).repeat(f1.get(c))
                );
            }

            return str.toString();
        }
    }

    return "";
}
        else if(x==2)
    {
      
          char ch=target.charAt(0);
         Character ans=f1.ceilingKey(ch);
         if(ans==null)
         {
             return "";
         }
        str.append(ans);
       f1.put(ans,f1.get(ans)-1);
       if(f1.get(ans)==0) f1.remove(ans);

       for(char z:f1.keySet())
       {
          str.append(String.valueOf(z).repeat(f1.get(z)));
       }
      
  //  return   str.toString();
       
       

    }
    else{
      int j=n-2;
      StringBuilder store= new StringBuilder(target);
      while(j>=0&&target.charAt(j)>=target.charAt(j+1)) j--;

       if(j<0) return "";

       if(j>=0)
       {
         int k=n-1;
         while(target.charAt(k)<=target.charAt(j)) k--;
         
         char temp1=target.charAt(k);
         store.setCharAt(k,store.charAt(j));
         store.setCharAt(j,temp1);

       }
         int left = 1+ j;
       int right = n-1;


// Reverse only the characters within this specific range
while (left < right) {
    char temp = store.charAt(left);
    store.setCharAt(left, store.charAt(right));
    store.setCharAt(right, temp);
    
    left++;
    right--;
}


       
return store.toString();

    }

   return str.toString();
    }
}