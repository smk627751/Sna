package com.smk627751.view;

import com.smk627751.dto.Player;
import com.smk627751.viewModel.ViewModel;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class View {
    private final ViewModel viewModel;

    public View()
    {
        this.viewModel = new ViewModel(this);
    }
    public void start()
    {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the size of the board");
//        viewModel.setSize(sc.nextInt());
          viewModel.setSize(10);
//        System.out.println("Enter the no of snakes");
//        int snakeCount = sc.nextInt();
//        for(int i = 0; i < snakeCount; i++)
//        {
//            System.out.println("Enter the head position: ");
//            int head = sc.nextInt();
//            System.out.println("Enter the tail position: ");
//            int tail = sc.nextInt();
//            viewModel.getSnakes().put(head,tail);
//        }
        Map<Integer,Integer> snakes = viewModel.getSnakes();
        snakes.put(96, 59);
        snakes.put(94, 71);
        snakes.put(75, 32);
        snakes.put(37, 3);
        snakes.put(48, 16);
        snakes.put(28, 10);

//        System.out.println("Enter the no of ladders");
//        int ladderCount = sc.nextInt();
//        for(int i = 0; i < ladderCount; i++)
//        {
//            System.out.println("Enter the bottom position: ");
//            int bottom = sc.nextInt();
//            System.out.println("Enter the top position: ");
//            int top = sc.nextInt();
//            viewModel.getLadders().put(bottom,top);
//        }
        Map<Integer,Integer> ladders = viewModel.getLadders();
        ladders.put(54, 88);
        ladders.put(41, 79);
        ladders.put(22, 58);
        ladders.put(4, 56);
        ladders.put(14, 55);
        ladders.put(12, 50);

//        System.out.println("Enter the no of players");
//        int playersCount = sc.nextInt();
//        sc.nextLine();
//        for(int i = 0; i < playersCount; i++)
//        {
//            System.out.println("Enter the name: ");
//            viewModel.getPlayers().add(new Player(sc.nextLine()));
//        }
        List<Player> players = viewModel.getPlayers();
        players.add(new Player("smk"));
        int choice;
        loop:do{
            System.out.println("1.Play the Game\n2.Find the minimum steps");
            choice = sc.nextInt();
            switch (choice)
            {
                case 1 ->{
                    viewModel.playGame();
                }
                case 2 -> {
                    viewModel.findTheMinPath();
                }
                case 0 -> {
                    break loop;
                }
                default -> {
                    System.out.println("Invalid choice");
                }
            }
        }while (true);
    }
    public void onPrint(String s)
    {
        System.out.println(s);
    }
}
