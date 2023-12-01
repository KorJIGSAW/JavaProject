import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WinnerFrame extends JFrame {
    public WinnerFrame(int player1, int player2, Theme theme) {
        System.out.println(player1 );
        System.out.println(player2 );
        setSize(900, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel winnerLabel = new JLabel();
        winnerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        winnerLabel.setBounds(50, 50, 800, 50);
        winnerLabel.setFont(new Font("Serif", Font.BOLD, 20));
        
        if(player1 > player2) {
            winnerLabel.setText("첫번째 플레이어가 승리하였습니다!");
        } else if(player1 < player2) {
            winnerLabel.setText("두번째 플레이어가 승리하였습니다!");
        } else {
            winnerLabel.setText("무승부입니다!");
        }
        
        getContentPane().add(winnerLabel);

        // Add firework images
        ImageIcon fireworkIcon = new ImageIcon("./image/firework.png");  // Adjust path if needed
        ImageIcon fireworkIcon2 = new ImageIcon("./image/firework2.png");  // Adjust path if needed
        Image fireworkImage = fireworkIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);  // Adjust size if needed
        Image fireworkImage2 = fireworkIcon2.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);  // Adjust size if needed

        JLabel leftFireworkLabel = new JLabel(new ImageIcon(fireworkImage2));
        leftFireworkLabel.setBounds(0, 50, 300, 300);  // Adjust position and size if needed
        getContentPane().add(leftFireworkLabel);

        JLabel rightFireworkLabel = new JLabel(new ImageIcon(fireworkImage));
        rightFireworkLabel.setBounds(600, 50, 300, 300);  // Adjust position and size if needed
        getContentPane().add(rightFireworkLabel);

        ImageIcon playAgainIcon = new ImageIcon("./image/play_again.jpg");  // Adjust path if needed
        Image playAgainImage = playAgainIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);  // Adjust size if needed

        JButton playAgainButton = new JButton(new ImageIcon(playAgainImage));
        playAgainButton.setBounds(400, 600, 100, 100);  // Adjust position and size if needed
        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Theme theme = new Theme();
                new ThemeFrame(theme); 
            }
        });
        getContentPane().add(playAgainButton);

        setVisible(true);
    }
}
