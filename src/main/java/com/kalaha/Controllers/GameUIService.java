package com.kalaha.Controllers;

import com.kalaha.Model.Game;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public final class GameUIService {

    BoardHtmlData getBoardHtmlDataFrom(final Game game) {
        return BoardHtmlData.builder()
                .rowSouth(game.getPitListSouth())
                .kalahaSouth(game.getStonesKalahaSouth())
                .rowNorth(reverse(game.getPitListNorth()))
                .kalahaNorth(game.getStonesKalahaNorth())
                .build();
    }

    private List<Integer> reverse(final List<Integer> list) {
        Collections.reverse(list);
        return list;
    }
}
