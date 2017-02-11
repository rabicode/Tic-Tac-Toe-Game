/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
/**
 *
 * @author User
 */
public class TicTacToeFrame extends JFrame{
     //indicate who play
    private char whoseTurn = 'X';
    private boolean gameover = false;
    
    private Cell[][] cell = new Cell[3][3];
    JLabel jlabel = new JLabel("X's turn to play");

   public TicTacToeFrame() {
     //panel to hold cell
        JPanel panel = new JPanel(new GridLayout(3,3,0,0));
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
               panel.add(cell[i][j] = new Cell());
        panel.setBorder(new LineBorder(Color.red,1));
        panel.setBorder(new LineBorder(Color.yellow, 1));
        add(panel,BorderLayout.CENTER);
        add(jlabel,BorderLayout.SOUTH);
        }
   
   public boolean isFull(){
   for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
               if(cell[i][j].getToken() == ' ')
                 return false;
        return true;
   }
    public boolean isWin(char token){
    for(int i=0;i<3;i++)
        if((cell[i][0].getToken() == token) 
                && (cell[i][1].getToken() == token) 
                && (cell[i][2].getToken() == token))
                 {
        return true;
    }
      for(int j=0;j<3;j++)
        if((cell[0][j].getToken() == token) 
                && (cell[1][j].getToken() == token) 
                && (cell[2][j].getToken() == token))
                 {
        return true;
    }
       if((cell[0][0].getToken() == token) 
                && (cell[1][1].getToken() == token) 
                && (cell[2][2].getToken() == token)) 
       {
           return true;
       }
       if((cell[0][2].getToken() == token) 
                && (cell[1][1].getToken() == token) 
                && (cell[2][0].getToken() == token)) 
    
    {
        return true;
    }
        return false;
       
    }
//class Cell
  public class Cell extends JPanel{
    private char token = ' ';
    
    public Cell(){
        setBorder(new LineBorder(Color.black, 1));
        addMouseListener(new MyMouseListener());
      //  addActionListener(new MyActionListener());
        
    }
    
    public char getToken()
    {
    return token;
    }
    public void setToken(char c){
    token = c;
    repaint();
    }
    @Override
    protected void paintComponent(Graphics g){
    super.paintComponent(g);
    if(token == 'X'){
        g.drawLine(10, 10,getWidth()-10,getHeight()-10);
        g.drawLine(getWidth()-10, 10, 10, getHeight()-10);
    }
    else if(token == 'O')
    {
    g.drawOval(10, 10,getWidth()-10, getHeight()-10);
    }
    }

       
    //mouse event
    private class MyMouseListener extends MouseAdapter
            
    {

        private char whoseTurn;
  @Override
  public void mouseClicked(MouseEvent e){
      
      if (gameover)
          return;
      if(token != ' ' || whoseTurn != ' ') {
       setToken(whoseTurn);
       //checking game status
       if(isWin(whoseTurn)){
       jlabel.setText(whoseTurn + "win ! Game Over");
       whoseTurn = ' ';
       gameover = true;
       }
       else if(isFull())
       {
           jlabel.setText("Draw ! Game Over");
          whoseTurn = ' ';
          gameover = true;
      }
       else 
       {
       whoseTurn = (whoseTurn == 'X') ? 'O' :'X';
       jlabel.setText(whoseTurn + ";s turn.");
       
       }
        }
  } 
   
    

       
     }
  //Turn for computer.
    }
  }


    

    

