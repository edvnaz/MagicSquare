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

    int [][] stac = {
                    {4,9,2,3,5},
                    {3,5,7,4,2},
                    {8,1,6,6,2},
                    {1,1,6,6,2}
                    };
    
    int magKvdSk = 0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MagicSquare jAp = new MagicSquare();
        jAp.sprendimas();
    }
    

    public void sprendimas(){
        for(int dyd = 1; dyd < (stac.length < stac[0].length ? stac.length : stac[0].length)+1; dyd++)
        {
            for(int eil = 0; eil < stac.length-dyd; eil++)
            {
                for(int stul = 0; stul < stac[0].length-dyd; stul++)
                {
                    if(tikrinimas(eil, stul, dyd))
                        magKvdSk++;
                }
            }
        }

        System.out.println("No. of Magic Square in matrix: " + magKvdSk);
//        System.out.println("ats " + magKvdSk);
    }
    
    public boolean tikrinimas(int eil, int stul, int dyd){
        int pvzSuma = 0, sum = 0;
        
        //pirmos eiles suma
        for(int e = eil; e < eil+1; e++)
        {
            for(int s = stul; s <= stul+dyd; s++)
            {
                pvzSuma += stac[e][s];
            }
        }
        
        //horizontaliai
        for(int e = eil; e <= eil+dyd; e++)
        {
            for(int s = stul; s <= stul+dyd; s++)
            {
                sum += stac[e][s];
            }   
            if(sum != pvzSuma)
            {
                return false;
            }
            sum = 0;
        }
        
        //vertikaliai
        for(int s = stul; s <= stul+dyd; s++)
        {
            for(int e = eil; e <= eil+dyd; e++)
            {
                sum += stac[e][s];
            }   
            if(sum != pvzSuma){
                return false;
            }
            sum = 0;
        }
        
        //istrizai #1
        if(dyd > 1)
        {
            for(int e = eil; e <= eil+dyd; e++)
            {
                sum += stac[e][stul++];
//                System.out.println(sum + " sum " + e + ":" + stul + "\n");
            }
            if(sum != pvzSuma)
            {
                return false;
            }
        }

        return true;
    }
}
