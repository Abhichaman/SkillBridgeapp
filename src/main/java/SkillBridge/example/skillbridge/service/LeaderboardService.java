package SkillBridge.example.skillbridge.service;

import SkillBridge.example.skillbridge.entity.Leaderboard;
import SkillBridge.example.skillbridge.repo.LeaderboardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LeaderboardService {

    @Autowired
    private LeaderboardRepo repo;

    public List<Leaderboard> getAll() {
        return repo.findAll().stream()
                .sorted((a, b) -> b.getScore() - a.getScore())   // ✅ Highest score first
                .toList();
    }

    public void saveOrUpdate(Leaderboard lb) {
        Leaderboard existing = repo.findByEmail(lb.getEmail());

        if(existing != null){
            if(lb.getScore() > existing.getScore()){
                existing.setScore(lb.getScore());
                existing.setSubject(lb.getSubject());
                repo.save(existing);
            }
        } else {
            repo.save(lb);
        }
    }
}
