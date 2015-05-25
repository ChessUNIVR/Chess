package game;
import Pieces.*;
import java.util.ArrayList;

/**
 * @author Emil Tomellini
 * @author Mattep Brentegani
 *
 */
public class Scacchiera {
    
    public Pezzo[][] matrix;
    public ArrayList<Pezzo> pezziNeri; 
    public ArrayList<Pezzo> pezziBianchi;
    private Pezzo scaccoN;
    
    /*
    *   Define the matrix that we use for save the position and the current state of the game.
    *   1 - White
    *   2 - Black
    *   P = Pedone
    *   C = Cavallo
    *   A = Alfiere
    *   T = Torre
    *   D = Donna/Regina
    *   R = Re
    *
    */
    public Scacchiera() { 
        
        pezziNeri = new ArrayList();
        pezziBianchi = new ArrayList();
        
        pezziNeri.add(new Re(0, 3, Color.Black, "R"));
        pezziNeri.add(new Regina(0 , 4, Color.Black, "D"));
        pezziNeri.add(new Alfiere(0 , 2, Color.Black, "A"));
        pezziNeri.add(new Alfiere(0 , 5, Color.Black, "A"));
        pezziNeri.add(new Cavallo(0, 1, Color.Black, "C"));
        pezziNeri.add(new Cavallo(0 , 6, Color.Black, "C"));
        pezziNeri.add(new Torre(0 , 0, Color.Black, "T"));
        pezziNeri.add(new Torre(0 , 7, Color.Black, "T"));
        pezziNeri.add(new Pedone( 1, 0, Color.Black, "P"));
        pezziNeri.add(new Pedone( 1, 1, Color.Black, "P"));
        pezziNeri.add(new Pedone( 1, 2, Color.Black, "P"));
        pezziNeri.add(new Pedone( 1, 3, Color.Black, "P"));
        pezziNeri.add(new Pedone( 1, 4, Color.Black, "P"));
        pezziNeri.add(new Pedone( 1, 5, Color.Black, "P"));
        pezziNeri.add(new Pedone( 1, 6, Color.Black, "P"));
        pezziNeri.add(new Pedone( 1, 7, Color.Black, "P"));
        
        pezziBianchi.add(new Re(8, 3, Color.White, "R"));
        pezziBianchi.add(new Regina(8 , 4, Color.White, "D"));
        pezziBianchi.add(new Alfiere(8 , 2, Color.White, "A"));
        pezziBianchi.add(new Alfiere(8 , 5, Color.White, "A"));
        pezziBianchi.add(new Cavallo(8, 1, Color.White, "C"));
        pezziBianchi.add(new Cavallo(8 , 6, Color.White, "C"));
        pezziBianchi.add(new Torre(8 , 0, Color.White, "T"));
        pezziBianchi.add(new Torre(8 , 7, Color.White, "T"));
        pezziBianchi.add(new Pedone( 7, 0, Color.White, "P"));
        pezziBianchi.add(new Pedone( 7, 1, Color.White, "P"));
        pezziBianchi.add(new Pedone( 7, 2, Color.White, "P"));
        pezziBianchi.add(new Pedone( 7, 3, Color.White, "P"));
        pezziBianchi.add(new Pedone( 7, 4, Color.White, "P"));
        pezziBianchi.add(new Pedone( 7, 5, Color.White, "P"));
        pezziBianchi.add(new Pedone( 7, 6, Color.White, "P"));
        pezziBianchi.add(new Pedone( 7, 7, Color.White, "P"));
        
	matrix = new Pezzo[][] {{ pezziNeri.get(6),
            pezziNeri.get(4),
            pezziNeri.get(2),
            pezziNeri.get(1),
            pezziNeri.get(0),
            pezziNeri.get(3),
            pezziNeri.get(5),
            pezziNeri.get(7)},
            { pezziNeri.get(8),
                pezziNeri.get(9), 
                pezziNeri.get(10), 
                pezziNeri.get(11), 
                pezziNeri.get(12), 
                pezziNeri.get(13), 
                pezziNeri.get(14), 
                pezziNeri.get(15)}, 
            { new Empty(), new Empty(), new Empty(), new Empty(), new Empty(), new Empty(), new Empty(), new Empty() },
            { new Empty(), new Empty(), new Empty(), new Empty(), new Empty(), new Empty(), new Empty(), new Empty() },
            { new Empty(), new Empty(), new Empty(), new Empty(), new Empty(), new Empty(), new Empty(), new Empty() },
            { new Empty(), new Empty(), new Empty(), new Empty(), new Empty(), new Empty(), new Empty(), new Empty() },
            { pezziBianchi.get(8),
                pezziBianchi.get(9),
                pezziBianchi.get(10),
                pezziBianchi.get(11),
                pezziBianchi.get(12),
                pezziBianchi.get(13),
                pezziBianchi.get(14),
                pezziBianchi.get(15)},
            { pezziBianchi.get(6),
                pezziBianchi.get(4),
                pezziBianchi.get(2),
                pezziBianchi.get(1),
                pezziBianchi.get(0),
                pezziBianchi.get(3),
                pezziBianchi.get(5),
                pezziBianchi.get(7)}
        };
    }
    
