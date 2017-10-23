/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsonex;

/**
 *
 * @author Tugrul
 */
public class sıralama {
     static int sırala(double dizi[])
    {
        // Dizinin en küçük ve en büyük elemanlarını bulduk
        double max = dizi[0];
        int maxtemp=0;
        for(int i=0; i<dizi.length; i++)
        {
            if(max < dizi[i])
            {
                max = dizi[i];
               
            }
        }
        
        for (int i = 0; i <dizi.length; i++) {
            if (dizi[i]==max) {
                maxtemp=i;
                
            }
        }
         
       return maxtemp;
    }

    
}
