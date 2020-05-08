package kenn.shi;

import javax.swing.*;

public class MainFrame extends JFrame {
    protected Welcome welcome;
    protected Menu menu;
    protected Add add;
    protected Results results;
    protected Exit exit;

    public MainFrame() {

        setSize(500, 500);
        setTitle("WORK SEARCHING APPLICATION");
        setLayout(null);

        welcome = new Welcome();
        welcome.setVisible(true);
        add(welcome);

        menu = new Menu();
        menu.setVisible(false);
        add(menu);

        add = new Add();
        add.setVisible(false);
        add(add);

        results = new Results();
        results.setVisible(false);
        add(results);

        exit = new Exit();
        exit.setVisible(false);
        add(exit);


    }

    public void showWelcome(){
        menu.setVisible(false);
        add.setVisible(false);
        exit.setVisible(false);
        results.setVisible(false);
        welcome.setVisible(true);
    }

    public void showAddStudent () {
        menu.setVisible(false);
        results.setVisible(false);
        exit.setVisible(false);
        welcome.setVisible(false);
        add.setVisible(true);
    }

    public void showListStudents(){
        menu.setVisible(false);
        exit.setVisible(false);
        add.setVisible(false);
        welcome.setVisible(false);
        results.setVisible(true);
    }

    public void showMenu(){
        exit.setVisible(false);
        add.setVisible(false);
        results.setVisible(false);
        welcome.setVisible(false);
        menu.setVisible(true);
    }

    public void showExit(){
        System.exit(0);
    }


}
