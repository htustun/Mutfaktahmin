/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsonex;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;   

public class mutfaktahmin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
           int lan=0;
           double [] bayestemp = new double[20];
           Gson gson = new Gson();
           JsonReader reader = new JsonReader(new FileReader("C:\\Users\\Tugrul\\Desktop\\yazlab\\train\\train.json"));
           Type listType = new TypeToken<ArrayList<sınıf>>(){}.getType();
           
               
            //List<sınıf> yourClassList = new Gson().fromJson(jsonArray, listType);
	    ArrayList<sınıf> staff = gson.fromJson(reader, listType);
            Set<String> letter = new HashSet<String>();
            Set<String> ing = new HashSet<String>();
            for (int i = 0; i <staff.size(); i++) {
                 letter.add(staff.get(i).cuisine); 
                 ing.addAll(staff.get(i).ingredients);
        }
           
            
            //mutfakların ismini ve numarasını tutucaz.
            Map<String,Integer> mutfaklar = new HashMap<String, Integer>();
            ArrayList<String> m2 =new ArrayList<>(letter);
            for (int i = 0; i <m2.size(); i++) {
            //System.out.println(m2.get(i));
            mutfaklar.put(m2.get(i),i);
             //System.out.println(mutfaklar);       
        }
           
            
            double [] mutfakcount = new double [20];
            
            //mutfak sayiları tutuluyor.
            for (int i = 0; i <staff.size(); i++) {
                if (staff.get(i).cuisine.equals("greek")) {
                    mutfakcount[0]++;
                }
                if (staff.get(i).cuisine.equals("spanish")) {
                    mutfakcount[1]++;
                }
                if (staff.get(i).cuisine.equals("russian")) {
                    mutfakcount[2]++;
                }
                if (staff.get(i).cuisine.equals("irish")) {
                    mutfakcount[3]++;
                }
                if (staff.get(i).cuisine.equals("italian")) {
                    mutfakcount[4]++;
                }
                if (staff.get(i).cuisine.equals("british")) {
                    mutfakcount[5]++;
                }
                if (staff.get(i).cuisine.equals("thai")) {
                    mutfakcount[6]++;
                }
                if (staff.get(i).cuisine.equals("moroccan")) {
                    mutfakcount[7]++;
                }
                if (staff.get(i).cuisine.equals("mexican")) {
                    mutfakcount[8]++;
                }
                if (staff.get(i).cuisine.equals("vietnamese")) {
                    mutfakcount[9]++;
                }
                 if (staff.get(i).cuisine.equals("korean")) {
                    mutfakcount[10]++;
                }
                if (staff.get(i).cuisine.equals("cajun_creole")) {
                    mutfakcount[11]++;
                }
                if (staff.get(i).cuisine.equals("chinese")) {
                    mutfakcount[12]++;
                }
                if (staff.get(i).cuisine.equals("jamaican")) {
                    mutfakcount[13]++;
                }
                if (staff.get(i).cuisine.equals("japanese")) {
                    mutfakcount[14]++;
                }
                if (staff.get(i).cuisine.equals("brazilian")) {
                    mutfakcount[15]++;
                }
                if (staff.get(i).cuisine.equals("southern_us")) {
                    mutfakcount[16]++;
                }
                if (staff.get(i).cuisine.equals("filipino")) {
                    mutfakcount[17]++;
                }
                if (staff.get(i).cuisine.equals("indian")) {
                    mutfakcount[18]++;
                }
                if (staff.get(i).cuisine.equals("french")) {
                    mutfakcount[19]++;
                }
           }
            //malzemelerin ismini ve numarasını tutuyoruz
            Map<String,Integer> malzemeler = new HashMap<String, Integer>();
            ArrayList<String> m3 =new ArrayList<>(ing);
            for (int i = 0; i <m3.size(); i++) {
                //System.out.println(m3.get(i));
                malzemeler.put(m3.get(i), i);
                //System.out.println(malzemeler);
        }
            
            //System.out.println(malzemeler.size());
	    double [][] malzemetablo = new double [m2.size()][m3.size()];
            
            
            //mutfaklara göre toplam malzeme sayisi  ataması.
            
            for (int i = 0; i <staff.size(); i++) {
                List<String> inf = staff.get(i).ingredients;
                int mutfakindex=mutfaklar.get(staff.get(i).cuisine);
                for (int j = 0; j <inf.size(); j++) {
                    int malzemeindex=malzemeler.get(inf.get(j));
                    malzemetablo[mutfakindex][malzemeindex]++;
                    
                    }
                 
                }
           
        double [][] bayestablo = new double [m2.size()][m3.size()];
       //olasılık tablosu olusumu
        for (int i = 0; i <m2.size(); i++) {
                //int mutfakindex=mutfaklar.get(staff.get(i).cuisine);
                for (int j = 0; j <m3.size(); j++) {
                    if (malzemetablo[i][j]==0) {
                        malzemetablo[i][j]=malzemetablo[i][j]+(1/mutfakcount[i]);
                        
                    }
                    bayestablo[i][j]=malzemetablo[i][j]/mutfakcount[i];
                   // System.out.print(temp); 
                 //  System.out.println(malzemetablo[i][j]);
                //System.out.println(gaussetablo[i][j]);
                    }
                //System.out.println("");
                 
                }
          
          
          for (int i = 0; i < m2.size(); i++) {
            bayestemp[i]=(mutfakcount[i]/staff.size());
              
              //System.out.println(gausstemp[i]);
        }
          System.out.println("Bekleyiniz");
          /*
           for (int i = 0; i <staff.size(); i++) {
            for (int j = 0; j<staff.get(i).ingredients.size(); j++) {
                for (int k = 0; k <m3.size(); k++) {
                    if (staff.get(i).ingredients.get(j).equals(m3.get(k))) {
                        for (int m = 0; m <20;m++) {
                                bayestemp[m]=bayestemp[m]*bayestablo[m][k];
                        }
                           for (int l = 0; l < 20; l++) {
                                        bayestemp[l]=mutfakcount[l]/staff.size();
                                    }
                    }
                }
            }
            
        } 
          */
           JsonReader readerdeneme = new JsonReader(new FileReader("C:\\Users\\Tugrul\\Desktop\\yazlab\\train\\testdeneme.json"));
           Type listTypedeneme = new TypeToken<ArrayList<sınıf>>(){}.getType();
           ArrayList<sınıf> staffdeneme = gson.fromJson(readerdeneme, listTypedeneme);
           //System.out.println(staffdeneme.size());
           int [] GaussWinner= new int[staffdeneme.size()];
           
          
           for (int i = 0; i <staffdeneme.size(); i++) {
            for (int j = 0; j<staffdeneme.get(i).ingredients.size(); j++) {
                for (int k = 0; k <m3.size(); k++) {
                    if (staffdeneme.get(i).ingredients.get(j).equals(m3.get(k))) {
                        for (int m = 0; m <20;m++) {
                                bayestemp[m]=bayestemp[m]*bayestablo[m][k];
                        }
                         GaussWinner[i]=sıralama.sırala(bayestemp);
                           for (int l = 0; l < 20; l++) {
                                        bayestemp[l]=mutfakcount[l]/staff.size();
                                        
                                    }
                    }
                }
            }
            
            //System.out.println(m2.get(GaussWinner[i]));
            if (staffdeneme.get(i).cuisine.equals(m2.get(GaussWinner[i]))) {
                lan++;
            }
            
        } 
           
       
        
        for (int i = 0; i <staffdeneme.size(); i++) {
            System.out.print(i+"-) "+staffdeneme.get(i).cuisine+"---------------------------->"+m2.get(GaussWinner[i]));
            System.out.println("");
        }
    //  System.out.println(staff.get(0).cuisine);
        System.out.println("test edilen veri sayisi:"+staffdeneme.size());
        System.out.println("doğru tahmin edilen mutfak sayisi:"+lan);
        System.out.println(("%"+(lan*100)/staffdeneme.size()));
           
        
    }
    
}
