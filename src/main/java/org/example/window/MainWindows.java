package org.example.window;

import cn.hutool.core.util.StrUtil;
import org.example.entity.CountMemory;
import org.example.park.ConuntMemoryAWT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @program: JFramer-demo
 * @description:
 * @author: tmz
 * @create: 2021-02-02 16:03
 */
public class MainWindows {
    private static final ConuntMemoryAWT util = new ConuntMemoryAWT();
    public static void main(String[] args) throws Exception{
        init();
    }
    private static void init() throws Exception{
        CountMemory countMemory = util.create();
        final String temp = "COUNT：{}";
        JFrame frame = new JFrame("计数器");
        Dimension dimension = new Dimension(350,200);
        frame.setSize(dimension);
        frame.setDefaultCloseOperation(3);
        JPanel panel = new JPanel();
        final JLabel userLabel = new JLabel(StrUtil.format(temp,countMemory.getCountNum()));
        frame.add(panel);
        panel.setLayout(null);
        final JButton loginButton = new JButton("INCREASE");
        loginButton.setBounds(100, 80, 120, 25);
        loginButton.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Long increatment = util.increatment();
                    userLabel.setText(StrUtil.format(temp,increatment));
                }catch (Exception t){
                    t.printStackTrace();
                }
            }
        });
        loginButton.setText("INCREASE");
        final JButton clear = new JButton("CLEAR");
        clear.setBounds(100, 120, 120, 25);
        clear.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    util.clear();
                    userLabel.setText(StrUtil.format(temp,0));
                }catch (Exception t){
                    t.printStackTrace();
                }
            }
        });
        clear.setText("CLEAR");
        panel.add(loginButton);
        userLabel.setBounds(120,20,80,25);
        panel.add(userLabel);
        panel.add(clear);
        frame.setVisible(true);
    }
}
