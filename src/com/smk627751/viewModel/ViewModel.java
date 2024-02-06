package com.smk627751.viewModel;

import com.smk627751.dto.Player;
import com.smk627751.view.View;

import java.util.*;

public class ViewModel {
    private int size;
    private int end;
    private  Map<Integer, Integer> snakes;
    private  Map<Integer, Integer> ladders;
    private  List<Player> players;
    private View view;

    public ViewModel(View view) {
        this.view = view;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
        this.players = new ArrayList<>();
    }
    public Map<Integer,Integer> getSnakes()
    {
        return snakes;
    }
    public Map<Integer,Integer> getLadders()
    {
        return ladders;
    }
    public List<Player> getPlayers()
    {
        return players;
    }
    public  void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        outer:while (true) {
            int newPosition;
            for(Player player : players)
            {
                view.onPrint(player.getName()+" Press Enter to roll the dice");
                scanner.nextLine();
                int diceRoll = random.nextInt(6) + 1;
                int prev = player.getPosition();
                int curr = prev + diceRoll;
                newPosition = updatePosition(curr);
                if (newPosition <= end) {
                    player.setPosition(newPosition);
                }
                System.out.println(player.getName()+" rolled " + diceRoll + " and moved from "+prev+" to position " + player.getPosition());
                if (player.getPosition() == end) {
                    view.onPrint(player.getName()+" wins!");
                    break outer;
                }
            }
        }
    }
    public void findTheMinPath()
    {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(new ArrayList<>());
        int currentPosition,newPosition;
        while(!queue.isEmpty())
        {
            List<Integer> curr = queue.poll();
            int last = curr.isEmpty() ? 0 : curr.getLast();
            if(last == end)
            {
                view.onPrint(curr.toString());
                view.onPrint("The minimum steps to win: "+curr.size());
                break;
            }
            for(int i = 1; i <= 6; i++)
            {
                currentPosition = last + i;
                newPosition = updatePosition(currentPosition);
                List<Integer> temp = new ArrayList<>(curr);
                temp.add(currentPosition);
                if(currentPosition != newPosition)
                {
                    temp.add(newPosition);
                }
                queue.offer(temp);
            }
        }
    }
    public int updatePosition(int position) {
        if (snakes.containsKey(position)) {
            view.onPrint("Oh no! You got bit by a snake!");
            return snakes.get(position);
        } else if (ladders.containsKey(position)) {
            view.onPrint("Great! You found a ladder!");
            return ladders.get(position);
        }
        return position;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
        this.end = size * size;
    }
}