    //Metodo per effettuare lo spostamento, inoltre controlla se quest ultimo è consentito e 
    // richiamando il metodo checkMove controlla se la casella su cio vuole effettuare lo spostamento non è 
    // occupata da un all'elleato
    public int move(int x, int y, Pezzo peace) {
        
        Re temp;
        
        if (peace.getColor() == Color.Black)
            temp = (Re)pezziNeri.get(0);
        else
            temp = (Re)pezziBianchi.get(0);
        
        switch(peace.getType()) {
            case "P": {
                Pedone p = (Pedone)peace;
                //controlliamo se è la prima mosse di quel pedone
                //if (pawnMove(x, y, p)) { // poi con il risultato possiamo andare a erificare e modificare lo spostamento nella cella
                    //if (checkScacco(x, y)) {
                    //non posso modificare la matrice perche porto in scacco oppure
                    //sto facendo una mossa che non mi risolve lo scacco attuale
                        
                    // se vado in checkScacco con il RE dobbiamogestire la cosa con un metodo apposito (x, y, Re)
                    //}
                    //else {
                    //modifico liberamente la matrice perche sto eeguendo un'operazione valida
                    //}
               // }
            } break;
            case "T": {
                Torre t = (Torre)peace;
                if (x == t.getX()) {
                    if (freeY(x, y, peace))   //Controlla se la linea in y è libera da altre pedine
                        return checkMove(x, y);
                }
                else {
                    if (y == t.getY()) {
                        if (freeX(x, y, peace))//controlla se la linea in x è libera da altre pedine
                            return checkMove(x, y);
                    }
                    else
                        return -1;
                }
            } break;
            case "C": {
                Cavallo c = (Cavallo)peace;
                //TO DO
            } break;
            case "A": {
                Alfiere a = (Alfiere)peace;
                if (x == a.getX() || y == a.getY()) {
                    return -1;
                }
                return checkAlferie(x, y, peace) ? 1 : -1; 
            }
            case "D": { 
                Regina d = (Regina)peace;
                if (x == d.getX()) {
                    if (freeX(x, y, peace)) {
                        return checkMove(x, y);
                    }
                }
                if (y == d.getY()) {
                    if (freeY(x, y, peace)) {
                        return checkMove(x, y);
                    }
                }
                return checkAlferie(x, y, peace) ? 1 : -1;
            }
            case "R": {
                Re r = (Re)peace;
            } break;
            default: return -1;
        }
        return -1;
    }
    
    private boolean freeX(int x, int y, Pezzo peace) {
        int val;
        
        if (peace.getColor() == Color.Black) {
            if (x - peace.getX() > 0)
                val = 1;
            else    
                val = -1;
        } else {
            if (x - peace.getX() > 0)
                val = 1;
            else 
                val = -1;
        }
        
        for (int j = peace.getX(); j != x; j+=val)
            if (matrix[j][y] != null)
                return false;
        return true;
    }
    
