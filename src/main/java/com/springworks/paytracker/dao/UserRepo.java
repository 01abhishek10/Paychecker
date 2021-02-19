package com.springworks.paytracker.dao;

import com.springworks.paytracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {

}
