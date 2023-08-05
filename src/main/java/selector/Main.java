package selector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import utilities.Pair;
import utilities.Value;

public class Main{

    public static void main(String[] args) {
        System.out.println("Hello World");
        String ROOT = System.getProperty("user.dir");
        String SEP = System.getProperty("file.separator");
        String PATH = ROOT + SEP + "src" + SEP + "main" + SEP + "resources" + SEP + "TOSELECT";
        String PATH1 = ROOT + SEP + "src" + SEP + "main" + SEP + "resources" + SEP + "CLASSIFIED";
        final String PATH2 = ROOT + SEP + "src" + SEP + "main" + SEP + "resources" + SEP + "LABS" + SEP;

        //List<String> names = List.of("ONE","TWO","THREE");

        String filename = "ciao.txt";

        File f = new File(PATH1 + SEP + "THREE" + SEP + filename);
        File f2 = new File(PATH1 + SEP + "TWO" + SEP + filename);
        System.out.println(f2.renameTo(f));

        Arrays.asList((Value.values())).stream().forEach(s -> System.out.println(s.toString() + "  " + s.ordinal()));

        var folder = new File(PATH);

        List<String> names = Arrays.asList(folder.list()).stream().toList();
        //names.forEach(s -> System.out.println(s));
        //System.out.println("##############################################");
        String EXT = ".txt";

        List<String> labelName = names.stream().map(s -> s.replace(".jpg", EXT)).toList();

        

        // labelName.forEach(s -> {
        //     String fileName = PATH2 + s;
        //     //System.out.println(fileName);
        //     String line;
        //     try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        //         String tmp;
        //         while ((line = br.readLine()) != null) {
        //             System.out.println(line);
        //         }
        //     } catch (IOException e) {
        //         e.printStackTrace();
        //     }
        // });




        
        // 

        //ImageManagerImpl im = new ImageManagerImpl(folder);
        //im.getActFile();

        // String[] file = folder.list ();

        // for (String tmp : file){
        //     System.out.println(tmp);
        // }



        // boolean success = true;

        // for (String i : names) {
        //     success = success && (new File(PATH1 + SEP + i).mkdirs());
        // }

        

        // if (success)
        // {
        // System.out.println("OK");
        // }else{
        //     System.out.println("NOOK");
        // }





        //System.out.println(PATH);

        //var folder = new File(PATH);

        //ImageManagerImpl im = new ImageManagerImpl(folder);
        //im.getActFile();

        // String[] file = folder.list ();

        // for (String tmp : file){
        //     System.out.println(tmp);
        // }
        
        
    }
}