    private boolean freeY(int x, int y, Pezzo peace) {
        int val;
        
        if (peace.getColor() == Color.Black) {
            if (y - peace.getY() > 0)
                val = 1;
            else    
                val = -1;
        } else {
            if (y - peace.getY() > 0)
                val = 1;
            else 
                val = -1;
        }
       
        for (int j = peace.getY(); j != y; j+=val)
            if (matrix[x][j] != null)
                return false;
        return true;
    }
    
    private boolean freeXY(int x, int y, int qx, int qy, Pezzo peace) {
        for (int i = peace.getX(); i != x; i+=qx)
            for (int j = peace.getY(); j != y; j+=qy) 
                if (matrix[i][j] != null) 
                    return false;
        return true;
    }
	
    private int checkMove(int x, int y) {
        //ritorna -1 non è possibile fare lo spostamento
	//ritorna 0 se può fare lo spostamento ma non mangia
	//ritorna 1 se può fare lo spostamento e mangia l'avversario
        return 0;
    }
    
    private boolean checkAlferie(int x, int y, Pezzo peace){
        if (x > peace.getX()) {
            if (y > peace.getY()) {
                if (freeXY(x, y, 1, 1, peace)) {     //Controllo sul quadrante cartesiano 1
                    return checkMove(x, y) >= 0;         //Non credo che bisogna chiamare checkmove perche so gia dall'if che il traggitto è libero e posso mangiare
                }
            } else {
                if (freeXY(x, y, 1, -1, peace)) {   //Controllo sul quadrante cartesiano 4
                    return checkMove(x, y) >= 0;
                 }                
            }
        } else {
            if (y > peace.getY()) {     //Controllo sul quadrante cartesiano 2
                if (freeXY(x, y, -1, 1, peace)) {
                    return checkMove(x, y) >= 0;
                }
            } else {
                if (freeXY(x, y, -1, -1, peace)) {        //Controllo sul quadrante cartesiano 3
                    return checkMove(x, y) >= 0;
                }
              }
        }
        return false;
    }
    
    private int pawnMove(int x, int y, Pedone p) {
            //Controllimo se il pedone ha effettuato spostamenti sull'asse x
            if (x == p.getX()) {
            //Controlliamo se si è spostato di uno sull'asse y o di due
                if (y == p.getY() + 1) {
                //Modifica matrice prima di restituire il valore di check
                    return checkMove(x, y);
                } else {
                    if ((p.getFirstMove()) && (y == p.getY() + 2)) {
                    //Modifica matrice prima di restituire il valore di check
                        p.setFirstMove();
                        return checkMove(x, y);
                    }   //altrimenti la mossa non è valida e rendiamo nulla la mossa
                    else
                        return -1;
                }
            } else {    //Controlliamo se siamo nel caso di spostamento diagonale per mangiare un nemico
                if (x == p.getX() + 1 && (y == p.getY() + 1 || y == p.getY() - 1)) {
                //Modifica matrice prima di restituire il valore di check
                    return checkMove(x, y);
                }
                else    
                    return -1;
            }
    }
    
