package com.deicos.lince.app.javafx;

import com.deicos.lince.app.LinceApp;
import com.deicos.lince.app.javafx.generic.JavaFXLinceBaseController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * lince-scientific-base
 * com.deicos.lince
 *
 * @author berto (alberto.soto@gmail.com)in 23/02/2017.
 * Description:
 * Loader for javafx classes supporting Spring in an indirect way.
 * Solves k
 * ey problem
 */
public class JavaFXLoader<T extends JavaFXLinceBaseController> {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    private FXMLLoader loader = new FXMLLoader();
    private LinceApp mainLinceApp;
    private Pane pane;
    private T controller;

    public T getController() {
        if (controller == null) {
            this.controller = loader.getController();
        }
        return controller;
    }


    public Pane getPane() {
        return pane;
    }

    public FXMLLoader getLoader() {
        return loader;
    }

    public JavaFXLoader(String location, LinceApp mainLinceApp) {
        try {
            //String location1 = location;
            this.loader = new FXMLLoader();
            this.mainLinceApp = mainLinceApp;
            loader.setLocation(this.mainLinceApp.getClass().getResource(location));
            this.pane = loader.load();
        } catch (Exception e) {
            log.error(this.getClass().getEnclosingMethod().toString(), e);
        }
    }

    /**
     * DARK ZONE
     * Javafx controllers cannot use autowired settings
     * Via lazy init, we make a link to linceApp who manages  autowired beans & services
     * This way we support Spring in javafx through a connection class
     * All javafx controllers that needs it should start data through "lazyInit" method
     */
    private void initController() {
        try {
            T controller = loader.getController();
            controller.setMainLinceApp(mainLinceApp);
            controller.lazyInit();
        } catch (Exception e) {
            log.error("initController", e);

        }
    }

    public void loadFXMLStage() {
        try {
            initController();
            mainLinceApp.setRootLayout((BorderPane) pane);
            // Show the scene containing the root layout.
            Scene scene = new Scene(mainLinceApp.getRootLayout());
            mainLinceApp.getPrimaryStage().setScene(scene);
            // Give the controller access to the main app.
            mainLinceApp.getPrimaryStage().show();
        } catch (Exception e) {
            //e.printStackTrace();
            log.error("loadFXMLStage", e);
        }
    }

    public Stage getDialog(String title, String icon) {
        try {
            Stage dialogStage = new Stage();
            dialogStage.setTitle(title);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.mainLinceApp.getPrimaryStage());
            dialogStage.getIcons().add(new Image(icon));
            // Show the dialog and wait until the user closes it
            Scene scene = new Scene(this.pane);
            dialogStage.setScene(scene);
            //dialogStage.showAndWait();
            return dialogStage;
        } catch (Exception e) {
            log.error("createDialog", e);
            return null;
        }
    }


    public static void exit() {
        System.exit(0);
    }


}
