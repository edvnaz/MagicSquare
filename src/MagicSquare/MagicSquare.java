/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MagicSquare;

/**
 *
 * @author Ed
 */
public class MagicSquare {

    //pvz #1
    int [][] stac = {
                    {4,9,2,3,5},
                    {3,5,7,4,2},
                    {8,1,6,6,2},
                    {1,1,6,6,2}
                    };
    /* pvz #2
     * 
    int [][] stac = {
                {4,9,2,3,5,4,14,15,1},
                {3,5,7,4,2,9,7,6,12},
                {8,1,6,6,2,5,11,10,8},
                {1,1,6,6,2,16,2,3,13}
                };
    */
    
    int magKvdSk = 0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MagicSquare jAp = new MagicSquare();
        jAp.sprendimas();
    }
    
    /**
     * Tikrina nuo maziausio iki didziausio galimo magisko kvadrato matricoje
     * dyd - riboja for funkcija kad neuzeiti is matricos ribu
     */
    public void sprendimas(){
        for(int dyd = 1; dyd < (stac.length < stac[0].length ? stac.length : stac[0].length)+1; dyd++){
            for(int eil = 0; eil < stac.length-dyd; eil++){
                for(int stul = 0; stul < stac[0].length-dyd; stul++){
                    if(tikrinimas(eil, stul, dyd))
                        magKvdSk++;
                }
            }
        }

        System.out.println("No. of Magic Square in matrix: " + magKvdSk);
//        System.out.println("ats " + magKvdSk);
    }
    
    //Tikrina ar tikrinamas kvadratas atitinka mag. kv. savybes
    public boolean tikrinimas(int eil, int stul, int dyd){
        int M = 0, sum = 0, sum2 = 0;
        
        //pirmos eiles suma
        for(int e = eil; e < eil+1; e++){
            for(int s = stul; s <= stul+dyd; s++){
                M += stac[e][s];
            }
        }
        
        //horizontaliai
        for(int e = eil; e <= eil+dyd; e++){
            for(int s = stul; s <= stul+dyd; s++){
                sum += stac[e][s];
            }   
            if(sum != M){
                return false;
            }
            sum = 0;
        }
        
        //vertikaliai
        for(int s = stul; s <= stul+dyd; s++){
            for(int e = eil; e <= eil+dyd; e++){
                sum += stac[e][s];
            }   
            if(sum != M){
                return false;
            }
            sum = 0;
        }
        
        //istrizai abiem pusem
        int x = dyd;
        if(dyd > 1){
            for(int e = eil; e <= eil+dyd; e++){
                sum += stac[e][stul++];
                sum2 += stac[e][x--];
            }
            if(sum != M && sum2 != M){
                return false;
            }
        }

        return true;
    }
}
