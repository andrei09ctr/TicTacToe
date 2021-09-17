package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe extends JFrame implements ActionListener {

    public boolean player1Turn = true, player2Turn = false, CpuTurn = false;
    JFrame frame;
    JLabel label, labelCPU, label1stPlayer, label2ndPlayer, text;
    JButton buttonPvP, buttonPvCPU, restartButton;
    JButton[] buttons;
    ImageIcon image, image1stPlayer, image2ndPlayer, imageCPU;

    public TicTacToe() {

        frame = new JFrame("TicTacToe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1500, 800));
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(10, 96, 75));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        imageCPU = new ImageIcon("computerImage.png");
        image1stPlayer =  new ImageIcon("image1.png");
        image2ndPlayer = new ImageIcon("image2.png");
        image = new ImageIcon("images3.png");

        label = new JLabel();
        label.setIcon(image);
        label.setLayout(null);
        label.setBounds(370, 170, 130, 100);
        label.setVisible(true);

        label2ndPlayer = new JLabel();
        label2ndPlayer.setIcon(image2ndPlayer);
        label2ndPlayer.setLayout(null);
        label2ndPlayer.setBounds(910, 170, 130, 100);
        label2ndPlayer.setVisible(true);

        label1stPlayer = new JLabel();
        label1stPlayer.setIcon(image1stPlayer);
        label1stPlayer.setLayout(null);
        label1stPlayer.setBounds(370, 280, 130, 100);
        label1stPlayer.setVisible(true);

        labelCPU = new JLabel();
        labelCPU.setIcon(imageCPU);
        labelCPU.setLayout(null);
        labelCPU.setBounds(910, 280, 130, 100);
        labelCPU.setVisible(true);

        text = new JLabel("TicTacToe");
        text.setLayout(null);
        text.setBounds(600, 50, 600, 60);
        text.setFont(new Font("", Font.BOLD, 40));

        buttonPvP = new JButton("Player vs Player");
        buttonPvP.setFocusable(false);
        buttonPvP.setBounds(500, 200, 400, 40);
        buttonPvP.addActionListener(this);

        buttonPvCPU = new JButton("Player vs Computer");
        buttonPvCPU.setFocusable(false);
        buttonPvCPU.setBounds(500, 300, 400, 40);
        buttonPvCPU.addActionListener(this);

        restartButton = new JButton("Restart Game");
        restartButton.setFocusable(false);
        restartButton.setBounds(450, 50, 600, 60);
        restartButton.addActionListener(this);

        frame.add(text);
        frame.add(label);
        frame.add(label2ndPlayer);
        frame.add(label1stPlayer);
        frame.add(labelCPU);
        frame.add(buttonPvCPU);
        frame.add(buttonPvP);
        frame.setVisible(true);
    }

    public void setBoard() {
        buttons = new JButton[9];
        int x = 300, y = 185;
        for (int i = 0; i < 9; ++i) {
            buttons[i] = new JButton();
            frame.add(buttons[i]);
            buttons[i].setFocusable(false);
            buttons[i].setBounds(x, y, 300, 185);
            buttons[i].setFont(new Font("MV Boil",Font.BOLD,110));
            buttons[i].addActionListener(this);
            buttons[i].setVisible(true);
            x += 300;
            if (x == 1200) {
                x = 300;
                y += 185;
            }
        }
        frame.remove(buttonPvP);
        frame.remove(buttonPvCPU);
        frame.repaint();
    }


    public void setWinner(int a, int b, int c) {
        buttons[a].setBackground(Color.RED);
        buttons[b].setBackground(Color.YELLOW);
        buttons[c].setBackground(Color.BLUE);

        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }

        frame.remove(text);
        frame.add(restartButton);
        frame.repaint();
    }

    public void checkWinner() {
        if (!buttons[0].getText().equals("") && buttons[1].getText().equals(buttons[0].getText())
                && buttons[2].getText().equals(buttons[1].getText())) {
            setWinner(0, 1, 2);
        } else if (!buttons[3].getText().equals("") && buttons[3].getText().equals(buttons[4].getText())
                && buttons[4].getText().equals(buttons[5].getText())) {
            setWinner(3, 4, 5);
        } else if (!buttons[6].getText().equals("") && buttons[6].getText().equals(buttons[7].getText())
                && buttons[7].getText().equals(buttons[8].getText())) {
            setWinner(6, 7, 8);
        } else if (!buttons[0].getText().equals("") && buttons[0].getText().equals(buttons[3].getText())
                && buttons[3].getText().equals(buttons[6].getText())) {
            setWinner(0, 3, 6);
        } else if (!buttons[1].getText().equals("") && buttons[1].getText().equals(buttons[4].getText())
                && buttons[4].getText().equals(buttons[7].getText())) {
            setWinner(1, 4, 7);
        } else if (!buttons[2].getText().equals("") && buttons[2].getText().equals(buttons[5].getText())
                && buttons[5].getText().equals(buttons[8].getText())) {
            setWinner(2, 5, 8);
        } else if (!buttons[0].getText().equals("") && buttons[0].getText().equals(buttons[4].getText())
                && buttons[4].getText().equals(buttons[8].getText())) {
            setWinner(0, 4, 8);
        } else if (!buttons[2].getText().equals("") && buttons[2].getText().equals(buttons[4].getText())
                && buttons[4].getText().equals(buttons[6].getText())) {
            setWinner(2, 4, 6);
        }
    }

    public int getCPUmove() {
        Random random = new Random();
        int randomNr = random.nextInt(9);
        while(!buttons[randomNr].getText().equals("")) {
            randomNr = random.nextInt(9);
        }
        return randomNr;
    }

    public void restartGame() {

        frame.getContentPane().removeAll();
        frame.add(text);
        frame.add(label);
        frame.add(label2ndPlayer);
        frame.add(label1stPlayer);
        frame.add(labelCPU);
        frame.add(buttonPvCPU);
        frame.add(buttonPvP);

        labelCPU.setBounds(910, 280, 130, 100);
        label1stPlayer.setBounds(370, 280, 130, 100);
        label2ndPlayer.setBounds(910, 170, 130, 100);
        label.setBounds(370, 170, 130, 100);

        player1Turn = true;
        player2Turn = false;
        CpuTurn = false;

        frame.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonPvP) {
            setBoard();
            frame.remove(label1stPlayer);
            frame.remove(labelCPU);
            label2ndPlayer.setBounds(1300, 400, 100, 100);
            label.setBounds(100, 400, 100, 100);
        } else if (e.getSource() == buttonPvCPU) {
            setBoard();
            CpuTurn = true;
            frame.remove(label2ndPlayer);
            frame.remove(label);
            labelCPU.setBounds(1300, 400, 100, 100);
            label1stPlayer.setBounds(100, 400, 100, 100);
        } else if (e.getSource() == restartButton) {
            restartGame();
        }

        for (int i = 0; i < 9; i++) {
            if (CpuTurn) {
                if (e.getSource() == buttons[i] && buttons[i].getText().equals("")) {
                    buttons[i].setText("X");
                    buttons[getCPUmove()].setText("O");
                    checkWinner();
                }
            } else {
                if (e.getSource() == buttons[i] && buttons[i].getText().equals("") && player1Turn) {
                    buttons[i].setText("X");
                    player1Turn = false;
                    player2Turn = true;
                    checkWinner();
                } else if (e.getSource() == buttons[i] && buttons[i].getText().equals("") && player2Turn) {
                    buttons[i].setText("O");
                    player1Turn = true;
                    player2Turn = false;
                    checkWinner();
                }
            }
        }
    }
}
