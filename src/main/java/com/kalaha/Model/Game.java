package com.kalaha.Model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public final class Game {

    private Board board;

    public void play(final int index) {

        board.makeMove(index);

    }

    public String getWinnerMessage() {
        int exceedingStonesSouth = getStonesKalahaSouth() - getStonesKalahaNorth();

        if (exceedingStonesSouth == 0)
            return "It's a tie!";

        return exceedingStonesSouth > 0 ? "Player South has won!" : "Player North has won!";
    }

    public int getOffsetPlayerNorth() {
        return board.getPitList().size() / 2;
    }

    public List<Integer> getPitListSouth() {
        List<Integer> subList = board.getPitList().subList(0, board.getIndexKalahaSouth());
        return new ArrayList<>(subList);
    }

    public List<Integer> getPitListNorth() {
        List<Integer> subList = board.getPitList()
                .subList(board.getIndexKalahaSouth() + 1, board.getIndexKalahaNorth());
        return new ArrayList<>(subList);
    }

    public int getStonesKalahaSouth() {
        int index = board.getIndexKalahaSouth();
        return board.getPitList().get(index);
    }

    public int getStonesKalahaNorth() {
        int index = board.getIndexKalahaNorth();
        return board.getPitList().get(index);
    }

    public boolean isSouthTurn() {
        return board.isSouthTurn();
    }

    public void setSouthTurn(final boolean southTurn) {
        board.setSouthTurn(southTurn);
    }

    public boolean isPitEmpty(final int index) {
        return board.isEmpty(index);
    }

    public boolean isGameOver() {
        return board.isGameOver();
    }
}
