package com.java.study.chapter8.puzzle;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public interface Puzzle<P, M> {
    P inititalPosition();

    boolean isGloal(P position);

    Set<M> legalMoves(P position);

    P move(P position, M move);

    public static class Node<P,M>{
        final P pos;
        final M move;
        final Node<P,M> prev;

        public Node(P pos, M move, Node<P, M> prev) {
            this.pos = pos;
            this.move = move;
            this.prev = prev;
        }

        List<M> asMoveList(){
            List<M> solution = new LinkedList<M>();
            for (Node node = this;node.move != null;node = node.prev){
                solution.add(0,move);
            }
            return solution;
        }
    }
}
