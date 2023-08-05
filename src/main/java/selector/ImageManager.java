package selector;

import java.io.File;

import utilities.Pair;
import utilities.Value;

public interface ImageManager {

    //dimmi ancora cosa devi lavorare
    void getActFile();

    //dammi l'immagine successiva
    String next();

    //dammi l'immagine precedente
    String prev();

    //dammi l'immagine attuale
    Pair<String, Value> getActImage();

    //classifica immagine
    void classThisImage(Value toClass);

    //procedura di chiusura
    void closeAll();

    //annulla l'ultima operazione

    
    
}
