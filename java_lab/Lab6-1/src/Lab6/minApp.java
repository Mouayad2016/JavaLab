package Lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Calendar;

public class minApp {
    public JPanel lab6MainPanel;
    private JTextField tfFirst;
    private JTextField tfLast;
    private JTextField tfTermin;
    private JTextField tfUsername;
    private JTextField tfEpost;
    private JTextArea textArea1;
    private JButton btnSpara;
    private JButton btnSotera;
    private JButton btnsok;
    private JButton btnUppdatera;
    private JButton btnTabort;
    private JButton btnBack;
    private JButton btnForward;
    private JButton btnVisa;

    private Student[] array = new Student[20];
    private int hållare = 0;
    private int idx = 0;
    private int sidaIdx = 0;
    private int bladdra = 0;


    public minApp() {
        btnSpara.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (hållare == 20) {
                    JOptionPane.showMessageDialog(null, "Array är fullt");
                } else {

                    String firstName = tfFirst.getText();
                    String lastNmae = tfLast.getText();
                    String termin = tfTermin.getText() + Calendar.getInstance().get(Calendar.YEAR);
                    tfTermin.setText(termin);
                    String userName = termin.substring(0, 1) + termin.substring(Math.max(termin.length() - 2, 0)) + firstName.substring(0, 3) + lastNmae.substring(0, 2);
                    tfUsername.setText(userName);
                    String email = userName + "@du.se";
                    tfEpost.setText(email);
                    Student nyarray = new Student(firstName, lastNmae, termin, userName, email);
                    array[hållare] = nyarray;
                    hållare++;
                }
                tfTermin.setText("");
                tfLast.setText("");
                tfFirst.setText("");
            }
        });
        btnTabort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String fornamn = tfFirst.getText();
                for (int i = 0; i < array.length; i++) {
                    if (array[i] != null) {
                        if (array[i].getFirstname().equalsIgnoreCase(fornamn)) {
                            array[i] = array[hållare - 1];
                            array[hållare - 1] = null;
                            hållare--;
                            textArea1.setText("Du nu har tagit bort " + fornamn);
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Det du söker vinns inte i array");
                            break;
                        }
                    }

                }

            }

        });
        btnVisa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");

                for (int i = 0; i < hållare; i++) {

                    Student nyarray = array[i];
                    textArea1.setText(textArea1.getText() + "\n" + " First name: " +
                            nyarray.getFirstname() + " Last name: " + nyarray.getLastname()
                            + " Termin :" + nyarray.getTermin() + " Username :" + nyarray.getUsernmae() + " Email :" + nyarray.getEamil());
                }
            }
        });
        btnUppdatera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fornamn = tfFirst.getText();
                String efternamn = tfLast.getText();
                String termin = tfTermin.getText();
                String email = tfEpost.getText();
                String username = tfUsername.getText().trim();

                if (tfFirst.getText().equals("") || tfLast.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, " Du måste skriva förnamn och efternamn");
                }
                for (Student student : array) {
                    if (student != null && student.getFirstname().equalsIgnoreCase(fornamn) && student.getLastname().equalsIgnoreCase(efternamn)) {
                        student.setUsernmae(tfUsername.getText());
                        student.setEamil(tfEpost.getText());
                        student.setTermin(tfTermin.getText());

                    }

                }
                tfFirst.setText("");
                tfLast.setText("");


            }
        });
        btnsok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(null);
                String fornamn = tfFirst.getText();

                for (Student student : array) {
                    if (student != null && student.getFirstname().equalsIgnoreCase(fornamn)) {
                        textArea1.append(student.getFirstname() + " " + student.getLastname()
                                + " " + student.getTermin() + " " + student.getUsernmae() + " " + student.getEamil() + "\n");
                    }

                }


            }
        });
        btnSotera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Arrays.sort(array, new Sort());
                for (Student student : array) {
                    if (student != null) {
                        textArea1.append(" \n" + student.getLastname() + " " + student.getFirstname() + " " + student.getTermin() + " " + student.getUsernmae() + " " + student.getEamil() + "\n");
                    }
                }

            }
        });
        btnForward.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                for (int i = 0; i < array.length; i++) {
                    if (array[i] != null) {
                        idx = i;
                    }
                }
                if (bladdra < idx + 1) {
                    bladdra++;
                }

                if (bladdra > idx) {
                    bladdra = 0;
                }
                textArea1.setText(array[bladdra].getFirstname() + " "
                        + array[bladdra].getUsernmae() + " " + array[bladdra].getEamil() + " bläddra " + bladdra);


            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean firstPageTurn = false;
                if (bladdra == 0) {
                    bladdra = idx - 1;
                    sidaIdx = idx;
                } else {
                    bladdra--;
                    sidaIdx = sidaIdx + 1;
                }

                textArea1.setText(array[bladdra].getFirstname() + " " + array[bladdra].getUsernmae()
                        + " " + array[bladdra].getEamil() + " bläddra " + bladdra);

                if (firstPageTurn) {
                    firstPageTurn = false;
                }
            }

        });
    }
}




