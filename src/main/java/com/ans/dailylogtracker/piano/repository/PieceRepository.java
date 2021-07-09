package com.ans.dailylogtracker.piano.repository;

import com.ans.dailylogtracker.piano.model.Piece;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PieceRepository extends MongoRepository<Piece, String> {

}
