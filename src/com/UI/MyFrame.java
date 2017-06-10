package com.UI;

import com.timer.Listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created @2017/6/10 15:47
 */
public class MyFrame {

    public void show() {

        JFrame jFrame = new JFrame("Timer");
        jFrame.setSize(800, 600);
        JTextField jTextField = new JTextField();
        JButton start = new JButton("start");

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int num = Integer.parseInt(jTextField.getText());

                com.timer.Timer timer = new com.timer.Timer();
                timer.addListener(new Listener() {
                    @Override
                    public void onTick(int left) {
                        jTextField.setText(String.valueOf(left));
                    }

                    @Override
                    public void onComplete() {
                        jTextField.setText("complete");
                    }
                });

                timer.timerAsync(num);
            }
        });

        jFrame.add(jTextField, BorderLayout.NORTH);
        jFrame.add(start, BorderLayout.SOUTH);
        jFrame.setVisible(true);
    }

}
