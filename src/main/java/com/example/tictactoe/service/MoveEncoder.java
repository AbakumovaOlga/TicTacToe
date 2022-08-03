package com.example.tictactoe.service;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.example.tictactoe.model.Move;
import com.google.gson.Gson;

public class MoveEncoder implements Encoder.Text<Move> {

    private static Gson gson = new Gson();

    @Override
    public String encode(Move move) throws EncodeException {
        return gson.toJson(move);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        // Custom initialization logic
    }

    @Override
    public void destroy() {
        // Close resources
    }
}
