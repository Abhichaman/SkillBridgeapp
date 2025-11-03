package SkillBridge.example.skillbridge.repo;


import SkillBridge.example.skillbridge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
  User  findByEmail(String email);
}
