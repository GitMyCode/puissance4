package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Enumeration;

/**
 * Created by desk on 2/27/14.
 */
public class ConfigurationView extends JFrame{

    /*
    *   Les actions commande pour que le controller sacher
    *   quel radio button est choisi
    *   Humain doit etre 0
    *   AI doit etre 1
    * */
    final String action_AI = "1";
    final String action_HUMAN = "0";
    final String action_PLAYER1 = "1";
    final String action_PLAYER2 = "2";
    final String action_COULISSE= "COULISSE";
    final String action_EXACT = "EXACT";



    private int player1Type;
    private int player2Type;

    private int FirstTurn;

    private int rows;
    private int cols;

    private int placementType;


    JLabel player1;
    JLabel player2;

    JRadioButton p1Ai;
    JRadioButton p1Human;
    JRadioButton p2Ai;
    JRadioButton p2Human;

    JRadioButton p1Turn;
    JRadioButton p2Turn;

    JRadioButton coulisse;
    JRadioButton exact;

    JTextField row;
    JTextField col;

    ButtonGroup groupP1type;
    ButtonGroup groupP2type;
    ButtonGroup groupTurn;
    ButtonGroup groupPlacement;

    JPanel configurationPanel;



    JButton ok;
    JButton cancel;

    public ConfigurationView(){
        super("Configurer");
        setSize(300,300);
        configurationPanel = new JPanel();

        /*
        *   Creation des JButton JLabel Et ButtonGroup
        */
        player1 = new JLabel("player1");
        player2 = new JLabel("player2");
        JLabel lrow = new JLabel("row :");
        JLabel lcol = new JLabel("column :");

        p1Ai = new JRadioButton("Ai");
        p1Human = new JRadioButton("Human");

        p2Ai = new JRadioButton("Ai");
        p2Human = new JRadioButton("Human");

        p1Turn = new JRadioButton("Player 1");
        p2Turn = new JRadioButton("Player 2");

       row = new JTextField(10);
        col = new JTextField(10);

        groupP1type = new ButtonGroup();
        groupP2type = new ButtonGroup();
        groupTurn = new ButtonGroup();
        groupPlacement = new ButtonGroup();

        JLabel lplacementType = new JLabel("Type placement:");
        coulisse = new JRadioButton("Coulisse");
        exact = new JRadioButton("Exact");


        ok = new JButton("Ok");
        cancel = new JButton("Cancel");

        /*
        *   Lisaison des ButtonGroup avec les Button
        * */
        groupP1type.add(p1Ai);groupP1type.add(p1Human);
        groupP2type.add(p2Ai);groupP2type.add(p2Human);
        groupTurn.add(p1Turn);groupTurn.add(p2Turn);
        groupPlacement.add(coulisse);groupPlacement.add(exact);


        setActionCommande();

        /*
        *  Placement des component dans le JPanel
        * */
        configurationPanel.setLayout(new GridBagLayout());

        addItem(configurationPanel,player1,0,0,1,1,GridBagConstraints.EAST);
        addItem(configurationPanel,player2,0,1,1,1,GridBagConstraints.EAST);
        addItem(configurationPanel,p1Ai,1,0,1,1,GridBagConstraints.WEST);
        addItem(configurationPanel,p1Human,2,0,1,1,GridBagConstraints.WEST);
        addItem(configurationPanel,p2Ai,1,1,1,1,GridBagConstraints.WEST);
        addItem(configurationPanel,p2Human,2,1,1,1,GridBagConstraints.WEST);


        addItem(configurationPanel,new JLabel("Start first?"),0,3,1,1,GridBagConstraints.EAST);
        addItem(configurationPanel,p1Turn,1,3,1,1,GridBagConstraints.WEST);
        addItem(configurationPanel,p2Turn,2,3,1,1,GridBagConstraints.WEST);



        addItem(configurationPanel,lrow,0,4,1,1,GridBagConstraints.WEST);
        addItem(configurationPanel,row,1,4,2,1,GridBagConstraints.WEST);
        addItem(configurationPanel,lcol,0,5,1,1,GridBagConstraints.WEST);
        addItem(configurationPanel,col,1,5,2,1,GridBagConstraints.WEST);



        addItem(configurationPanel,lplacementType,0,6,1,1,GridBagConstraints.EAST);
        addItem(configurationPanel,coulisse,1,6,1,1,GridBagConstraints.WEST);
        addItem(configurationPanel,exact,2,6,1,1,GridBagConstraints.WEST);


        addItem(configurationPanel,ok,0,7,1,1,GridBagConstraints.WEST);
        addItem(configurationPanel,cancel,1,7,1,1,GridBagConstraints.EAST);


        add(configurationPanel);


        //setVisible(true);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void setActionCommande(){

        p1Ai.setActionCommand(action_AI);
        p1Human.setActionCommand(action_HUMAN);
        p2Ai.setActionCommand(action_AI);
        p2Human.setActionCommand(action_HUMAN);

        coulisse.setActionCommand(action_COULISSE);
        exact.setActionCommand(action_EXACT);

        p1Turn.setActionCommand("1");
        p2Turn.setActionCommand("2");
    }


