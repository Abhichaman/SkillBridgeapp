package SkillBridge.example.skillbridge.repo;

import SkillBridge.example.skillbridge.entity.Leaderboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface LeaderboardRepo extends JpaRepository<Leaderboard, Long> {
    Leaderboard findByEmail(String email);
}

