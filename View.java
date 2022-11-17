/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import codeFiles.Compress;
import codeFiles.Decompress;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Girish Doshi
 */
public class View extends JFrame implements ActionListener{
    
    JButton compressButton;
    JButton decompressButton;
    
    View(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit from the application
        this.setLayout(null); // we can keep button where ever we want 
        this.setSize(500,200);
        compressButton = new JButton("select file to compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(20, 100, 200, 30);
        
        decompressButton = new JButton("select file to decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250, 100, 200, 30);
        this.add(compressButton);
        this.add(decompressButton);
        this.getContentPane().setBackground(Color.PINK);
        
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    Compress.method(file);
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null,excp.toString());
                }
                
            }
        }
        if(e.getSource() == decompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    Decompress.method(file);
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null,excp.toString());
                }
                
            }
        }
    }
    
    public static void main(String[] args){
        View view = new View();
        view.setVisible(true);  //make jframe visible
    }
}
