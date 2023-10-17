package com.kalaha.config;

import com.kalaha.Model.Board;
import com.kalaha.Model.BoardImpl;
import com.kalaha.Model.Game;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class GameConfig extends WebMvcConfigurationSupport {
    private final int pitsPerPlayer;
    private final int stonesPerPit;
    private final boolean southTurn;

    public GameConfig(@Value("${board.pitsPerPlayer: 6}") final int pitsPerPlayer,
                      @Value("${board.stonesPerPit: 6}") final int stonesPerPit,
                      @Value("${board.southTurn: true}") final boolean southTurn) {
        this.pitsPerPlayer = pitsPerPlayer;
        this.stonesPerPit = stonesPerPit;
        this.southTurn = southTurn;
    }

    @Bean
    public Game getGameBean() {
        return Game.builder().board(getBoardBean()).build();
    }

    @Bean
    public Board getBoardBean() {
        return BoardImpl.builder()
                .pitList(pitsPerPlayer, stonesPerPit)
                .southTurn(southTurn)
                .build();
    }
}
