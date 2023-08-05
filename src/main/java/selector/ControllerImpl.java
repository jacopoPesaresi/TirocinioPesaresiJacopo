package selector;



import java.io.File;

import utilities.Value;
import view.FXMLMainView;
import view.View;

public class ControllerImpl implements ControllerObserver {

    private View view;
    private ImageManager manager;

    public ControllerImpl() {
        this.view = new FXMLMainView();
        //System.out.println("Hello World");
        String ROOT = System.getProperty("user.dir");
        String SEP = System.getProperty("file.separator");
        String PATH = ROOT + SEP + "src" + SEP + "main" + SEP + "resources" + SEP + "TOSELECT";
        System.out.println(PATH);

        var folder = new File(PATH);

        manager = new ImageManagerImpl(folder);
    }

    @Override
    public void init() {
        this.view.init(this);
    }


    @Override
    public void start() {
        this.view.startView();
        this.view.uploadImage(manager.getActImage());

    }

    @Override
    public void computeInput(Value input) {
        switch(input) {
            case GOBACK : manager.prev(); break;
            case GO : manager.next(); break;
            case UNCLASSIFIED : break;
            case CLOSE : manager.closeAll(); break;
            default : manager.classThisImage(input); manager.next(); break;
        }
        System.out.println(manager.getActImage());
        view.uploadImage(manager.getActImage());
    }
    
}
