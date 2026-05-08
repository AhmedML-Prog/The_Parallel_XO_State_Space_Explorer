package com.mycompany.the_parallel_xo_state_space_explorer;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmed
 */

public class Explorer {
    int threads = Runtime.getRuntime().availableProcessors();
    ExecutorService pool = Executors.newFixedThreadPool(threads);
    ExecutorService vpool = Executors.newVirtualThreadPerTaskExecutor();
    ThreadLocal<char[][]> localBoard = new ThreadLocal<>();

    // Single Thread
    public Result single(char[][] board, char player) {

        Result result = new Result();

        if (Board.isWinner(board, 'X')) {
            result.xWins = 1;
            result.total = 1;
            return result;
        }

        if (Board.isWinner(board, 'O')) {
            result.oWins = 1;
            result.total = 1;
            return result;
        }

        if (Board.isFull(board)) {
            result.draws = 1;
            result.total = 1;
            return result;
        }

        List<int[]> moves = Board.getMoves(board);

        for (int[] move : moves) {
            char[][] copy = Board.copy(board);
            copy[move[0]][move[1]] = player;
            char next = (player == 'X') ? 'O' : 'X';

            Result child = single(copy, next);
            result.add(child);
        }

        return result;
    }

    public Result multiThreaded(char[][] board, char player) throws Exception {

        if (Board.isWinner(board, 'X') || Board.isWinner(board, 'O') || Board.isFull(board))
        {return single(board, player);}
        
        List<int[]> moves = Board.getMoves(board);
        Future<Result>[] futures = new Future[moves.size()];

        for (int i = 0; i < moves.size(); i++) {
            int[] move = moves.get(i);

            futures[i] = pool.submit(() -> {
                char[][] copy = Board.copy(board);
                localBoard.set(copy);

                char[][] b = localBoard.get();
                b[move[0]][move[1]] = player;

                char next = (player == 'X') ? 'O' : 'X';

                Result result = single(b, next);

                localBoard.remove();
                return result;
            });
        }

        Result finalResult = new Result();

        for (Future<Result> f : futures) {
            finalResult.add(f.get());
        }

        return finalResult;
    }

    // Virtual Threads
    public Result virtual(char[][] board, char player) throws Exception {
            
            if (Board.isWinner(board, 'X') || Board.isWinner(board, 'O') || Board.isFull(board))
                {return single(board, player);}
        
            List<int[]> moves = Board.getMoves(board);
            Future<Result>[] futures = new Future[moves.size()];

            for (int i = 0; i < moves.size(); i++) {
                int[] move = moves.get(i);

                futures[i] = vpool.submit(() -> {
                    char[][] copy = Board.copy(board);
                    localBoard.set(copy);

                    char[][] b = localBoard.get();
                    b[move[0]][move[1]] = player;

                    char next = (player == 'X') ? 'O' : 'X';

                    Result result = single(b, next);

                    localBoard.remove();
                    return result;
                });
            }

            Result finalResult = new Result();

            for (Future<Result> f : futures) {
                finalResult.add(f.get());
            }

            return finalResult;
    }
    
     public void shutdown() {
        pool.shutdown();
        vpool.shutdown();
    }
}
