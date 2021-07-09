package com.ans.dailylogtracker.piano.api;

import com.ans.dailylogtracker.piano.model.Piece;
import com.ans.dailylogtracker.piano.model.User;

import java.util.List;

public interface PieceApi {
   Piece getPiece(long id);
   List<Piece> getPieces(User user);
}