    private void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align) {
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = x;
        gc.gridy = y;
        gc.gridwidth = width;
        gc.gridheight = height;
        gc.weightx = 100.0;
        gc.weighty = 100.0;
        gc.insets = new Insets(5, 5, 5, 5);
        gc.anchor = align;
        gc.fill = GridBagConstraints.NONE;
        p.add(c, gc);
    }

    /*
    * Prend un buttonGroup et retourn le ACTION_COMMANDE du RadioButton
    * Selectionner
    * */
    public String getSlectedButton(ButtonGroup buttonGroup){
        for(Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();){
            AbstractButton button = buttons.nextElement();
            if(button.isSelected()){
                return button.getActionCommand();
            }
        }
        return null;
    }

    public void addController(ActionListener actionListener){
        ok.addActionListener(actionListener);
        cancel.addActionListener(actionListener);

    }



    /*************************************
    * Getter setter
    **************************************/

    public JLabel getPlayer1() {
        return player1;
    }

    public void setPlayer1(JLabel player1) {
        this.player1 = player1;
    }

    public JLabel getPlayer2() {
        return player2;
    }

    public void setPlayer2(JLabel player2) {
        this.player2 = player2;
    }

    public JRadioButton getP1Ai() {
        return p1Ai;
    }

    public void setP1Ai(JRadioButton p1Ai) {
        this.p1Ai = p1Ai;
    }

    public JRadioButton getP1Human() {
        return p1Human;
    }

    public void setP1Human(JRadioButton p1Human) {
        this.p1Human = p1Human;
    }

    public JRadioButton getP2Ai() {
        return p2Ai;
    }

    public void setP2Ai(JRadioButton p2Ai) {
        this.p2Ai = p2Ai;
    }

    public JRadioButton getP2Human() {
        return p2Human;
    }

    public void setP2Human(JRadioButton p2Human) {
        this.p2Human = p2Human;
    }

    public JRadioButton getP1Turn() {
        return p1Turn;
    }

    public void setP1Turn(JRadioButton p1Turn) {
        this.p1Turn = p1Turn;
    }

    public JRadioButton getP2Turn() {
        return p2Turn;
    }

    public void setP2Turn(JRadioButton p2Turn) {
        this.p2Turn = p2Turn;
    }

    public ButtonGroup getGroupP1type() {
        return groupP1type;
    }

    public void setGroupP1type(ButtonGroup groupP1type) {
        this.groupP1type = groupP1type;
    }

    public ButtonGroup getGroupTurn() {
        return groupTurn;
    }

    public void setGroupTurn(ButtonGroup groupTurn) {
        this.groupTurn = groupTurn;
    }

    public ButtonGroup getGroupPlacement() {
        return groupPlacement;
    }

    public void setGroupPlacement(ButtonGroup groupPlacement) {
        this.groupPlacement = groupPlacement;
    }

    public JPanel getConfigurationPanel() {
        return configurationPanel;
    }

    public void setConfigurationPanel(JPanel configurationPanel) {
        this.configurationPanel = configurationPanel;
    }

    public JRadioButton getExact() {
        return exact;
    }

    public void setExact(JRadioButton exact) {
        this.exact = exact;
    }

    public JRadioButton getCoulisse() {
        return coulisse;
    }

    public void setCoulisse(JRadioButton coulisse) {
        this.coulisse = coulisse;
    }

    public ButtonGroup getGroupP2type() {
        return groupP2type;
    }

    public void setGroupP2type(ButtonGroup groupP2type) {
        this.groupP2type = groupP2type;
    }

    public JTextField getRow() {
        return row;
    }

    public void setRow(JTextField row) {
        this.row = row;
    }

    public JTextField getCol() {
        return col;
    }

    public void setCol(JTextField col) {
        this.col = col;
    }
}
