package com.example.tictactoe.service;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.example.tictactoe.model.Move;
import com.google.gson.Gson;

public class MoveDecoder implements Decoder.Text<Move> {

    private static Gson gson = new Gson();

    @Override
    public Move decode(String s) throws DecodeException {
        return gson.fromJson(s, Move.class);
    }

    @Override
    public boolean willDecode(String s) {
        return (s != null);
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