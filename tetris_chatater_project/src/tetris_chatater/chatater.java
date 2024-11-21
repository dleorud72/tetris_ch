package tetris_chatater;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

public class chatater extends JFrame{
	private JLabel characterWindow; // 캐릭터창
    private JLabel characterDescription; // 캐릭터 설명
    private String selectedCharacter = null; // 선택된 캐릭터
    
	public chatater() {
		setTitle("캐릭터 선택");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // 캐릭터창
        characterWindow = new JLabel("캐릭터창");
        characterWindow.setBounds(50, 30, 200, 100);
        characterWindow.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(characterWindow);

        // 캐릭터 설명
        characterDescription = new JLabel("캐릭터 설명");
        characterDescription.setBounds(300, 30, 200, 100);
        characterDescription.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(characterDescription);

        // 캐릭터 버튼 추가
        String[] characters = {"남자1", "남자2", "여자1", "여자2", "과물"};
        int x = 50;
        for (String character : characters) {
            JButton button = new JButton(character);
            button.setBounds(x, 200, 80, 40);
            button.addActionListener(e -> selectCharacter(character));
            add(button);
            x += 100;
        }

        // 시작 버튼
        JButton startButton = new JButton("시작");
        startButton.setBounds(450, 300, 100, 40);
        startButton.addActionListener(e -> startGame());
        add(startButton);

        setVisible(true);
    }
	
	private void selectCharacter(String character) {
        selectedCharacter = character;
        characterWindow.setText(character); // 캐릭터창에 선택된 캐릭터 표시
        characterDescription.setText(character + " 설명"); // 캐릭터 설명 표시
    }
	
	 private void startGame() {
	        if (selectedCharacter != null) {
	            int result = JOptionPane.showConfirmDialog(
	                    this,
	                    "캐릭터를 선택하시겠습니까?",
	                    "확인",
	                    JOptionPane.YES_NO_OPTION
	            );
	            if (result == JOptionPane.YES_OPTION) {
	                JOptionPane.showMessageDialog(this, selectedCharacter + "로 게임 시작!");
	            }
	        } else {
	            JOptionPane.showMessageDialog(this, "캐릭터를 선택해주세요!");
	        }
	    }
	
	public static void main(String args[]) {
		new chatater();
	}
}
