import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOfLifeGui {
    static int count = 0;
    static boolean[] test = new boolean[1];

    public static void helper(){
        count ++;

        if (count %2!= 0 ){
            test[0] = false;
        }else{
            test[0] = true;
        }
    }

    public static void GraphicalInterface(int [][] array, Graphics graphics){
        int BOX_DIM = 10;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                if (array[i][j] == 0){
                    graphics.setColor(Color.WHITE);
                }
                if (array[i][j] == 1){
                    graphics.setColor(Color.BLACK);
                }
                graphics.fillRect(i * BOX_DIM, j* BOX_DIM,BOX_DIM,BOX_DIM);
            }
        }
    }

    public static void printingOut(int[][] array)  throws InterruptedException {
        test[0] = true;

        JFrame frame = new JFrame("Conway's Game of Life");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(485, 410));
        JButton button = new JButton("Start / Stop");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                helper();
            }

        });
        frame.add(button, BorderLayout.EAST);
        frame.add(panel, BorderLayout.WEST);
        frame.setVisible(true);


        while(true) {
            //Printing out
            while(GameOfLifeGui.test[0]) {
                Graphics graphic = panel.getGraphics();
                GraphicalInterface(array, graphic);

                //Applying rules
                Life.applyRules(array);
                Thread.sleep(249);
            }
            Thread.sleep(1);
        }
    }
}