    private Pezzo[][] copyMatrix() {
        Pezzo[][] copy = new Pezzo[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                copy[i][j] = matrix[i][j];
            }
        }
        return copy;
    }
    
    public int checkScacco(int x, int y, Re re) {
        if (re.getColor() == Color.Black) { //Caso Re Nero
            if (re.getScacco()) {
                //Qui siamo in scacco e sappiamo da pezzo perche lo abbiamo salvato in una variabile globale
                if (scaccoN.getX() == x && scaccoN.getY() == y) {   //mangio
                    if (anotherCheck(re.getColor())) {
                        re.setScacco();
                        return 1; // possiamo fare la mossa e siamo usciti dallo scacco   
                    } else return -1;
                }
                if (scaccoN.getType().equals("C")) { //Si potrebbe inserire il controllo all'interno dello switch
                    return -1;  //Qui va bene ma nel checkMove dobbiamo fare controli speciali per il re
                } else {
                    switch(scaccoN.getType()) {
                        case "P": {
                            if (scaccoN.getX() == x && scaccoN.getY() == y) {
                                //possiamo entrare in un ulteriore scacco se muoviamo  richiamiamo una funzione per  la gestione del controllo
                                return 1;   //siamo usciti dallo scacco movimento possible
                            } else return -1; //lo scacco perisiste non si puo fare
                        }
                        case "D":
                        case "A": {
                            if (scaccoN.getX() == x && scaccoN.getY() == y) { 
                                return -1;
                            } else {                                
                                if (checkAlferie(re.getX(), re.getY(), scaccoN))
                                    //Ulteriore scacco?
                                    return 1;
                                //se questo da un riusltato positivo devo controllare che il movimento non porti ad un ulteriore scacco
                            }
                        }
                        case "T": {
                            if (scaccoN.getX() == x && scaccoN.getY() == y) { 
                                return 1;
                            } else {
                                if (x == scaccoN.getX() && scaccoN.getX() == re.getX()) {
                                    int max;
                                    int min;
                                    if (scaccoN.getY() > re.getY()) {
                                        max = scaccoN.getY();
                                        min = re.getY();
                                    } else {
                                        max = re.getY();
                                        min = scaccoN.getY();
                                    }
                                    if (min < y && y < max) {
                                        freeX(re.getX(), re.getY(), scaccoN);
                                    }
                                } else {
                                    if (x == scaccoN.getY() && scaccoN.getY() == re.getY()) {
                                        int max;
                                        int min;
                                        if (scaccoN.getX() > re.getX()) {
                                            max = scaccoN.getX();
                                            min = re.getX();
                                        } else {
                                            max = re.getX();
                                            min = scaccoN.getX();
                                        }
                                        if (min < x && x < max) {
                                         freeY(re.getX(), re.getY(), scaccoN);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }                
            } else {
                //Non siamo in scacco ma la mossa ci potrebbe portare in questa situazione e potremmo anche a nostra volta 
                //porre scacco all'avversario
            }
        } else {    //Caso Re Bianco
            //Idem
        }
        
        return 0;
    }
    
    private boolean anotherCheck(Color c) {
        ArrayList<Pezzo> temp;
        Re re;
        int i;
        
        if (c == Color.Black) {
            //temp = new ArrayList<>(pezziBianchi.size());
            temp = (ArrayList<Pezzo>)pezziBianchi.clone();
            re = (Re)pezziBianchi.get(0);
            i = 1;
            
            for (Pezzo x : temp) {
                switch  (x.getType()) {
                    case "P": {
                        if (Math.abs(x.getX() - re.getX()) > 1 && Math.abs(x.getY() - re.getY()) > 1)
                            return false;
                        else
                            return re.getX() == x.getX() + i && (re.getY() == x.getY() + i || re.getY() == x.getY() - i);
                    }
                    case "T": {
                        if (x.getX() != re.getX() && x.getY() != re.getY())
                            return false;
                        else {
                            if (x.getX() == re.getX())
                                return freeY(re.getX(), re.getY(), x);
                            else return freeX(re.getX(), re.getY(), x);
                        }
                    }
                    case "A": {
                        return checkAlferie(re.getX(), re.getY(), x);       
                    }
                    case "D": {
                        if (x.getX() != re.getX() && x.getY() != re.getY())
                            return false;
                        if (x.getX() == re.getX() && x.getY() != re.getY())
                            return freeY(re.getX(), re.getY(), x);
                        else if (x.getX() != x.getY()  && x.getY() == re.getY())
                            return freeX(re.getX(), re.getY(), x);
                        else return checkAlferie(re.getX(), re.getY(), x);
                    }                    
                    case "R":
                        if (Math.abs(x.getX() - re.getX()) == 1 && Math.abs(x.getY() - re.getY()) == 1)
                            return false;
                }
            }
        }  
        return true;
    }
    
    public void Stamp() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(matrix[i][j].getType() + " | ");
            }
            System.out.println("\n");
        }
    }
}