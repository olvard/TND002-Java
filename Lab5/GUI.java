import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener {


    private JButton load, save, search, next, add, delete;
    private JTextField searchField, nameField, numberField;
    private JLabel theLabel;
    private JPanel panel1,panel2;
    PhoneBook test;
    ArrayList<Person> find;
    int count = 0;


    public GUI() {

        test = new PhoneBook();

        setTitle("Interactive phone book");

        Font theFont = new Font("SansSerif", Font.PLAIN, 20);

        load = new JButton("Load phonebook"); load.setFont(theFont);
        load.addActionListener(this);
        save = new JButton("Save phonebook"); save.setFont(theFont);
        save.addActionListener(this);
        search = new JButton("Search"); search.setFont(theFont);
        search.addActionListener(this);
        next = new JButton("Next name"); next.setFont(theFont);
        next.addActionListener(this);
        delete = new JButton("Delete person"); delete.setFont(theFont);
        delete.addActionListener(this);
        add = new JButton("Add person"); add.setFont(theFont);
        add.addActionListener(this);

        load.setEnabled(true);
        save.setEnabled(false);
        search.setEnabled(false);
        next.setEnabled(false);
        delete.setEnabled(false);
        add.setEnabled(false);

        panel1 = new JPanel(new GridLayout(3,2));
        panel1.add(load);
        panel1.add(save);
        panel1.add(add);
        panel1.add(search);
        panel1.add(next);
        panel1.add(delete);

        theLabel = new JLabel(); theLabel.setFont(theFont);

        searchField = new JTextField(); searchField.setFont(theFont);
        searchField.addActionListener(this);

        nameField = new JTextField(); nameField.setFont(theFont);
        numberField = new JTextField(); numberField.setFont(theFont);

        nameField.setEnabled(false);
        numberField.setEnabled(false);

        panel2 = new JPanel(new GridLayout(3,1));
        panel2.add(searchField);
        panel2.add(nameField);
        panel2.add(numberField);

        Container c = getContentPane();
        c.setBackground(Color.WHITE);
        c.setLayout(new GridLayout(1,2));
        c.add(panel1);
        c.add(panel2);


        setVisible(true); setSize(800,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {

        int counter = 0;
        String extract = searchField.getText();


        try {

            if (e.getSource() == searchField || e.getSource() == load) {
                String filename = searchField.getText();
                searchField.setText("");

                test.load(filename);
                nameField.setText("Phone book loaded");
                numberField.setText("");

                save.setEnabled(true);
                search.setEnabled(true);
                next.setEnabled(false);
                delete.setEnabled(true);
                add.setEnabled(true);

            }

        } catch (IOException f) {
            nameField.setText("Try again");
        }

        if (e.getSource() == save) {
            String filename = searchField.getText();
            if(filename.length() == 0){
                nameField.setText("Provide a file name");
            }
            searchField.setText("");
            try {
                nameField.setText(test.save(filename));
            } catch (IOException ioException)
            {
                ioException.printStackTrace();
            }


        }

        if(e.getSource() == search){

            searchField.setText("");

            find = test.search(extract);

            if(find.size() == 0){
                nameField.setText("Provide a name");
                numberField.setText("");
            }

            if(find.size() == 1){

                nameField.setText(find.get(0).getFullName());
                String numb = String.valueOf(find.get(0).getPhoneNumber());
                numberField.setText(numb);


            }

            if(find.size() > 1){

                next.setEnabled(true);

                nameField.setText(find.get(counter).getFullName());
                String numb1 = String.valueOf(find.get(counter).getPhoneNumber());
                numberField.setText(numb1);

            }

        }

        if(e.getSource() == next){

            counter++;
            nameField.setText(find.get(counter).getFullName());
            String numb2 = String.valueOf(find.get(counter).getPhoneNumber());
            numberField.setText(numb2);

            if(counter + 1 == find.size()) {
                next.setEnabled(false);
            }

        }

        if(e.getSource() == delete){

            /*nameField.setEnabled(true);
            numberField.setEnabled(true);*/

            String inName = nameField.getText();
            int inNum = Integer.parseInt(numberField.getText());

            searchField.setText(test.deletePerson(inNum,inName));


        }

        if(e.getSource() == add){

            if(count == 0) {
                nameField.setText("");
                searchField.setText("Type in name and phone number");

                nameField.setEnabled(true);
                numberField.setEnabled(true);
                count++;
            }
            else{
                try {

                    String newName = nameField.getText();
                    int newNum = Integer.parseInt(numberField.getText());
                    test.addPerson(newName, newNum);
                    searchField.setText("Person added.");

                    nameField.setText("");
                    numberField.setText("");
                    nameField.setEnabled(false);
                    numberField.setEnabled(false);

                }
                catch(NumberFormatException ierr){
                    System.out.println("åh nej");
                }
            }

        }


    }

}
