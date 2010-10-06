/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author Eduardo Cerritos
 */
public class VisualNotas extends MIDlet implements CommandListener {

    private boolean midletPaused = false;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private List list;
    private Alert Dialogo;
    private Form IngresoNotas;
    private StringItem stringItem;
    private ChoiceGroup choiceGroup;
    private TextField textField1;
    private TextField textField2;
    private TextField textField;
    private TextBox Notas;
    private Alert NotaDeCiclo;
    private Alert BorrarNotas;
    private Command exitCommand;
    private Command itemCommand;
    private Command okCommand;
    private Command cancelCommand;
    private Command SiCommand;
    private Command NoCommand;
    private Command okCommand1;
    //</editor-fold>//GEN-END:|fields|0|

    /**
     * The VisualNotas constructor.
     */
    public VisualNotas() {
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getList());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == Dialogo) {//GEN-BEGIN:|7-commandAction|1|33-preAction
            if (command == NoCommand) {//GEN-END:|7-commandAction|1|33-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|2|33-postAction
                // write post-action user code here
            } else if (command == SiCommand) {//GEN-LINE:|7-commandAction|3|31-preAction
                // write pre-action user code here
                switchDisplayable(null, getIngresoNotas());//GEN-LINE:|7-commandAction|4|31-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|5|29-preAction
        } else if (displayable == IngresoNotas) {
            if (command == cancelCommand) {//GEN-END:|7-commandAction|5|29-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|6|29-postAction
                // write post-action user code here
            } else if (command == okCommand) {//GEN-LINE:|7-commandAction|7|27-preAction
                // write pre-action user code here
                switchDisplayable(null, getDialogo());//GEN-LINE:|7-commandAction|8|27-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|9|70-preAction
        } else if (displayable == Notas) {
            if (command == okCommand1) {//GEN-END:|7-commandAction|9|70-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|10|70-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|11|16-preAction
        } else if (displayable == list) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|11|16-preAction
                // write pre-action user code here
                listAction();//GEN-LINE:|7-commandAction|12|16-postAction
                // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|13|23-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|14|23-postAction
                // write post-action user code here
            } else if (command == itemCommand) {//GEN-LINE:|7-commandAction|15|25-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|16|25-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|17|7-postCommandAction
        }//GEN-END:|7-commandAction|17|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|18|
    //</editor-fold>//GEN-END:|7-commandAction|18|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: list ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initiliazed instance of list component.
     * @return the initialized component instance
     */
    public List getList() {
        if (list == null) {//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
            list = new List("Notas", Choice.IMPLICIT);//GEN-BEGIN:|14-getter|1|14-postInit
            list.append("Ingresar Notas", null);
            list.append("Mostrar notas ingresadas", null);
            list.append("Mostrar Nota de Ciclo", null);
            list.append("Borrar Notas", null);
            list.addCommand(getExitCommand());
            list.addCommand(getItemCommand());
            list.setCommandListener(this);
            list.setSelectedFlags(new boolean[] { false, false, false, false });//GEN-END:|14-getter|1|14-postInit
            // write post-init user code here
        }//GEN-BEGIN:|14-getter|2|
        return list;
    }
    //</editor-fold>//GEN-END:|14-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: listAction ">//GEN-BEGIN:|14-action|0|14-preAction
    /**
     * Performs an action assigned to the selected list element in the list component.
     */
    public void listAction() {//GEN-END:|14-action|0|14-preAction
        // enter pre-action user code here
        String __selectedString = getList().getString(getList().getSelectedIndex());//GEN-BEGIN:|14-action|1|93-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("Ingresar Notas")) {//GEN-END:|14-action|1|93-preAction
                // write pre-action user code here
//GEN-LINE:|14-action|2|93-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Mostrar notas ingresadas")) {//GEN-LINE:|14-action|3|94-preAction
                // write pre-action user code here
//GEN-LINE:|14-action|4|94-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Mostrar Nota de Ciclo")) {//GEN-LINE:|14-action|5|95-preAction
                // write pre-action user code here
//GEN-LINE:|14-action|6|95-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Borrar Notas")) {//GEN-LINE:|14-action|7|96-preAction
                // write pre-action user code here
//GEN-LINE:|14-action|8|96-postAction
                // write post-action user code here
            }//GEN-BEGIN:|14-action|9|14-postAction
        }//GEN-END:|14-action|9|14-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|14-action|10|
    //</editor-fold>//GEN-END:|14-action|10|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: IngresoNotas ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initiliazed instance of IngresoNotas component.
     * @return the initialized component instance
     */
    public Form getIngresoNotas() {
        if (IngresoNotas == null) {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
            IngresoNotas = new Form("form", new Item[] { getStringItem(), getChoiceGroup(), getTextField(), getTextField1(), getTextField2() });//GEN-BEGIN:|18-getter|1|18-postInit
            IngresoNotas.addCommand(getOkCommand());
            IngresoNotas.addCommand(getCancelCommand());
            IngresoNotas.setCommandListener(this);//GEN-END:|18-getter|1|18-postInit
            // write post-init user code here
        }//GEN-BEGIN:|18-getter|2|
        return IngresoNotas;
    }
    //</editor-fold>//GEN-END:|18-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem ">//GEN-BEGIN:|34-getter|0|34-preInit
    /**
     * Returns an initiliazed instance of stringItem component.
     * @return the initialized component instance
     */
    public StringItem getStringItem() {
        if (stringItem == null) {//GEN-END:|34-getter|0|34-preInit
            // write pre-init user code here
            stringItem = new StringItem("Porcentaje ingresado:", null);//GEN-LINE:|34-getter|1|34-postInit
            // write post-init user code here
        }//GEN-BEGIN:|34-getter|2|
        return stringItem;
    }
    //</editor-fold>//GEN-END:|34-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: choiceGroup ">//GEN-BEGIN:|36-getter|0|36-preInit
    /**
     * Returns an initiliazed instance of choiceGroup component.
     * @return the initialized component instance
     */
    public ChoiceGroup getChoiceGroup() {
        if (choiceGroup == null) {//GEN-END:|36-getter|0|36-preInit
            // write pre-init user code here
            choiceGroup = new ChoiceGroup("Tipo de evaluacion", Choice.EXCLUSIVE);//GEN-BEGIN:|36-getter|1|36-postInit
            choiceGroup.append("Laboratorio", null);
            choiceGroup.append("Parcial", null);
            choiceGroup.append("Tarea", null);
            choiceGroup.setSelectedFlags(new boolean[] { false, false, false });//GEN-END:|36-getter|1|36-postInit
            // write post-init user code here
        }//GEN-BEGIN:|36-getter|2|
        return choiceGroup;
    }
    //</editor-fold>//GEN-END:|36-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField ">//GEN-BEGIN:|41-getter|0|41-preInit
    /**
     * Returns an initiliazed instance of textField component.
     * @return the initialized component instance
     */
    public TextField getTextField() {
        if (textField == null) {//GEN-END:|41-getter|0|41-preInit
            // write pre-init user code here
            textField = new TextField("Numero de evaluacion", null, 1, TextField.NUMERIC);//GEN-LINE:|41-getter|1|41-postInit
            // write post-init user code here
        }//GEN-BEGIN:|41-getter|2|
        return textField;
    }
    //</editor-fold>//GEN-END:|41-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField1 ">//GEN-BEGIN:|42-getter|0|42-preInit
    /**
     * Returns an initiliazed instance of textField1 component.
     * @return the initialized component instance
     */
    public TextField getTextField1() {
        if (textField1 == null) {//GEN-END:|42-getter|0|42-preInit
            // write pre-init user code here
            textField1 = new TextField("Porcentaje", null, 2, TextField.NUMERIC);//GEN-LINE:|42-getter|1|42-postInit
            // write post-init user code here
        }//GEN-BEGIN:|42-getter|2|
        return textField1;
    }
    //</editor-fold>//GEN-END:|42-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField2 ">//GEN-BEGIN:|43-getter|0|43-preInit
    /**
     * Returns an initiliazed instance of textField2 component.
     * @return the initialized component instance
     */
    public TextField getTextField2() {
        if (textField2 == null) {//GEN-END:|43-getter|0|43-preInit
            // write pre-init user code here
            textField2 = new TextField("Nota", null, 5, TextField.DECIMAL);//GEN-LINE:|43-getter|1|43-postInit
            // write post-init user code here
        }//GEN-BEGIN:|43-getter|2|
        return textField2;
    }
    //</editor-fold>//GEN-END:|43-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Dialogo ">//GEN-BEGIN:|19-getter|0|19-preInit
    /**
     * Returns an initiliazed instance of Dialogo component.
     * @return the initialized component instance
     */
    public Alert getDialogo() {
        if (Dialogo == null) {//GEN-END:|19-getter|0|19-preInit
            // write pre-init user code here
            Dialogo = new Alert("alert", "<null>", null, null);//GEN-BEGIN:|19-getter|1|19-postInit
            Dialogo.addCommand(getSiCommand());
            Dialogo.addCommand(getNoCommand());
            Dialogo.setCommandListener(this);
            Dialogo.setTimeout(Alert.FOREVER);//GEN-END:|19-getter|1|19-postInit
            // write post-init user code here
        }//GEN-BEGIN:|19-getter|2|
        return Dialogo;
    }
    //</editor-fold>//GEN-END:|19-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Notas ">//GEN-BEGIN:|20-getter|0|20-preInit
    /**
     * Returns an initiliazed instance of Notas component.
     * @return the initialized component instance
     */
    public TextBox getNotas() {
        if (Notas == null) {//GEN-END:|20-getter|0|20-preInit
            // write pre-init user code here
            Notas = new TextBox("textBox", null, 100, TextField.ANY);//GEN-BEGIN:|20-getter|1|20-postInit
            Notas.addCommand(getOkCommand1());
            Notas.setCommandListener(this);//GEN-END:|20-getter|1|20-postInit
            // write post-init user code here
        }//GEN-BEGIN:|20-getter|2|
        return Notas;
    }
    //</editor-fold>//GEN-END:|20-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|22-getter|0|22-preInit
            // write pre-init user code here
            exitCommand = new Command("Salir", Command.EXIT, 0);//GEN-LINE:|22-getter|1|22-postInit
            // write post-init user code here
        }//GEN-BEGIN:|22-getter|2|
        return exitCommand;
    }
    //</editor-fold>//GEN-END:|22-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand ">//GEN-BEGIN:|24-getter|0|24-preInit
    /**
     * Returns an initiliazed instance of itemCommand component.
     * @return the initialized component instance
     */
    public Command getItemCommand() {
        if (itemCommand == null) {//GEN-END:|24-getter|0|24-preInit
            // write pre-init user code here
            itemCommand = new Command("Seleccionar", Command.ITEM, 0);//GEN-LINE:|24-getter|1|24-postInit
            // write post-init user code here
        }//GEN-BEGIN:|24-getter|2|
        return itemCommand;
    }
    //</editor-fold>//GEN-END:|24-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|26-getter|0|26-preInit
    /**
     * Returns an initiliazed instance of okCommand component.
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {//GEN-END:|26-getter|0|26-preInit
            // write pre-init user code here
            okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|26-getter|1|26-postInit
            // write post-init user code here
        }//GEN-BEGIN:|26-getter|2|
        return okCommand;
    }
    //</editor-fold>//GEN-END:|26-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cancelCommand ">//GEN-BEGIN:|28-getter|0|28-preInit
    /**
     * Returns an initiliazed instance of cancelCommand component.
     * @return the initialized component instance
     */
    public Command getCancelCommand() {
        if (cancelCommand == null) {//GEN-END:|28-getter|0|28-preInit
            // write pre-init user code here
            cancelCommand = new Command("Cancel", Command.CANCEL, 0);//GEN-LINE:|28-getter|1|28-postInit
            // write post-init user code here
        }//GEN-BEGIN:|28-getter|2|
        return cancelCommand;
    }
    //</editor-fold>//GEN-END:|28-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: SiCommand ">//GEN-BEGIN:|30-getter|0|30-preInit
    /**
     * Returns an initiliazed instance of SiCommand component.
     * @return the initialized component instance
     */
    public Command getSiCommand() {
        if (SiCommand == null) {//GEN-END:|30-getter|0|30-preInit
            // write pre-init user code here
            SiCommand = new Command("Item", Command.ITEM, 0);//GEN-LINE:|30-getter|1|30-postInit
            // write post-init user code here
        }//GEN-BEGIN:|30-getter|2|
        return SiCommand;
    }
    //</editor-fold>//GEN-END:|30-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: NoCommand ">//GEN-BEGIN:|32-getter|0|32-preInit
    /**
     * Returns an initiliazed instance of NoCommand component.
     * @return the initialized component instance
     */
    public Command getNoCommand() {
        if (NoCommand == null) {//GEN-END:|32-getter|0|32-preInit
            // write pre-init user code here
            NoCommand = new Command("Item", Command.ITEM, 0);//GEN-LINE:|32-getter|1|32-postInit
            // write post-init user code here
        }//GEN-BEGIN:|32-getter|2|
        return NoCommand;
    }
    //</editor-fold>//GEN-END:|32-getter|2|


        // enter pre-switch user code here

        // enter post-switch user code here


    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: NotaDeCiclo ">//GEN-BEGIN:|44-getter|0|44-preInit
    /**
     * Returns an initiliazed instance of NotaDeCiclo component.
     * @return the initialized component instance
     */
    public Alert getNotaDeCiclo() {
        if (NotaDeCiclo == null) {//GEN-END:|44-getter|0|44-preInit
            // write pre-init user code here
            NotaDeCiclo = new Alert("Nota de ciclo");//GEN-BEGIN:|44-getter|1|44-postInit
            NotaDeCiclo.setTimeout(Alert.FOREVER);//GEN-END:|44-getter|1|44-postInit
            // write post-init user code here
        }//GEN-BEGIN:|44-getter|2|
        return NotaDeCiclo;
    }
    //</editor-fold>//GEN-END:|44-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchOpciones ">//GEN-BEGIN:|71-switch|0|71-preSwitch
    /**
     * Performs an action assigned to the switchOpciones switch-point.
     */
    public void switchOpciones() {//GEN-END:|71-switch|0|71-preSwitch
        int opcion = list.getSelectedIndex() + 1;
        switch (opcion) {//GEN-BEGIN:|71-switch|1|72-preAction
            case 1://GEN-END:|71-switch|1|72-preAction
                // write pre-action user code here
                switchDisplayable(null, getIngresoNotas());//GEN-LINE:|71-switch|2|72-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|71-switch|3|73-preAction
            case 2://GEN-END:|71-switch|3|73-preAction
                // write pre-action user code here
                switchDisplayable(null, getNotas());//GEN-LINE:|71-switch|4|73-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|71-switch|5|74-preAction
            case 3://GEN-END:|71-switch|5|74-preAction
                // write pre-action user code here
                switchDisplayable(null, getNotaDeCiclo());//GEN-LINE:|71-switch|6|74-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|71-switch|7|76-preAction
            case 4://GEN-END:|71-switch|7|76-preAction
                // write pre-action user code here
                switchDisplayable(null, getBorrarNotas());//GEN-LINE:|71-switch|8|76-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|71-switch|9|71-postSwitch
        }//GEN-END:|71-switch|9|71-postSwitch
        // enter post-switch user code here
    }//GEN-BEGIN:|71-switch|10|
    //</editor-fold>//GEN-END:|71-switch|10|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: BorrarNotas ">//GEN-BEGIN:|75-getter|0|75-preInit
    /**
     * Returns an initiliazed instance of BorrarNotas component.
     * @return the initialized component instance
     */
    public Alert getBorrarNotas() {
        if (BorrarNotas == null) {//GEN-END:|75-getter|0|75-preInit
            // write pre-init user code here
            BorrarNotas = new Alert("alert2");//GEN-BEGIN:|75-getter|1|75-postInit
            BorrarNotas.setTimeout(Alert.FOREVER);//GEN-END:|75-getter|1|75-postInit
            // write post-init user code here
        }//GEN-BEGIN:|75-getter|2|
        return BorrarNotas;
    }
    //</editor-fold>//GEN-END:|75-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand1 ">//GEN-BEGIN:|69-getter|0|69-preInit
    /**
     * Returns an initiliazed instance of okCommand1 component.
     * @return the initialized component instance
     */
    public Command getOkCommand1() {
        if (okCommand1 == null) {//GEN-END:|69-getter|0|69-preInit
            // write pre-init user code here
            okCommand1 = new Command("Ok", Command.OK, 0);//GEN-LINE:|69-getter|1|69-postInit
            // write post-init user code here
        }//GEN-BEGIN:|69-getter|2|
        return okCommand1;
    }
    //</editor-fold>//GEN-END:|69-getter|2|

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay () {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable (null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet ();
        } else {
            initialize ();
            startMIDlet ();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

}
