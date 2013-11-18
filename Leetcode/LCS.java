c class LCS {                                                              
        public static void main(String[] args) {                                
                // to be implemented                                            
                String s1 = "cn_blog";                                          
                String s2 = "chinglish";                                        
                                                                                
                LCString LString = new LCString();                              
                LString.CountLCS(s1, s2);                                       
                LString.LCS_print(s1, s2, s1.length(), s2.length());                                      
        }                                                                       
}                                                                               
                                                                                
class LCString {                                                                
        private int[][] cnt;                                                    
        private char[][] tag;  // in fact, we don't use tag.                                                 
                                                                                
        public void CountLCS(String s1, String s2) {                            
                int len1 = s1.length();                                         
                int len2 = s2.length();                                         
                                                                                
                if(len1 == 0 || len2 == 0) {                                    
                        System.out.println("LCS is 0");                         
                        return;                                                 
                }                                                               
                                                                                
                this.cnt = new int[len1+1][len2+1];                             
                this.tag = new char[len1+1][len2+1];                            
                                                                                
                for(int i = 0; i <= len2; i++) {                                
                        cnt[0][i] = 0;                                          
                        tag[0][i] = 'q';                                         
                }                                                               
                for(int j = 0; j <= len1; j++) {                                
                        cnt[j][0] = 0;                                          
                        tag[j][0] = 'q';                                         
                }                                                                                
                                                                            
	            for(int i = 1; i <= len1; i++) {                                
	                    for(int j = 1; j <= len2; j++) {                        
	                            if(s1.charAt(i-1) == s2.charAt(j-1)) {          
	                                    cnt[i][j] = cnt[i-1][j-1] + 1;          
	                                    tag[i][j] = 'a';                        
	                                    //LCS_len++;                              
	                            } else {                                        
	                                    if(cnt[i][j-1] > cnt[i-1][j]) {         
	                                            cnt[i][j] = cnt[i][j-1];        
	                                            tag[i][j] = 'b';                
	                                    } else {                                
	                                            cnt[i][j] = cnt[i-1][j];        
	                                            tag[i][j] = 'c';                
	                                    }                                       
	                            }                                               
	                    }                                                       
	            }                                                               
	             	            
	            // This method is wrong.
	            //System.out.println("The length is: " + LCS_len);                
	            
	            System.out.println("cnt[][] is: " + cnt[len1][len2]);           
	            return;                                                         
	    }  
        
        // This kind of print will have problems;
        /*
         *  qqqqqqqqqq
			qabbbbbbbb
			qcccabbbbb
			qccccccccc
			qccccccccc
			qcccccabbb
			qccccccccc
			qccccacccc
         * */
        
        /*
        public void LCS_print(String s1, String s2) {                           
            for(int i = 0; i <= s1.length(); i++) {                          
                    for(int j = 0; j <= s2.length(); j++) {               
                            if(tag[i][j] == 'a')                            
                                    System.out.print(s1.charAt(i-1));       
                            else                                            
                                    continue;                               
                    }                                                       
            }                                                               
        }*/
        
